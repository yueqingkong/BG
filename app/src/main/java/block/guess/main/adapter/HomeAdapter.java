package block.guess.main.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.HomeBean;
import block.guess.utils.imageload.GlideUtil;
import block.guess.widget.BettingEndTextView;
import block.guess.widget.ClockCountView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    private Context context;
    private List<HomeBean> homeBeanList;

    public void setHomeBeans(List<HomeBean> beans) {
        this.homeBeanList = beans;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        HomeBean homeBean = homeBeanList.get(position);
        return homeBean.getContract().getCategory();
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HomeHolder viewHolder = null;
        View view = null;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.item_top_game_3d, parent, false);
                viewHolder = new BCH3DHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.item_top_game_lucky, parent, false);
                viewHolder = new BCHLuckyHolder(view);
                break;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.item_top_game_3d, parent, false);
                viewHolder = new BCH3DHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        final HomeBean homeBean = homeBeanList.get(position);
        int category = homeBean.getContract().getCategory();
        switch (category) {
            case 1:
                bch3D((BCH3DHolder) holder, homeBean);
                break;
            case 2:
                bchLucky((BCHLuckyHolder) holder, homeBean);
                break;
            case 3:
                bchLotto((BCH3DHolder) holder, homeBean);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickCallBack.itemClick(homeBean);
            }
        });
    }

    private void bch3D(@NonNull BCH3DHolder holder, HomeBean homeBean) {
        long unit = homeBean.getContract().getUnit();
        long times = homeBean.getContract().getTimes();
        double single = ((double) unit) / (100000000d);
        double win = single * times;

        GlideUtil.load(holder.categoryImg, R.mipmap.ic_bch_3_d_home);
        holder.categoryTxt.setText(context.getString(R.string.bch_3d));
        holder.countView.init(homeBean.getContract().getEnd());
        holder.endTextView.init(R.string.later_to_draw, homeBean.getContract().getStart(), homeBean.getContract().getEnd());

        holder.noteTxt.setText(context.getString(R.string.single_note) + " " + String.format("%.4f", single) + context.getString(R.string.bch));

        SpannableStringBuilder stringBuffer = new SpannableStringBuilder();
        stringBuffer.append(context.getString(R.string.can_win));
        SpannableStringBuilder colorBuilder = new SpannableStringBuilder(String.valueOf(win) + context.getString(R.string.bch));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.color_645aff));
        colorBuilder.setSpan(colorSpan, 0, colorBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuffer.append(colorBuilder);
        holder.winTxt.setText(stringBuffer);
    }

    private void bchLucky(@NonNull BCHLuckyHolder holder, HomeBean homeBean) {
        long unit = homeBean.getContract().getUnit();
        long times = homeBean.getContract().getTimes();
        int remain = 1000 - homeBean.getContract().getRemaining();

        double single = ((double) unit) / (100000000d);
        double win = single * times;

        GlideUtil.load(holder.categoryImg, R.mipmap.ic_bchlucky_home);
        holder.categoryTxt.setText(context.getString(R.string.bch_lucky));
        holder.explainTxt.setText(context.getString(R.string.remain_full, remain, 1000));
        holder.noteTxt.setText(context.getString(R.string.single_note) + " " + String.format("%.4f", single) + context.getString(R.string.bch));
        holder.winTxt.setText(String.valueOf(win));

        SpannableStringBuilder stringBuffer = new SpannableStringBuilder();
        stringBuffer.append(context.getString(R.string.can_win));
        SpannableStringBuilder colorBuilder = new SpannableStringBuilder(String.valueOf(win) + context.getString(R.string.bch));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.color_645aff));
        colorBuilder.setSpan(colorSpan, 0, colorBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuffer.append(colorBuilder);
        holder.winTxt.setText(stringBuffer);
    }

    private void bchLotto(@NonNull BCH3DHolder holder, HomeBean homeBean) {
        long unit = homeBean.getContract().getUnit();
        long times = homeBean.getContract().getTimes();
        double single = ((double) unit) / (100000000d);
        double win = single * times;

        GlideUtil.load(holder.categoryImg, R.mipmap.ic_bchlotto_home);
        holder.categoryTxt.setText(context.getString(R.string.bch_lotto));
        holder.countView.init(homeBean.getContract().getEnd());
        holder.endTextView.init(R.string.later_to_draw, homeBean.getContract().getStart(), homeBean.getContract().getEnd());

        holder.noteTxt.setText(context.getString(R.string.single_note) + " " + String.format("%.4f", single) + context.getString(R.string.bch));

        SpannableStringBuilder stringBuffer = new SpannableStringBuilder();
        stringBuffer.append(context.getString(R.string.can_win));
        SpannableStringBuilder colorBuilder = new SpannableStringBuilder(String.valueOf(win) + context.getString(R.string.bch));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.color_645aff));
        colorBuilder.setSpan(colorSpan, 0, colorBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuffer.append(colorBuilder);
        holder.winTxt.setText(stringBuffer);
    }

    @Override
    public int getItemCount() {
        int itemCount = homeBeanList == null ? 0 : homeBeanList.size();
        return itemCount;
    }

    static class BCH3DHolder extends HomeHolder {

        ClockCountView countView;
        BettingEndTextView endTextView;

        public BCH3DHolder(View itemView) {
            super(itemView);
            countView = itemView.findViewById(R.id.view_clock);
            endTextView = itemView.findViewById(R.id.txt_date_end);
        }
    }

    static class BCHLuckyHolder extends HomeHolder {

        TextView explainTxt;

        public BCHLuckyHolder(View itemView) {
            super(itemView);
            explainTxt = itemView.findViewById(R.id.txt_explain);
        }
    }

    static class HomeHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView categoryTxt;
        TextView playTxt;
        TextView noteTxt;
        TextView winTxt;

        public HomeHolder(View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.img_category);
            categoryTxt = itemView.findViewById(R.id.txt_category);
            playTxt = itemView.findViewById(R.id.txt_play);
            noteTxt = itemView.findViewById(R.id.txt_single_note);
            winTxt = itemView.findViewById(R.id.txt_win);
        }
    }

    private HomeItemClickCallBack clickCallBack;

    public interface HomeItemClickCallBack {
        void itemClick(HomeBean homeBean);
    }

    public void setClickCallBack(HomeItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }
}
