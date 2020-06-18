package com.project.servlet.classes;

import com.project.bean.AreaBean;
import com.project.bean.ClassesBean;
import com.project.service.IAreaService;
import com.project.service.IClassesService;
import com.project.service.impl.AreaServiceImpl;
import com.project.service.impl.ClassesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddClassesServlet",value = "/addClasses")
public class AddClassesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String person = request.getParameter("person");
        String phone = request.getParameter("phone");
        Integer num = Integer.valueOf(request.getParameter("num"));
        Integer id = Integer.valueOf(request.getParameter("areaId"));

        ClassesBean classesBean = new ClassesBean();
        classesBean.setName(name);
        classesBean.setPerson(person);
        classesBean.setPhone(phone);
        classesBean.setNum(num);
        AreaBean areaBean = new AreaBean();
        areaBean.setAreaId(id);
        classesBean.setAreaBean(areaBean);

        IClassesService service = new ClassesServiceImpl();

        int i = service.addClasses(classesBean);

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
