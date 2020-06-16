package com.project.bean;

import lombok.Data;

import java.sql.Date;

/**
 * 专家
 */
@Data
public class ExpertsBean {
    private Integer id;
    private  String expertsName;
    /**出生日期*/
    private Date date;
    private String sex;
    /**专长*/
    private String specialties;
    /**电话*/
    private String telephone;
    /**通讯地址*/
    private String site;
    /**头像*/
    private String head;
    /**职务*/
    private String duty;
    /**工作单位*/
    private String work;
    /**邮箱*/
    private String mailbox;

}
