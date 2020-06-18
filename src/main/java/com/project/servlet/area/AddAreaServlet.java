package com.project.servlet.area;

import com.project.bean.AreaBean;
import com.project.service.IAreaService;
import com.project.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAreaServlet",value="/addArea")
public class AddAreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAreaService service = new AreaServiceImpl();
        String areaName = request.getParameter("name");
        String tree = request.getParameter("tree");
        String goodTree = request.getParameter("goodTree");
        Integer tpye = Integer.valueOf(request.getParameter("type"));

        AreaBean areaBean = new AreaBean();
        areaBean.setName(areaName);
        areaBean.setGoodTree(goodTree);
        areaBean.setType(tpye);
        areaBean.setTree(tree);

        int i = service.addArea(areaBean);

        if (i == 1){
            response.getWriter().println("成功");
        }else {
            response.getWriter().println("失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
