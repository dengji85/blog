package com.dengji85.blog.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class UserControlller {

	@RequestMapping("/toLogin")
	public String loginPage() {
		return "manager/index";

	}
	@RequestMapping("/main")
	public String main() {
		return "manager/main";

	}
}
