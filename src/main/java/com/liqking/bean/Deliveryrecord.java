package com.liqking.bean;

import com.project.bean.ClassesBean;
import lombok.Data;

/**
 * 药剂机械出库
 */@Data
public class Deliveryrecord {

    //主键id
    private Integer deliveryrecordId;
    //小班id . Bean
    private ClassesBean classesBean;
    //出库人
    private String userName;
    //日期
    private String date;

}
