package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.ClassesBean;
import com.project.dao.IClassesDao;
import com.project.service.IClassesService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ClassesServiceImpl implements IClassesService {
    private SqlSession sqlSession = MyBatisUtil.getSession();

    @Override
    public List<ClassesBean> getAll() {

        List<ClassesBean> list = sqlSession.getMapper(IClassesDao.class).getAll();




        return list;
    }

    @Override
    public List<ClassesBean> getClassesByItem(Map<String,String> map) {


        List<ClassesBean> list = sqlSession.getMapper(IClassesDao.class).getClassesByItem(map);
        return list;
    }

    @Override
    public ClassesBean getClassesById(int id) {
       ClassesBean classesBean = sqlSession.getMapper(IClassesDao.class).getClassesById(id);
       return classesBean;
    }

    @Override
    public int addClasses(ClassesBean classesBean) {
        int i = sqlSession.getMapper(IClassesDao.class).addClasses(classesBean);
        sqlSession.commit();
        return i;
    }

    @Override
    public int updateClasses(int id, String person, String phone) {
        int i = sqlSession.getMapper(IClassesDao.class).updateClasses(id,person,phone);
        sqlSession.commit();
        return i;
    }
}
