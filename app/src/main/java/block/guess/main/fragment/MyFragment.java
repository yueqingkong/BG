package block.guess.main.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.login.bean.UserInfoBean;
import block.guess.main.MainActivity;
import block.guess.main.contract.MyContract;
import block.guess.main.presenter.MyPresenter;
import block.guess.utils.file.FileUtils;
import block.guess.utils.imageload.GlideUtil;
import block.guess.utils.log.LogUtil;
import block.guess.utils.share.AppInfo;
import block.guess.widget.dialog.DialogUtil;
import block.guess.widget.dialog.bean.DialogCallback;
import block.guess.widget.roundedimageview.RoundedImageView;
import block.guess.widget.snackbar.SnackBarUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends BaseFragment implements MyContract.BView {

    @BindView(R.id.img_signout)
    ImageView imgSignout;
    @BindView(R.id.constraintlayout_signout)
    ConstraintLayout constraintlayoutSignout;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.constraintlayout_record)
    ConstraintLayout constraintlayoutRecord;
    @BindView(R.id.constraintlayout_about)
    ConstraintLayout constraintlayoutAbout;
    @BindView(R.id.img_useravatar)
    RoundedImageView imgUseravatar;

    private static MyFragment myFragment;

    public static MyFragment my() {
        if (myFragment == null) {
            myFragment = new MyFragment();
        }
        return myFragment;
    }

    private static String TAG = "_MyFragment";
    private Activity activity;
    private View baseView;

    private MyContract.Presenter presenter;
    private Uri tempUri;
    private Uri desUri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_tab_my, container, false);
        ButterKnife.bind(this, baseView);
        new MyPresenter(this).start();
        return baseView;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            presenter.start();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void init() {
        activity = getActivity();

        if (AppInfo.getAppInfo().userExist()) {
            UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
            txtName.setText(infoBean.getUsername());
            txtEmail.setText(infoBean.getEmail());
            GlideUtil.load(imgUseravatar, infoBean.getAvatar());
        } else {
            ((MainActivity) activity).onPageSelected(0);
        }
    }

    @Override
    public void initPlan() {
        View view = baseView.findViewById(R.id.include_my_part_plan);
        view.setBackgroundResource(R.drawable.shape_rectangle_white_r12);

        TextView textView = view.findViewById(R.id.txt_my_catergory);
        ImageView imageView = view.findViewById(R.id.img_my_catergory);

        textView.setText(getResources().getString(R.string.partner_plan));
        imageView.setBackgroundResource(R.mipmap.ic_my_partner);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/my/partnerplan")
                        .navigation(activity);
            }
        });
    }

    @Override
    public void initRecord() {
        View view = baseView.findViewById(R.id.constraintlayout_record);
        View bettingView = view.findViewById(R.id.include_my_part_record_betting);
        View winningView = view.findViewById(R.id.include_my_part_record_winning);

        TextView bettingTxt = bettingView.findViewById(R.id.txt_my_catergory);
        ImageView bettingImg = bettingView.findViewById(R.id.img_my_catergory);
        bettingTxt.setText(getResources().getString(R.string.betting_record));
        bettingImg.setBackgroundResource(R.mipmap.ic_my_bet);

        TextView winningTxt = winningView.findViewById(R.id.txt_my_catergory);
        ImageView winningImg = winningView.findViewById(R.id.img_my_catergory);
        winningTxt.setText(getResources().getString(R.string.winning_record));
        winningImg.setBackgroundResource(R.mipmap.ic_my_win);

        bettingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/my/bettingrecord")
                        .navigation(activity);
            }
        });
        winningView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/my/winningrecord")
                        .navigation(activity);
            }
        });
    }

    @Override
    public void initAbout() {
        View view = baseView.findViewById(R.id.constraintlayout_about);
        View passwordView = view.findViewById(R.id.include_my_part_about_chagnge_password);
        View aboutView = view.findViewById(R.id.include_my_part_about_about_us);

        TextView passwordTxt = passwordView.findViewById(R.id.txt_my_catergory);
        ImageView passwordImg = passwordView.findViewById(R.id.img_my_catergory);
        passwordTxt.setText(getResources().getString(R.string.change_password));
        passwordImg.setBackgroundResource(R.mipmap.ic_my_password);
        passwordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/my/changepassword")
                        .navigation(activity);
            }
        });

        TextView aboutTxt = aboutView.findViewById(R.id.txt_my_catergory);
        ImageView aboutImg = aboutView.findViewById(R.id.img_my_catergory);
        aboutTxt.setText(getResources().getString(R.string.about_us));
        aboutImg.setBackgroundResource(R.mipmap.ic_my_us);
        aboutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/my/aboutme").navigation(activity);
            }
        });
    }

    @OnClick({R.id.txt_name, R.id.constraintlayout_signout, R.id.img_useravatar})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_name:
                namePopupwindow();
                break;
            case R.id.img_useravatar:
                avatarPopupwindow();
                break;
            case R.id.constraintlayout_signout:
                loginOut();
                break;
        }
    }

    @Override
    public void presenter(MyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void namePopupwindow() {
        DialogUtil.show(activity, R.layout.dialog_nick_name, new DialogCallback() {
            @Override
            public void createView(final Dialog dialog, final View view) {
                TextView cancelTxt = view.findViewById(R.id.txt_left);
                cancelTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                String userName = txtName.getText().toString();
                final EditText nameEdit = view.findViewById(R.id.edit_username);
                nameEdit.setText(userName);

                TextView confirmTxt = view.findViewById(R.id.txt_right);
                confirmTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String string = nameEdit.getText().toString();

                        if (TextUtils.isEmpty(string)) {
                            SnackBarUtil.error(activity, activity.getString(R.string.name_empty));
                        } else {
                            presenter.updateName(activity, string);
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void avatarPopupwindow() {
        View popView = LayoutInflater.from(activity).inflate(R.layout.popupwindow_update_avatar, null);

        final PopupWindow popupWindow = new PopupWindow(popView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        ColorDrawable dw = new ColorDrawable(0x30000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.showAsDropDown(getView().getRootView(), 0, 0);

        TextView takephotoTxt = popView.findViewById(R.id.txt_takephoto);
        takephotoTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File tempFile = FileUtils.tempFile("", ".png");

                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //通过FileProvider创建一个content类型的Uri
                    tempUri = FileProvider.getUriForFile(getContext(), "block.guess.fileProvider", tempFile);
                } else {
                    tempUri = Uri.parse(tempFile.getAbsolutePath());
                }

                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                //将拍照结果保存至photo_file的Uri中，不保留在相册中
                intent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                startActivityForResult(intent, 120);

                popupWindow.dismiss();
            }
        });

        TextView albumTxt = popView.findViewById(R.id.txt_album);
        albumTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 130);

                popupWindow.dismiss();
            }
        });

        View topView = popView.findViewById(R.id.view_top);
        topView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    public void imageCrop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 200);
        intent.putExtra("scale", true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //开启临时权限
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //重点:针对7.0以上的操作
            intent.setClipData(ClipData.newRawUri(MediaStore.EXTRA_OUTPUT, uri));
            desUri = uri;
        } else {
            //将剪切的图片保存到目标Uri中
            File desFile = FileUtils.tempFile("", ".png");
            desUri = Uri.parse(desFile.getAbsolutePath());
        }

        intent.putExtra(MediaStore.EXTRA_OUTPUT, desUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, 140);
    }

    @Override
    public void loginOut() {
        DialogUtil.alert(activity, "", getString(R.string.confirm_logout), getString(R.string.cancel), getString(R.string.confirm), new DialogUtil.AlertCallback() {
            @Override
            public void cancelClick() {

            }

            @Override
            public void confirmClick() {
                AppInfo.getAppInfo().removeUser();
                AppInfo.getAppInfo().removeBalance();

                ARouter.getInstance().build("/login/login").navigation(activity);
            }
        });
    }

    @Override
    public void updateName(String name) {
        txtName.setText(name);
    }

    @Override
    public void loadAvatar(String avatar) {
        GlideUtil.load(imgUseravatar, avatar);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 120:
                LogUtil.d(TAG, "Take Photo");
                imageCrop(tempUri);
                break;
            case 130:
                LogUtil.d(TAG, "Album");
                imageCrop(data.getData());
                break;
            case 140:
                presenter.uploadAvatar(activity, desUri);
                break;
        }
    }
}
