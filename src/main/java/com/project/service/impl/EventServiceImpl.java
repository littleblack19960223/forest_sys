package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;
import com.project.bean.EventBean;
import com.project.dao.IEventDao;
import com.project.service.IEventService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class EventServiceImpl implements IEventService {
    private SqlSession sqlSession = MyBatisUtil.getSession();

    ///提交//
    @Override
    public int addEvent(EventBean eventBean) {
        int i = sqlSession.getMapper(IEventDao.class).addEvent(eventBean);
        sqlSession.commit();
        return i;
    }

    @Override
    public EventBean getEventById(int id) {
        EventBean eventBean = sqlSession.getMapper(IEventDao.class).getEventById(id);
        return eventBean;
    }

    @Override
    public int updateEvent(int id,int state,String prevention) {
        int i = sqlSession.getMapper(IEventDao.class).updateEvent(id,state,prevention);
        sqlSession.commit();
        return i;
    }

    @Override
    public int updateEventType(int id, int type) {
        int i = sqlSession.getMapper(IEventDao.class).updateEventType(id,type);
        sqlSession.commit();
        return i;
    }

    @Override
    public List<EventBean> getEventByItem(Map<String,Object> map) {

        List<EventBean> list = sqlSession.getMapper(IEventDao.class).getEventByItem(map);


        return list;

    }

    @Override
    public List<EventBean> getAllEvent() {


        List<EventBean> list = sqlSession.getMapper(IEventDao.class).getAllEvent();



        return list;
    }

    @Override
    public List<EventBean> getEventByType() {



        List<EventBean> list = sqlSession.getMapper(IEventDao.class).getEventByType();



        return list;

    }
}
