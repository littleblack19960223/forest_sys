package com.project.bean;

import lombok.Data;

import java.util.List;

@Data
public class AreaBean {

    private Integer areaId;

    private String name;

    private String goodTree;

    private Integer type;

    private String tree;

    private List<ClassesBean> classesBeans;

}
