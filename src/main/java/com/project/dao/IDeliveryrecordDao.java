package com.project.dao;

import com.project.bean.DeliveryrecordBean;
import com.project.bean.DeliveryrecordEquipmentBean;
import com.project.dao.sqlProvider.DRequipment;
import com.project.dao.sqlProvider.DeliveryrecordSqlProvider;
import com.project.dao.sqlProvider.UpdataInventory;
import org.apache.ibatis.annotations.*;


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
     * 根据出库器械表id 查询出库信息
     * @param id 出库表id
     * @return 出库信息集合
     */
    public List<DeliveryrecordEquipmentBean> getDeliveryrecordEquipmentById(@Param(value = "id") int id);

    /**
     * 添加 药剂机械出库表
     * @param deliveryrecordBean 药剂机械出库对象
     * @return 受影响行数， 并返回增加的主键id
     */
    @Insert(" INSERT INTO t_deliveryrecord SET " +
            "classes_id = #{dr.classeName}," +
            "t_user = #{dr.userName} ," +
            "t_date = #{dr.date} ")
    @Options(useGeneratedKeys = true,keyProperty = "dr.deliveryrecordId",keyColumn = "deliveryrecordId_id")
    public int InseDeliveryrecordInfo(@Param(value = "dr") DeliveryrecordBean deliveryrecordBean);

    /**
     * 添加 出库机械表
     * @param DRprincipal 药剂机械出库id
     * @param map   k:设备id 与 v:出库数量
     * @return 受影响行数
     */
    @InsertProvider(type = DRequipment.class,method = "InseDRequipmentProvider")
    public int InseDRequipment(@Param(value = "DRprincipal") int DRprincipal,@Param(value = "map") Map<String,String> map);


    /**
     *  根据 设备id 和 出库数量 更新库存
     * @param map 设备id 和 出库数量集合
     * @return 受影响行数
     */
    @UpdateProvider(type = UpdataInventory.class,method = "updataInventoryProvider")
    public int updataInventory(Map<String,String> map);

}
