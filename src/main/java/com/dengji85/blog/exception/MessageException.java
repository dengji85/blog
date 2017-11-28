package com.dengji85.blog.exception;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 负责传送应用程序中service层出现的异常以及相应的信息; 如果在service层集成外部系统，捕获异常后也转为该异常抛出
 * @author Administrator
 *
 */
public class MessageException extends RuntimeException {
	private final static String EXCEPTION_FILE_PATH = "message.properties";

	private Integer code = 999;
	private String message;
	private String[] params;

	public Integer getCode() {
		return code;
	}

	public String[] getParams() {
		return params;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageException(Integer code, String... params) {
		this.code = code;
		this.params = params;

		String content = null;
		if (code != null) {
			Properties props = loadProperties(EXCEPTION_FILE_PATH);
			if (props == null) {
				this.message = "";
			}
			content = props.getProperty(String.valueOf(code));
		} else {
			content = this.message;
		}
		String errMsg = getFormatedContent(content, params);
		this.message = errMsg;
	} 
	
	public MessageException(String message, String... params) {
		super(message);
		this.message = message;
		this.params = params;
	}

	public MessageException(Throwable cause) {
		super(cause);
	}

	private static Properties loadProperties(String filePath) {
		Properties prop = new Properties();
		try {
			 
			InputStream in = MessageException.class.getClassLoader()
					.getResourceAsStream(filePath);
			if (in != null) {
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				prop.load(isr);
			}
		} catch (Exception e) {
			System.out.println("Fail to load properties:" + filePath);
		}
		return prop;
	}

	public String getMessage() {

		return message;
	}

	/**
	 * 生成格式化的信息 使用参数替换模板中的占位符
	 * 
	 * @param templateMessage
	 * @param params
	 * @return
	 */
	public static String getFormatedContent(String content, String... params) {
		if (isEmpty(content)) {
			return "";
		}
		// 使用传入的参数替换模板中的占位符
		String formatedMsg = MessageFormat.format(content, params);
		// 将未处理的占位符替换，用于处理少传参数的情况
		String regex = "\\{[0|[1-9]\\d*]\\}";
		String replacement = "";
		formatedMsg = formatedMsg.replaceAll(regex, replacement);
		return formatedMsg;
	}

	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
}
