package com.project.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.bean.Logbean;
import com.project.service.ILogService;
import com.project.service.IUserService;
import com.project.service.impl.LogServiceImpl;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author 23
 */
@WebServlet(name = "AddLogServelet",value = "/addlog")
public class AddLogServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        ILogService iUserService = new LogServiceImpl();
        //获得当前时间
        Calendar now = Calendar.getInstance();
        Logbean logbean = new Logbean();
        if(now.get(Calendar.MINUTE)<10) {
            logbean.setLoginfo("用户" + username + "在" + now.get(Calendar.HOUR_OF_DAY) + ":0" + now.get(Calendar.MINUTE) + "登录了系统");
        } else {
            logbean.setLoginfo("用户" + username + "在" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + "登录了系统");

        }
        logbean.setLogdata(new java.sql.Date(new java.util.Date().getTime()));


        iUserService.addlog(logbean);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
