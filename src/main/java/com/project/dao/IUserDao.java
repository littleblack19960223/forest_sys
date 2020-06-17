package com.project.dao;

import com.project.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("SELECT user_name,user_password,user_grade,user_realname\n" +
            "FROM t_user \n" +
            "where user_name='#{name}'\n")
    public UserBean showUserInfo(@Param(value = "name") String name);

    /**
     * 根据传入用户对象修改用户信息
     */
    @Update("UPDATE t_user SET user_password=#{userBean.userpwd}, user_grade=#{userBean.usergrade}\n" +
            "WHERE  user_name = #{userBean.username}")
    public int updateUserInfo(@Param(value = "userBean") UserBean userBean);
}
