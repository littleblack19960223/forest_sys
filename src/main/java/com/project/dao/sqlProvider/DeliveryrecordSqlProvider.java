package com.project.dao.sqlProvider;

import java.util.Map;

public class DeliveryrecordSqlProvider {

    public String DeliveryrecordCondition(Map<String, String> map) {

        String sql = "SELECT " +
                " dr.t_date as date, " +
                " cla.classes_name as classeName, " +
                " dr.t_user as username " +
                " from t_deliveryrecord as dr " +
                " LEFT JOIN t_classes as cla on dr.classes_id = cla.classes_id  " +
                " WHERE 1=1 ";

        String startDate = map.get("startDate");
        String endDate = map.get("endDate");
        String className = map.get("className");


        if ((startDate != null && !"".equals(startDate))) {
            sql += " and t_date >= '" + startDate + "' ";
        }
        if ((endDate != null && !"".equals(endDate))) {
            sql += " and t_date <= '" + endDate + "' ";
        }

        if (className != null && !"".equals(className)) {
            sql += " and t_user = '" + className + "' ";
        }

        return sql;

    }

    ;

}
