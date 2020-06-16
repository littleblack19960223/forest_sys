package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.EquipmentBean;
import com.project.dao.IEquipmentDao;
import com.project.service.IEquipmentService;
import com.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * 药剂、器械管理 Impl
 */
public class EquipmentServiceImpl implements IEquipmentService {

    SqlSession sqlSession = MyBatisUtil.getSession();

    @Override
    public PageInfo<EquipmentBean> showEquipmentAll(String currentPage, String pageSize) {

        IEquipmentDao iEquipmentDao = sqlSession.getMapper(IEquipmentDao.class);

        //使用 pagehelper 分页插件
        PageInfo<EquipmentBean> pageInfo = null;

        //定义分页规则
        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        //得到所有药剂器械信息
        List<EquipmentBean> equipmentBeanList = iEquipmentDao.getEquipmentAll();

        //进行分页
        pageInfo = new PageInfo<EquipmentBean>(equipmentBeanList);

        return pageInfo;
    }

    @Override
    public List<EquipmentBean> queryEquipmentByCondition(Map<String, String> map) {
        return null;
    }

    @Override
    public int addEquipment(EquipmentBean equipmentBean) {
        return 0;
    }
}
