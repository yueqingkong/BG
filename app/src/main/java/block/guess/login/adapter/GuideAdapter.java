package block.guess.login.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.ViewHolder> {

    private Activity activity;

    public GuideAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                firstStep(holder);
                break;
            case 1:
                secondStep(holder);
                break;
            case 2:
                thirdStep(holder);
                break;
            case 3:
                threeStep(holder);
                break;
        }
    }

    void firstStep(ViewHolder holder) {
        holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.color_645aff));
        holder.frameView.setBackgroundColor(activity.getResources().getColor(R.color.color_white));
        holder.directImg.setBackgroundResource(R.mipmap.btn_guide_one);

        holder.logoImg.setBackgroundResource(R.mipmap.img_logo_white);
        holder.cardImg.setBackgroundResource(R.mipmap.img_guide_one);

        holder.stepTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.stepTxt.setText(activity.getString(R.string.first_step));

        holder.titleTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.titleTxt.setText(activity.getString(R.string.select_bet));

        holder.explainTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.explainTxt.setText(activity.getString(R.string.first_explain));
    }

    void secondStep(ViewHolder holder) {
        holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.color_white));
        holder.frameView.setBackgroundColor(activity.getResources().getColor(R.color.color_645aff));
        holder.directImg.setBackgroundResource(R.mipmap.btn_guide_two);

        holder.logoImg.setBackgroundResource(R.mipmap.img_logo_purple);
        holder.cardImg.setBackgroundResource(R.mipmap.img_guide_two);

        holder.stepTxt.setTextColor(activity.getResources().getColor(R.color.color_8a94be));
        holder.stepTxt.setText(activity.getString(R.string.second_step));

        holder.titleTxt.setTextColor(activity.getResources().getColor(R.color.color_00115d));
        holder.titleTxt.setText(activity.getString(R.string.fairness_algorthn));

        holder.explainTxt.setTextColor(activity.getResources().getColor(R.color.color_8a94be));
        holder.explainTxt.setText(activity.getString(R.string.second_explain));
    }

    void thirdStep(ViewHolder holder) {
        holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.color_645aff));
        holder.frameView.setBackgroundColor(activity.getResources().getColor(R.color.color_white));
        holder.directImg.setBackgroundResource(R.mipmap.btn_guide_three);

        holder.logoImg.setBackgroundResource(R.mipmap.img_logo_white);
        holder.cardImg.setBackgroundResource(R.mipmap.img_guide_three);

        holder.stepTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.stepTxt.setText(activity.getString(R.string.third_step));

        holder.titleTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.titleTxt.setText(activity.getString(R.string.receive_prize));

        holder.explainTxt.setTextColor(activity.getResources().getColor(R.color.color_white));
        holder.explainTxt.setText(activity.getString(R.string.third_explain));
    }

    void threeStep(ViewHolder holder) {
        holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.color_white));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView logoImg;
        ImageView cardImg;
        TextView stepTxt;
        TextView titleTxt;
        TextView explainTxt;
        View frameView;
        ImageView directImg;

        public ViewHolder(View itemView) {
            super(itemView);
            logoImg = itemView.findViewById(R.id.img_guess_logo);
            cardImg = itemView.findViewById(R.id.img_card);
            stepTxt = itemView.findViewById(R.id.txt_step);
            titleTxt = itemView.findViewById(R.id.txt_title);
            explainTxt = itemView.findViewById(R.id.txt_explain);
            frameView = itemView.findViewById(R.id.view_frame);
            directImg = itemView.findViewById(R.id.img_guide_direct);
        }
    }
}
