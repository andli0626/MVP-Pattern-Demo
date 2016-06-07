package me.kaede.mvp.login.view;

/**
 *author andli
 *create at 16/6/7 上午10:06
 *	视图逻辑接口：操控视图View
**/

public interface ILoginView {
	// 清空文本输入框
	public void onClearText();
    // 登录结果处理
	public void onLoginResult(Boolean result, int code);
    // 控制进度条对话框
	public void onSetProgressBarVisibility(int visibility);
}
