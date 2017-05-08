package xieteng.bawei.com.newdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import xieteng.bawei.com.newdemo.bean.User;
import xieteng.bawei.com.newdemo.presenter.UserLoginPresenter;
import xieteng.bawei.com.newdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private Button bt_clear;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    private ProgressBar pd_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        initView();
    }

    private void initView() {
        //查找控件
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText)  findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_clear = (Button)  findViewById(R.id.bt_clear);
        pd_loading = (ProgressBar) findViewById(R.id.pd_loading);

        //登录的监听
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
        //清除输入框的监听
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getusername() {
        return et_username.getText().toString();
    }

    @Override
    public String getpassword() {
        return et_password.getText().toString();
    }

    @Override
    public void clearusername() {
        et_username.setText("");
    }

    @Override
    public void clearpassword() {
        et_password.setText("");
    }

    @Override
    public void showLoading() {
        pd_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pd_loading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailder() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }
}
