package com.mooer.manager.gtrs.enums;



public enum ContactStatus {
	
	NEW("100","新消息"),
	READ("200","已查阅"),
	DEAL("300","已处理");
	
	
	private final String code;
    private final String message;
	
	private ContactStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
