package com.project.bean;

import lombok.Data;

import java.sql.Date;

/**
 * @author 23
 */
@Data
public class Logbean {

    private Integer logid;
    private String loginfo;
    private Date logdata;
}
