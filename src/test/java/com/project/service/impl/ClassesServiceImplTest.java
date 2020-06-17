package com.project.service.impl;

import com.project.bean.ClassesBean;
import com.project.service.IClassesService;
import org.junit.Test;

import java.util.List;


public class ClassesServiceImplTest {
    private IClassesService service = new ClassesServiceImpl();

    @Test
    public void get(){
        List<ClassesBean> list = service.getAll();
        System.out.println(list);
    }
}