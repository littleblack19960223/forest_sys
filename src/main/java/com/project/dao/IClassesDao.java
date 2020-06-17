package com.project.dao;

import com.project.bean.ClassesBean;

import java.util.List;

public interface IClassesDao {

    public List<ClassesBean> getAll();

    public List<ClassesBean> getClassesByItem(String className,String area);

    public ClassesBean getClassesById(int id);

    public int addClasses(ClassesBean classesBean);

    public int updateClasses(int id,String person,String phone);
}
