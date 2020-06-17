package com.project.bean;


import lombok.Data;

import java.util.List;

/**
 * 出库机械表
 */
@Data
public class DeliveryrecordEquipmentBean{
    //主键id
    private Integer id;
    //出库id
    private List<DeliveryrecordBean> deliveryrecord;
    //出库设备id
    private List<EquipmentBean> equipmentBean;
    //出库数量
    private Integer equipmentNnumber;


}
