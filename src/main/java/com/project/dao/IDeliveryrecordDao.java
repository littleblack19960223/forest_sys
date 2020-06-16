package com.project.dao;

import com.project.bean.Deliveryrecord;

import java.util.List;

/**
 * 出库管理dao
 */
public interface IDeliveryrecordDao {

    /**
     * 得到所有出库信息
     * @return 出库信息集合.
     */
    public List<Deliveryrecord> getDeliveryrecordInfo();

    /**
     * 添加出库信息
     * @param deliveryrecord 出库信息
     * @return 受影响行数
     */
    public int addDeliveryrecord(Deliveryrecord deliveryrecord);

}
