package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.EquipmentBean;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;


/**
 * 药剂、器械管理service
 */
public interface IEquipmentService {

    /**
     * 分页显示。药剂、器械 信息
     * @param currentPage 当前页数
     * @param pageSize 每页显示数量
     * @return 分页后的药剂、器械信息
     */
    public PageInfo<EquipmentBean> showEquipmentAll(String currentPage, String pageSize);


    /**
     * 根据条件查询药剂信息,分页
     * @param map 条件集合
     * @return 符合条件的分页集合
     */
    public PageInfo<EquipmentBean> queryEquipmentByCondition(Map<String,String> map);


    /**
     * 添加药剂
     * @param equipmentBean 添加的药剂信息
     * @return 添加后，受影响行数
     */
    public int addEquipment(EquipmentBean equipmentBean);

    /**
     * 根据id得到物品信息
     * @param map 物品id，可能有多个
     * @return 对应id的物品信息集合
     */
    public List<EquipmentBean> getEquipmentById(Map<Integer,String> map);
}
