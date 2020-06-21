package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.DeliveryrecordEquipmentBean;
import com.project.dao.IDeliveryrecordDao;
import com.project.service.IDeliveryrecordService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * 药剂机械出库管理 Impl
 */
public class DeliveryrecordServiceImpl implements IDeliveryrecordService {

    SqlSession sqlSession = MyBatisUtil.getSession();

    IDeliveryrecordDao iDeliveryrecordDao = sqlSession.getMapper(IDeliveryrecordDao.class);

    @Override
    public PageInfo<DeliveryrecordBean> showDeliveryrecordInfo(String currentPage, String pageSize) {


       PageInfo<DeliveryrecordBean> pageInfo = null;

        //进行分页
        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

       //得到所有出库信息
        List<DeliveryrecordBean> deliveryrecordInfo = iDeliveryrecordDao.getDeliveryrecordInfo();

        pageInfo = new PageInfo<DeliveryrecordBean>(deliveryrecordInfo);

        return pageInfo;
    }


    @Override
    public PageInfo<DeliveryrecordBean> queryDeliveryrecordByCondition(Map<String, String> map) {


        String currentPage = map.get("currentPage");
        String pageSize = map.get("pageSize");

        PageInfo<DeliveryrecordBean> pageInfo = null;

        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        List<DeliveryrecordBean> list = iDeliveryrecordDao.getDeliveryrecordByCondition(map);

        pageInfo = new PageInfo<DeliveryrecordBean>(list);

        return pageInfo;
    }

    @Override
    public List<DeliveryrecordEquipmentBean> getDeliveryrecordEquipmentById(int id) {
        return iDeliveryrecordDao.getDeliveryrecordEquipmentById(id);
    }

    @Override
    public int addDeliveryrecordInfo(Map<String, String> map, String classId, String outName) {

        //首先添加 药剂机械出库表，deliveryrecord 并返回主键

        int DRprincipal = 0; //返回主键
        int n = -1; //受影响行数
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String format = dateTimeFormatter.format(localDateTime);

            DeliveryrecordBean deliveryrecordBean = new DeliveryrecordBean();
            deliveryrecordBean.setClasseName(classId);
            deliveryrecordBean.setUserName(outName);
            deliveryrecordBean.setDate(format);

            n = iDeliveryrecordDao.InseDeliveryrecordInfo(deliveryrecordBean);
            DRprincipal = deliveryrecordBean.getDeliveryrecordId();

            //添加 出库器械表  t_deliveryrecord_equipment
            iDeliveryrecordDao.InseDRequipment(DRprincipal,map);

            //根据设备id和出库数量，修改设备表库存  equipment
            iDeliveryrecordDao.updataInventory(map);

            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return n;
    }
}
