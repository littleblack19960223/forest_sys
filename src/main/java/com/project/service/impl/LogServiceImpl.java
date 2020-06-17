package com.project.service.impl;

import com.project.bean.Logbean;
import com.project.dao.IUserDao;
import com.project.service.ILogService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class LogServiceImpl implements ILogService {

    private SqlSession sqlSession = MyBatisUtil.getSession();
    @Override
    public int addlog(Logbean logbean) {
        int num = 0;
        try {
            num = sqlSession.getMapper(IUserDao.class).addlog(logbean);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return num;
    }
}
