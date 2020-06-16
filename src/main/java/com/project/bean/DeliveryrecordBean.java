package com.project.bean;

import lombok.Data;

/**
 * 药剂机械出库记录
 */
@Data
public class DeliveryrecordBean {

    //主键id
    private Integer deliveryrecordId;
    //小班id . Bean
    private ClassesBean classesBean;
    //出库人
    private String userName;
    //日期
    private String date;



}
