package com.project.servlet.Information;

import com.google.gson.Gson;
import com.project.bean.PestBean;
import com.project.bean.RatsBean;
import com.project.service.IPestService;
import com.project.service.IRatsService;
import com.project.service.impl.PestServiceImpl;
import com.project.service.impl.RatsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddRatsServlet",value = "/addRats")
public class AddRatsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("pestName");
        String food=request.getParameter("pestFood");
        String breed=request.getParameter("pestBreed");
        String enemy=request.getParameter("pestEnemy");
        String measure=request.getParameter("pestMeasure");
        String harm=request.getParameter("pestHarm");

        RatsBean ratsBean=new RatsBean();
        ratsBean.setName(name);
        ratsBean.setFood(food);
        ratsBean.setHarm(harm);
        ratsBean.setBreed(breed);
        ratsBean.setEnemy(enemy);
        ratsBean.setMeasure(measure);
        ratsBean.setImg("");


        IRatsService iRatsService=new RatsServiceImpl();
        Gson gson=new Gson();
        String json=gson.toJson(iRatsService.addNewRats(ratsBean));
        System.out.println(json);
        response.getWriter().print(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
