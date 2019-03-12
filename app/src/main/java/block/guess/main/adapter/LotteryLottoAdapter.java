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

import java.util.ArrayList;
import java.util.List;

public class LotteryLottoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LoadStatusEnum statusEnum;
    private List<LotteryBean> lotteryBeans;

    private LotteryAdapter.LotteryCallback lotteryCallback;

    public LotteryLottoAdapter(LotteryAdapter.LotteryCallback callback) {
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
            View view = LayoutInflater.from(context).inflate(R.layout.item_lottery_lotto, parent, false);
            viewHolder = new LottoViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LottoViewHolder) {
            onBindLottoViewHolder((LottoViewHolder) holder, position);
        } else if (holder instanceof FooterViewHolder) {
            onBindFooterViewHolder((FooterViewHolder) holder);
        }
    }

    protected void onBindLottoViewHolder(@NonNull LottoViewHolder holder, int position) {
        final LotteryBean pageBean = lotteryBeans.get(position);

        LottoViewHolder lottoViewHolder = holder;
        int id = pageBean.getPeriod();
        lottoViewHolder.numberTxt.setText(context.getResources().getString(R.string.nomber_, id));

        if (pageBean.getLotteries_numbers() == null || pageBean.getLotteries_numbers().size() == 0) {//为空的时候，还未开奖
            lottoViewHolder.firstTxt.setText("?");
            lottoViewHolder.secondTxt.setText("?");
            lottoViewHolder.thirdTxt.setText("?");
            lottoViewHolder.fourthTxt.setText("?");
            lottoViewHolder.fifthTxt.setText("?");
            lottoViewHolder.sixthTxt.setText("?");
            lottoViewHolder.seventhTxt.setText("?");
        } else {
            List<LotteryBean.LotteriesNumbersBean> numbersBeanList = pageBean.getLotteries_numbers();

            String blueNum = "";
            List<String> redNums = new ArrayList<>();
            for (LotteryBean.LotteriesNumbersBean bean : numbersBeanList) {
                if(bean.getCategory() ==3){
                    blueNum = bean.getAward_number();
                }else {
                    redNums.add(bean.getAward_number());
                }
            }

            lottoViewHolder.firstTxt.setText(redNums.get(0));
            lottoViewHolder.secondTxt.setText(redNums.get(1));
            lottoViewHolder.thirdTxt.setText(redNums.get(2));
            lottoViewHolder.fourthTxt.setText(redNums.get(3));
            lottoViewHolder.fifthTxt.setText(redNums.get(4));
            lottoViewHolder.sixthTxt.setText(redNums.get(5));
            lottoViewHolder.seventhTxt.setText(blueNum);
        }

        long endTime = pageBean.getOpen_time() * 1000;
        lottoViewHolder.timeTxt.setText(TimeUtil.timestampFormat(endTime, TimeUtil.FORMAT_MONTH_DAY_TIME));
        lottoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
            fourthTxt = itemView.findViewById(R.id.txt_ball_fourth);
            fifthTxt = itemView.findViewById(R.id.txt_ball_fifth);
            sixthTxt = itemView.findViewById(R.id.txt_ball_sixth);
            seventhTxt = itemView.findViewById(R.id.txt_ball_seventh);
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
}