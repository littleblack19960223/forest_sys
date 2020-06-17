package com.project.servlet.experts;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.bean.EventBean;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExpertsIncidentServlet",value = "/inciden")
/**展示专家需要解决的事件*/
public class ExpertsIncidentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页的数据
        String curentPage = request.getParameter("curentPage");
        String pageSize = request.getParameter("pageSize");
        ExpertsServiceImpl expertsService = new ExpertsServiceImpl();
        PageInfo<EventBean> list=expertsService.Incident(curentPage, pageSize);
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        Gson gson =gsonBuilder.create();
        String json = gson.toJson(list);
        response.getWriter().print(json);

    }
}
