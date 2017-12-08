package com.dengji85.blog.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//@FeignClient("eureka-file")
public interface CkeditFileUploadClient {
	@PostMapping("/ckedit")
	public void ckedit();
	/*
	HttpServletRequest req, HttpServletResponse res,
	@RequestParam("upload") MultipartFile upload*/
}
