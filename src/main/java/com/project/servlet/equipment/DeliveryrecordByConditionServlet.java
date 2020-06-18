package com.project.servlet.equipment;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.DeliveryrecordBean;
import com.project.service.IDeliveryrecordService;
import com.project.service.impl.DeliveryrecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件查询出库信息
 */
@WebServlet(name = "DeliveryrecordByConditionServlet",value = "/deliveryrecordByCondition")
public class DeliveryrecordByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String className = request.getParameter("className");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        Map<String,String> map = new HashMap<String,String>();

        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("className",className);
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);

        IDeliveryrecordService iDeliveryrecordService = new DeliveryrecordServiceImpl();

        PageInfo<DeliveryrecordBean> pageInfo = iDeliveryrecordService.queryDeliveryrecordByCondition(map);

        Gson gson = new Gson();
        String json = gson.toJson(pageInfo);
        response.getWriter().println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
