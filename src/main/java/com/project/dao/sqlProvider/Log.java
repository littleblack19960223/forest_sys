package com.project.dao.sqlProvider;

import java.util.Map;

public class Log {
    public String log(Map<String, String> map) {

        String sql = "SELECT " +
                " log_info as loginfo, " +
                " log_data as logdata " +
                " from t_log " +
                " WHERE 1=1 ";

        String startDate = map.get("startDate");
        String endDate = map.get("endDate");


        if ((startDate != null && !"".equals(startDate))) {
            sql += " and log_data >= '" + startDate + " 00:00:00' ";
        }
        if ((endDate != null && !"".equals(endDate))) {
            sql += " and log_data <= '" + endDate + " 23:59:59' ";
        }
        return sql;


    }
}
