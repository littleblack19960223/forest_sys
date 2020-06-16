package com.project.service.impl;

import com.project.bean.PestBean;
import com.project.dao.IPestDao;
import com.project.service.IPestService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PestServiceImpl implements IPestService {
    @Override
    public List<PestBean> showAllPest() {
        SqlSession sqlSession= MyBatisUtil.getSession();
        IPestDao iPestDao=sqlSession.getMapper(IPestDao.class);

        return iPestDao.getAllPest();
    }
}
