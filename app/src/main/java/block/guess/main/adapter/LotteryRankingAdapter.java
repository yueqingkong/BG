package block.guess.main.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.RankingBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.widget.roundedimageview.RoundedImageView;

public class LotteryRankingAdapter extends RecyclerView.Adapter<LotteryRankingAdapter.LuckyHolder> {

    private List<RankingBean> rankingBeanList;

    public void setRankingBeanList(List<RankingBean> beans) {
        this.rankingBeanList = beans;
        notifyDataSetChanged();
    }

    public void appendRankingBeanList(List<RankingBean> beans) {
        this.rankingBeanList.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LuckyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lottery_ranking, parent, false);
        LuckyHolder viewHolder = new LuckyHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LuckyHolder holder, int position) {
        RankingBean rankingBean = rankingBeanList.get(position);

        if (position == 0) {
            holder.rankingTxt.setText("");
            holder.rankingTxt.setBackgroundResource(R.mipmap.ic_first_place);
        } else if (position == 1) {
            holder.rankingTxt.setText("");
            holder.rankingTxt.setBackgroundResource(R.mipmap.ic_second_place);
        } else if (position == 2) {
            holder.rankingTxt.setText("");
            holder.rankingTxt.setBackgroundResource(R.mipmap.ic_third_place);
        } else {
            int showPosition = position + 1;
            String placeString = showPosition < 10 ? "0" + showPosition : String.valueOf(showPosition);
            holder.rankingTxt.setText(placeString);
            holder.rankingTxt.setBackground(null);
        }

        String avatar = rankingBean.getAvatar();
        GlideUtil.avatar(holder.avatarImg, avatar);

        String name = rankingBean.getUsername();
        holder.nameTxt.setText(StringsUtil.nameEllipsis(name, 11));

        String address = rankingBean.getAddress();
        holder.addressTxt.setText(address);

        String reward = rankingBean.getReward();
        if (!TextUtils.isEmpty(reward)) {
            long win = Long.parseLong(reward);
            holder.winTxt.setText(String.format("+%.1fBCH", ((double) win) / (100000000)));
        }
    }

    @Override
    public int getItemCount() {
        int itemcount = rankingBeanList == null ? 0 : rankingBeanList.size();
        return itemcount;
    }

    protected static class LuckyHolder extends RecyclerView.ViewHolder {

        private TextView rankingTxt;
        private RoundedImageView avatarImg;
        private TextView nameTxt;
        private TextView addressTxt;
        private TextView winTxt;

        public LuckyHolder(View itemView) {
            super(itemView);
            rankingTxt = itemView.findViewById(R.id.txt_ranking_order);
            avatarImg = itemView.findViewById(R.id.img_ranking_avatar);
            nameTxt = itemView.findViewById(R.id.txt_ranking_name);
            addressTxt = itemView.findViewById(R.id.txt_ranking_address);
            winTxt = itemView.findViewById(R.id.txt_ranking_win);
        }
    }
}
