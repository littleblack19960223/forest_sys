package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.Logbean;
import com.project.dao.IUserDao;
import com.project.service.ILogService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询日志信息
     * @param map 查询条件
     * @return 符合条件集合
     */
    @Override
    public PageInfo<Logbean> showLogInfoList(Map<String, String> map) {
        String currentPage = map.get("currentPage");
        String pageSize = map.get("pageSize");

        PageInfo<Logbean> pageInfo = null;

        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        List<Logbean> list = sqlSession.getMapper(IUserDao.class).showLogInfoList(map);

        pageInfo = new PageInfo<Logbean>(list);

        return pageInfo;
    }
}
