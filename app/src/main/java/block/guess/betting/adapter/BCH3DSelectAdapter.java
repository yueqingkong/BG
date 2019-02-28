package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;

public class BCH3DSelectAdapter extends RecyclerView.Adapter<BCH3DSelectAdapter.BCH3DHolder> {

    private Context context;
    private int bch3dTag;

    public BCH3DSelectAdapter(int tag) {
        this.bch3dTag = tag;
    }

    public void updatePosition(int position) {
        if (bch3DCallBack.isSelectNumber(bch3dTag, position)) {
            bch3DCallBack.cancel(bch3dTag);
        } else {
            bch3DCallBack.setSelectNumber(bch3dTag, position);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BCH3DHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_bch3d, parent, false);
        BCH3DHolder viewHolder = new BCH3DHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BCH3DHolder holder, final int position) {
        final int ballNumber = position + 1;
        holder.d3Txt.setText(String.valueOf(ballNumber));

        if (bch3DCallBack.isSelectNumber(bch3dTag, ballNumber)) {
            holder.d3Txt.setSelected(true);
            holder.d3Txt.setTextColor(context.getResources().getColor(R.color.color_white));
        } else {
            holder.d3Txt.setSelected(false);
            holder.d3Txt.setTextColor(context.getResources().getColor(R.color.color_645aff));
        }

        holder.d3Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePosition(ballNumber);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    static class BCH3DHolder extends RecyclerView.ViewHolder {

        TextView d3Txt;

        public BCH3DHolder(View itemView) {
            super(itemView);
            d3Txt = itemView.findViewById(R.id.txt_betting_number);
        }
    }

    private BCH3DCallBack bch3DCallBack;

    public interface BCH3DCallBack {

        boolean isSelectNumber(int tag, int number);

        void setSelectNumber(int tag, int number);

        void cancel(int tag);
    }

    public void setBch3DCallBack(BCH3DCallBack bch3DCallBack) {
        this.bch3DCallBack = bch3DCallBack;
    }
}
