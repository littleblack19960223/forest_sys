package com.project.bean;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class EventBean {
    /**
     * 事件id
     * */
    private Integer eventId;

    private String name;

    /**
     * 事件时间
     * */
    private Date date = new Date(System.currentTimeMillis());
    /**
     * 事件防止措施
     * */
    private String prevention;
    /**
     * 事件状态
     * */
    private Integer state;
    /**
     * 事件描述
     * */
    private String describe;
    /**
     * 事件损失
     * */
    private float loss;
    /**
     * 事件影响面积
     * */
    private float area;
    /**
     * 事件发现途径
     * */
    private Integer pathWay;
    /**
     * 事件灾害类型
     * */
    private Integer disasterType;
    /**
     * 事件图片
     * */
    private String picture;
    /**
     * 事件发生位置
     * */
    private AreaBean areaBean;
    /**
     * 事件是否申请专家会商
     * */
    private Integer type;

    /**
     * 会商纪录
     * */
    private List<DiscussBean> list;


}
