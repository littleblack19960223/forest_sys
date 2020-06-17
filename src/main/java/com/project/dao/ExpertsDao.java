package com.project.dao;

import com.project.bean.ExpertsBean;

import java.util.List;
import java.util.Map;

public interface ExpertsDao {
    /**
     * 显示全部专家并分页，或按条件查询
     */
    List<ExpertsBean> show(Map map);

    /**
     * 根据id 查询专家详情
     */
    ExpertsBean lookExperts(int id);

    /**
     * 添加专家
     */
    int addExperts(ExpertsBean expertsBean);

    /**
     * 根据名字查询是否存在
     */
    int queryName(String name);

    /**
     * 修改专家
     */
    int updateExperts(ExpertsBean expertsBean);

    /**
     * 根据id删除专家
     */
    void deleteExperts(Integer id);
    /**根据灾害类型查询专家的信息*/
    List<ExpertsBean> shows(String disaster);
}
