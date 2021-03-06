package com.project.servlet.experts;

import com.google.gson.Gson;
import com.project.bean.ExpertsBean;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisasterExpertsServlet",value = "/disasterExperts")
public class DisasterExpertsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String disaster = request.getParameter("disaster");
        //获得前端的数据灾害类型看是字符串还是数字字符串数字还要再转化
        switch (disaster){
            case "1":
                disaster="虫害防治";
                break;
            case "2":
                disaster="鼠害防治";
                break;
            case "3":
                disaster="病害防治";
                break;

        }
        ExpertsServiceImpl expertsService = new ExpertsServiceImpl();
        List<ExpertsBean> list =expertsService.shows(disaster);
        Gson gson =new Gson();
        String json = gson.toJson(list);
        response.getWriter().print(json);

    }
}
