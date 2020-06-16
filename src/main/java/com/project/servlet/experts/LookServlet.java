package com.project.servlet.experts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.bean.ExpertsBean;
import com.project.service.ExpertsService;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LookServlet",value = "/look")
public class LookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("expertsId");
        ExpertsService expertsService = new ExpertsServiceImpl();

         if (id!=null){
             int num = Integer.parseInt(id);
             ExpertsBean expertsBean = expertsService.lookExperts(num);
             GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
             Gson gson =gsonBuilder.create();
             String json = gson.toJson(expertsBean);
             response.getWriter().print(json);
         }
    }
}
