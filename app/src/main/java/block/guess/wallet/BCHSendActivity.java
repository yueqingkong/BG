package block.guess.wallet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import block.guess.utils.okhttp.Callback.BaseCallBack;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.utils.MathUtil;
import block.guess.utils.StringsUtil;
import block.guess.wallet.contract.BCHSendContract;
import block.guess.wallet.presenter.BCHSendPresenter;
import block.guess.widget.VerifyTextView;
import block.guess.widget.dialog.DialogUtil;
import block.guess.widget.dialog.bean.DialogCallback;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/wallet/bchsend")
public class BCHSendActivity extends BaseActivity implements BCHSendContract.BView, ToolbarCallback, SeekBar.OnSeekBarChangeListener {

    private static final String TAG = "_BCHSendActivity";

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.edit_address)
    EditText editAddress;
    @BindView(R.id.img_scan)
    ImageView imgScan;
    @BindView(R.id.edit_email_code)
    EditText editEmailCode;
    @BindView(R.id.txt_verify_code)
    VerifyTextView txtVerifyCode;
    @BindView(R.id.txt_balance)
    TextView txtBalance;
    @BindView(R.id.txt_balance_value)
    TextView txtBalanceValue;
    @BindView(R.id.edit_amount)
    EditText editAmount;
    @BindView(R.id.constraintlayout_balance)
    ConstraintLayout constraintlayoutBalance;
    @BindView(R.id.txt_fee)
    TextView txtFee;
    @BindView(R.id.txt_fee_value)
    TextView txtFeeValue;
    @BindView(R.id.seekbar)
    AppCompatSeekBar seekbar;
    @BindView(R.id.constraintlayout_fee)
    ConstraintLayout constraintlayoutFee;
    @BindView(R.id.txt_send)
    TextView txtSend;

    @Autowired
    boolean scan;
    @Autowired
    long accountBalance;

    private BCHSendActivity activity;
    private BCHSendContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bch_send);
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);

        new BCHSendPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.send_bch));
        toolbarBase.setToolbarCallback(this);

        txtVerifyCode.finishCount();

        String balance = StringsUtil.decimal(accountBalance);
        txtBalanceValue.setText(balance + "BCH");

        String fee = StringsUtil.decimal(500);
        txtFeeValue.setText(fee);

        seekbar.setProgress(38);
        seekbar.setOnSeekBarChangeListener(this);

        if (scan) {
            qrcodeScan();
        }
    }

    @OnClick({R.id.txt_fee_value, R.id.img_scan, R.id.txt_verify_code, R.id.txt_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_scan:
                qrcodeScan();
                break;
            case R.id.txt_verify_code:
                withdrawalEmail();
                break;
            case R.id.txt_fee_value:
                minerFeePopupwindow();
                break;
            case R.id.txt_send:
                withdrawalConfirm();
                break;
        }
    }

    @Override
    public void qrcodeScan() {
        ARouter.getInstance().build("/wallet/qrcodescan")
                .navigation(activity, 120);
    }

    private void withdrawalEmail() {
        String amount = editAmount.getText().toString();
        String address = editAddress.getText().toString();

        if (TextUtils.isEmpty(address) || TextUtils.isEmpty(amount)) {
            txtVerifyCode.finishCount();
            SnackBarUtil.error(activity, getString(R.string.tips_empty_address_amount));
        } else {
            presenter.withdrawalRequest(address, (long) (Float.parseFloat(amount) * StringsUtil.Unit),new BaseCallBack<Boolean>(activity){

                @Override
                public void success(Boolean b) {
                    SnackBarUtil.success(activity, getString(R.string.email_send_success));

                }

                @Override
                public void serverError(int code, String err) {
                    SnackBarUtil.error(activity, err);
                }

                @Override
                public void netError() {
                    SnackBarUtil.error(activity, getString(R.string.error_network_timeout));
                }
            });
        }
    }

    private void withdrawalConfirm() {
        String amount = editAmount.getText().toString();
        String address = editAddress.getText().toString();
        String code = editEmailCode.getText().toString();
        String fee = txtFeeValue.getText().toString();
        long feeBig = (long) (Double.parseDouble(fee.substring(0, fee.length() - 3)) * MathUtil.Unit);//200-1500

        if (TextUtils.isEmpty(amount) || TextUtils.isEmpty(address) || TextUtils.isEmpty(code)) {
            SnackBarUtil.error(activity, getString(R.string.tips_empty_address_code_amount));
        } else {
            long amountValue = (long) (Float.parseFloat(amount) * StringsUtil.Unit);
            presenter.withdrawalConfirm(address, amountValue, code, feeBig, new BaseCallBack<Boolean>(activity) {
                @Override
                public void success(Boolean aBoolean) {
                    activity.finish();
                    SnackBarUtil.success(activity, getString(R.string.withdraw_success));
                }

                @Override
                public void serverError(int code, String err) {
                    SnackBarUtil.error(activity, err);
                }

                @Override
                public void netError() {
                    SnackBarUtil.error(activity, getString(R.string.error_network_timeout));
                }
            });
        }
    }

    @Override
    public void minerFeePopupwindow() {
        DialogUtil.show(activity, R.layout.dialog_miner_fee, new DialogCallback() {
            @Override
            public void createView(final Dialog dialog, View view) {
                TextView cancelTxt = view.findViewById(R.id.txt_left);
                cancelTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                final EditText editText = view.findViewById(R.id.edit_amount);

                TextView confirmTxt = view.findViewById(R.id.txt_right);
                confirmTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String string = editText.getText().toString();

                        double feeAmount = 0.00000200;
                        if (!TextUtils.isEmpty(string)) {
                            double inputAmount = Double.parseDouble(string);
                            if (inputAmount > 0.00001500) {
                                feeAmount = 0.00001500;
                            } else {
                                feeAmount = inputAmount;
                            }
                        }

                        int progress = (int) ((feeAmount - 0.00000200) * 100 / (0.00001500 - 0.00000200));
                        seekbar.setProgress(progress);
                        String feevalue = StringsUtil.decimal(feeAmount);
                        txtFeeValue.setText(feevalue + "BCH");

                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120) {
            if (data != null) {
                String value = data.getStringExtra("qrcode");
                if (TextUtils.isEmpty(value) && scan) {
                    activity.finish();
                } else {
                    editAddress.setText(value);
                }
            }
        }
    }

    @Override
    public void presenter(BCHSendContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int fee = 200 + seekbar.getProgress() * 1300;//200-1500
        String feevalue = StringsUtil.decimal(fee);
        txtFeeValue.setText(feevalue + "BCH");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
