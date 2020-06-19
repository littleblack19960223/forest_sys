package com.project.servlet;

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
import java.util.*;

@WebServlet(name = "UploadServlet", value = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

                String uploadPath = this.getServletContext().getRealPath("/upload");
                File file = new File(uploadPath);
                //如果文件夹不存在则创建
                if (!file.exists() && !file.isDirectory()) {
                    System.out.println("//不存在");
                    file.mkdir();
                }
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
                write(response, "/upload/" + fileName);
                response.getWriter().print("/upload/" + fileName);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
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
