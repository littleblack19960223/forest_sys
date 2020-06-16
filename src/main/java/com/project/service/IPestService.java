package com.project.service;

import com.project.bean.PestBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPestService {
    /**
     * 虫害一览信息
     * @return 所有虫害信息的集合
     */
    public List<PestBean> showAllPest();

    /**
     * 添加新虫害信息
     * @return 影响行数
     */
    public int addNewPest(PestBean pestBean);

    /**
     * 显示详细信息
     * @param id  所选条目的id
     * @return  虫害对象
     */
    public PestBean showDetail(int id);
}
