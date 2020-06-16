package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.DeliveryrecordEquipmentBean;
import com.project.dao.IDeliveryrecordDao;
import com.project.service.IDeliveryrecordService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

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
    public int addDeliveryrecordInfo(DeliveryrecordEquipmentBean deliveryrecordEquipmentBean) {
        return 0;
    }

    @Override
    public List<DeliveryrecordBean> queryDeliveryrecordByCondition(Map<String, String> map) {
        return null;
    }
}
