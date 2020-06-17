package com.project.dao.sqlProvider;

import java.util.Map;

public class RatsSqlProvider {
    public String handleSql(Map<String,String> map){
        String sql="";
        sql="select  pk_rats_id as id," +
                "rats_name as name, +" +
                "rats_food as food, +" +
                "rats_harm as harm, +" +
                "rats_breed as breed, +" +
                "rats_enemy as enemy, +" +
                "rats_measure as measure, +" +
                "rats_img as img" +
                " from t_rats  where 1=1 ";

        String value1=map.get("ratsName");


        if (value1 !=null && ! "".equals(value1)){
            sql+=" and rats_name like '%"+value1+"%'";
        }

        return sql;
    }
}
