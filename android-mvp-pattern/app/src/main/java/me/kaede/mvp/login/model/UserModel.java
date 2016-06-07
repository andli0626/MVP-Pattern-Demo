package me.kaede.mvp.login.model;

/**
 * author andli
 * create at 16/6/7 上午11:09
 * 数据层
 **/

public class UserModel implements IUser {
    String name;
    String passwd;

    public UserModel(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    /******************************** 实现IUser接口:进行业务逻辑的相关操作 START ********************************/
    // 获取用户名
    @Override
    public String getName() {
        return name;
    }
    // 获取密码
    @Override
    public String getPasswd() {
        return passwd;
    }
    // 校验登录
    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name == null || passwd == null || !name.equals(getName()) || !passwd.equals(getPasswd())) {
            return -1;
        }
        return 0;
    }
    /******************************** 实现IUser接口:进行业务逻辑的相关操作 END ********************************/
}
