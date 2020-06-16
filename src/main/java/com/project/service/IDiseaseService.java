package com.project.service;

import com.project.bean.DiseaseBean;
import com.project.bean.PestBean;

import java.util.List;
import java.util.Map;

public interface IDiseaseService {
    /**
     * 病害一览信息
     * @return 所有病害信息的集合
     */
    public List<DiseaseBean> showAllDisease();

    /**
     * 添加新病害信息
     * @return 影响行数
     */
    public int addNewDisease(DiseaseBean diseaseBean);

    /**
     * 显示详细信息
     * @param id  所选条目的id
     * @return  病害对象
     */
    public DiseaseBean showDetail(int id);

    /**
     * 根据条件查找病害信息
     * @param conditon 查找条件
     * @return  病害对象集合
     */
    public List<DiseaseBean>  showPestByCondition(Map<String,String> conditon);
}
