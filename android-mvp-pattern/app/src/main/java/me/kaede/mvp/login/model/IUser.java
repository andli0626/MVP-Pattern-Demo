package me.kaede.mvp.login.model;

/**
 * author andli
 * create at 16/6/7 上午11:10
 * 数据层接口
 **/

public interface IUser {
    // 获取用户名
    String getName();
    // 获取密码
    String getPasswd();
    // 校验登录
    int checkUserValidity(String name, String passwd);
}
