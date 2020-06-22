package com.project.servlet.Information;

import com.google.gson.Gson;
import com.project.service.IDiseaseService;
import com.project.service.IPestService;
import com.project.service.impl.DiseaseServiceImpl;
import com.project.service.impl.PestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SearchDiseaseServlet",value = "/searchDisease")
public class SearchDiseaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("++++++++++进入查询");
        String name=request.getParameter("condition_Name");
        String host=request.getParameter("condition_Symptom");
        String curPage=request.getParameter("curPage");
        String pageSize=request.getParameter("pageSize");

        Map<String,String> condition=new HashMap<String,String>();
        condition.put("diseaseName",name);
        condition.put("diseaseSymptom",host);

       IDiseaseService iDiseaseService=new DiseaseServiceImpl();


        Gson gson=new Gson();

        String json=gson.toJson(iDiseaseService.showDiseaseByCondition(condition,Integer.valueOf(curPage),Integer.valueOf(pageSize)));
        System.out.println(json);

        response.getWriter().print(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
