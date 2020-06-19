package com.project.dao.sqlProvider;

import java.util.Map;

public class PestSqlProvider {
    public String handleSql(Map<String,String> map){
        String sql="";
        sql="select  pest_id as id," +
                " pest_name as name," +
                " pest_host as host," +
                " pest_harm as harm," +
                " pest_breed as breed," +
                " pest_enemy as enemy," +
                " pest_measure as measure," +
                " larva_img as larvaImg," +
                " adult_img as adultImg " +
                " from t_pest where 1=1";

        String value1=map.get("pestName");
        String value2=map.get("pestHost");

        if (value1 !=null && !"".equals(value1)){
            sql+=" and pest_name like '%"+value1+"%'";
        }
        if (value2 !=null && !"".equals(value2)){
            sql+=" and pest_host like '%"+value2+"%'";
        }
        return sql;
    }
}
