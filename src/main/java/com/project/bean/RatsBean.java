package com.project.bean;

/**
 * 鼠害一览bean
 */
public class RatsBean {
//      id
    private int id;
//      名称
    private String name;
//      食物
    private String food;
//      主要危害
    private String harm;
//      繁殖
    private String breed;
//      天敌
    private String enemy;
//      主要措施
    private String measure;
//      鼠害图片
    private String ratsImg;

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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
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

    public String getRatsImg() {
        return ratsImg;
    }

    public void setRatsImg(String ratsImg) {
        this.ratsImg = ratsImg;
    }

    @Override
    public String toString() {
        return "RatsBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", harm='" + harm + '\'' +
                ", breed='" + breed + '\'' +
                ", enemy='" + enemy + '\'' +
                ", measure='" + measure + '\'' +
                ", ratsImg='" + ratsImg + '\'' +
                '}';
    }
}
