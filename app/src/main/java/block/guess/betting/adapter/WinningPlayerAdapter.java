package block.guess.betting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.imageload.GlideUtil;

public class WinningPlayerAdapter extends RecyclerView.Adapter<WinningPlayerAdapter.WinningPlayerViewHolder> {

    private Context context;
    private List<ContractDetailBean.WinnerListBean> winningPlayerList;

    public WinningPlayerAdapter(List<ContractDetailBean.WinnerListBean> list) {
        this.winningPlayerList = list;
    }

    @NonNull
    @Override
    public WinningPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_winning_player, parent, false);
        WinningPlayerViewHolder viewHolder = new WinningPlayerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WinningPlayerViewHolder holder, int position) {
        ContractDetailBean.WinnerListBean bean = winningPlayerList.get(position);

        GlideUtil.load(holder.avatarImg, bean.getAvatar());
        holder.nameTxt.setText(bean.getUsername());

        holder.txidTxt.setText(context.getString(R.string.txid));
        String txid = StringsUtil.ellipsisStartEnd(bean.getTx_hash());
        holder.txidValueTxt.setText(txid);

        holder.timeTxt.setText(context.getString(R.string.times));
        holder.timeValueTxt.setText(String.valueOf(bean.getPurchase_numbers().size()));

        holder.amountTxt.setText("+" + StringsUtil.decimal(bean.getReward()) + "BCH");
    }

    @Override
    public int getItemCount() {
        int itemCount = winningPlayerList == null ? 0 : winningPlayerList.size();
        return itemCount;
    }

    static class WinningPlayerViewHolder extends RecyclerView.ViewHolder {

        private ImageView avatarImg;
        private TextView nameTxt;
        private TextView txidTxt;
        private TextView txidValueTxt;
        private TextView timeTxt;
        private TextView timeValueTxt;
        private TextView amountTxt;

        public WinningPlayerViewHolder(View itemView) {
            super(itemView);
            avatarImg = itemView.findViewById(R.id.img_useravatar);
            nameTxt = itemView.findViewById(R.id.txt_name);
            txidTxt = itemView.findViewById(R.id.txt_txid);
            txidValueTxt = itemView.findViewById(R.id.txt_txid_value);
            timeTxt = itemView.findViewById(R.id.txt_time);
            timeValueTxt = itemView.findViewById(R.id.txt_time_value);
            amountTxt = itemView.findViewById(R.id.txt_bch);
        }
    }
}
