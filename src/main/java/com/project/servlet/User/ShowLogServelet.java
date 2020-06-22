package com.project.servlet.User;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.Logbean;
import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ShowLogServelet",value = "/showlog")
public class ShowLogServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        IUserService iStudentService = new UserServiceImpl();
        PageInfo<Logbean> userBean = iStudentService.showLogInfoList(currentPage,pageSize);

        Gson gson = new Gson();

        String json = gson.toJson(userBean);

        response.getWriter().print(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
