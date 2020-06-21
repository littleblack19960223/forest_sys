package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.ConnectExperts;
import com.project.bean.DiscussBean;
import com.project.bean.EventBean;
import com.project.bean.ExpertsBean;
import com.project.dao.ExpertsDao;
import com.project.dao.IEventDao;
import com.project.service.ExpertsService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpertsServiceImpl implements ExpertsService {
    SqlSession sqlSession = MyBatisUtil.getSession();
    ExpertsDao expertsDao = sqlSession.getMapper(ExpertsDao.class);

    @Override
    public PageInfo<ExpertsBean> show(Map<String, String> map) {
        int curentPage = Integer.parseInt(map.get("curentPage"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        //使用mybatis的分页插件
        PageHelper.startPage(curentPage, pageSize);
        PageInfo<ExpertsBean> pageInfo = null;

        List<ExpertsBean> show = expertsDao.show(map);
        pageInfo = new PageInfo<>(show);

        return pageInfo;
    }

    @Override
    public ExpertsBean lookExperts(int id) {
        ExpertsBean expertsBean = expertsDao.lookExperts(id);
        return expertsBean;
    }

    @Override
    public int addExperts(ExpertsBean expertsBean) {
        int i = expertsDao.addExperts(expertsBean);
        sqlSession.commit();
        return i;
    }

    @Override
    public int queryName(String name) {

        return expertsDao.queryName(name);
    }

    @Override
    public int updateExperts(ExpertsBean expertsBean) {
        int i = expertsDao.updateExperts(expertsBean);
        sqlSession.commit();
        return i;
    }

    @Override
    public void daleteExperts(Integer id) {
        try {
            expertsDao.deleteExperts(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<ExpertsBean> shows(String disaster) {
        return expertsDao.shows(disaster);
    }

    @Override
    public PageInfo<EventBean> Incident(String curentPage, String pageSize) {

        int curentPage1 = Integer.parseInt(curentPage);
        int pageSize1 = Integer.parseInt(pageSize);

        //使用mybatis的分页插件
        PageHelper.startPage(curentPage1, pageSize1);
        PageInfo<EventBean> pageInfo = null;
        //调用事件接口的方法
        IEventDao mapper = MyBatisUtil.getSession().getMapper(IEventDao.class);
        List<EventBean> eventByType = mapper.getEventByType();
        pageInfo = new PageInfo<EventBean>(eventByType);
        return pageInfo;
    }

    @Override
    public EventBean talks(int id) {
        //调用事件接口的方法
        IEventDao mapper = MyBatisUtil.getSession().getMapper(IEventDao.class);
        EventBean eventById = mapper.getEventById(id);
        return eventById;
    }

    @Override
    public int addTalks(DiscussBean discussBean, List<Integer> expertsId) {
        //添加与结果相关联的专家

        //添加会商结果信息
        try {
            expertsDao.addTalks(discussBean);
            int discussId = discussBean.getDiscussId();
            List<ConnectExperts> list = new ArrayList<>();
            for (int i : expertsId) {
                ConnectExperts conn = new ConnectExperts(i, discussId);
                list.add(conn);

            }
            int i = expertsDao.addConnectExperts(list);
            sqlSession.commit();
            return i;
        } catch (Exception e) {

            sqlSession.rollback();
            e.printStackTrace();
            return 0;
        }
    }
}
