package com.mooer.manager.gtrs.exception;

public class ExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String field;
	
	public ExistException(String msg)
    {
		super("ERROR100002:"+msg);
    }

}
