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

@WebServlet(name = "GetEventIdServlet",value = "/getEventId")
public class GetEventIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        IEventService service = new EventServiceImpl();

        EventBean eventBean= service.getEventById(id);

        Gson gson = new Gson();

        String json = gson.toJson(eventBean);

        System.out.println(eventBean);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
