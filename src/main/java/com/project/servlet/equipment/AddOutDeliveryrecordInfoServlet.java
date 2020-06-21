package com.project.servlet.equipment;

import com.project.service.IDeliveryrecordService;
import com.project.service.impl.DeliveryrecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

/**
 * 添加出库信息
 */
@WebServlet(name = "AddOutDeliveryrecordInfoServlet",value = "/AddOutDeliveryrecordInfo")
public class AddOutDeliveryrecordInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String classId = request.getParameter("classId");   //领用小班
        String outName = request.getParameter("outName");   //出库人
        String outbound = request.getParameter("outbound"); //出库设备id 与 出库数量

        String[] split = outbound.split(",");


        //键出库物品id， 值出库数量
        Map<String,String> map = new HashMap<>();

        for (int i = 0; i < split.length; i += 2) {
            map.put(split[i],split[i+1]);
        }

        IDeliveryrecordService iDeliveryrecordService = new DeliveryrecordServiceImpl();

        int n = iDeliveryrecordService.addDeliveryrecordInfo(map,classId,"张三");

        response.getWriter().println(n);

        //使用迭代器遍历
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            String k = iterator.next();
//            String v = map.get(k);
//            System.out.println(k +":"+v);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
