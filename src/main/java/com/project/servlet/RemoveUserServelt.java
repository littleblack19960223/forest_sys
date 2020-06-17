package com.project.servlet;

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
@WebServlet(name = "RemoveUserServelt",value = "/removeuser")
public class RemoveUserServelt extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //传入需要删除对象的名字
        String username = req.getParameter("username");
        IUserService iStudentService = new UserServiceImpl();
        int userBean = iStudentService.removeuser(username);
        System.out.println(userBean);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
