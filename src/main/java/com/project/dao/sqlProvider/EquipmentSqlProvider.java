package com.project.dao.sqlProvider;

import java.util.Map;

public class EquipmentSqlProvider {

    public String showEquipmentByConditions(Map<String,String> map){

        String sql = "SELECT  " +
                "    equipment_id as equipmentId, " +
                "    t_name as name, " +
                "    t_genre as genre, " +
                "    t_type as type, " +
                "    t_purpose as purpose " +
                "from t_equipment WHERE 1=1   ";

        if(map.get("name") != null && !map.get("name").equals("")){
            sql +=" and t_name like'%"+map.get("name")+"%' ";
        }
        if(map.get("genre") != null && !map.get("genre").equals("")){
            sql +=" and t_genre = "+map.get("genre")+" ";
        }
        if(map.get("type") != null && !map.get("type").equals("")){
            sql +=" and t_type = "+map.get("type")+" ";
        }

        return sql;
    }

}
