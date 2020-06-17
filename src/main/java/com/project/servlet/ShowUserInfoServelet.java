package com.project.servlet;

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

/**
 * @author 23
 */
@WebServlet(name = "ShowUserInfoServelet",value = "/showuserinfo")
public class ShowUserInfoServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        IUserService iStudentService = new UserServiceImpl();
        UserBean userBean = iStudentService.showUserInfo(username);

        Gson gson = new Gson();

        String json = gson.toJson(userBean);

        response.getWriter().print(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
