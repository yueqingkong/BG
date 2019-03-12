package block.guess.betting;

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
import block.guess.betting.adapter.LottoPurpleAdapter;
import block.guess.betting.adapter.LottoRedAdapter;
import block.guess.betting.bean.LottoBean;
import block.guess.betting.contract.LottoSelectContract;
import block.guess.betting.presenter.LottoSelectPresenter;
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

@Route(path = "/betting/lottoselect")
public class LottoSelectActivity extends BaseActivity implements LottoSelectContract.BView, ToolbarCallback, SensorEventListener {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_category)
    ImageView imgCategory;
    @BindView(R.id.txt_stage_number)
    TextView txtStageNumber;
    @BindView(R.id.view_clock)
    ClockCountView viewClock;
    @BindView(R.id.txt_date_end)
    BettingEndTextView txtDateEnd;
    @BindView(R.id.img_shake_hand)
    ImageView imgShakeHand;
    @BindView(R.id.img_bottom)
    ImageView imgBottom;
    @BindView(R.id.txt_bottom)
    TextView txtBottom;
    @BindView(R.id.txt_betting)
    TextView txtBetting;
    @BindView(R.id.constraintlayout_bottom)
    ConstraintLayout constraintlayoutBottom;

    @Autowired
    HomeBean homeBean;
    @Autowired
    LottoBean currentBean;
    @Autowired
    ArrayList<LottoBean> bettingBeans;

    private static final int SENSOR_VALUE = 14;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private long lastVibratorTime = 0;

    private LottoSelectActivity activity;
    private RecyclerView recyclerTwo;
    private RecyclerView recyclerOne;
    private LottoSelectContract.Presenter presenter;

    private LottoRedAdapter lottoRedAdapter;
    private LottoPurpleAdapter lottoPurpleAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_select);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new LottoSelectPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        if (currentBean == null) {
            currentBean = new LottoBean();
        }
        if (bettingBeans == null) {
            bettingBeans = new ArrayList<>();
        }

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setRightTxt(R.mipmap.btn_more_big);
        toolbarBase.setToolbarCallback(this);

        GlideUtil.load(imgCategory, R.mipmap.ic_bchlotto_home);
        viewClock.init(homeBean.getContract().getEnd());
        txtStageNumber.setText(getString(R.string.betting_lotto_stage, homeBean.getContract().getId()));
        txtDateEnd.init(R.string.betting_bch3d_end, homeBean.getContract().getStart(), homeBean.getContract().getEnd());

        findViewById(R.id.include_ball_item_one).findViewById(R.id.view_centre).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        View twoGroup = findViewById(R.id.include_select_two);
        View oneGroup = findViewById(R.id.include_select_one);

        twoGroup.setBackgroundResource(R.drawable.shape_rectangle_f3f4fa_r4_top);
        oneGroup.setBackgroundResource(R.drawable.shape_rectangle_f3f4fa_r4_bottom);

        TextView chooseTwoTxt = twoGroup.findViewById(R.id.txt_choose);
        TextView chooseOneTxt = oneGroup.findViewById(R.id.txt_choose);
        chooseTwoTxt.setText(getString(R.string.choose_six_red_ball));
        chooseOneTxt.setText(getString(R.string.choose_one_ball));

        recyclerTwo = twoGroup.findViewById(R.id.recycler_select);
        recyclerOne = oneGroup.findViewById(R.id.recycler_select);

        GridLayoutManager twoLayoutManager = new GridLayoutManager(activity, 6);
        recyclerTwo.setLayoutManager(twoLayoutManager);
        lottoRedAdapter = new LottoRedAdapter();
        recyclerTwo.setAdapter(lottoRedAdapter);
        lottoRedAdapter.setLottoRedCallBack(new LottoRedAdapter.LottoRedCallBack() {

            @Override
            public boolean numberContain(int number) {
                return currentBean.containsNumber(number);
            }

            @Override
            public void selectNumber(int number) {
                currentBean.selectNumber(number);
            }
        });

        GridLayoutManager oneLayoutManager = new GridLayoutManager(activity, 6);
        recyclerOne.setLayoutManager(oneLayoutManager);
        lottoPurpleAdapter = new LottoPurpleAdapter();
        recyclerOne.setAdapter(lottoPurpleAdapter);
        lottoPurpleAdapter.setLottoPurpleCallBack(new LottoPurpleAdapter.LottoPurpleCallBack() {

            @Override
            public boolean numberContain(int number) {
                return currentBean.purpleContain(number);
            }

            @Override
            public void selectNumber(int number) {
                currentBean.selectPurple(number);
            }
        });

        bottomStatus();
    }

    @Override
    public void bottomStatus() {
        if (bettingBeans == null || bettingBeans.size() == 0) {
            GlideUtil.load(imgBottom, R.mipmap.ic_bet_random_4);
            txtBottom.setText(getString(R.string.machine_selects_4));
        } else {
            GlideUtil.load(imgBottom, R.mipmap.ic_bet_clear);
            txtBottom.setText(getString(R.string.clear));
        }
    }

    @OnClick({R.id.img_shake_hand, R.id.img_bottom, R.id.txt_bottom, R.id.txt_betting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_shake_hand:
                shaking();
                break;
            case R.id.img_bottom:
            case R.id.txt_bottom:
                bottomClick();
                break;
            case R.id.txt_betting:
                toBetting();
                break;
        }
    }

    @Override
    public void bottomClick() {
        if (bettingBeans == null || bettingBeans.size() == 0) {//显示机选4注
            bettingBeans = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                LottoBean lottoBean = new LottoBean();
                lottoBean.randomNumber();
                bettingBeans.add(lottoBean);
            }

            toBetting();
        } else {//清空
            bettingBeans.clear();
            bottomStatus();
        }
    }

    @Override
    public void toBetting() {
        if (currentBean.isAvailable()) {
            bettingBeans.add(currentBean);
        }

        if (bettingBeans.size() == 0) {
            String tips = getString(R.string.betting_at_least_one);
            SnackBarUtil.error(activity, tips);
        } else {
            ARouter.getInstance().build("/betting/lottobetting")
                    .withSerializable("homeBean", homeBean)
                    .withSerializable("bettingBeans", bettingBeans)
                    .navigation(activity);
        }
    }

    @Override
    public void registerSensor() {
        sensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void unregisterSensor() {

    }

    @Override
    public void presenter(LottoSelectContract.Presenter presenter) {
        this.presenter = presenter;
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
                        String category = CategoryEnum.LOTTO.getCategory() + "";
                        String language = SystemUtil.language(activity);
                        BlockChainUrlUtil.gameRule(activity,category, language);

                        dialog.dismiss();
                    }
                });

                view.findViewById(R.id.txt_contractaddress).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String address = homeBean.getContract().getAddress();
                        String url = BlockChainUrlUtil.addressUrl(address, SystemUtil.language(activity));
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
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float[] values = sensorEvent.values;

        if (TimeUtil.timestamp() - lastVibratorTime > 2000) {
            lastVibratorTime = TimeUtil.timestamp();

            if (sensorType == Sensor.TYPE_ACCELEROMETER) {
                if ((Math.abs(values[0]) > SENSOR_VALUE || Math.abs(values[1]) > SENSOR_VALUE || Math.abs(values[2]) > SENSOR_VALUE)) {
                    shaking();
                }
            }
        }
    }

    @Override
    public void shaking() {
        SystemUtil.vibrator(activity);

        currentBean.randomNumber();
        lottoRedAdapter.updateAll();
        lottoPurpleAdapter.updateAll();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
