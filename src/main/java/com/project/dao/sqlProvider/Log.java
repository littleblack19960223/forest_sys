package com.project.dao.sqlProvider;

import java.util.Map;

public class Log {
    public String log(Map<String, String> map) {

        String sql = "SELECT " +
                " log_info as loginfo, " +
                " log_data as logdata, " +
                " from t_log " +
                " WHERE 1=1 ";

        String startDate = map.get("startDate");
        String endDate = map.get("endDate");


        if ((startDate != null && !"".equals(startDate))) {
            sql += " and t_date >= '" + startDate + "' ";
        }
        if ((endDate != null && !"".equals(endDate))) {
            sql += " and t_date <= '" + endDate + "' ";
        }

        return sql;

    }
}
