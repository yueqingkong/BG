package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;

public class LottoRedAdapter extends RecyclerView.Adapter<LottoRedAdapter.LottoHolder> {

    private Context context;

    public LottoRedAdapter() {
    }

    public void updatePosition(int num) {
        lottoRedCallBack.selectNumber(num);
        notifyDataSetChanged();
    }

    public void updateAll(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LottoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_ball_select, parent, false);
        LottoHolder viewHolder = new LottoHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LottoHolder holder, final int position) {
        final int ballNumber = position + 1;
        holder.ballTxt.setText(String.valueOf(ballNumber));
        holder.ballTxt.setBackgroundResource(R.drawable.selector_oval_white_e1615d);

        if (lottoRedCallBack.numberContain(ballNumber)) {
            holder.ballTxt.setSelected(true);
            holder.ballTxt.setTextColor(context.getResources().getColor(R.color.color_white));
        } else {
            holder.ballTxt.setSelected(false);
            holder.ballTxt.setTextColor(context.getResources().getColor(R.color.color_e1615d));
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
        return 33;
    }

    static class LottoHolder extends RecyclerView.ViewHolder {

        TextView ballTxt;

        public LottoHolder(View itemView) {
            super(itemView);
            ballTxt = itemView.findViewById(R.id.txt_ball);
        }
    }

    private LottoRedCallBack lottoRedCallBack;

    public interface LottoRedCallBack {

        boolean numberContain(int number);

        void selectNumber(int number);
    }

    public void setLottoRedCallBack(LottoRedCallBack callBack) {
        this.lottoRedCallBack = callBack;
    }
}
