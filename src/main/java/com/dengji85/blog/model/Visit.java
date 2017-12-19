package com.dengji85.blog.model;

import java.util.Date;

public class Visit {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.ID
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.IP
	 * @mbggenerated
	 */
	private String ip;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.USER_ID
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.ADD_TIME
	 * @mbggenerated
	 */
	private Date addTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.URL
	 * @mbggenerated
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.HTTP_METHOD
	 * @mbggenerated
	 */
	private String httpMethod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column visit.CLASS_METHOD
	 * @mbggenerated
	 */
	private String classMethod;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.ID
	 * @return  the value of visit.ID
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.ID
	 * @param id  the value for visit.ID
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.IP
	 * @return  the value of visit.IP
	 * @mbggenerated
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.IP
	 * @param ip  the value for visit.IP
	 * @mbggenerated
	 */
	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.USER_ID
	 * @return  the value of visit.USER_ID
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.USER_ID
	 * @param userId  the value for visit.USER_ID
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.ADD_TIME
	 * @return  the value of visit.ADD_TIME
	 * @mbggenerated
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.ADD_TIME
	 * @param addTime  the value for visit.ADD_TIME
	 * @mbggenerated
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.URL
	 * @return  the value of visit.URL
	 * @mbggenerated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.URL
	 * @param url  the value for visit.URL
	 * @mbggenerated
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.HTTP_METHOD
	 * @return  the value of visit.HTTP_METHOD
	 * @mbggenerated
	 */
	public String getHttpMethod() {
		return httpMethod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.HTTP_METHOD
	 * @param httpMethod  the value for visit.HTTP_METHOD
	 * @mbggenerated
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod == null ? null : httpMethod.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column visit.CLASS_METHOD
	 * @return  the value of visit.CLASS_METHOD
	 * @mbggenerated
	 */
	public String getClassMethod() {
		return classMethod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column visit.CLASS_METHOD
	 * @param classMethod  the value for visit.CLASS_METHOD
	 * @mbggenerated
	 */
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod == null ? null : classMethod.trim();
	}
}