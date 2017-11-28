package com.dengji85.blog.resultmap;

import java.util.List;

public class TimeLineResultMap {
	
	private String time;
	private String content;
	private List<TimeLineResultMap> data;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<TimeLineResultMap> getData() {
		return data;
	}
	public void setData(List<TimeLineResultMap> data) {
		this.data = data;
	}

}
