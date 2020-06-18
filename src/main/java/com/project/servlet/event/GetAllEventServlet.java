package com.project.servlet.event;

import com.google.gson.Gson;
import com.project.bean.EventBean;
import com.project.service.IEventService;
import com.project.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllEventServlet",value = "/getAllEvent")
public class GetAllEventServlet extends HttpServlet {
    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService service = new EventServiceImpl();

        List<EventBean> list = service.getAllEvent();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        System.out.println(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
