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

    //dao
    IEquipmentDao iEquipmentDao = sqlSession.getMapper(IEquipmentDao.class);

    @Override
    public PageInfo<EquipmentBean> showEquipmentAll(String currentPage, String pageSize) {


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
    public PageInfo<EquipmentBean> queryEquipmentByCondition(Map<String, String> map) {

        PageInfo<EquipmentBean> pageInfo = null;

        String currentPage = map.get("currentPage");
        String pageSize = map.get("pageSize");

        PageHelper.startPage(Integer.valueOf(currentPage),Integer.valueOf(pageSize));

        List<EquipmentBean> equipmentByconditions = iEquipmentDao.getEquipmentByconditions(map);

        pageInfo = new PageInfo<EquipmentBean>(equipmentByconditions);

        return pageInfo;
    }


    @Override
    public int addEquipment(EquipmentBean equipmentBean) {

        int n = 0;

        try {
            n = iEquipmentDao.addEquipmentBean(equipmentBean);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return n;

    }

    @Override
    public List<EquipmentBean> getEquipmentById(Map<Integer,String> map) {

        return iEquipmentDao.getEquipmentById(map);
    }
}
