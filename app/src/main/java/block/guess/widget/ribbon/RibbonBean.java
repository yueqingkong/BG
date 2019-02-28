package block.guess.widget.ribbon;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import block.guess.utils.MathUtil;
import block.guess.utils.log.LogUtil;

public class RibbonBean {

    private static String TAG = "_RibbonBean";
    private String tag;
    private static final float P = (float) Math.PI;//π

    private int speed;

    private int parentWidth;
    private int parentHeight;
    private int scrollX;
    private int scrollY;
    private double scrollXUnit;

    private Bitmap newBitmap;

    public RibbonBean() {
    }

    /**
     * 初始化资源及速度
     */
    public void resource() {
        tag = MathUtil.randomInMax(1000) + "_" + MathUtil.randomInMax(10000);
        this.speed = MathUtil.randomInMax(50) + 10;
        this.scrollXUnit = P * MathUtil.random(3) * (MathUtil.random() ? -1d : 1d);
    }

    /**
     * 初始化父组件大小
     *
     * @param pw
     * @param ph
     */
    public void parentParams(int pw, int ph) {
        this.parentWidth = pw;
        this.parentHeight = ph;
    }

    /**
     * 初始化开始大小
     */
    public void randomScale(Bitmap bitmap) {
        float scale = (float) MathUtil.random(1);

        LogUtil.d(TAG, "scale: " + scale);
        if (scale < 0.1f) {// 缩放大小大于0.1,否则会默认为0
            scale += 0.1f;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        LogUtil.d(TAG, "width: " + width + "-- height: " + height);
        newBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /**
     * 初始化起始位置
     */
    public void startPoint() {
        this.scrollX = MathUtil.randomInMax(parentWidth);
        this.scrollY = -MathUtil.randomInMax(parentHeight / 3);
    }

    /**
     * 掉落 重置位置
     */
    public boolean fall() {
        this.scrollX += scrollXUnit;
        this.scrollY = scrollY + speed;
        return scrollY < parentHeight;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (newBitmap != null && !newBitmap.isRecycled()) {
            canvas.drawBitmap(newBitmap, scrollX, scrollY, paint);
        }
    }

    public String getTag() {
        return tag;
    }
}
