package me.kaede.mvp.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import me.kaede.mvp.R;
import me.kaede.mvp.login.presenter.ILoginPresenter;
import me.kaede.mvp.login.presenter.LoginPresenterCompl;
import me.kaede.mvp.login.view.ILoginView;

/**
 * author andli
 * create at 16/6/7 上午10:29
 * 登录界面：实现ILoginView接口
 **/

public class LoginActivity extends Activity implements ILoginView, View.OnClickListener {

	private EditText 	editUser;
	private EditText 	editPass;

	private Button   	btnLogin;
	private Button   	btnClear;

    // 登录逻辑处理
	ILoginPresenter     loginPresenter;

	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		//find view
		editUser 	= (EditText) this.findViewById(R.id.et_login_username);
		editPass 	= (EditText) this.findViewById(R.id.et_login_password);
		btnLogin 	= (Button)   this.findViewById(R.id.btn_login_login);
		btnClear 	= (Button)   this.findViewById(R.id.btn_login_clear);

		progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

		//set listener
		btnLogin.setOnClickListener(this);
		btnClear.setOnClickListener(this);

		//init
		loginPresenter = new LoginPresenterCompl(this);
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			// 清空
			case R.id.btn_login_clear:
				loginPresenter.clear();
				break;
			// 登录
			case R.id.btn_login_login:
				loginPresenter.setProgressBarVisiblity(View.VISIBLE);
				btnLogin.setEnabled(false);
				btnClear.setEnabled(false);
				loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
				break;
		}
	}

    /******************************** 实现ILoginView接口:进行视图逻辑的相关操作 START ********************************/

    // 清空文本输入框
	@Override
	public void onClearText() {
		editUser.setText("");
		editPass.setText("");
	}

    // 登录结果处理
	@Override
	public void onLoginResult(Boolean result, int code) {
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
		btnLogin.setEnabled(true);
		btnClear.setEnabled(true);
		if (result){
			Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
		}
		else
			Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
	}

    // 控制进度条对话框
	@Override
	public void onSetProgressBarVisibility(int visibility) {
		progressBar.setVisibility(visibility);
	}
    /******************************** 实现ILoginView接口:进行视图逻辑的相关操作 END ********************************/
}
