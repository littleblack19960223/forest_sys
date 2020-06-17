package com.project.service;

import com.project.bean.Logbean;

public interface ILogService  {

    /**
     * 根据传入的对象，添加日志
     */
    public int addlog(Logbean logbean);
}
