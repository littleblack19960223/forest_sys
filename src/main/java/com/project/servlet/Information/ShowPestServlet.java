package com.project.servlet.Information;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.PestBean;
import com.project.service.IPestService;
import com.project.service.impl.PestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowPestServlet",value = "/showPest")
public class ShowPestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入showPest");
        IPestService iPestService=new PestServiceImpl();
        PageInfo<PestBean> pageInfo =iPestService.showAllPest();
        Gson gson=new Gson();
        String json=gson.toJson(pageInfo);
        response.getWriter().print(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
