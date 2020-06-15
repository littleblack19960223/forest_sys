package com.project.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class EventBean {

    private Integer eventId;

    private Date date;

    private String prevention;

    private Integer state;

    private String describe;

    private float loss;

    private float area;

    private Integer pathWay;

    private Integer disasterType;

    private String picture;

    private AreaBean areaBean;


}
