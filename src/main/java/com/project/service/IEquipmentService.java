package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.DeliveryrecordEquipmentBean;

import java.util.List;
import java.util.Map;

/**
 * 药剂机械出库管理servlet
 */
public interface IEquipmentService {


    /**
     * 初始化，显示分页后出库信息
     * @param current 当前页数
     * @param pageSize 每页显示数量
     * @return 分页后信息集合
     */
    public PageInfo<DeliveryrecordBean> showDeliveryrecordInfo(String current,String pageSize);

    /**
     * 添加出库信息
     * @param deliveryrecordEquipmentBean 出库信息
     * @return 受影响行数
     */
    public int addDeliveryrecordInfo(DeliveryrecordEquipmentBean deliveryrecordEquipmentBean);

    /**
     * 查询出库信息
     * @param map 查询条件
     * @return 符合条件集合
     */
    public List<DeliveryrecordBean>  queryDeliveryrecordByCondition(Map<String,String> map);

}
