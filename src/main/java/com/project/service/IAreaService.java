package com.project.service;

import com.project.bean.AreaBean;

import java.util.List;

public interface IAreaService {
    public List<AreaBean> getAreaByItem(String name,String tree,String classesName);

    public int addArea(AreaBean areaBean);

    public List<AreaBean> getAllArea();
}
