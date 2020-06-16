package com.project.dao;

import com.project.bean.DeliveryrecordBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 出库管理dao
 */
public interface IDeliveryrecordDao {

    /**
     * 得到所有出库信息
     * @return 出库信息集合.
     */
    @Select("  SELECT " +
            " dr.t_date as date, " +
            " cla.classes_name as classeName, " +
            " dr.t_user as username " +
            " from t_deliveryrecord as dr " +
            " LEFT JOIN t_classes as cla on dr.classes_id = cla.classes_id")
    public List<DeliveryrecordBean> getDeliveryrecordInfo();

    /**
     * 添加出库信息
     * @param deliveryrecordBean 出库信息
     * @return 受影响行数
     */
    public int addDeliveryrecord(DeliveryrecordBean deliveryrecordBean);

}
