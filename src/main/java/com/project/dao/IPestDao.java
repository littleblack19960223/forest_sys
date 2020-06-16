package com.project.dao;

import com.project.bean.PestBean;
import com.project.sqlProvider.PestSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 虫害一览
 */
public interface IPestDao {
    /**
     * 获得所有的虫害信息
     * @return 虫害对象
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

    /**
     * 添加新虫害
     * @return 影响行数
     */
    @Insert("insert into t_pest " +
            "(pest_name," +
            "pest_host," +
            "pest_breed," +
            "pest_enemy," +
            "larva_img," +
            "adult_img," +
            "pest_measure," +
            "pest_harm) " +
            " values (#{pest.name},#{pest.host},#{pest.breed},#{pest.enemy},#{pest.larvaImg},#{pest.adultImg},#{pest.measure},#{pest.harm})")
    public int addNewPest(@Param("pest") PestBean pest);

    /**
     * 根据id得到详细信息
     * @return 虫害对象
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
            " from t_pest where pest_id =#{id}")
    public PestBean getDetailById(@Param("id") int id);

    /**
     * 根据名称或宿主查找虫害集合
     * @return  虫害集合
     */
    @SelectProvider(type = PestSqlProvider.class,method = "handleSql")
    public List<PestBean> getPestListByNameOrHost(Map<String,String> condition);
}
