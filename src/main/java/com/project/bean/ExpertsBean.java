package com.project.bean;

import lombok.Data;

import java.sql.Date;

/**
 * 专家
 */
@Data
public class ExpertsBean {
    private Integer id;
    /**名字*/
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

    public ExpertsBean() {
    }

    public ExpertsBean(String expertsName, Date date, String sex, String specialties, String telephone, String site, String head, String duty, String work, String mailbox) {
        this.expertsName = expertsName;
        this.date = date;
        this.sex = sex;
        this.specialties = specialties;
        this.telephone = telephone;
        this.site = site;
        this.head = head;
        this.duty = duty;
        this.work = work;
        this.mailbox = mailbox;
    }

    public ExpertsBean(Integer id, String expertsName, Date date, String sex, String specialties, String telephone, String site, String head, String duty, String work, String mailbox) {
        this.id = id;
        this.expertsName = expertsName;
        this.date = date;
        this.sex = sex;
        this.specialties = specialties;
        this.telephone = telephone;
        this.site = site;
        this.head = head;
        this.duty = duty;
        this.work = work;
        this.mailbox = mailbox;
    }

    @Override
    public String toString() {
        return "ExpertsBean{" +
                "id=" + id +
                ", expertsName='" + expertsName + '\'' +
                ", date=" + date +
                ", sex='" + sex + '\'' +
                ", specialties='" + specialties + '\'' +
                ", telephone='" + telephone + '\'' +
                ", site='" + site + '\'' +
                ", head='" + head + '\'' +
                ", duty='" + duty + '\'' +
                ", work='" + work + '\'' +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
