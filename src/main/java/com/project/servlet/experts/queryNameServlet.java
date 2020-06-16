package com.project.servlet.experts;

import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "queryNameServlet",value = "/queryName")
public class queryNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("expertsName");
        ExpertsServiceImpl expertsService = new ExpertsServiceImpl();
        int i=expertsService.queryName(name);
        response.getWriter().print(i);
    }
}
