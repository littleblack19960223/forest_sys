package com.project.bean;

import lombok.Data;

/**
 * 用户信息
 *
 * @author 23
 */
@Data
public class UserBean {

    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 登录名称
     */
    private String username;
    /**
     * 登录密码
     */
    private String userpwd;
    /**
     * 用户权限
     */
    private String usergrade;
    /**
     * 真实姓名
     */
    private String userrealname;

}
