package com.project.servlet.experts;

import com.project.bean.ExpertsBean;
import com.project.service.impl.ExpertsServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "UpdateExpertsServlet", value = "/UpdateExperts")
public class UpdateExpertsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //添加数据
        String expertsName = request.getParameter("expertsName");
        String date = request.getParameter("date");
        //将字符串转化为时间类
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sex = request.getParameter("sex");
        String specialties = request.getParameter("specialties");
        String specialties1 = null;
        switch (specialties) {
            case "1":
                specialties1 = "虫害防治";
                break;
            case "2":
                specialties1 = "病害防治";
                break;
            case "3":
                specialties1 = "鼠害防治";
                break;


        }
        String telephone = request.getParameter("telephone");
        String site = request.getParameter("site");
        String duty = request.getParameter("duty");
        String work = request.getParameter("work");
        String mailbox = request.getParameter("mailbox");
        String head = request.getParameter("head");
        ExpertsBean expertsBean = null;
        //看id 是否为空
        String id = request.getParameter("id");
        Integer expertsId = Integer.parseInt(id);
        expertsBean = new ExpertsBean(expertsId, expertsName, new java.sql.Date(parse.getTime()), sex, specialties1, telephone, site, head, duty, work, mailbox);

        int i = new ExpertsServiceImpl().updateExperts(expertsBean);
        response.getWriter().print(i);

    }

}
