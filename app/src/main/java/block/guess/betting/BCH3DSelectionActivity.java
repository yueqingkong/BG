package block.guess.betting;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.adapter.BCH3DSelectAdapter;
import block.guess.betting.bean.Betting3DBean;
import block.guess.betting.contract.BCH3dSelectionContract;
import block.guess.betting.presenter.BCH3DSelectionPresenter;
import block.guess.main.bean.HomeBean;
import block.guess.utils.DensityUtils;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.BettingEndTextView;
import block.guess.widget.ClockCountView;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/bch3dselection")
public class BCH3DSelectionActivity extends BaseActivity implements BCH3dSelectionContract.BView, ToolbarCallback, BCH3DSelectAdapter.BCH3DCallBack, SensorEventListener {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_3d)
    ImageView img3d;
    @BindView(R.id.txt_stage_number)
    TextView txtStageNumber;
    @BindView(R.id.view_clock)
    ClockCountView viewClock;
    @BindView(R.id.txt_date_end)
    BettingEndTextView txtDateEnd;
    @BindView(R.id.img_shake_hand)
    ImageView imgShakeHand;
    @BindView(R.id.img_bch3d_bottom)
    ImageView imgBch3dBottom;
    @BindView(R.id.txt_bch3d_bottom)
    TextView txtBch3dBottom;
    @BindView(R.id.txt_bch3d_betting)
    TextView txtBch3dBetting;
    @BindView(R.id.constraintlayout_bottom)
    ConstraintLayout constraintlayoutBottom;

    @Autowired
    HomeBean homeBean;
    @Autowired
    Betting3DBean current3DBean;
    @Autowired
    ArrayList<Betting3DBean> betting3DBeans;

    private Activity activity;
    private RecyclerView recyclerThree;
    private RecyclerView recyclerTwo;
    private RecyclerView recyclerOne;

    private BCH3DSelectAdapter bch3DThreeAdapter;
    private BCH3DSelectAdapter bch3DTwoAdapter;
    private BCH3DSelectAdapter bch3DOneAdapter;

    private BCH3dSelectionContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bch3d_selection);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BCH3DSelectionPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        if (current3DBean == null) {
            current3DBean = new Betting3DBean();
        }
        if (betting3DBeans == null) {
            betting3DBeans = new ArrayList<>();
        }

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setRightTxt(R.mipmap.btn_more_big);
        toolbarBase.setToolbarCallback(this);

        viewClock.init(homeBean.getContract().getEnd());
        txtStageNumber.setText(getString(R.string.betting_bch3d_stage, homeBean.getContract().getId()));
        txtDateEnd.init(R.string.betting_bch3d_end, homeBean.getContract().getStart(), homeBean.getContract().getEnd());

        findViewById(R.id.include_ball_item_one).findViewById(R.id.view_centre).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        findViewById(R.id.include_ball_item_two).findViewById(R.id.view_centre).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        View threeGroup = findViewById(R.id.include_select_three);
        View twoGroup = findViewById(R.id.include_select_two);
        View oneGroup = findViewById(R.id.include_select_one);

        threeGroup.setBackgroundResource(R.drawable.shape_rectangle_f3f4fa_r4_top);
        twoGroup.setBackgroundColor(getResources().getColor(R.color.color_f3f4fa));
        oneGroup.setBackgroundResource(R.drawable.shape_rectangle_f3f4fa_r4_bottom);

        TextView chooseThreeTxt = threeGroup.findViewById(R.id.txt_choose);
        TextView chooseTwoTxt = twoGroup.findViewById(R.id.txt_choose);
        TextView chooseOneTxt = oneGroup.findViewById(R.id.txt_choose);
        chooseThreeTxt.setText(getString(R.string.choose_one_ball));
        chooseTwoTxt.setText(getString(R.string.choose_one_ball));
        chooseOneTxt.setText(getString(R.string.choose_one_ball));

        TextView categoryThreeTxt = threeGroup.findViewById(R.id.txt_category);
        TextView categoryTwoTxt = twoGroup.findViewById(R.id.txt_category);
        TextView categoryOneTxt = oneGroup.findViewById(R.id.txt_category);
        categoryThreeTxt.setText(getString(R.string.hundreds));
        categoryTwoTxt.setText(getString(R.string.tens));
        categoryOneTxt.setText(getString(R.string.units));

        recyclerThree = threeGroup.findViewById(R.id.recycler_select);
        recyclerTwo = twoGroup.findViewById(R.id.recycler_select);
        recyclerOne = oneGroup.findViewById(R.id.recycler_select);

        GridLayoutManager threeLayoutManager = new GridLayoutManager(activity, 6);
        recyclerThree.setLayoutManager(threeLayoutManager);
        bch3DThreeAdapter = new BCH3DSelectAdapter(0);
        recyclerThree.setAdapter(bch3DThreeAdapter);
        bch3DThreeAdapter.setBch3DCallBack(this);

        GridLayoutManager twoLayoutManager = new GridLayoutManager(activity, 6);
        recyclerTwo.setLayoutManager(twoLayoutManager);
        bch3DTwoAdapter = new BCH3DSelectAdapter(1);
        recyclerTwo.setAdapter(bch3DTwoAdapter);
        bch3DTwoAdapter.setBch3DCallBack(this);

        GridLayoutManager oneLayoutManager = new GridLayoutManager(activity, 6);
        recyclerOne.setLayoutManager(oneLayoutManager);
        bch3DOneAdapter = new BCH3DSelectAdapter(2);
        recyclerOne.setAdapter(bch3DOneAdapter);
        bch3DOneAdapter.setBch3DCallBack(this);

        bettingSelected();
    }

    @Override
    public void bettingSelected() {
        if (betting3DBeans == null || betting3DBeans.size() == 0) {
            GlideUtil.load(imgBch3dBottom, R.mipmap.ic_bet_random_4);
            txtBch3dBottom.setText(getString(R.string.machine_selects_4));
        } else {
            GlideUtil.load(imgBch3dBottom, R.mipmap.ic_bet_clear);
            txtBch3dBottom.setText(getString(R.string.clear));
        }
    }

    @OnClick({R.id.img_shake_hand, R.id.img_bch3d_bottom, R.id.txt_bch3d_bottom, R.id.txt_bch3d_betting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_shake_hand:
                shakeSingleBetting();
                break;
            case R.id.img_bch3d_bottom:
            case R.id.txt_bch3d_bottom:
                bottomSelectedClick();
                break;
            case R.id.txt_bch3d_betting:
                bettingActivity();
                break;
        }
    }

    @Override
    public void presenter(BCH3dSelectionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bottomSelectedClick() {
        if (betting3DBeans == null || betting3DBeans.size() == 0) {//显示机选4注
            betting3DBeans = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Betting3DBean betting3DBean = new Betting3DBean();
                betting3DBean.randomNumber();
                betting3DBeans.add(betting3DBean);
            }
            bettingActivity();
        } else {//清空
            betting3DBeans.clear();
            bettingSelected();
        }
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {
        int leftMargin = DensityUtils.dip2px(-80);
        int topMargin = DensityUtils.dip2px(14);

        PopupwindowUtil.show(activity, R.layout.part_popupwindow_gamerule, toolbarBase.findViewById(R.id.txt_right), leftMargin, topMargin, new PopupCallback() {
            @Override
            public void createView(final PopupWindow dialog, View view) {
                view.findViewById(R.id.txt_gamerule).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String category = CategoryEnum.D3.getCategory() + "";
                        String language = SystemUtil.language(activity);
                        BlockChainUrlUtil.gameRule(activity,category, language);

                        dialog.dismiss();
                    }
                });

                view.findViewById(R.id.txt_contractaddress).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String address = homeBean.getContract().getAddress();
                        String url = BlockChainUrlUtil.btccomAddress(address);
                        ARouter.getInstance().build("/widget/webview")
                                .withString("url", url)
                                .navigation(activity);

                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public boolean isSelectNumber(int tag, int number) {
        boolean isSelect = false;
        switch (tag) {
            case 0:
                isSelect = current3DBean.getFirstNumber() == number;
                break;
            case 1:
                isSelect = current3DBean.getSecondNumber() == number;
                break;
            case 2:
                isSelect = current3DBean.getThirdNumber() == number;
                break;
        }
        return isSelect;
    }

    @Override
    public void setSelectNumber(int tag, int number) {
        switch (tag) {
            case 0:
                current3DBean.setFirstNumber(number);
                break;
            case 1:
                current3DBean.setSecondNumber(number);
                break;
            case 2:
                current3DBean.setThirdNumber(number);
                break;
        }
    }

    @Override
    public void cancel(int tag) {
        switch (tag) {
            case 0:
                current3DBean.setFirstNumber(-1);
                break;
            case 1:
                current3DBean.setSecondNumber(-1);
                break;
            case 2:
                current3DBean.setThirdNumber(-1);
                break;
        }
    }

    public void bettingActivity() {
        if (current3DBean.isAvailable()) {
            betting3DBeans.add(current3DBean);
        }

        if (betting3DBeans.size() == 0) {
            String tips = getString(R.string.betting_at_least_one);
            SnackBarUtil.error(activity, tips);
        } else {
            ARouter.getInstance().build("/betting/bch3dbetting")
                    .withSerializable("homeBean", homeBean)
                    .withSerializable("betting3DBeans", betting3DBeans)
                    .navigation(activity);
        }
    }

    private static final int SENSOR_VALUE = 14;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private long lastVibratorTime = 0;

    @Override
    public void registerSensor() {
        sensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void unregisterSensor() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float[] values = sensorEvent.values;

        if (TimeUtil.timestamp() - lastVibratorTime > 2000) {
            lastVibratorTime = TimeUtil.timestamp();

            if (sensorType == Sensor.TYPE_ACCELEROMETER) {
                if ((Math.abs(values[0]) > SENSOR_VALUE || Math.abs(values[1]) > SENSOR_VALUE || Math.abs(values[2]) > SENSOR_VALUE)) {
                    shakeSingleBetting();
                }
            }
        }
    }

    private void shakeSingleBetting() {
        SystemUtil.vibrator(activity);

        Betting3DBean betting3DBean = new Betting3DBean();
        betting3DBean.randomNumber();

        current3DBean.clear();
        bch3DOneAdapter.updatePosition(betting3DBean.getFirstNumber());
        bch3DTwoAdapter.updatePosition(betting3DBean.getSecondNumber());
        bch3DThreeAdapter.updatePosition(betting3DBean.getThirdNumber());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerSensor();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterSensor();
    }
}
