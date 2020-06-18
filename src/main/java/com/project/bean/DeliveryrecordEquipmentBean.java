package com.project.bean;



import java.util.List;

/**
 * 出库机械表
 */
public class DeliveryrecordEquipmentBean{
    //主键id
    private Integer id;
    //出库id
    private List<DeliveryrecordBean> deliveryrecord;
    //出库设备id
    private List<EquipmentBean> equipmentBean;
    //出库数量
    private List<Integer> equipmentNnumber;


    public DeliveryrecordEquipmentBean(Integer id, List<DeliveryrecordBean> deliveryrecord, List<EquipmentBean> equipmentBean, List<Integer> equipmentNnumber) {
        this.id = id;
        this.deliveryrecord = deliveryrecord;
        this.equipmentBean = equipmentBean;
        this.equipmentNnumber = equipmentNnumber;
    }

    public DeliveryrecordEquipmentBean() {
    }

    @Override
    public String toString() {
        return "DeliveryrecordEquipmentBean{" +
                "id=" + id +
                ", deliveryrecord=" + deliveryrecord +
                ", equipmentBean=" + equipmentBean +
                ", equipmentNnumber=" + equipmentNnumber +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<DeliveryrecordBean> getDeliveryrecord() {
        return deliveryrecord;
    }

    public void setDeliveryrecord(List<DeliveryrecordBean> deliveryrecord) {
        this.deliveryrecord = deliveryrecord;
    }

    public List<EquipmentBean> getEquipmentBean() {
        return equipmentBean;
    }

    public void setEquipmentBean(List<EquipmentBean> equipmentBean) {
        this.equipmentBean = equipmentBean;
    }

    public List<Integer> getEquipmentNnumber() {
        return equipmentNnumber;
    }

    public void setEquipmentNnumber(List<Integer> equipmentNnumber) {
        this.equipmentNnumber = equipmentNnumber;
    }
}
