package com.project.service.impl;

import com.project.bean.EventBean;
import com.project.service.IEventService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EventServiceImplTest {
    private IEventService service = new EventServiceImpl();

    @Test
    public void addEvent() {
    }

    @Test
    public void getEventById() {
    }

    @Test
    public void updateEvent() {
    }

    @Test
    public void updateEventType() {
    }

    @Test
    public void getEventByItem() {
    }

    @Test
    public void getAllEvent() {
        List<EventBean> list = service.getAllEvent();
        System.out.println(list);
    }

    @Test
    public void getEventByType() {
    }
}