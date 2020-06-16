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
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "UpdateExpertsServlet",value = "/UpdateExperts")
public class UpdateExpertsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(request);

                // 存储普通表单参数
                Map<String, String> paramMap = new HashMap<>();

                // 存储文件参数
                Map<String, FileItem> fileMap = new HashMap<>();

                /* 解析表单参数 */
                for (FileItem item : items) {

                    // 普通表单参数
                    if (item.isFormField()) {
                        paramMap.put(item.getFieldName(), item.getString("UTF-8"));
                    }

                    // 文件参数
                    else {
                        fileMap.put(item.getFieldName(), item);
                    }
                }

                /* 从参数集合中获取需要的参数 */
//                String uploadPath = paramMap.get("uploadPath");
                String uploadPath = this.getServletContext().getRealPath("/img");
                System.out.println(uploadPath);
                FileItem fileItem = fileMap.get("file");
                String fileName = fileItem.getName();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                Date d = new Date();
                Random rand = new Random();
                String prefix = d.getTime() + "" + rand.nextLong();
                fileName = prefix + suffix;
                File outFile = new File(uploadPath, fileName);
                if (outFile.exists()) {
                    FileUtils.forceDelete(outFile);
                }
                fileItem.write(outFile);

                write(response,"/img/"+fileName);
                //添加数据
                String expertsName = paramMap.get("expertsName");
                String date = paramMap.get("date");
                //将字符串转化为时间类
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
                Date parse = dateFormat.parse(date);
                String sex = paramMap.get("sex");
                String specialties = paramMap.get("specialties");
                String telephone = paramMap.get("telephone");
                String site = paramMap.get("site");
                String duty = paramMap.get("duty");
                String work = paramMap.get("work");
                String mailbox = paramMap.get("mailbox");
                ExpertsBean expertsBean=null;
                //看id 是否为空
                String id = paramMap.get("id");
                Integer expertsId= Integer.parseInt(id);
                expertsBean = new ExpertsBean(expertsId,expertsName,new java.sql.Date(parse.getTime()),sex,specialties,telephone,site,fileName,duty,work,mailbox);

                int i =new ExpertsServiceImpl().updateExperts(expertsBean);
                    response.getWriter().print(i);
            } catch (FileUploadException e) {
                e.printStackTrace();
                write(response, e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                write(response, e.getMessage());
            }
        }

        // 请求Content-type设置错误时给出提示
        else {
            write(response, "非multipart类型，检查Content-type");
        }
    }
    private void write(HttpServletResponse response, String message) {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
