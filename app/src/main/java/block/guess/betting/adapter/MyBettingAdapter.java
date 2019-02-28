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
import block.guess.betting.bean.ContractDetailBean;

public class MyBettingAdapter extends RecyclerView.Adapter<MyBettingAdapter.MyBettingViewHolder> {

    private Context context;
    private List<ContractDetailBean.PurchaseHistoryBean> historyBeanList;

    public MyBettingAdapter(List<ContractDetailBean.PurchaseHistoryBean> beans) {
        this.historyBeanList = beans;
    }

    @NonNull
    @Override
    public MyBettingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_mybetting, parent, false);
        MyBettingViewHolder viewHolder = new MyBettingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyBettingViewHolder holder, int position) {
        timeHolder(holder, position);
        betHolder(holder, position);
        contentHolder(holder, position);
        amountHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        int itemcount = historyBeanList == null ? 0 : historyBeanList.size();
        return itemcount;
    }

    private void timeHolder(@NonNull MyBettingViewHolder holder, int position) {
        TextView leftTxt = holder.timeView.findViewById(R.id.txt_left);
        TextView rightTxt = holder.timeView.findViewById(R.id.txt_right);

        leftTxt.setText(context.getString(R.string.times));

        ContractDetailBean.PurchaseHistoryBean bean = historyBeanList.get(position);
        rightTxt.setText(String.valueOf(bean.getTimes()));
    }

    private void betHolder(@NonNull MyBettingViewHolder holder, int position) {
        TextView leftTxt = holder.betView.findViewById(R.id.txt_left);
        TextView rightTxt = holder.betView.findViewById(R.id.txt_right);

        leftTxt.setText(context.getString(R.string.bet));

        ContractDetailBean.PurchaseHistoryBean bean = historyBeanList.get(position);
        rightTxt.setText(String.valueOf(bean.getPurchase_numbers().size()));
    }

    private void contentHolder(@NonNull MyBettingViewHolder holder, int position) {
        TextView leftTxt = holder.contentView.findViewById(R.id.txt_left);
        TextView rightTxt = holder.contentView.findViewById(R.id.txt_right);

        leftTxt.setText(context.getString(R.string.bet));

        ContractDetailBean.PurchaseHistoryBean bean = historyBeanList.get(position);

        StringBuffer stringBuffer = new StringBuffer();
        int length = bean.getPurchase_numbers().size();
        for (int i = 0; i < length; i++) {
            ContractDetailBean.PurchaseHistoryBean.PurchaseNumbersBean numbersBean = bean.getPurchase_numbers().get(i);
            stringBuffer.append(numbersBean.getAward_number());
            if (!(i == 0 || i == length - 1)) {
                stringBuffer.append(",");
            }
        }
        rightTxt.setText(stringBuffer.toString());
    }

    private void amountHolder(@NonNull MyBettingViewHolder holder, int position) {
        TextView leftTxt = holder.amountView.findViewById(R.id.txt_left);
        TextView rightTxt = holder.amountView.findViewById(R.id.txt_right);

        leftTxt.setText(context.getString(R.string.bet));

        ContractDetailBean.PurchaseHistoryBean bean = historyBeanList.get(position);
        rightTxt.setText(String.valueOf(bean.getContract().getAddress()));
    }

    static class MyBettingViewHolder extends RecyclerView.ViewHolder {

        private View timeView;
        private View betView;
        private View contentView;
        private View amountView;

        public MyBettingViewHolder(View itemView) {
            super(itemView);

            timeView = itemView.findViewById(R.id.include_number);
            betView = itemView.findViewById(R.id.include_bet);
            contentView = itemView.findViewById(R.id.include_beting_content);
            amountView = itemView.findViewById(R.id.include_amount);
        }
    }
}
