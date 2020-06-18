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

@WebServlet(name = "GetClassesIdServlet",value = "/getClassesById")
public class GetClassesIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassesService service = new ClassesServiceImpl();

        Integer id = Integer.valueOf(request.getParameter("id"));

        ClassesBean classesBean = service.getClassesById(id);

        Gson gson = new Gson();

        String json = gson.toJson(classesBean);

        System.out.println(classesBean);

        response.getWriter().print(classesBean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
