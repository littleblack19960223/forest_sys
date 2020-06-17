package com.project.servlet.experts;

import com.project.bean.DiscussBean;
import com.project.service.impl.ExpertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addTalksServlet",value = "/addTalks")
/**添加会商结果信息*/
public class addTalksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得专家的字符串数组,进行分隔
        String experts = request.getParameter("experts");
        String[] split = experts.split(",");
        //将字符串转化成一个专家id,数组，和专家名字的字符串，
        int [] expertsId=null;

        //获得会商结果
        String talksTxt = request.getParameter("talksTxt");
        //获得事件的id
       int expId=Integer.parseInt( request.getParameter("expertsId"));
        //获得当前时间
        LocalDate now = LocalDate.now();
        Date date = Date.valueOf(now);
        DiscussBean discussBean = new DiscussBean(expId,date, new String(), talksTxt);
        ExpertsServiceImpl expertsService = new ExpertsServiceImpl();
       int i = expertsService.addTalks(discussBean,expertsId);

    }
}
