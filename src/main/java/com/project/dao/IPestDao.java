package com.project.dao;

import com.project.bean.PestBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 虫害一览
 */
public interface IPestDao {
    /**
     * 获得所有的虫害信息
     * @return
     */
    @Select("select  pest_id as id," +
            "pest_name as name," +
            "pest_host as host," +
            "pest_harm as harm," +
            "pest_breed as breed," +
            "pest_enemy as enemy," +
            "pest_measure as measure," +
            "larva_img as larvaImg," +
            "adult_img as adultImg " +
            " from t_pest")
    public List<PestBean> getAllPest();
}
