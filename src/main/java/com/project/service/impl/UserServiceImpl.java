package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.EquipmentBean;
import com.project.bean.Logbean;
import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 23
 */
public class UserServiceImpl implements IUserService {
    private SqlSession sqlSession = MyBatisUtil.getSession();

    /**
     * 根据传入的用户信息创建用户
     */
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

        UserBean userBean = null;
        try {
            userBean = sqlSession.getMapper(IUserDao.class).showUserInfo(name);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return userBean;
    }

    /**
     * 根据修改后的对象
     * 修改数据库信息
     */
    @Override
    public int updateUserInfo(UserBean userBean) {
        SqlSession sqlSession = MyBatisUtil.getSession();

        int update = 0;
        try {
            update = sqlSession.getMapper(IUserDao.class).updateUserInfo(userBean);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return update;
    }

    /**
     * 传入用户名字，删除对应用户
     * 回复1表示删除成功，0表示失败
     */
    @Override
    public int removeuser(String username) {

        int userBean = 0;
        try {
            userBean = sqlSession.getMapper(IUserDao.class).removeuser(username);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return userBean;
    }

    @Override
    public PageInfo<UserBean> showUserInfoList(String currentPage, String pageSize, String usergrade) {
        //使用 pagehelper 分页插件
        PageInfo<UserBean> pageInfo = null;

        //定义分页规则
        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        //得到所有管理员
        List<UserBean> beanList = sqlSession.getMapper(IUserDao.class).showUserInfoList(usergrade);
        //进行分页
        pageInfo = new PageInfo<UserBean>(beanList);

        return pageInfo;
    }
    /**
     * 根据传入的账号密码进行查找
     */
    @Override
    public UserBean login(String username, String pwd) {
        UserBean userBean = null;
        try {
            userBean = sqlSession.getMapper(IUserDao.class).login(username,pwd);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return userBean;
    }
    /**
     * 根据传入的页数
     */
    @Override
    public PageInfo<Logbean> showLogInfoList(String currentPage, String pageSize) {
        //使用 pagehelper 分页插件
        PageInfo<Logbean> pageInfo = null;

        //定义分页规则
        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        //得到所有管理员
        List<Logbean> beanList = sqlSession.getMapper(IUserDao.class).LogInfoList();
        //进行分页
        pageInfo = new PageInfo<Logbean>(beanList);

        return pageInfo;
    }


}
