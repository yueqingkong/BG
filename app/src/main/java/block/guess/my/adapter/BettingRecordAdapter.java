package block.guess.my.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.my.bean.RecordDetailBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;
import block.guess.widget.recyclerview.bean.LoadStatusEnum;

public class BettingRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private BettingRecordCallback recordCallback;

    private LoadStatusEnum statusEnum;
    private List<RecordDetailBean> recordDetailBeans;

    public BettingRecordAdapter() {
    }

    public void updateRecords(List<RecordDetailBean> beans) {
        this.statusEnum = LoadStatusEnum.STATUS_END;
        this.recordDetailBeans = beans;
        notifyDataSetChanged();
    }

    public void insertRecords(List<RecordDetailBean> beans) {
        this.statusEnum = LoadStatusEnum.STATUS_END;
        this.recordDetailBeans.addAll(beans);
        notifyDataSetChanged();
    }

    public void setEndStatus() {
        this.statusEnum = LoadStatusEnum.STATUS_END;
        statusEnum = LoadStatusEnum.STATUS_END;
        notifyDataSetChanged();
    }

    public void setLoadingStatus() {
        statusEnum = LoadStatusEnum.STATUS_LOADING;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = recordDetailBeans == null || position < recordDetailBeans.size() ? 0 : 1;
        return viewtype;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_betting_record, parent, false);
            viewHolder = new BettingRecorHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent, false);
            viewHolder = new FooterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BettingRecorHolder) {
            onBindRecordViewHolder((BettingRecorHolder) holder, position);
        } else if (holder instanceof FooterViewHolder) {
            onBindFooterViewHolder((FooterViewHolder) holder);
        }
    }

    protected void onBindRecordViewHolder(@NonNull BettingRecorHolder holder, int position) {
        final RecordDetailBean detailBean = recordDetailBeans.get(position);

        CategoryEnum category = CategoryEnum.parse(detailBean.getCategory());
        switch (category) {
            case D3:
                GlideUtil.load(holder.categoryImg, R.mipmap.img_bch_3_d_small);
                holder.categoryTxt.setText(context.getString(R.string.buy_bch3d));
                break;
            case LUCKY:
                GlideUtil.load(holder.categoryImg, R.mipmap.img_luckybch_small);
                holder.categoryTxt.setText(context.getString(R.string.buy_bchlucky));
                break;
            case FREE:
                GlideUtil.load(holder.categoryImg, R.mipmap.img_bch_3_d_small);
                holder.categoryTxt.setText(context.getString(R.string.free_bch_3d));
                break;
            case LOTTO:
                GlideUtil.load(holder.categoryImg, R.mipmap.ic_bchlotto_home);
                holder.categoryTxt.setText(context.getString(R.string.bch_lotto));
                break;
        }

        String showTime = TimeUtil.timestampFormat(detailBean.getCreated_at() * 1000, TimeUtil.FORMAT_MONTH_DAY_TIME);
        holder.dateTimeTxt.setText(showTime);

        StatusEnum status = StatusEnum.parse(detailBean.getStatus());
        switch (status) {
            case WAIT:
                holder.resultTxt.setText(context.getString(R.string.to_be_award));
                holder.winTxt.setVisibility(View.GONE);
                break;
            case WIN:
                holder.resultTxt.setText(context.getString(R.string.the_wining));
                holder.winTxt.setVisibility(View.VISIBLE);
                String showWin = context.getString(R.string.win_amount_bch, StringsUtil.decimal(detailBean.getPrize()));
                holder.winTxt.setText(context.getString(R.string.win_amount_bch, showWin));
                break;
            case NOT_WIN:
                holder.resultTxt.setText(context.getString(R.string.not_award));
                holder.winTxt.setVisibility(View.GONE);
                break;
            case OPEN:
                holder.resultTxt.setText(context.getString(R.string.open_prize));
                holder.winTxt.setVisibility(View.GONE);
                break;
        }

        String number = "NO." + String.valueOf(detailBean.getId());
        holder.numberTxt.setText(number);

        String explain = "";
        String amountFormat = StringsUtil.decimal(detailBean.getTotal_amount());
        if (detailBean.getPurchase_numbers() == null || detailBean.getPurchase_numbers().size() == 0) {
            explain = context.getString(R.string.bet_and_total, 0, amountFormat);
        } else {
            explain = context.getString(R.string.bet_and_total, detailBean.ownPurchase(), amountFormat);
        }
        holder.explainTxt.setText(explain);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordCallback.itemClick(detailBean);
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
        int itemcount = recordDetailBeans == null ? 0 : recordDetailBeans.size() + 1;
        return itemcount;
    }

    static class BettingRecorHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView categoryTxt;
        TextView dateTimeTxt;
        TextView resultTxt;
        TextView winTxt;
        TextView numberTxt;
        TextView explainTxt;

        public BettingRecorHolder(View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.img_category);
            categoryTxt = itemView.findViewById(R.id.txt_category);
            dateTimeTxt = itemView.findViewById(R.id.txt_datetime);
            resultTxt = itemView.findViewById(R.id.txt_result);
            winTxt = itemView.findViewById(R.id.txt_win_bch);
            numberTxt = itemView.findViewById(R.id.txt_number);
            explainTxt = itemView.findViewById(R.id.txt_explain);
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

    public void setRecordCallback(BettingRecordCallback callback) {
        this.recordCallback = callback;
    }

    public interface BettingRecordCallback {

        void itemClick(RecordDetailBean detailBean);
    }
}
