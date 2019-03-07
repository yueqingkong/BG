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
import block.guess.my.bean.WinningRecordBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.recyclerview.bean.LoadStatusEnum;

public class WinningRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private WinningRecordCallback recordCallback;

    private LoadStatusEnum statusEnum;
    private List<WinningRecordBean> recordDetailBeans;

    public void updateRecords(List<WinningRecordBean> beans) {
        this.statusEnum = LoadStatusEnum.STATUS_END;
        this.recordDetailBeans = beans;
        notifyDataSetChanged();
    }

    public void appendRecords(List<WinningRecordBean> beans) {
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
            viewHolder = new WiningRecorHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent, false);
            viewHolder = new FooterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WiningRecorHolder) {
            onBindRecordViewHolder((WiningRecorHolder) holder, position);
        } else if (holder instanceof FooterViewHolder) {
            onBindFooterViewHolder((FooterViewHolder) holder);
        }
    }

    protected void onBindRecordViewHolder(@NonNull WiningRecorHolder holder, int position) {
        final WinningRecordBean detailBean = recordDetailBeans.get(position);

        CategoryEnum category = CategoryEnum.parse(detailBean.getContract().getCategory());
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
        }

        String showTime = TimeUtil.timestampFormat(detailBean.getContract().getStart() * 1000, TimeUtil.FORMAT_MONTH_DAY_TIME);
        holder.dateTimeTxt.setText(showTime);

        holder.resultTxt.setText(context.getString(R.string.the_wining));
        holder.winTxt.setVisibility(View.VISIBLE);
        String showWin = context.getString(R.string.win_amount_bch, StringsUtil.decimal(detailBean.getReward()));
        holder.winTxt.setText(showWin);

        String number = context.getString(R.string.no_period, detailBean.getContract().getPeriod());
        holder.numberTxt.setText(number);

        String amountFormat = StringsUtil.decimal(detailBean.getContract().getTotal_amount());
        String explain = context.getString(R.string.bet_and_total, detailBean.getContract().getTimes(), amountFormat);
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

    static class WiningRecorHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView categoryTxt;
        TextView dateTimeTxt;
        TextView resultTxt;
        TextView winTxt;
        TextView numberTxt;
        TextView explainTxt;

        public WiningRecorHolder(View itemView) {
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

    public void setRecordCallback(WinningRecordCallback callback) {
        this.recordCallback = callback;
    }

    public interface WinningRecordCallback {

        void itemClick(WinningRecordBean bean);
    }
}
