package com.project.dao;

import com.project.bean.DiseaseBean;
import com.project.bean.PestBean;
import com.project.sqlProvider.DiseaseSqlProvider;
import com.project.sqlProvider.PestSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IDiseaseDao {
    /**
     * 获得所有的病害信息
     * @return 病害对象
     */
    @Select("select  pk_disease_id as id," +
            "disease_name as name," +
            "disease_harm as harm," +
            "disease_pattern as pattern," +
            "disease_cause as cause," +
            "disease_symptom as symptom," +
            "disease_measure as measure," +
            "img_path as img," +
            " from t_disease")
    public List<DiseaseBean> getAllDisease();

    /**
     * 添加新病害
     * @return 影响行数
     */
    @Insert("insert into t_disease " +
            "(disease_name," +
            "disease_harm," +
            "disease_pattern," +
            "disease_cause," +
            "disease_symptom," +
            "disease_measure," +
            "img_path) " +
            " values (#{disease.name},#{disease.harm},#{disease.pattern},#{disease.cause},#{disease.symptom},#{disease.measure},#{disease.img})")
    public int addNewDisease(@Param("disease") DiseaseBean disease);

    /**
     * 根据id得到详细信息
     * @return 病害对象
     */
    @Select("select  pk_disease_id as id," +
            "disease_name as name," +
            "disease_harm as harm," +
            "disease_pattern as pattern," +
            "disease_cause as cause," +
            "disease_symptom as symptom," +
            "disease_measure as measure," +
            "img_path as img " +
            " from t_disease where pk_disease_id=#{id}")
    public DiseaseBean getDetailById(@Param("id") int id);

    /**
     * 根据病害名称或发病症状查找病害集合
     * @return  病害集合
     */
    @SelectProvider(type = DiseaseSqlProvider.class,method = "handleSql")
    public List<DiseaseBean> getPestListByNameOrSymptom(Map<String,String> condition2);
}
