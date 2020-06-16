package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.ExpertsBean;


import java.util.Map;

public interface ExpertsService {
    /**显示全部专家并分页，或按条件查询*/
    public PageInfo<ExpertsBean> show(Map<String,String> map);
    /**根据id 查询专家详情*/
    public  ExpertsBean lookExperts(int id);
}
