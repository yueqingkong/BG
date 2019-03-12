package block.guess.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.HistoryBean;
import block.guess.utils.MathUtil;
import block.guess.utils.TimeUtil;
import block.guess.wallet.bean.TransactionCategoryEnum;
import block.guess.widget.recyclerview.bean.LoadStatusEnum;

public class WalletAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LoadStatusEnum statusEnum;
    private List<HistoryBean.ItemsBean> historyBeans=new ArrayList<>();
    private TransactionCallback transactionCallback;

    public void setHistoryBeans(List<HistoryBean.ItemsBean> beans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.historyBeans.addAll(beans);
        notifyDataSetChanged();
    }

    public void appendHistoryBeans(List<HistoryBean.ItemsBean> beans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.historyBeans.addAll(beans);
        notifyDataSetChanged();
    }

    public void setEndStatus() {
        statusEnum = LoadStatusEnum.STATUS_END;
        notifyDataSetChanged();
    }

    public void setLoadingStatus() {
        statusEnum = LoadStatusEnum.STATUS_LOADING;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = historyBeans == null || position < historyBeans.size() ? 0 : 1;
        return viewtype;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_transaction_history, parent, false);
            viewHolder = new WalletViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent, false);
            viewHolder = new FooterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WalletViewHolder) {
            onBHistoryindViewHolder((WalletViewHolder) holder, position);
        } else if (holder instanceof FooterViewHolder) {
            onBindFooterViewHolder((FooterViewHolder) holder);
        }
    }

    protected void onBHistoryindViewHolder(@NonNull WalletViewHolder holder, int position) {
        final HistoryBean.ItemsBean itemsBean = historyBeans.get(position);

        int category = itemsBean.getOp_category().getCategory();
        holder.categoryImg.setBackgroundResource(TransactionCategoryEnum.resourceId(context, category));
        holder.categoryTxt.setText(TransactionCategoryEnum.string(context, category));

        String showTime = TimeUtil.timestampFormat(itemsBean.getCreated_at()*1000, TimeUtil.FORMAT_TIME);
        holder.timestampTxt.setText(showTime);

        long diff = itemsBean.getBalance_diff();
        String showAmount = (diff > 0 ? "+" : "") + MathUtil.format(diff);
        holder.amountTxt.setText(String.format("%sBCH", showAmount));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionCallback.historyClick(itemsBean);
            }
        });
    }

    protected void onBindFooterViewHolder(@NonNull FooterViewHolder holder) {
        if (statusEnum == LoadStatusEnum.STATUS_LOADING) {
            holder.progressBar.setVisibility(View.VISIBLE);
            holder.statusTxt.setText(context.getString(R.string.loading));
        } else if (statusEnum == LoadStatusEnum.STATUS_END) {
            holder.progressBar.setVisibility(View.GONE);
            holder.statusTxt.setText(context.getString(R.string.no_more_data));
        }
    }

    @Override
    public int getItemCount() {
        int itemcount = historyBeans == null ? 0 : historyBeans.size() + 1;
        return itemcount;
    }

    static class WalletViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView categoryTxt;
        TextView timestampTxt;
        TextView amountTxt;

        public WalletViewHolder(View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.img_history_category);
            categoryTxt = itemView.findViewById(R.id.txt_transaction_history_category);
            timestampTxt = itemView.findViewById(R.id.txt_transaction_timestamp);
            amountTxt = itemView.findViewById(R.id.txt_transaction_amount);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {

        private ProgressBar progressBar;
        private TextView statusTxt;

        public FooterViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.pb_loading);
            statusTxt = itemView.findViewById(R.id.txt_status);
        }
    }

    public void setTransactionCallback(TransactionCallback transactionCallback) {
        this.transactionCallback = transactionCallback;
    }

    public interface TransactionCallback {

        void historyClick(HistoryBean.ItemsBean itemsBean);
    }
}
