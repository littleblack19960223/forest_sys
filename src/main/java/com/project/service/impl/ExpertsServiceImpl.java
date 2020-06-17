package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.ExpertsBean;
import com.project.dao.ExpertsDao;
import com.project.service.ExpertsService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

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
        return expertsDao.updateExperts(expertsBean);
    }
}
