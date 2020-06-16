package com.project.bean;


/**
 * 病害一览bean
 */
public class DiseaseBean {
//   id
    private int id;
//    名称
    private String name;
//    主要危害
    private String harm;
//    发病规律
    private String pattern;
//    病原
    private String cause;
//    主要症状
    private String symptom;
//    主要措施
    private String measure;
//    图片
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarm() {
        return harm;
    }

    public void setHarm(String harm) {
        this.harm = harm;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "DiseaseBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", harm='" + harm + '\'' +
                ", pattern='" + pattern + '\'' +
                ", cause='" + cause + '\'' +
                ", symptom='" + symptom + '\'' +
                ", measure='" + measure + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
