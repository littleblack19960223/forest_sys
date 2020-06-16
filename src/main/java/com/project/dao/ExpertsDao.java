package com.project.dao;

import com.project.bean.ExpertsBean;

import java.util.List;
import java.util.Map;

public interface ExpertsDao {
    /**显示全部专家并分页，或按条件查询*/
    public List<ExpertsBean> show(Map map);
    /**根据id 查询专家详情*/
    public  ExpertsBean lookExperts(int id);
}
