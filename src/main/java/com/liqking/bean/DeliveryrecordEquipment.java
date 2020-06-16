package com.liqking.bean;


import lombok.Data;

/**
 * 出库机械表
 */
@Data
public class DeliveryrecordEquipment {
    //主键id
    private Integer id;
    //出库id
    Deliveryrecord deliveryrecord;
    //出库设备id
    EquipmentBean equipmentBean;
    //出库数量
    private Integer equipmentNnumber;

}
