package com.dengji85.blog.resultmap;

import java.util.Date;

import com.dengji85.blog.common.PagerParams;

public class ArticleResultMap extends PagerParams {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String description;

	private Integer type;
	private String typeName;

	private Date addTime;
	private String author = "zhangsan";
	private Long addUser;
	private String addTimeStr;
	private Date modTime;

	private Long modUser;

	private Integer delFlag;

	private Integer viewNum;

	private Integer commentNum;

	private String keyWords;

	private String content;
	
	private Integer orderNo;

	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.ID
	 * 
	 * @param id
	 *            the value for article.ID
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.TITLE
	 * 
	 * @return the value of article.TITLE
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.TITLE
	 * 
	 * @param title
	 *            the value for article.TITLE
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.DESCRIPTION
	 * 
	 * @return the value of article.DESCRIPTION
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.DESCRIPTION
	 * 
	 * @param description
	 *            the value for article.DESCRIPTION
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.TYPE
	 * 
	 * @return the value of article.TYPE
	 * @mbggenerated
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.TYPE
	 * 
	 * @param type
	 *            the value for article.TYPE
	 * @mbggenerated
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.ADD_TIME
	 * 
	 * @return the value of article.ADD_TIME
	 * @mbggenerated
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.ADD_TIME
	 * 
	 * @param addTime
	 *            the value for article.ADD_TIME
	 * @mbggenerated
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.ADD_USER
	 * 
	 * @return the value of article.ADD_USER
	 * @mbggenerated
	 */
	public Long getAddUser() {
		return addUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.ADD_USER
	 * 
	 * @param addUser
	 *            the value for article.ADD_USER
	 * @mbggenerated
	 */
	public void setAddUser(Long addUser) {
		this.addUser = addUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.MOD_TIME
	 * 
	 * @return the value of article.MOD_TIME
	 * @mbggenerated
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.MOD_TIME
	 * 
	 * @param modTime
	 *            the value for article.MOD_TIME
	 * @mbggenerated
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.MOD_USER
	 * 
	 * @return the value of article.MOD_USER
	 * @mbggenerated
	 */
	public Long getModUser() {
		return modUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.MOD_USER
	 * 
	 * @param modUser
	 *            the value for article.MOD_USER
	 * @mbggenerated
	 */
	public void setModUser(Long modUser) {
		this.modUser = modUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.DEL_FLAG
	 * 
	 * @return the value of article.DEL_FLAG
	 * @mbggenerated
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.DEL_FLAG
	 * 
	 * @param delFlag
	 *            the value for article.DEL_FLAG
	 * @mbggenerated
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.VIEW_NUM
	 * 
	 * @return the value of article.VIEW_NUM
	 * @mbggenerated
	 */
	public Integer getViewNum() {
		return viewNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.VIEW_NUM
	 * 
	 * @param viewNum
	 *            the value for article.VIEW_NUM
	 * @mbggenerated
	 */
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.COMMENT_NUM
	 * 
	 * @return the value of article.COMMENT_NUM
	 * @mbggenerated
	 */
	public Integer getCommentNum() {
		return commentNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.COMMENT_NUM
	 * 
	 * @param commentNum
	 *            the value for article.COMMENT_NUM
	 * @mbggenerated
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.KEY_WORDS
	 * 
	 * @return the value of article.KEY_WORDS
	 * @mbggenerated
	 */
	public String getKeyWords() {
		return keyWords;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.KEY_WORDS
	 * 
	 * @param keyWords
	 *            the value for article.KEY_WORDS
	 * @mbggenerated
	 */
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords == null ? null : keyWords.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column article.CONTENT
	 * 
	 * @return the value of article.CONTENT
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column article.CONTENT
	 * 
	 * @param content
	 *            the value for article.CONTENT
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAddTimeStr() {
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
}