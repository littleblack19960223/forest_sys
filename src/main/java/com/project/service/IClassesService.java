package com.project.service;

import com.project.bean.ClassesBean;

import java.util.List;
import java.util.Map;

public interface IClassesService {
    public List<ClassesBean> getAll();

    public List<ClassesBean> getClassesByItem(Map<String,String> map);

    public ClassesBean getClassesById(int id);

    public int addClasses(ClassesBean classesBean);

    public int updateClasses(int id,String person,String phone);

}
