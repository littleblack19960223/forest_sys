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
@WebServlet(name = "UpdateUserServlet", value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String newuserpwd = request.getParameter("newuserpwd");
        String usergrade = request.getParameter("usergrade");

        IUserService iStudentService = new UserServiceImpl();
        UserBean userBean = iStudentService.showUserInfo(username);

        if (newuserpwd.equals(userpwd)) {

            userBean.setUsername(username);
            userBean.setUserpwd(userpwd);
            userBean.setUsergrade(usergrade);

            iStudentService.updateUserInfo(userBean);
        }


        Gson gson = new Gson();

        String json = gson.toJson(userBean);

        response.getWriter().print(json);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
