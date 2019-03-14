package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.betting.bean.LottoBean;

public class LottoBettingAdapter extends RecyclerView.Adapter<LottoBettingAdapter.LottoBettingHolder> {

    private Context context;
    private LottoBettingCallback lottoBettingCallback;

    private List<LottoBean> lottoBeanList;

    public LottoBettingAdapter(List<LottoBean> beans) {
        this.lottoBeanList = beans;
    }

    public void update(List<LottoBean> beans){
        this.lottoBeanList = beans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LottoBettingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_lotto_betting, parent, false);
        LottoBettingHolder viewHolder = new LottoBettingHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LottoBettingHolder holder, int position) {
        final LottoBean lottoBean = lottoBeanList.get(position);
        List<String> numberList = lottoBean.numberLists();
        String purpleNumber = lottoBean.purpleNumber();

        holder.firstTxt.setText(String.valueOf(numberList.get(0)));
        holder.secondTxt.setText(String.valueOf(numberList.get(1)));
        holder.thirdTxt.setText(String.valueOf(numberList.get(2)));
        holder.fourthTxt.setText(String.valueOf(numberList.get(3)));
        holder.fifthTxt.setText(String.valueOf(numberList.get(4)));
        holder.sixthTxt.setText(String.valueOf(numberList.get(5)));
        holder.purpleTxt.setText(String.valueOf(purpleNumber));

        holder.deleteview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottoBettingCallback.delete(lottoBean);
            }
        });
        holder.body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottoBettingCallback.detail(lottoBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = lottoBeanList == null ? 0 : lottoBeanList.size();
        return count;
    }

    static class LottoBettingHolder extends RecyclerView.ViewHolder {

        ConstraintLayout body;
        View deleteview;
        TextView firstTxt;
        TextView secondTxt;
        TextView thirdTxt;
        TextView fourthTxt;
        TextView fifthTxt;
        TextView sixthTxt;
        TextView purpleTxt;
        View detailTxt;

        public LottoBettingHolder(View itemView) {
            super(itemView);
            body = itemView.findViewById(R.id.constraintlayout_body);
            deleteview = itemView.findViewById(R.id.view_betting_delete);
            firstTxt = itemView.findViewById(R.id.txt_ball_first);
            secondTxt = itemView.findViewById(R.id.txt_ball_second);
            thirdTxt = itemView.findViewById(R.id.txt_ball_third);
            fourthTxt = itemView.findViewById(R.id.txt_ball_fourth);
            fifthTxt = itemView.findViewById(R.id.txt_ball_fifth);
            sixthTxt = itemView.findViewById(R.id.txt_ball_sixth);
            purpleTxt = itemView.findViewById(R.id.txt_ball_purple);
            detailTxt = itemView.findViewById(R.id.view_detail);
        }
    }

    public void setLottoBettingCallback(LottoBettingCallback callback) {
        this.lottoBettingCallback = callback;
    }

    public interface LottoBettingCallback {
        void delete(LottoBean bean);

        void detail(LottoBean bean);
    }
}
