package com.project.dao;

import com.project.bean.DeliveryrecordBean;
import com.project.bean.Logbean;
import com.project.bean.UserBean;
import com.project.dao.sqlProvider.DeliveryrecordSqlProvider;
import com.project.dao.sqlProvider.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT user_name as username,user_password as userpwd,user_grade as usergrade,user_realname as userrealname\n" +
            "FROM t_user where user_grade like \"%\"#{usergrade} ")
    public List<UserBean> showUserInfoList(@Param(value = "usergrade") String usergrade);
    @Insert("INSERT INTO t_log(log_info,log_data) " +
            "VALUES (#{logbean.loginfo},#{logbean.logdata})")
    public int addlog(@Param(value = "logbean") Logbean logbean);
    /**
     * 根据传入的账号密码进行查找
     */
    @Select("SELECT user_name as username,user_password as userpwd,user_grade as usergrade,user_realname as userrealname " +
            " FROM t_user where user_name=#{username} and user_password =#{pwd} ")
    public UserBean login(@Param(value = "username") String username,@Param(value = "pwd") String pwd);
    /**
     * 查询日志信息
     * @param map 查询条件
     * @return 符合条件集合
     */
    @SelectProvider(type = Log.class,method = "log")
    public List<Logbean> showLogInfoList(Map<String, String> map);
    /**
     * 查询日志信息
     * @return 符合条件集合
     */
    @Select("SELECT log_info as loginfo,log_data as logdata FROM t_log ")
    List<Logbean> LogInfoList();
}
