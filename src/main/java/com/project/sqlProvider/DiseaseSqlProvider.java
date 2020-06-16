package com.project.sqlProvider;

import java.util.Map;

public class DiseaseSqlProvider {
    public String handleSql(Map<String,String> map){
        String sql="";
        sql="select  pk_disease_id as id," +
                "disease_name as name," +
                "disease_harm as harm," +
                "disease_pattern as pattern," +
                "disease_cause as cause," +
                "disease_symptom as symptom," +
                "disease_measure as measure," +
                "img_path as img," +
                " from t_disease where 1=1 ";

        String value1=map.get("diseaseName");
        String value2=map.get("diseaseSymptom");

        if (value1 !=null && !value1.equals(" ")){
            sql+=" and disease_name like '%"+value1+"%'";
        }
        if (value2!=null && !value2.equals(" ")){
            sql+=" and disease_symptom like '%"+value2+"%'";
        }
        return sql;
    }
}
