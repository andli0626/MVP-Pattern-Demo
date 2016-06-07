package me.kaede.mvp.login.presenter;

import android.os.Handler;
import android.os.Looper;

import me.kaede.mvp.login.model.IUser;
import me.kaede.mvp.login.model.UserModel;
import me.kaede.mvp.login.view.ILoginView;

/**
 * author andli
 * create at 16/6/7 上午10:58
 * 登录逻辑处理 Presenter
 * 作为View和Model之间的纽带
 **/

public class LoginPresenterCompl implements ILoginPresenter {

    // 视图逻辑接口
    ILoginView  iLoginView;
    // 业务逻辑接口
    IUser       user;

    Handler     handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("mvp", "mvp");
    }

    /******************************** 实现ILoginPresenter接口:进行业务逻辑的相关操作 START ********************************/
    // 清空
    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    // 执行登录
    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);

        if (code != 0) isLoginSuccess = false;

        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);

    }

    // 设置进度条对话框
    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }
    /******************************** 实现ILoginPresenter接口:进行业务逻辑的相关操作 END ********************************/


}
