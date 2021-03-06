package com.project.dao;

import com.project.bean.EquipmentBean;
import com.project.dao.sqlProvider.EquipmentProvider;
import com.project.dao.sqlProvider.EquipmentSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * 药剂机械管理dao
 */
public interface IEquipmentDao {


    /**
     * 得到所有药剂、器械
     * @return 药剂、器械。集合
     */
    @Select("select  " +
            " equipment_id as equipmentId , " +
            " t_name as name, " +
            " t_genre as genre, " +
            " t_type as type, " +
            " t_purpose as purpose  " +
            " from t_equipment")
    public List<EquipmentBean> getEquipmentAll();


    /**
     * 添加药剂、器械
     * @param equipmentBean 添加对象
     * @return 受影响行数
     */
    @Insert(" INSERT into t_equipment SET " +
            "equipment_id = #{equipment.equipmentId}, " +
            "t_name = #{equipment.name}, " +
            "t_genre = #{equipment.genre}, " +
            "t_type = #{equipment.type}, " +
            "t_purpose = #{equipment.purpose}, " +
            "t_num = #{equipment.num}")
    public int addEquipmentBean(@Param(value = "equipment") EquipmentBean equipmentBean);


    /**
     * 根据多条件查询
     * @param map 条件集合
     * @return 符合条件的集合
     */
    @SelectProvider(type = EquipmentSqlProvider.class,method = "showEquipmentByConditions")
    public List<EquipmentBean> getEquipmentByconditions(Map<String, String> map);


    /**
     * 根据id得到物品信息
     * @param map 物品id，可能有多个
     * @return 对应id的物品信息集合
     */
    @SelectProvider(type = EquipmentProvider.class,method = "getEquipmentById")
    public List<EquipmentBean> getEquipmentById(Map<Integer,String> map);



}
