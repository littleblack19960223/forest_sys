package com.project.service;

import com.project.bean.AreaBean;

import java.util.List;
import java.util.Map;

public interface IAreaService {
    public List<AreaBean> getAreaByItem(Map<String,String> map);

    public int addArea(AreaBean areaBean);

    public List<AreaBean> getAllArea();
}
