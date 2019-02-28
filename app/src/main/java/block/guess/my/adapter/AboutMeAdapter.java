package block.guess.my.adapter;

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
import block.guess.my.bean.AboutMeBean;
import block.guess.utils.imageload.GlideUtil;

public class AboutMeAdapter extends RecyclerView.Adapter<AboutMeAdapter.AboutMeHolder> {

    private List<AboutMeBean> aboutMeBeanList;
    private AboutMeCallBack aboutMeCallBack;

    private Context context;

    public AboutMeAdapter(List<AboutMeBean> list) {
        this.aboutMeBeanList = list;
    }

    @NonNull
    @Override
    public AboutMeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_aboutme, parent, false);
        AboutMeHolder viewHolder = new AboutMeHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AboutMeHolder holder, int position) {
        final AboutMeBean aboutMeBean = aboutMeBeanList.get(position);

        GlideUtil.load(holder.categoryImg, aboutMeBean.getResId());
        holder.nameTxt.setText(aboutMeBean.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                aboutMeCallBack.itemClick(aboutMeBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aboutMeBeanList.size();
    }

    static class AboutMeHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView nameTxt;

        public AboutMeHolder(View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.img_category);
            nameTxt = itemView.findViewById(R.id.txt_name);
        }
    }

    public void setAboutMeCallBack(AboutMeCallBack callBack) {
        this.aboutMeCallBack = callBack;
    }

    public interface AboutMeCallBack {

        void itemClick(AboutMeBean bean);
    }
}
