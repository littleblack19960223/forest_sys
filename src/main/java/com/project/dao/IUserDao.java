package com.project.dao;

import com.project.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author 23
 */
public interface IUserDao {
/** 传入用户对象,添加用户*/
@Insert("INSERT INTO t_user(user_name,user_password,user_grade,user_realname) " +
        "VALUES (#{userBean.username},#{userBean.userpwd},#{userBean.usergrade},#{userBean.userrealname})")
    public int adduser(@Param(value = "userBean") UserBean userBean);

}
