package xieteng.bawei.com.newdemo.biz;

import xieteng.bawei.com.newdemo.bean.User;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface OnLoginListenner {
    //接口中成功的方法
    void loginSuccess(User user);
    //接口中失败的方法
    void loginFailed();
}
