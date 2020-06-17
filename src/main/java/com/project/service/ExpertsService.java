package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.DiscussBean;
import com.project.bean.EventBean;
import com.project.bean.ExpertsBean;


import java.util.List;
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
     *
     * @return 1存在，0不存在
     */
    int queryName(String name);

    /**
     * 修改专家
     */
    int updateExperts(ExpertsBean expertsBean);

    /**
     * 根据id，删除专家
     */
    void daleteExperts(Integer id);

    /**
     * 根据灾害类型选择专家
     *
     * @return 专家集合
     */
    List<ExpertsBean> shows(String disaster);

   /**
    * 查询专家需要解决的事情并分页展示
    * @param curentPage
    * @param pageSize
    */
   PageInfo<EventBean> Incident(String curentPage,String pageSize);
/**根据事件id，查询事件详细信息，包含会商结果*/
    EventBean talks(int id);
/**添加会商的结果*/
    int addTalks(DiscussBean discussBean,int[] expertsId);
}
