package com.project.servlet;

import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 23
 */
public class SeekUserServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String usergrade = request.getParameter("usergrade");
        //用模糊查询，如果是所有用户，就查是管理员
        if(usergrade.equals("所有用户")){
            usergrade = "管理员";
        }
        IUserService iStudentService = new UserServiceImpl();
        ArrayList<UserBean> userBean = (ArrayList<UserBean>) iStudentService.showUserInfoList(currentPage,pageSize,usergrade);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
