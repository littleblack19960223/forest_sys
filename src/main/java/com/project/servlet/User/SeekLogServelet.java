package com.project.servlet.User;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.DeliveryrecordBean;
import com.project.bean.Logbean;
import com.project.bean.UserBean;
import com.project.service.IDeliveryrecordService;
import com.project.service.ILogService;
import com.project.service.IUserService;
import com.project.service.impl.DeliveryrecordServiceImpl;
import com.project.service.impl.LogServiceImpl;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SeekLogServelet",value = "/seeklog")
public class SeekLogServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        Map<String,String> map = new HashMap<String,String>();

        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);

        ILogService logService = new LogServiceImpl();

        PageInfo<Logbean> pageInfo = logService.showLogInfoList(map);

        Gson gson = new Gson();
        String json = gson.toJson(pageInfo);
        response.getWriter().println(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
