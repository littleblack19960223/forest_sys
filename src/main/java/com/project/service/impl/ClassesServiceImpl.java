package com.project.service.impl;

import com.project.bean.ClassesBean;
import com.project.dao.IClassesDao;
import com.project.service.IClassesService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassesServiceImpl implements IClassesService {
    private SqlSession sqlSession = MyBatisUtil.getSession();

    @Override
    public List<ClassesBean> getAll() {
        List<ClassesBean> list = sqlSession.getMapper(IClassesDao.class).getAll();
        return list;
    }

    @Override
    public List<ClassesBean> getClassesByItem(String className, String area) {
        return null;
    }

    @Override
    public ClassesBean getClassesById(int id) {
        return null;
    }

    @Override
    public int addClasses(ClassesBean classesBean) {
        return 0;
    }

    @Override
    public int updateClasses(int id, String person, String phone) {
        return 0;
    }
}
