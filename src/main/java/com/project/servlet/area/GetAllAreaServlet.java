package com.project.servlet.area;

import com.github.pagehelper.PageInfo;
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
import java.util.List;

@WebServlet(name = "GetAllAreaServlet",value = "/getAllArea")
public class GetAllAreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        IAreaService service = new AreaServiceImpl();

        List<AreaBean> list = service.getAllArea();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
