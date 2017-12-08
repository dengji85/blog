package com.dengji85.blog.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dengji85.blog.feign.CkeditFileUploadClient;

@Controller
public class CkeditFileController {
	//@Autowired
	CkeditFileUploadClient ckeditFileUploadClient;
	
	@RequestMapping("/ckedit")
	public void ckedit() {
		ckeditFileUploadClient.ckedit();

	}

}
