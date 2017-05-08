package xieteng.bawei.com.newdemo.biz;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface IUserBiz {

    public void login(String username,String password,OnLoginListenner loginListenner);
}
