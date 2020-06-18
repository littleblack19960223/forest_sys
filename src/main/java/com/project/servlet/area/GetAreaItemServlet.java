package com.project.servlet.area;

import com.google.gson.Gson;
import com.project.bean.AreaBean;
import com.project.service.IAreaService;
import com.project.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetAreaItemServlet",value = "/getAreaItem")
public class GetAreaItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAreaService service = new AreaServiceImpl();

        String name = request.getParameter("name");
        String tree = request.getParameter("tree");
        String classes = request.getParameter("classes");

        Map<String, String> map = new HashMap<>();
        if (name!=null && name.length() != 0) {
            map.put("areaName", name);
        }
        if (tree != null && tree.length() != 0) {
            map.put("areaTree", tree);
        }
        if (classes != null && classes.length() != 0) {
            map.put("areaClass", classes);
        }

        List<AreaBean> list = service.getAreaByItem(map);

        Gson gson = new Gson();

        String json = gson.toJson(list);

        System.out.println(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
