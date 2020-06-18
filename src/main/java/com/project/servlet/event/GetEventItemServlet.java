package com.project.servlet.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetEventItemServlet",value = "/getEventItem")
public class GetEventItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer state = Integer.valueOf(request.getParameter("state"));
        String areaName = request.getParameter("areaName");

//        Map<String,Object> map = new HashMap<>();
//        if (name!=null && name.length() != 0) {
//            map.put("classesName", name);
//        }
//        if (area != null && area.length() != 0) {
//            map.put("areaName", area);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
