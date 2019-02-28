package block.guess.widget.ribbon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.utils.DensityUtils;
import block.guess.utils.MathUtil;
import block.guess.utils.log.LogUtil;

public class RibbonView extends View {

    private static String TAG = "_RibbonView";
    private Context context;
    private Paint paint;
    private int maxBallNumbers = 100;

    private Timer timer;
    private TimerTask timerTask;

    private Map<String, RibbonBean> ribbonBeanMap = new HashMap<>();

    public RibbonView(Context context) {
        super(context);
        initParams();
    }

    public RibbonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public RibbonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }

    public void initParams() {
        context = getContext();
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        initTimer();
    }

    private void initTimer() {
        cancelTimer();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                LogUtil.d(TAG, "_TimerTask Run");

                postInvalidate();
            }
        };
        timer.schedule(timerTask, 50, 50);
    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public void addAllBeans(final int numbers) {
        this.maxBallNumbers = numbers;

        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);

                int screenWidth = DensityUtils.screenWidth();
                int screenHeight = DensityUtils.screenHeight();
                for (int i = 0; i < maxBallNumbers; i++) {
                    RibbonBean ribbonBean = new RibbonBean();
                    ribbonBean.resource();
                    ribbonBean.parentParams(screenWidth, screenHeight);
                    ribbonBean.randomScale(resourceBitmap());
                    ribbonBean.startPoint();
                    ribbonBeanMap.put(ribbonBean.getTag(), ribbonBean);
                }

                invalidate();
                return true;
            }

            private int[] resourceIds = new int[]{R.mipmap.img_ribbon_01, R.mipmap.img_ribbon_02,
                    R.mipmap.img_ribbon_03, R.mipmap.img_ribbon_04,
                    R.mipmap.img_ribbon_05, R.mipmap.img_ribbon_06};

            private Map<Integer, Bitmap> bitmapMap = new HashMap<>();

            private Bitmap resourceBitmap() {
                Bitmap bitmap = null;
                int random = MathUtil.randomInMax(6);
                if (bitmapMap.containsKey(random)) {
                    bitmap = bitmapMap.get(random);
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1;
                    bitmap = BitmapFactory.decodeResource(context.getResources(), resourceIds[random], options);
                    bitmapMap.put(random, bitmap);
                }
                return bitmap;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawShape(canvas);
    }

    private void drawShape(Canvas canvas) {
        Iterator<Map.Entry<String, RibbonBean>> iterator = ribbonBeanMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, RibbonBean> entry = iterator.next();
            RibbonBean bean = entry.getValue();
            if (bean.fall()) {
                bean.draw(canvas, paint);
            } else {
                iterator.remove();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelTimer();
    }
}
