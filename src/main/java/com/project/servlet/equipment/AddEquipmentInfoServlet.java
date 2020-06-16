package com.project.servlet.equipment;

import com.project.bean.EquipmentBean;
import com.project.service.IEquipmentService;
import com.project.service.impl.EquipmentServiceImpl;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加药剂
 */
@WebServlet(name = "AddEquipmentInfoServlet" ,value ="/AddEquipmentInfo")
public class AddEquipmentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        String type = request.getParameter("type");
        String purpose = request.getParameter("purpose");
        String num = request.getParameter("num");


        EquipmentBean equipmentBean = new EquipmentBean();

        equipmentBean.setEquipmentId(null);
        equipmentBean.setName(name);
        equipmentBean.setGenre(Integer.valueOf(genre));
        equipmentBean.setType(Integer.valueOf(type));
        equipmentBean.setPurpose(purpose);
        equipmentBean.setNum(Integer.valueOf(num));

        //调用业务层
        IEquipmentService iEquipmentService = new EquipmentServiceImpl();
        int n = iEquipmentService.addEquipment(equipmentBean);

        response.getWriter().println(n);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
