package com.dengji85.blog.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	//@Value("${com.dengji85.uploadpath}")
	private String uploadPath;
	private static List<String> imgType;

	 {
		imgType = Arrays
				.asList("bmp,jpg,png,tiff,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF"
						.split(","));

	}

	@RequestMapping("/upload")
	public void uplod(HttpServletRequest req, HttpServletResponse res,
			@RequestParam("upload") MultipartFile file) {

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}

		try {
			String CKEditorFuncNum = req.getParameter("CKEditorFuncNum");
			String s = ClassUtils.getDefaultClassLoader().getResource("static")
					.getPath();
			// File upload = new File(s + "/upload");
			File upload = new File(uploadPath);
			if (!upload.exists()) {
				upload.mkdirs();
			}
			/*
			 * File newFile = new File(s + "/upload", new Date().getTime() +
			 * file.getOriginalFilename());
			 */
			File newFile = new File(uploadPath, new Date().getTime()
					+ file.getOriginalFilename());

			file.transferTo(newFile);
			res.setContentType("text/html; charset=UTF-8");
			res.setHeader("Cache-Control", "no-cache");
			PrintWriter out = res.getWriter();
			StringBuffer sb = new StringBuffer();
			sb.append("<script type=\"text/javascript\">");
			sb.append("window.parent.CKEDITOR.tools.callFunction("
					+ CKEditorFuncNum + ",'" + "/image?name="
					+ newFile.getName() + "','')");
			sb.append("</script>");
			System.out.println(sb.toString());
			out.write(sb.toString());
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/image")
    public void getImage(HttpServletRequest request,HttpServletResponse response,String name) {
		if(name==null){
			//输出默认图片
			//name = "";
		}
		String type = name.substring(name.lastIndexOf("."));
		if(!imgType.contains(type)){
			//输出默认图片
			//name = "";
		}
        FileInputStream fis = null;
        response.setContentType("image/gif");
        try {
            OutputStream out = response.getOutputStream();
            File file = new File(uploadPath,name);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                   fis.close();
                } catch (IOException e) {
                e.printStackTrace();
            }   
              }
        }
    }
}
