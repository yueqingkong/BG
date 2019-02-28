package block.guess.widget.recyclerview.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseApp;

public class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint;
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int diverBottom;
    private boolean lastItem;

    public BaseItemDecoration(int left, int top, int right) {
        this(left, top, right, 0, R.color.color_d3d8ef, 0, false);
    }

    public BaseItemDecoration(int left, int top, int right, int diver) {
        this(left, top, right, 0, R.color.color_d3d8ef, diver, false);
    }

    public BaseItemDecoration(int left, int top, int right, int bottom, int colorid, int diver, boolean last) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.diverBottom = diver;
        this.lastItem = last;

        Context context = BaseApp.getBaseApp().getBaseContext();
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(1f);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(context.getResources().getColor(colorid));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = left;
        outRect.top = top;
        outRect.right = right;
        outRect.bottom = bottom;

        int position = parent.getChildAdapterPosition(view);
        int lastPosition = state.getItemCount() - 1;
        if (position == lastPosition) {
            outRect.bottom = top;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        if (diverBottom != 0) {
            int r = parent.getWidth() - right;
            int count = lastItem ? childCount : childCount - 1;

            for (int i = 0; i < count; i++) {
                View view = parent.getChildAt(i);
                float linetop = view.getBottom() - diverBottom;
                float linebottom = view.getBottom();
                c.drawRect(left, linetop, r, linebottom, paint);
            }
        }
    }
}
