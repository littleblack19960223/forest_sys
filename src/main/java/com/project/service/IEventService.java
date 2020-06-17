package com.project.service;

import com.project.bean.EventBean;

import java.util.List;

public interface IEventService {

    public int addEvent(EventBean eventBean);

    /**
     * 通过id查事件
     * */
    public EventBean getEventById(int id);

    public int updateEvent(int id,int state,String prevention);

    public List<EventBean> getEventByItem(String name,String state,String area,String startDate,String endDate);

    public List<EventBean> getAllEvent();

    /**
     * 根据是否专家会商查事件列表
     * */
    public List<EventBean> getEventByType();
}
