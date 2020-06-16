package com.project.service.impl;

import com.project.bean.AreaBean;
import com.project.dao.IAreaDao;
import com.project.service.IAreaService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AreaServiceImpl implements IAreaService {

    private SqlSession sqlSession = MyBatisUtil.getSession();

    @Override
    public List<AreaBean> getAreaByItem(String name, String tree, String classesName) {


        return null;
    }

    @Override
    public int addArea(AreaBean areaBean) {
        int i = sqlSession.getMapper(IAreaDao.class).addArea(areaBean);
        sqlSession.commit();
        return i;
    }

    @Override
    public List<AreaBean> getAllArea() {
        List<AreaBean> list = sqlSession.getMapper(IAreaDao.class).getAllArea();
        return list;
    }

}
