package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.UserBean;

import java.util.List;

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
     * 返回1表示修改成功，0表示修改失败
     */
    public int updateUserInfo(UserBean userBean);

    /**
     * 传入用户名字，删除对应用户
     */
    public int removeuser(String username);

    /**
     * 根据条件查询符合要求的数据，返回一个数组
     * currentPage,当前多少页
     * pageSize：每页多少条数据
     */
    public PageInfo<UserBean> showUserInfoList(String currentPage, String pageSize, String usergrade);

}
