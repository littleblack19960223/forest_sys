package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.Logbean;

import java.util.Map;

public interface ILogService  {

    /**
     * 根据传入的对象，添加日志
     */
    public int addlog(Logbean logbean);
    /**
     * 查询日志信息
     * @param map 查询条件
     * @return 符合条件集合
     */
    PageInfo<Logbean> showLogInfoList(Map<String, String> map);
}
