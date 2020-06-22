package com.project.servlet.User;

import com.google.gson.Gson;
import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserBean resutBean = new UserBean();


        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        IUserService iUserService = new UserServiceImpl();

        UserBean userBean = iUserService.login(username, pwd);

        if (userBean != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userBean);
        }
        Gson gson = new Gson();

        String json = gson.toJson(userBean);
        response.getWriter().println(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
