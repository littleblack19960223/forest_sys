package com.project.bean;


/**
 * 药剂器械
 */
public class EquipmentBean {

    //设备id
    private Integer equipmentId;
    //设备名称
    private String name;
    //防治类型：1：鼠害，2：虫害 3:病害
    private Integer genre;
    //防止类别：1：药剂，2：器械
    private Integer type;
    //主要用途
    private String purpose;
    //数量
    private Integer num;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "EquipmentBean{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", type=" + type +
                ", purpose='" + purpose + '\'' +
                ", num=" + num +
                '}';
    }

    public EquipmentBean() {
    }

    public EquipmentBean(Integer equipmentId, String name, Integer genre, Integer type, String purpose, Integer num) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.purpose = purpose;
        this.num = num;
    }
}
