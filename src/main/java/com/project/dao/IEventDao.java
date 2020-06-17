package com.project.dao;

import com.project.bean.EventBean;

import java.util.List;
import java.util.Map;

public interface IEventDao {
    /**
     * 添加事件
     * */
    public int addEvent(EventBean eventBean);

    /**
     * 通过id查事件
     * */
    public EventBean getEventById(int id);

    /**
     * 修改事件信息（灾情阶段，防治措施）
     * */
    public int updateEvent(int id,int state,String prevention);

    /**
     * 修改事件信息（修改为专家会商）
     * */
    public int updateEventType(int id,int type);

    /**
     * 模糊查询
     * */
    public List<EventBean> getEventByItem(Map<String,String> Map);

    /**
     * 查所有事件
     * */
    public List<EventBean> getAllEvent();

    /**
     * 根据是否专家会商查事件列表
     * */
    public List<EventBean> getEventByType();
}
