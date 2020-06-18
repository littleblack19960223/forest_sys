package com.project.service.impl;

import com.project.bean.EventBean;
import com.project.service.IEventService;
import org.junit.Test;

import java.util.List;


public class EventServiceImplTest {
    private IEventService service = new EventServiceImpl();

    @Test
    public void addEvent() {

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

    }

    @Test
    public void getAllEvent() {
        List<EventBean> list = service.getAllEvent();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void getEventByType() {
        List<EventBean> list = service.getEventByType();
        System.out.println(list);
        System.out.println(list.size());
    }
}