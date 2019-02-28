package block.guess.main.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.main.bean.BannerBean;
import block.guess.utils.imageload.GlideUtil;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.AdvertHolder> {

    private Context context;
    private BannerCallback bannerCallback;

    private Timer timer;
    private TimerTask timerTask;

    private List<BannerBean> bannerBeanList;

    public void updateBeans(List<BannerBean> beans) {
        this.bannerBeanList = beans;
        notifyDataSetChanged();

        lauchTimer();
    }

    @NonNull
    @Override
    public AdvertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
        AdvertHolder viewHolder = new AdvertHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertHolder holder, int position) {
        final BannerBean bannerBean = bannerBeanList.get(position);

        // TODO: 2018/11/17 图片不能访问
        // GlideUtil.load(holder.bannerImg, bannerBean.getUrl());
        GlideUtil.load(holder.bannerImg, bannerBean.getCategory() == 2 ?
                R.mipmap.img_banner_invite : R.mipmap.img_banner_new);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bannerCallback.itemBannerClick(bannerBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = bannerBeanList == null ? 0 : bannerBeanList.size();
        return count;
    }

    static class AdvertHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView bannerImg;

        public AdvertHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            bannerImg = itemView.findViewById(R.id.img_banner);
        }
    }

    public void setBannerCallback(BannerCallback bannerCallback) {
        this.bannerCallback = bannerCallback;
    }

    public interface BannerCallback {

        void itemBannerClick(BannerBean bean);

        void bannerScroll();
    }

    private Handler handler = new Handler(Looper.myLooper()) {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 120:
                    bannerCallback.bannerScroll();
                    break;
            }
        }
    };

    public void lauchTimer() {
        cancelTimer();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(120);
            }
        };
        timer.schedule(timerTask, 1000, 5000);
    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }
}
