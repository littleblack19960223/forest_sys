package com.project.servlet.Information;

import com.google.gson.Gson;
import com.project.bean.DiseaseBean;
import com.project.bean.PestBean;
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

@WebServlet(name = "AddDiseaseServlet",value = "/addDisease")
public class AddDiseaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("diseaseName");
        String cause=request.getParameter("diseaseHost");
        String symptom=request.getParameter("diseaseSymptom");
        String pattern=request.getParameter("diseasePattern");
        String measure=request.getParameter("diseaseMeasure");
        String harm=request.getParameter("diseaseHarm");
        String img=request.getParameter("diseaseImg");
        DiseaseBean diseaseBean=new DiseaseBean();

        diseaseBean.setName(name);
        diseaseBean.setHarm(harm);
        diseaseBean.setPattern(pattern);
        diseaseBean.setCause(cause);
        diseaseBean.setSymptom(symptom);
        diseaseBean.setMeasure(measure);
        diseaseBean.setImg(img);


        IDiseaseService iDiseaseService=new DiseaseServiceImpl();
        Gson gson=new Gson();
        String json=gson.toJson(iDiseaseService.addNewDisease(diseaseBean));
        System.out.println(json);
        response.getWriter().print(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
