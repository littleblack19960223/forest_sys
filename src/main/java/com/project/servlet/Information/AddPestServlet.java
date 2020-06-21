package com.project.servlet.Information;

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

@WebServlet(name = "AddPestServlet",value = "/addPest")
public class AddPestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("pestName");
        String host=request.getParameter("pestHost");
        String breed=request.getParameter("pestBreed");
        String enemy=request.getParameter("pestEnemy");
        String measure=request.getParameter("pestMeasure");
        String harm=request.getParameter("pestHarm");

        PestBean pestBean=new PestBean();
        pestBean.setName(name);
        pestBean.setHost(host);
        pestBean.setHarm(harm);
        pestBean.setBreed(breed);
        pestBean.setEnemy(enemy);
        pestBean.setMeasure(measure);
        pestBean.setLarvaImg("path1");
        pestBean.setAdultImg("path2");

        IPestService iPestService=new PestServiceImpl();
        Gson gson=new Gson();
        String json=gson.toJson(iPestService.addNewPest(pestBean));
        System.out.println(json);
        response.getWriter().print(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
