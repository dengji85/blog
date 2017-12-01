package com.dengji85.blog.controller.av;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/av")
public class ActressController {
	@RequestMapping("/index")
public String index(){
	return "av/index";
}
}
