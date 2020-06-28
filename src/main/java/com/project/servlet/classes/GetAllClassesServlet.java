package com.project.servlet.classes;

import com.github.pagehelper.PageInfo;
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
import java.util.List;

@WebServlet(name = "GetAllClassesServlet",value = "/getAllClasses")
public class GetAllClassesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassesService service = new ClassesServiceImpl();


        List<ClassesBean> list = service.getAll();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
