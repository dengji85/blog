package com.dengji85.blog.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dengji85.blog.service.TimeLineService;

@Controller
@RequestMapping("/timeLine")
public class TimeLineController {
	@Autowired
	private TimeLineService timeLineService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get(ModelMap map) {
		map.put("timeLine", timeLineService.getAll());

		return "timeLine";
	}

}
