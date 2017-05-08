package xieteng.bawei.com.newdemo.view;

import xieteng.bawei.com.newdemo.bean.User;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface IUserLoginView {

    String getusername();
    String getpassword();
    void clearusername();
    void clearpassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailder();

}
