package com.project.servlet.equipment;

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

        Enumeration<String> parameterNames = request.getParameterNames();


        System.out.println(parameterNames);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
