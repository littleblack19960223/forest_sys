package com.project.dao.sqlProvider;

import org.apache.ibatis.annotations.Param;

import java.util.Iterator;
import java.util.Map;

public class DRequipment {

    public String InseDRequipmentProvider(@Param(value = "DRprincipal") int DRprincipal, @Param(value = "map") Map<String,String> map){


        String sql = "INSERT into t_deliveryrecord_equipment (deliveryrecord_id,equipment_id,d_e_num) values";

        //循环map得到键值
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String k = iterator.next();
            String v = map.get(k);

            //每次循环添加一次设备id 和 出库数量
            sql += "(#{DRprincipal},"+k+","+v+"),";

        }
        sql = sql.substring(0,sql.lastIndexOf(","));

        return sql;
    }


}
