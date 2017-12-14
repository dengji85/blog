package com.dengji85.blog.feign.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dengji85.blog.feign.CkeditFileUploadClient;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
public class CkeditFileController {
	//@Autowired
	CkeditFileUploadClient ckeditFileUploadClient;
	
	@RequestMapping("/ckedit")
	public void ckedit() {
		ckeditFileUploadClient.ckedit();

	}

	@RequestMapping("t/hello")
	@ResponseBody
	public String hellot() {
		return ckeditFileUploadClient.hello();
	}
	
	@GetMapping("t/view/{id}")
	public Object getImage(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="id") String id) {
		GridFSDBFile file = (GridFSDBFile) this.ckeditFileUploadClient.view(id);

		if (file != null) {
			return ResponseEntity
					.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"fileName=\"" + file.getFilename() + "\"")
					.header(HttpHeaders.CONTENT_TYPE, file.getContentType())
					.header(HttpHeaders.CONTENT_LENGTH, file.getLength() + "")
					.header("Connection", "close").body(this.getByteArray(file.getInputStream()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"File was not fount");
		}
		
	}
	
	/**
	 * 
	* @Title: getByteArray  
	* @Description: 流转为byte数组
	* @return byte[]    返回类型  
	* @throws
	 */
	private byte[] getByteArray(InputStream in) {
		byte[] datas = null;
		try {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];

			int count = -1;
			while ((count = in.read(b)) != -1) {
				bos.write(b, 0, count);

			}
			datas = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
}
