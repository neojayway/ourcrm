package org.zhiqiang.lzw.exception;

/**
 * 自定义异常类，用于测试
 * @author LZW
 *
 */
public class CustomException extends Exception{
	
	//异常信息
	private String message;
	
	public CustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
