package com.project.servlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "SeekUserServelet",value = "/seekuser")
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
        PageInfo<UserBean> userBean = iStudentService.showUserInfoList(currentPage,pageSize,usergrade);


        Gson gson = new Gson();

        String json = gson.toJson(userBean);

        response.getWriter().print(json);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
