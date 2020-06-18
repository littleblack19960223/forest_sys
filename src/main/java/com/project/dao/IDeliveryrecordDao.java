package com.project.dao;

import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.DeliveryrecordEquipmentBean;
import com.project.dao.sqlProvider.DeliveryrecordSqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 出库管理dao
 */
public interface IDeliveryrecordDao {

    /**
     * 得到所有出库信息
     * @return 出库信息集合.
     */
    @Select("  SELECT " +
            " dr.deliveryrecord_id as deliveryrecordId," +
            " dr.t_date as date, " +
            " cla.classes_name as classeName, " +
            " dr.t_user as username " +
            " from t_deliveryrecord as dr " +
            " LEFT JOIN t_classes as cla on dr.classes_id = cla.classes_id")
    public List<DeliveryrecordBean> getDeliveryrecordInfo();

    /**
     * 根据条件查询出库信息
     * @param map 集合条件
     * @return 符合条件的集合
     */
    @SelectProvider(type = DeliveryrecordSqlProvider.class,method = "DeliveryrecordCondition")
    public List<DeliveryrecordBean> getDeliveryrecordByCondition(Map<String,String> map);


    /**
     * 添加出库信息
     * @param deliveryrecordEquipmentBean 出库信息
     * @return 受影响行数
     */
    public int addDeliveryrecord(DeliveryrecordEquipmentBean deliveryrecordEquipmentBean);



}
