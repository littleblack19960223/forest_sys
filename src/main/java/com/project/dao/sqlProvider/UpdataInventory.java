package com.project.dao.sqlProvider;

import org.apache.ibatis.annotations.Param;

import java.util.*;

public class UpdataInventory {

    public String updataInventoryProvider(Map<String,String> map){

        System.out.println(map);

        String sql = " UPDATE t_equipment " +
                "set t_num = case equipment_id";

        List<String> list = new ArrayList<>();
        // key出库设备id  value出库数量
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String k = iterator.next();
            String v = map.get(k);
            sql += " when "+k+" then t_num - "+v+"";
            list.add(k);
        }
        sql += " end where ";

        for (String id : list) {
            sql += "equipment_id = "+id+" or ";
        }

        sql = sql.substring(0,sql.lastIndexOf("or"));

        System.out.println(sql);
        return sql;
    }


}
