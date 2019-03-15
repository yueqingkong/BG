package block.guess.my.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.my.bean.PartnerDynamicBean;
import block.guess.my.bean.PartnerInviteeBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.TimeUtil;

public class PartnerPlanAdapter extends RecyclerView.Adapter<PartnerPlanAdapter.PartnerPlanHolder> {

    private Context context;
    private List<Object> objectList;

    public void setDatas(List list) {
        this.objectList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PartnerPlanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_partner, parent, false);
        PartnerPlanHolder viewHolder = new PartnerPlanHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerPlanHolder holder, int position) {
        Object object = objectList.get(position);
        if (object instanceof PartnerInviteeBean) {
            partnerInviteeHolder(holder, (PartnerInviteeBean) object);
        } else if(object instanceof PartnerDynamicBean){
            partnerDynamicHolder(holder,(PartnerDynamicBean)object);
        }
    }

    private void partnerInviteeHolder(@NonNull PartnerPlanHolder holder, PartnerInviteeBean bean) {
        long date = bean.getCreated_at();
        String userName = bean.getUsername();

        String showTime = TimeUtil.timestampFormat(date * 1000, TimeUtil.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE);
        holder.leftTxt.setText(showTime);
        holder.rightTxt.setText(userName);
    }

    private void partnerDynamicHolder(@NonNull PartnerPlanHolder holder, PartnerDynamicBean bean) {
        long reward = bean.getReward();

        holder.leftTxt.setText(bean.getUsername());

        String showDivi = "+"+StringsUtil.decimal(reward)+"BCH";
        holder.rightTxt.setText(showDivi);
    }

    @Override
    public int getItemCount() {
        int itemCount = objectList == null ? 0 : objectList.size();
        return itemCount;
    }

    static class PartnerPlanHolder extends RecyclerView.ViewHolder {

        TextView leftTxt;
        TextView rightTxt;

        public PartnerPlanHolder(View itemView) {
            super(itemView);
            leftTxt = itemView.findViewById(R.id.txt_left);
            rightTxt = itemView.findViewById(R.id.txt_right);
        }
    }
}
