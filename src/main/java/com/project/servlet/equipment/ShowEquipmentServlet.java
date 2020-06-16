package com.project.servlet.equipment;

import com.github.pagehelper.PageInfo;
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

/**
 * 显示分页、药剂器械信息
 */
@WebServlet(name = "ShowEquipmentServlet" ,value = "/showEquipmentInfo")
public class ShowEquipmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        IEquipmentService iEquipmentService = new EquipmentServiceImpl();

        PageInfo<EquipmentBean> pageInfo = iEquipmentService.showEquipmentAll(currentPage,pageSize);

        Gson gson = new Gson();
        String json = gson.toJson(pageInfo);
        response.getWriter().println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
