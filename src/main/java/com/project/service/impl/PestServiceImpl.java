package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.PestBean;
import com.project.dao.IPestDao;
import com.project.service.IPestService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PestServiceImpl implements IPestService {
    @Override
    public PageInfo<PestBean> showAllPest(Integer curPage,Integer pageSize) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IPestDao iPestDao=sqlSession.getMapper(IPestDao.class);

        PageInfo<PestBean> pageInfo=null;
        PageHelper.startPage(curPage,pageSize);
        List<PestBean> list=iPestDao.getAllPest();
        pageInfo=new PageInfo<PestBean>(list);

        return pageInfo;
    }

    @Override
    public int addNewPest(PestBean pestBean) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IPestDao iPestDao=sqlSession.getMapper(IPestDao.class);
        int n=iPestDao.addNewPest(pestBean);
        sqlSession.commit();
        return n;
    }

    @Override
    public PestBean showDetail(int id) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IPestDao iPestDao=sqlSession.getMapper(IPestDao.class);
        return iPestDao.getDetailById(id);
    }

    @Override
    public PageInfo<PestBean> showPestByCondition(Map<String, String> conditon,Integer curPage,Integer pageSize) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IPestDao iPestDao=sqlSession.getMapper(IPestDao.class);

        PageInfo pageInfo=null;
        PageHelper.startPage(curPage,pageSize);

        pageInfo=new PageInfo(iPestDao.getPestListByNameOrHost(conditon));

        return pageInfo;
    }
}
