package com.project.bean;

import lombok.Data;

import java.util.Date;

/**
 * 登录信息类
 *
 * @author 23
 */
@Data
public class LogBean {
    /**
     * 信息编号
     */
    private Integer logid;
    /**
     * 日志类容
     */
    private String loginfo;
    /**
     * 添加时间
     */
    private Date logdata;
}
