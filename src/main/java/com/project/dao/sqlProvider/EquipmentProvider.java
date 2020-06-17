package com.project.dao.sqlProvider;

import java.util.Map;

public class EquipmentProvider {

    public String getEquipmentById(Map<Integer,String> map){

        String sql = " select " +
                "equipment_id as equipmentId , " +
                "t_name as name, " +
                "t_genre as genre," +
                "t_type as type, " +
                "t_purpose as purpose, " +
                "t_num as num " +
                "from t_equipment WHERE 1=1  ";

        if(map.size() < 0 ){
            return sql;
        }else{
            sql += " and equipment_id = "+map.get(0)+" ";

            for (int i = 1; i < map.size(); i++) {
                sql += " or equipment_id = "+ map.get(i)+" ";
            }
        }

        return sql;
    }
}
