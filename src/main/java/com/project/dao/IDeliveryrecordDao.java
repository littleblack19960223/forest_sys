package com.project.dao;

import com.project.bean.DeliveryrecordBean;

import java.util.List;

/**
 * 出库管理dao
 */
public interface IDeliveryrecordDao {

    /**
     * 得到所有出库信息
     * @return 出库信息集合.
     */
    public List<DeliveryrecordBean> getDeliveryrecordInfo();

    /**
     * 添加出库信息
     * @param deliveryrecordBean 出库信息
     * @return 受影响行数
     */
    public int addDeliveryrecord(DeliveryrecordBean deliveryrecordBean);

}
