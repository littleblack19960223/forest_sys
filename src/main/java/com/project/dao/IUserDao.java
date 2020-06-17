package com.project.dao;

import com.project.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 23
 */
public interface IUserDao {
    /**
     * 传入用户对象,添加用户
     */
    @Insert("INSERT INTO t_user(user_name,user_password,user_grade,user_realname) " +
            "VALUES (#{userBean.username},#{userBean.userpwd},#{userBean.usergrade},#{userBean.userrealname})")
    public int adduser(@Param(value = "userBean") UserBean userBean);

    /**
     * 根据用户名，查询用户信息
     */
    @Select("SELECT user_name as username,user_password as userpwd,user_grade as usergrade,user_realname as userrealname\n" +
            "FROM t_user \n" +
            "where user_name=#{name}")
    public UserBean showUserInfo(@Param(value = "name") String name);

    /**
     * 根据传入用户对象修改用户信息
     */
    @Update("UPDATE t_user SET user_password=#{user.userpwd}, user_grade=#{user.usergrade}\n" +
            "WHERE  user_name = #{user.username}")
    public int updateUserInfo(@Param(value = "user") UserBean user);

    /**
     * 传入用户名字，删除对应用户
     */
    @Delete("DELETE FROM t_user WHERE user_name=#{username}")
    public int removeuser(@Param(value = "username") String username);

    @Select("SELECT user_name,user_password,user_grade,user_realname\n" +
            "FROM t_user where user_grade like % #{usergrade} ")
    public List<UserBean> showUserInfoList(@Param(value = "usergrade") String usergrade);
}
