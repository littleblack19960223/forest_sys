package com.project.bean;

import lombok.Data;

/**
 * 药剂器械
 */
@Data
public class EquipmentBean {

    //设备id
    private Integer equipmentId;
    //设备名称
    private String name;
    //防治类型：1：鼠害，2：虫害
    private Integer genre;
    //防止类别：1：药剂，2：器械
    private Integer type;
    //主要用途
    private String purpose;
    //数量
    private Integer num;




}
