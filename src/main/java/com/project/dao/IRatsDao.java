package com.project.dao;

import com.project.bean.DiseaseBean;
import com.project.bean.RatsBean;
import com.project.dao.sqlProvider.DiseaseSqlProvider;
import com.project.dao.sqlProvider.RatsSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IRatsDao {
    /**
     * 获得所有的鼠害信息
     * @return 鼠害对象
     */
    @Select("select  pk_rats_id as id," +
            "rats_name as name," +
            "rats_food as food," +
            "rats_harm as harm," +
            "rats_breed as breed," +
            "rats_enemy as enemy," +
            "rats_measure as measure," +
            "rats_img as img" +
            " from t_rats ")
    public List<RatsBean> getAllRats();

    /**
     * 添加新鼠害
     * @return 影响行数
     */
    @Insert("insert into t_rats " +
            "(rats_name," +
            "rats_food," +
            "rats_harm," +
            "rats_breed," +
            "rats_enemy," +
            "rats_measure," +
            "rats_img) " +
            " values (#{rats.name},#{rats.food},#{rats.harm},#{rats.breed},#{rats.enemy},#{rats.measure},#{rats.img})")
    public int addNewRats(@Param("rats") RatsBean rats);

    /**
     * 根据id得到详细信息
     * @return 鼠害对象
     */
    @Select("select  pk_rats_id as id," +
            "rats_name as name, +" +
            "rats_food as food, +" +
            "rats_harm as harm, +" +
            "rats_breed as breed, +" +
            "rats_enemy as enemy, +" +
            "rats_measure as measure, +" +
            "rats_img as img" +
            " from t_rats  where pk_rats_id=#{id}")
    public RatsBean getDetailById(@Param("id") int id);

    /**
     * 根据鼠害名称查找鼠害集合
     * @return  鼠害集合
     */
    @SelectProvider(type = RatsSqlProvider.class,method = "handleSql")
    public List<RatsBean> getRatsListByName(Map<String,String> condition2);
}
