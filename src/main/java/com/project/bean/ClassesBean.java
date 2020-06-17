package com.project.bean;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class ClassesBean {
    private Integer classId;

    private String name;

    private String person;

    private String phone;

    private Integer num;

    private AreaBean areaBean;

    private Date creat = new Date(System.currentTimeMillis());
}
