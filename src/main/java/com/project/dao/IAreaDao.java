package com.project.dao;

import com.project.bean.AreaBean;

import java.util.List;
import java.util.Map;

public interface IAreaDao {
    public List<AreaBean> getAreaByItem(Map<String ,String> map);

    public int addArea(AreaBean areaBean);

    public List<AreaBean> getAllArea();
}
