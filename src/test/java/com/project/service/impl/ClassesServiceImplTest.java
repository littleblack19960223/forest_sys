package com.project.service.impl;

import com.project.bean.AreaBean;
import com.project.bean.ClassesBean;
import com.project.service.IClassesService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassesServiceImplTest {
    private IClassesService service = new ClassesServiceImpl();

    @Test
    public void get(){
        List<ClassesBean> list = service.getAll();
        System.out.println(list);
    }

    @Test
    public void getOne(){
        ClassesBean classesBean = service.getClassesById(2);
        System.out.println(classesBean);
    }

    @Test
    public void add(){
        ClassesBean classesBean = new ClassesBean();
        AreaBean areaBean = new AreaBean();
        areaBean.setAreaId(11);
        classesBean.setName("测试添加");
        classesBean.setAreaBean(areaBean);
        int i = service.addClasses(classesBean);
        System.out.println(i);
    }

    @Test
    public void update(){
        int i = service.updateClasses(11,"bbb","1433223");
        System.out.println(i);
    }

    @Test
    public void getByItem(){
        Map<String,String> map = new HashMap<>();
        map.put("classesName","班");
        map.put("areaName","区");
        List<ClassesBean> list = service.getClassesByItem(map);
        System.out.println(list);
    }
}