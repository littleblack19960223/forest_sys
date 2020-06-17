package com.project.servlet.experts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.bean.EventBean;
import com.project.service.ExpertsService;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TalksServlet", value = "/talks")
/**根据id查询事件的详细信息，包含会商信息*/
public class TalksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        ExpertsService expertsService = new ExpertsServiceImpl();
        int id = Integer.parseInt(eventId);
        EventBean eventBean=expertsService.talks(id);
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        Gson gson =gsonBuilder.create();
        String json = gson.toJson(eventBean);
        response.getWriter().print(json);

    }
}
