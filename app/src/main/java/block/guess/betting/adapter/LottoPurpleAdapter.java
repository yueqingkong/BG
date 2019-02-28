package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;

public class LottoPurpleAdapter extends RecyclerView.Adapter<LottoPurpleAdapter.LottoPurpleHolder> {

    private Context context;

    public void updatePosition(int num) {
        lottoCallBack.selectNumber(num);
        notifyDataSetChanged();
    }

    public void updateAll(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LottoPurpleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_ball_select, parent, false);
        LottoPurpleHolder viewHolder = new LottoPurpleHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LottoPurpleHolder holder, int position) {
        final int ballNumber = position + 1;
        holder.ballTxt.setText(String.valueOf(ballNumber));
        holder.ballTxt.setBackgroundResource(R.drawable.selector_oval_645aff_d2f8f1);

        if (lottoCallBack.numberContain(ballNumber)) {
            holder.ballTxt.setSelected(true);
            holder.ballTxt.setTextColor(context.getResources().getColor(R.color.color_white));
        } else {
            holder.ballTxt.setSelected(false);
            holder.ballTxt.setTextColor(context.getResources().getColor(R.color.color_645aff));
        }

        holder.ballTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePosition(ballNumber);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    static class LottoPurpleHolder extends RecyclerView.ViewHolder {

        TextView ballTxt;

        public LottoPurpleHolder(View itemView) {
            super(itemView);
            ballTxt = itemView.findViewById(R.id.txt_ball);
        }
    }

    private LottoPurpleCallBack lottoCallBack;

    public interface LottoPurpleCallBack {

        boolean numberContain(int number);

        void selectNumber(int number);
    }

    public void setLottoPurpleCallBack(LottoPurpleCallBack callBack) {
        this.lottoCallBack = callBack;
    }
}
