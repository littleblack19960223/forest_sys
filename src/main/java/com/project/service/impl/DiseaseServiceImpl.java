package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.DiseaseBean;
import com.project.dao.IDiseaseDao;

import com.project.service.IDiseaseService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DiseaseServiceImpl implements IDiseaseService {
    @Override
    public List<DiseaseBean> showAllDisease() {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IDiseaseDao iDiseaseDao=sqlSession.getMapper(IDiseaseDao.class);

        return iDiseaseDao.getAllDisease();
    }

    @Override
    public int addNewDisease(DiseaseBean diseaseBean) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IDiseaseDao iDiseaseDao=sqlSession.getMapper(IDiseaseDao.class);
        int n= 0;
        try {
            n = iDiseaseDao.addNewDisease(diseaseBean);
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
    public DiseaseBean showDetail(int id) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IDiseaseDao iDiseaseDao=sqlSession.getMapper(IDiseaseDao.class);
        return iDiseaseDao.getDetailById(id);
    }

    @Override
    public PageInfo<DiseaseBean> showDiseaseByCondition(Map<String, String> condition, Integer curPage, Integer pageSize) {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IDiseaseDao iDiseaseDao=sqlSession.getMapper(IDiseaseDao.class);

        PageInfo pageInfo=null;
        PageHelper.startPage(curPage,pageSize);

        pageInfo=new PageInfo(iDiseaseDao.getDiseaseListByNameOrSymptom(condition));
        return pageInfo;
    }
}
