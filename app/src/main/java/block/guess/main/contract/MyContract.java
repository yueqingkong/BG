package block.guess.main.contract;

import android.app.Activity;
import android.net.Uri;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface MyContract {
    interface BView extends BaseView<Presenter> {

        void initPlan();

        void initRecord();

        void initAbout();

        void namePopupwindow();

        void avatarPopupwindow();

        void loginOut();

        void loadAvatar(String avatar);

        void updateName(String name);
    }

    interface Presenter extends BasePresenter {

        void updateName(Activity activity, String name);

        void uploadAvatar(Activity activity, Uri uri);
    }
}
