package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.betting.bean.Betting3DBean;

public class BCH3DBettingAdapter extends RecyclerView.Adapter<BCH3DBettingAdapter.BCH3DBettingHolder> {

    private Context context;
    private BettingItemCallback bettingItemCallback;
    private List<Betting3DBean> betting3DBeans;

    public BCH3DBettingAdapter(List<Betting3DBean> beans) {
        this.betting3DBeans = beans;
    }

    public void updateBettingBeans(List<Betting3DBean> beans) {
        this.betting3DBeans = beans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BCH3DBettingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_betting_selected, parent, false);
        BCH3DBettingHolder viewHolder = new BCH3DBettingHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BCH3DBettingHolder holder, int position) {
        final Betting3DBean betting3DBean = betting3DBeans.get(position);

        holder.firstTxt.setText(String.valueOf(betting3DBean.getFirstNumber()));
        holder.secondTxt.setText(String.valueOf(betting3DBean.getSecondNumber()));
        holder.thirdTxt.setText(String.valueOf(betting3DBean.getThirdNumber()));

        holder.deleteview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bettingItemCallback.deleteItem(betting3DBean);
            }
        });
        holder.detailTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bettingItemCallback.detailItem(betting3DBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        int itemCount = betting3DBeans == null ? 0 : betting3DBeans.size();
        return itemCount;
    }

    static class BCH3DBettingHolder extends RecyclerView.ViewHolder {

        View deleteview;
        TextView firstTxt;
        TextView secondTxt;
        TextView thirdTxt;
        View detailTxt;

        public BCH3DBettingHolder(View itemView) {
            super(itemView);
            deleteview = itemView.findViewById(R.id.view_betting_delete);
            firstTxt = itemView.findViewById(R.id.txt_ball_first);
            secondTxt = itemView.findViewById(R.id.txt_ball_second);
            thirdTxt = itemView.findViewById(R.id.txt_ball_third);
            detailTxt = itemView.findViewById(R.id.view_detail);
        }
    }

    public void setBettingItemCallback(BettingItemCallback callback) {
        this.bettingItemCallback = callback;
    }

    public interface BettingItemCallback {
        void deleteItem(Betting3DBean bean);

        void detailItem(Betting3DBean bean);
    }
}
