package com.project.service.impl;

import com.project.bean.AreaBean;
import com.project.service.IAreaService;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void getByItem(){
        Map<String,String> map = new HashMap<>();
        map.put("areaName","区");
        map.put("areaTree","林");
        map.put("areaClass","班");

        List<AreaBean> list = service.getAreaByItem(map);

        System.out.println(list);
    }

}