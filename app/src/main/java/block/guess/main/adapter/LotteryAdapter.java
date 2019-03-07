package block.guess.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.LotteryBean;
import block.guess.utils.TimeUtil;
import block.guess.widget.recyclerview.bean.LoadStatusEnum;

import java.util.List;

public class LotteryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LoadStatusEnum statusEnum;
    private List<LotteryBean> lotteryBeans;

    private LotteryCallback lotteryCallback;

    public LotteryAdapter(LotteryCallback callback) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryCallback = callback;
    }

    public void setLotteries(List<LotteryBean> pageBeans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryBeans = pageBeans;
        notifyDataSetChanged();
    }

    public void appendLotteries(List<LotteryBean> pageBeans) {
        statusEnum = LoadStatusEnum.STATUS_END;
        this.lotteryBeans.addAll(pageBeans);
        notifyDataSetChanged();
    }

    public void setEndStatus() {
        statusEnum = LoadStatusEnum.STATUS_END;
        notifyDataSetChanged();
    }

    public void clearBeans() {
        if (lotteryBeans != null) {
            lotteryBeans.clear();
        }
        notifyDataSetChanged();
    }

    public void setLoadingStatus() {
        statusEnum = LoadStatusEnum.STATUS_LOADING;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = lotteryBeans == null || position == lotteryBeans.size() ? 0 : 1;
        return viewtype;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent, false);
            viewHolder = new FooterViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_lottery_lottery, parent, false);
            viewHolder = new LotteryViewHolder(view);
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
        final LotteryBean pageBean = lotteryBeans.get(position);

        LotteryViewHolder lotteryViewHolder = (LotteryViewHolder) holder;
        int id = pageBean.getPeriod();
        lotteryViewHolder.numberTxt.setText(context.getResources().getString(R.string.nomber_, id));

        if (pageBean.getLotteries_numbers() == null || pageBean.getLotteries_numbers().size() == 0) {//为空的时候，还未开奖
            lotteryViewHolder.firstTxt.setText("?");
            lotteryViewHolder.secondTxt.setText("?");
            lotteryViewHolder.thirdTxt.setText("?");
        } else {
            LotteryBean.LotteriesNumbersBean numbersBean = pageBean.getLotteries_numbers().get(0);
            lotteryViewHolder.firstTxt.setText(String.valueOf(numbersBean.getAward_number().charAt(0)));
            lotteryViewHolder.secondTxt.setText(String.valueOf(numbersBean.getAward_number().charAt(1)));
            lotteryViewHolder.thirdTxt.setText(String.valueOf(numbersBean.getAward_number().charAt(2)));
        }

        long endTime = pageBean.getOpen_time() * 1000;
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
        int itemcount = lotteryBeans == null ? 0 : lotteryBeans.size() + 1;
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

    static class LottoViewHolder extends RecyclerView.ViewHolder {

        private TextView numberTxt;
        private TextView firstTxt;
        private TextView secondTxt;
        private TextView thirdTxt;
        private TextView fourthTxt;
        private TextView fifthTxt;
        private TextView sixthTxt;
        private TextView seventhTxt;
        private TextView timeTxt;

        public LottoViewHolder(View itemView) {
            super(itemView);
            numberTxt = itemView.findViewById(R.id.txt_no_);
            firstTxt = itemView.findViewById(R.id.txt_ball_first);
            secondTxt = itemView.findViewById(R.id.txt_ball_second);
            thirdTxt = itemView.findViewById(R.id.txt_ball_third);
            fourthTxt = itemView.findViewById(R.id.txt_ball_third);
            fifthTxt = itemView.findViewById(R.id.txt_ball_third);
            sixthTxt = itemView.findViewById(R.id.txt_ball_third);
            seventhTxt = itemView.findViewById(R.id.txt_ball_third);
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
        void itemClick(LotteryBean bean);
    }
}
