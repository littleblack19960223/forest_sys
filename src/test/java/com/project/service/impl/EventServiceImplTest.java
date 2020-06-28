package com.project.service.impl;

import com.project.bean.AreaBean;
import com.project.bean.EventBean;
import com.project.service.IEventService;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventServiceImplTest {
    private IEventService service = new EventServiceImpl();

    @Test
    public void addEvent() {
        EventBean eventBean = new EventBean();
        eventBean.setState(1);
        eventBean.setPrevention("prevention");
        eventBean.setPathWay(1);
        eventBean.setDisasterType(2);
        eventBean.setName("name");
        eventBean.setDate(new Date(System.currentTimeMillis()));
        AreaBean areaBean = new AreaBean();
        areaBean.setAreaId(7);
        eventBean.setAreaBean(areaBean);
        eventBean.setDescribe("describe");
        eventBean.setLoss(Float.valueOf("100.00"));
        eventBean.setPicture("/forest_sys/upload/1592553088299-3732910603041649112.jpg");
        eventBean.setArea(Float.valueOf("100.00"));
        eventBean.setType(2);
        int i = service.addEvent(eventBean);

        System.out.println(i);
    }

    @Test
    public void getEventById() {
        System.out.println(service.getEventById(1));
    }

    @Test
    public void updateEvent() {
        System.out.println(service.updateEvent(1,2,"修改"));
    }

    @Test
    public void updateEventType() {
        System.out.println(service.updateEventType(1,2));
    }

    @Test
    public void getEventByItem() {
        Map<String,Object> map = new HashMap<>();
        map.put("eventName","事");
        map.put("state",2);
        map.put("areaName","区");
        System.out.println(service.getEventByItem(map));
    }

    @Test
    public void getAllEvent() {
        List<EventBean> list = service.getAllEvent();
        System.out.println(list);

    }

    @Test
    public void getEventByType() {
        List<EventBean> list = service.getEventByType();
        System.out.println(list);
    }
}