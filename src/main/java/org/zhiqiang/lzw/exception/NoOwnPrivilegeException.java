package org.zhiqiang.lzw.exception;

/**
 * 不具有权限异常
 * @author LZW
 *
 */
public class NoOwnPrivilegeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public NoOwnPrivilegeException() {}

	public NoOwnPrivilegeException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
