package com.dengji85.blog.param;

import java.util.Date;

public class DictParam {

	public DictParam(String classCode) {
		this.classCode = classCode;
	}

	public DictParam() {
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.ID
	 * 
	 * @mbggenerated
	 */
	private Long id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.CLASS_CODE
	 * 
	 * @mbggenerated
	 */
	private String classCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.DICT_CODE
	 * 
	 * @mbggenerated
	 */
	private String dictCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.DICT_VALUE
	 * 
	 * @mbggenerated
	 */
	private String dictValue;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.PARTENT
	 * 
	 * @mbggenerated
	 */
	private String partent;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.ADD_TIME
	 * 
	 * @mbggenerated
	 */
	private Date addTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.ADD_USER
	 * 
	 * @mbggenerated
	 */
	private Long addUser;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.MOD_USER
	 * 
	 * @mbggenerated
	 */
	private Long modUser;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.MOD_TIME
	 * 
	 * @mbggenerated
	 */
	private Date modTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column dict.DEL_FLAG
	 * 
	 * @mbggenerated
	 */
	private Integer delFlag;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.ID
	 * 
	 * @return the value of dict.ID
	 * 
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.ID
	 * 
	 * @param id
	 *            the value for dict.ID
	 * 
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.CLASS_CODE
	 * 
	 * @return the value of dict.CLASS_CODE
	 * 
	 * @mbggenerated
	 */
	public String getClassCode() {
		return classCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.CLASS_CODE
	 * 
	 * @param classCode
	 *            the value for dict.CLASS_CODE
	 * 
	 * @mbggenerated
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode == null ? null : classCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.DICT_CODE
	 * 
	 * @return the value of dict.DICT_CODE
	 * 
	 * @mbggenerated
	 */
	public String getDictCode() {
		return dictCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.DICT_CODE
	 * 
	 * @param dictCode
	 *            the value for dict.DICT_CODE
	 * 
	 * @mbggenerated
	 */
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode == null ? null : dictCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.DICT_VALUE
	 * 
	 * @return the value of dict.DICT_VALUE
	 * 
	 * @mbggenerated
	 */
	public String getDictValue() {
		return dictValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.DICT_VALUE
	 * 
	 * @param dictValue
	 *            the value for dict.DICT_VALUE
	 * 
	 * @mbggenerated
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue == null ? null : dictValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.PARTENT
	 * 
	 * @return the value of dict.PARTENT
	 * 
	 * @mbggenerated
	 */
	public String getPartent() {
		return partent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.PARTENT
	 * 
	 * @param partent
	 *            the value for dict.PARTENT
	 * 
	 * @mbggenerated
	 */
	public void setPartent(String partent) {
		this.partent = partent == null ? null : partent.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.ADD_TIME
	 * 
	 * @return the value of dict.ADD_TIME
	 * 
	 * @mbggenerated
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.ADD_TIME
	 * 
	 * @param addTime
	 *            the value for dict.ADD_TIME
	 * 
	 * @mbggenerated
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.ADD_USER
	 * 
	 * @return the value of dict.ADD_USER
	 * 
	 * @mbggenerated
	 */
	public Long getAddUser() {
		return addUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.ADD_USER
	 * 
	 * @param addUser
	 *            the value for dict.ADD_USER
	 * 
	 * @mbggenerated
	 */
	public void setAddUser(Long addUser) {
		this.addUser = addUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.MOD_USER
	 * 
	 * @return the value of dict.MOD_USER
	 * 
	 * @mbggenerated
	 */
	public Long getModUser() {
		return modUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.MOD_USER
	 * 
	 * @param modUser
	 *            the value for dict.MOD_USER
	 * 
	 * @mbggenerated
	 */
	public void setModUser(Long modUser) {
		this.modUser = modUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.MOD_TIME
	 * 
	 * @return the value of dict.MOD_TIME
	 * 
	 * @mbggenerated
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.MOD_TIME
	 * 
	 * @param modTime
	 *            the value for dict.MOD_TIME
	 * 
	 * @mbggenerated
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column dict.DEL_FLAG
	 * 
	 * @return the value of dict.DEL_FLAG
	 * 
	 * @mbggenerated
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column dict.DEL_FLAG
	 * 
	 * @param delFlag
	 *            the value for dict.DEL_FLAG
	 * 
	 * @mbggenerated
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}