package com.project.dao;

import com.project.bean.UserBean;
import org.apache.ibatis.annotations.Insert;

public interface IUserDao {


    public int adduser(UserBean userBean);

}
