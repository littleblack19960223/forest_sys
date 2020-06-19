package com.project.servlet.event;

import com.project.bean.AreaBean;
import com.project.bean.EventBean;
import com.project.service.IEventService;
import com.project.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "AddEventServlet",value="/addEvent")
public class AddEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String name = request.getParameter("name");

        Date date = Date.valueOf(request.getParameter("date"));

        Integer state = Integer.valueOf(request.getParameter("state"));

        String describe = request.getParameter("describe");

        float loss = Float.parseFloat(request.getParameter("loss"));

        float area = Float.parseFloat(request.getParameter("area"));

        String prevention = request.getParameter("prevention");

        Integer pathWay = Integer.valueOf(request.getParameter("pathWay"));

        Integer disasterType = Integer.valueOf(request.getParameter("disasterType"));

        AreaBean areaBean = new AreaBean();

        Integer areaId = Integer.valueOf(request.getParameter("areaBean"));

        areaBean.setAreaId(areaId);

        String picture = request.getParameter("picture");

        EventBean eventBean = new EventBean();
        eventBean.setState(state);
        eventBean.setPrevention(prevention);
        eventBean.setPathWay(pathWay);
        eventBean.setDisasterType(disasterType);
        eventBean.setName(name);
        eventBean.setDate(date);
        eventBean.setAreaBean(areaBean);
        eventBean.setDescribe(describe);
        eventBean.setLoss(loss);
        eventBean.setPicture(picture);
        eventBean.setArea(area);
        eventBean.setType(2);

        IEventService service = new EventServiceImpl();

        int i = service.addEvent(eventBean);

        System.out.println(i);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
