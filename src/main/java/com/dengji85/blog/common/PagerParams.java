package com.dengji85.blog.common;

import java.io.Serializable;

public class PagerParams implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int  page = 1;
	private int limit = 10;
	private int offSet;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffSet() {
		return offSet=this.getLimit()*(this.getPage()-1);
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

}
