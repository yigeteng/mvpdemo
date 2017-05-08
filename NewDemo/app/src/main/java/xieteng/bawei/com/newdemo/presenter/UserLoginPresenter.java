package xieteng.bawei.com.newdemo.presenter;

import android.os.Handler;

import xieteng.bawei.com.newdemo.bean.User;
import xieteng.bawei.com.newdemo.biz.IUserBiz;
import xieteng.bawei.com.newdemo.biz.OnLoginListenner;
import xieteng.bawei.com.newdemo.biz.UserBiz;
import xieteng.bawei.com.newdemo.view.IUserLoginView;

/**
 * Created by Administrator on 2017/5/8.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();


    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    //登录的方法
    public void login(){
        //显示进度条
        userLoginView.showLoading();
        userBiz.login(userLoginView.getusername(), userLoginView.getpassword(), new OnLoginListenner() {
            @Override
            public void loginSuccess(final User user) {
                //登陆成功   需要在UI线程中进行
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        userLoginView.toMainActivity(user);
                        //隐藏进度条
                        userLoginView.hideLoading();

                    }
                });
            }

            @Override
            public void loginFailed() {

                //登录失败   需要在UI线程中进行
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        userLoginView.showFailder();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    //清除的方法
    public void clear(){
        //调取清除的方法
        userLoginView.clearusername();
        userLoginView.clearpassword();
    }
}
