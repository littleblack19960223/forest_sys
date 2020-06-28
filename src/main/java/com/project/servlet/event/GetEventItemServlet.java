package com.project.servlet.event;

import com.github.pagehelper.PageInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetEventItemServlet",value = "/getEventItem")
public class GetEventItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer state = null;
        if(request.getParameter("state") != null && request.getParameter("state") != ""){
           state = Integer.valueOf(request.getParameter("state"));
        }
        String areaName = request.getParameter("areaName");

        Map<String,Object> map = new HashMap<>();
        if (name!=null && name.length() != 0) {
            map.put("eventName", name);
        }
        if (state != null) {
            map.put("state", state);
        }
        if (areaName != null && areaName.length() != 0) {
            map.put("areaName", areaName);
        }

        IEventService service = new EventServiceImpl();

        List<EventBean> list = service.getEventByItem(map);

        Gson gson = new Gson();

        String json = gson.toJson(list);

        System.out.println(list);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
