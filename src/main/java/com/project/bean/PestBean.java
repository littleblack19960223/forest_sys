package com.project.bean;

/**
 * 虫害一览bean
 */
public class PestBean {
//    id
    private int id;
//   名称
    private String name;
//    虫害寄主
    private String host;
//    主要危害
    private String harm;
//    繁殖
    private String breed;
//    主要天敌
    private String enemy;
//    主要措施
    private String measure;
//    幼虫图片
    private String larvaImg;
//    成虫图片
    private String adultImg;

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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHarm() {
        return harm;
    }

    public void setHarm(String harm) {
        this.harm = harm;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getLarvaImg() {
        return larvaImg;
    }

    public void setLarvaImg(String larvaImg) {
        this.larvaImg = larvaImg;
    }

    public String getAdultImg() {
        return adultImg;
    }

    public void setAdultImg(String adultImg) {
        this.adultImg = adultImg;
    }

    @Override
    public String toString() {
        return "PestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", harm='" + harm + '\'' +
                ", breed='" + breed + '\'' +
                ", enemy='" + enemy + '\'' +
                ", measure='" + measure + '\'' +
                ", larvaImg='" + larvaImg + '\'' +
                ", adultImg='" + adultImg + '\'' +
                '}';
    }
}
