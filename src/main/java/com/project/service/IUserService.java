package com.project.service;

import com.project.bean.UserBean;

/**
 * @author 23
 */
public interface IUserService {
    /**
     * 传入用户对象,添加用户,返回1表示成功,返回0表示添加失败,返回-1表示两次密码不一致
     */
    public int addUser(UserBean userBean);

    /**
     * 根据名字查询用户信息
     * 返回用户对象
     */
    public UserBean showUserInfo(String name);

    /**
     * 根据修改后的对象
     * 修改数据库信息
     */
    public void updateUserInfo(UserBean userBean);
}
