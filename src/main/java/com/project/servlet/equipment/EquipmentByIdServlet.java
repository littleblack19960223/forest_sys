package com.project.servlet.equipment;

import com.google.gson.Gson;
import com.project.bean.EquipmentBean;
import com.project.service.IEquipmentService;
import com.project.service.impl.EquipmentServiceImpl;

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
 * 根据id 得到物品信息
 */
@WebServlet(name = "EquipmentByIdServlet" ,value = "/equipmentById")
public class EquipmentByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strId = request.getParameter("strId");
        String[] split = strId.split("");

        Map<Integer,String> map = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            map.put(i,split[i]);
        }


        IEquipmentService iEquipmentService = new EquipmentServiceImpl();

        List<EquipmentBean> equipmentById = iEquipmentService.getEquipmentById(map);

        Gson gson = new Gson();
        String json = gson.toJson(equipmentById);
        response.getWriter().println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
