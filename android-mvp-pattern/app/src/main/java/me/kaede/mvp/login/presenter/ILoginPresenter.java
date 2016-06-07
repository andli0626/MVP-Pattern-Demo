package me.kaede.mvp.login.presenter;

/**
 * author andli
 * create at 16/6/7 上午11:01
 * 登录逻辑处理接口
 **/

public interface ILoginPresenter {
    // 清空
    void clear();

    // 执行登录
    void doLogin(String name, String passwd);

    // 设置进度条对话框
    void setProgressBarVisiblity(int visiblity);
}
