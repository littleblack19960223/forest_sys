package com.project.dao;

import com.project.bean.ConnectExperts;
import com.project.bean.DiscussBean;
import com.project.bean.ExpertsBean;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据灾害类型查询专家的信息
     */
    List<ExpertsBean> shows(String disaster);

    /**
     * 添加专家会商的结果，并返回该条数据的id
     */
    void addTalks(DiscussBean discussBean);

    /**
     * 添加专家时，同时添加会谈结果对应的专家id
     */
    int addConnectExperts(List<ConnectExperts> list);

    /**添加会谈的结果时，修改会谈的结果*/
    int updateEvent(int id);
}
