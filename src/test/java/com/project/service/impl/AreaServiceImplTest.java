package com.project.service.impl;

import com.project.bean.AreaBean;
import com.project.service.IAreaService;

import org.junit.Test;

import java.util.List;

public class AreaServiceImplTest {
    private IAreaService service = new AreaServiceImpl();

    @Test
    public void get(){
        List<AreaBean> list = service.getAllArea();
        System.out.println(list);
    }

    @Test
    public void add(){
        AreaBean areaBean = new AreaBean();
        areaBean.setName("单元测试提交");
        int i = service.addArea(areaBean);
        System.out.println(i);
    }



}