package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.RatsBean;
import com.project.dao.sqlProvider.RatsSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IRatsService {
    /**
     * 显示所有的鼠害信息
     * @return 鼠害对象
     */
    public List<RatsBean> showAllRats();

    /**
     * 添加新鼠害
     * @return 影响行数
     */
    public int addNewRats(RatsBean rats);

    /**
     * 根据id得到详细信息
     * @return 鼠害对象
     */
    public RatsBean showDetail(int id);

    /**
     * 根据鼠害名称查找鼠害集合
     * @return  鼠害集合
     */
    public PageInfo<RatsBean> showRatsListByCondition(Map<String,String> condition2,Integer curPage,Integer pageSize);
}
