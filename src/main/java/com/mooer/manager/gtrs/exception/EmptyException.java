package com.mooer.manager.gtrs.exception;

public class EmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String field;
	
	public EmptyException(String field)
    {
		super("ERROR100001:"+field+":can not be bull");
    }

}
