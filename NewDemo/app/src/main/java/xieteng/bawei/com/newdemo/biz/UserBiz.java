package xieteng.bawei.com.newdemo.biz;

import xieteng.bawei.com.newdemo.bean.User;

/**
 * Created by Administrator on 2017/5/8.
 */

public class UserBiz implements IUserBiz {


    @Override
    public void login(final String username, final String password, final OnLoginListenner loginListenner) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    //睡眠2秒钟
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //判断用户名和密码是否一致
                if ("zhangsan".equals(username) && "123".equals(password)) {

                    /**
                     *
                     */
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);

                    loginListenner.loginSuccess(user);
                }else{
                    loginListenner.loginFailed();
                }
            }
        }.start();
    }
}
