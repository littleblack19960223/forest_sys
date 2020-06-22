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
import java.io.IOException;

/**
 * @author 23
 */
@WebServlet(name = "AddUserServelet", value = "/adduser")
public class AddUserServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String newuserpwd = request.getParameter("newuserpwd");
        String userrealname = request.getParameter("userrealname");
        String usergrade = request.getParameter("usergrade");

//        判断两次密码是否一致
        if (userpwd.equals(newuserpwd)) {

            IUserService userService = new UserServiceImpl();
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setUserpwd(newuserpwd);
            userBean.setUsergrade(usergrade);
            userBean.setUserrealname(userrealname);
//          添加用户
            userService.addUser(userBean);

            response.getWriter().print(1);

        } else {
            response.getWriter().print(-1);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
