package com.project.service.impl;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 23
 */
public class UserServiceImpl implements IUserService {
    private SqlSession sqlSession = MyBatisUtil.getSession();

    /**
     * 根据传入的用户信息创建用户
     * */
    @Override
    public int addUser(UserBean userBean) {

        int num = 0;
        try {
        num = sqlSession.getMapper(IUserDao.class).adduser(userBean);

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
     * 根据名字查询用户信息
     * 返回用户对象
     */
    @Override
    public UserBean showUserInfo(String name) {

        UserBean userBean = sqlSession.getMapper(IUserDao.class).showUserInfo(name);
        return userBean;
    }

    /**
     * 根据修改后的对象
     * 修改数据库信息
     */
    @Override
    public int updateUserInfo(UserBean userBean) {
        int update = sqlSession.getMapper(IUserDao.class).updateUserInfo(userBean);
        return update;
    }
}
