package com.dengji85.blog.service;

import java.util.List;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.model.TimeLine;
import com.dengji85.blog.resultmap.TimeLineResultMap;

public interface TimeLineService {
	
	public List<TimeLineResultMap> getAll();

}
