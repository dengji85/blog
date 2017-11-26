

package com.dengji85.blog.common;

import java.io.Serializable;
import java.util.List;

/**
 * ajax分页结果
 * 
 * 
 * @param <T>
 */
public class AjaxPagerResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg = "";
	private int code = 0;
	// 总页数
	private int total = 0;
	// 查询出的总条数
	private int count;
	// 当前页
	private int page;

	// 数据集
	private List<T> data;
	// 每页大小
	private int limit;

	public int getTotal() {
		if (count % limit > 0) {
			total = count / limit + 1;
		} else {
			total = count / limit;
		}
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
