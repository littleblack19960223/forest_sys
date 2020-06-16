package com.project.dao;

import com.project.bean.EquipmentBean;
import org.apache.ibatis.annotations.Select;

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
    public int addEquipmentBean(EquipmentBean equipmentBean);

    /**
     * 根据多条件查询
     * @param map 条件集合
     * @return 符合条件的集合
     */
    public List<EquipmentBean> getEquipmentByconditions(Map<String, String> map);



}
