package com.project.servlet.classes;

import com.project.service.IClassesService;
import com.project.service.impl.ClassesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdataClassesServlet",value = "/updateClasses")
public class UpdataClassesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String preson = request.getParameter("person");
        String phone = request.getParameter("phone");

        IClassesService service = new ClassesServiceImpl();

        int i = service.updateClasses(id,preson,phone);

        if (i == 1){
            response.getWriter().println("成功");
        }else {
            response.getWriter().println("失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
