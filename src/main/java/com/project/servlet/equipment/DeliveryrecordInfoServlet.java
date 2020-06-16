package com.project.servlet.equipment;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.DeliveryrecordBean;
import com.project.dao.IDeliveryrecordDao;
import com.project.service.IDeliveryrecordService;
import com.project.service.impl.DeliveryrecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *初始化、设备出库信息
 */
@WebServlet(name = "DeliveryrecordInfoServlet",value = "/DeliveryRecordInfo")
public class DeliveryrecordInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        IDeliveryrecordService iDeliveryrecordService = new DeliveryrecordServiceImpl();

        PageInfo<DeliveryrecordBean> pageInfo = iDeliveryrecordService.showDeliveryrecordInfo(currentPage, pageSize);


        Gson gson = new Gson();
        String json = gson.toJson(pageInfo);
        response.getWriter().println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
