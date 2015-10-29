package com.jsu.ic.exception;

import org.apache.struts2.json.annotations.JSON;

/**
 * 
 * 系统异常，key.code对应的编码，异常内容，在国际化资源文件内定义 key暂时只使用code，其他预留先不用
 * 
 * @author hadoop
 * 
 */
@SuppressWarnings("serial")
public class CodeException extends RuntimeException {

	private int code;
	private String key = "code";
	private String message;

	public CodeException(int code) {
		this.code = code;
	}

	public CodeException(int code, Throwable throwable) {
		super(throwable);
		this.code = code;
	}

	public CodeException(int code, String key) {
		this.code = code;
		this.key = key;
	}

	public CodeException(int code, String key, Throwable throwable) {
		super(throwable);
		this.code = code;
		this.key = key;
	}

	public String getMessage() {
		return this.message == null ? (key + "." + code) : this.message;
	}

	/**
	 * 不要轻易调用，会自动从国际化文件中加载消息内容
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public int getCode() {
		return code;
	}

	@JSON(serialize = false, deserialize = false)
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CodeException)) {
			return false;
		}
		return this.code == ((CodeException) obj).code && this.key.equals(((CodeException) obj).key);
	}

}