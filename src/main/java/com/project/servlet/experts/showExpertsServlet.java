package com.project.servlet.experts;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.ExpertsBean;
import com.project.service.ExpertsService;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**展示专家*/
@WebServlet(name = "showExpertsServlet",value = "/showExperts")
public class showExpertsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //分页的数据
        String curentPage = request.getParameter("curentPage");
        String pageSize = request.getParameter("pageSize");
        //获得查询的数据,名字，专长，工作
        String name = request.getParameter("name");
        String specialties = request.getParameter("specialties");
        String work = request.getParameter("work");
        if ("".equals(name)){name=null;}
            if ("".equals(specialties)){specialties=null;}
             if ("".equals(work)){work=null;}


        Map<String,String> map = new HashMap<>();
        map.put("curentPage",curentPage);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("specialties",specialties);
        map.put("work",work);
        ExpertsService expertsService = new ExpertsServiceImpl();
        PageInfo<ExpertsBean> show = expertsService.show(map);
        Gson gson = new Gson();
        String s = gson.toJson(show);
        response.getWriter().print(s);


    }
}
