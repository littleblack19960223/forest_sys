package com.project.service;

import com.project.bean.PestBean;

import java.util.List;

public interface IPestService {
    /**
     * 虫害一览信息
     * @return 所有虫害信息的集合
     */
    public List<PestBean> showAllPest();
}
