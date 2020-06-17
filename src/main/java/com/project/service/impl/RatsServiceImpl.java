package com.project.service.impl;

import com.project.bean.RatsBean;
import com.project.dao.IDiseaseDao;
import com.project.dao.IRatsDao;
import com.project.service.IRatsService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class RatsServiceImpl implements IRatsService {
    @Override
    public List<RatsBean> showAllRats() {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IRatsDao iRatsDao=sqlSession.getMapper(IRatsDao.class);

        return iRatsDao.getAllRats();
    }

    @Override
    public int addNewRats(RatsBean rats) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IRatsDao iRatsDao=sqlSession.getMapper(IRatsDao.class);
        int n= 0;
        try {
            n = iRatsDao.addNewRats(rats);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return n;
    }

    @Override
    public RatsBean showDetail(int id) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IRatsDao iRatsDao=sqlSession.getMapper(IRatsDao.class);
        return iRatsDao.getDetailById(id);

    }

    @Override
    public List<RatsBean> showRatsListByCondition(Map<String, String> condition2) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IRatsDao iRatsDao=sqlSession.getMapper(IRatsDao.class);

        return iRatsDao.getRatsListByName(condition2);
    }
}
