package com.project.servlet.equipment;

import com.google.gson.Gson;
import com.project.bean.DeliveryrecordEquipmentBean;
import com.project.service.IDeliveryrecordService;
import com.project.service.impl.DeliveryrecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 根据出库器械表id 查询出库信息
 */
@WebServlet(name = "QueryOutDeliveryrecordInfoServlet" ,value = "/QueryOutDeliveryrecordInfo")
public class QueryOutDeliveryrecordInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        IDeliveryrecordService iDeliveryrecordService = new DeliveryrecordServiceImpl();

        List<DeliveryrecordEquipmentBean> list = iDeliveryrecordService.getDeliveryrecordEquipmentById(Integer.valueOf(id));

        System.out.println(list);

        Gson gson = new Gson();
        String json = gson.toJson(list);

        response.getWriter().println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
