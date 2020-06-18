package com.project.bean;


/**
 * 药剂机械出库记录
 */
public class DeliveryrecordBean {

    //主键id
    private Integer deliveryrecordId;
    //小班id
    private String classeName;
    //出库人
    private String userName;
    //日期
    private String date;


    public DeliveryrecordBean() {
    }

    public DeliveryrecordBean(Integer deliveryrecordId, String classeName, String userName, String date) {
        this.deliveryrecordId = deliveryrecordId;
        this.classeName = classeName;
        this.userName = userName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "DeliveryrecordBean{" +
                "deliveryrecordId=" + deliveryrecordId +
                ", classeName='" + classeName + '\'' +
                ", userName='" + userName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getDeliveryrecordId() {
        return deliveryrecordId;
    }

    public void setDeliveryrecordId(Integer deliveryrecordId) {
        this.deliveryrecordId = deliveryrecordId;
    }

    public String getClasseName() {
        return classeName;
    }

    public void setClasseName(String classeName) {
        this.classeName = classeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
