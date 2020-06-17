package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.ExpertsBean;


import java.util.Map;

public interface ExpertsService {
    /**
     * 显示全部专家并分页，或按条件查询
     */
    PageInfo<ExpertsBean> show(Map<String, String> map);

    /**
     * 根据id 查询专家详情
     */
    ExpertsBean lookExperts(int id);

    /**
     * 添加专家
     *
     * @return 受影响的行数
     */
    int addExperts(ExpertsBean expertsBean);
    /**
     * 根据名字查询是否存在
     * @return  1存在，0不存在
     */
    int queryName(String name);
/**修改专家*/
    int updateExperts(ExpertsBean expertsBean);
}
