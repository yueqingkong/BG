package block.guess.main.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.LotteryPageBean;
import block.guess.utils.TimeUtil;
import block.guess.widget.recyclerview.bean.LoadStatusEnum;

public class LotteryLotteryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LoadStatusEnum statusEnum;
    private List<LotteryPageBean> lotteryPageBeans;

    private LotteryCallback lotteryCallback;

    public LotteryLotteryAdapter(LotteryCallback callback) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryCallback = callback;
    }

    public void setLotteries(List<LotteryPageBean> pageBeans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryPageBeans = pageBeans;
        notifyDataSetChanged();
    }

    public void appendLotteries(List<LotteryPageBean> pageBeans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryPageBeans.addAll(pageBeans);
        notifyDataSetChanged();
    }

    public void setEndStatus() {
        statusEnum = LoadStatusEnum.STATUS_END;
        notifyDataSetChanged();
    }

    public void clearBeans(){
        if (lotteryPageBeans != null) {
            lotteryPageBeans.clear();
        }
        notifyDataSetChanged();
    }

    public void setLoadingStatus() {
        statusEnum = LoadStatusEnum.STATUS_LOADING;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = lotteryPageBeans == null || position < lotteryPageBeans.size() ? 0 : 1;
        return viewtype;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_lottery_lottery, parent, false);
            viewHolder = new LotteryViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent, false);
            viewHolder = new FooterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LotteryViewHolder) {
            onBindLotteryViewHolder((LotteryViewHolder) holder, position);
        } else if (holder instanceof FooterViewHolder) {
            onBindFooterViewHolder((FooterViewHolder) holder);
        }
    }

    protected void onBindLotteryViewHolder(@NonNull LotteryViewHolder holder, int position) {
        final LotteryPageBean pageBean = lotteryPageBeans.get(position);

        LotteryViewHolder lotteryViewHolder = (LotteryViewHolder) holder;
        int id = pageBean.getPeriod();
        lotteryViewHolder.numberTxt.setText(context.getResources().getString(R.string.nomber_, id));

        String awardNumber = pageBean.getAward_number();
        if (TextUtils.isEmpty(awardNumber)) {//为空的时候，还未开奖
            awardNumber = "???";
        }

        lotteryViewHolder.firstTxt.setText(String.valueOf(awardNumber.charAt(0)));
        lotteryViewHolder.secondTxt.setText(String.valueOf(awardNumber.charAt(1)));
        lotteryViewHolder.thirdTxt.setText(String.valueOf(awardNumber.charAt(2)));

        long endTime = pageBean.getEnd() * 1000;
        lotteryViewHolder.timeTxt.setText(TimeUtil.timestampFormat(endTime, TimeUtil.FORMAT_MONTH_DAY_TIME));
        lotteryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lotteryCallback.itemClick(pageBean);
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
        int itemcount = lotteryPageBeans == null ? 0 : lotteryPageBeans.size() + 1;
        return itemcount;
    }

    static class LotteryViewHolder extends RecyclerView.ViewHolder {

        private TextView numberTxt;
        private TextView firstTxt;
        private TextView secondTxt;
        private TextView thirdTxt;
        private TextView timeTxt;

        public LotteryViewHolder(View itemView) {
            super(itemView);
            numberTxt = itemView.findViewById(R.id.txt_no_);
            firstTxt = itemView.findViewById(R.id.txt_ball_first);
            secondTxt = itemView.findViewById(R.id.txt_ball_second);
            thirdTxt = itemView.findViewById(R.id.txt_ball_third);
            timeTxt = itemView.findViewById(R.id.txt_time);
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

    public interface LotteryCallback {
        void itemClick(LotteryPageBean bean);
    }
}
