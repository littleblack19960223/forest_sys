package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.PestBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IPestService {
    /**
     * 虫害一览信息
     * @return 分好页的虫害信息的集合
     */
    public PageInfo<PestBean> showAllPest(Integer curPage,Integer pageSize);

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

    /**
     * 根据条件查找虫害信息
     * @param conditon 查找条件
     * @return  分好页的虫害对象集合
     */
    public PageInfo<PestBean>  showPestByCondition(Map<String,String> conditon,Integer curPage,Integer pageSize);
}
