package com.project.servlet.classes;

import com.google.gson.Gson;
import com.project.bean.ClassesBean;
import com.project.service.IClassesService;
import com.project.service.impl.ClassesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetClassesItemServlet",value="/getClassesItem")
public class GetClassesItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassesService service = new ClassesServiceImpl();
        String name = request.getParameter("name");
        String area = request.getParameter("area");

        System.out.println(name);
        System.out.println(area);

        Map<String, String> map = new HashMap<>();
        if (name!=null && name.length() != 0) {
            map.put("classesName", name);
        }
        if (area != null && area.length() != 0) {
            map.put("areaName", area);
        }

        List<ClassesBean> list = service.getClassesByItem(map);

        Gson gson = new Gson();

        String json = gson.toJson(list);

        System.out.println(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
