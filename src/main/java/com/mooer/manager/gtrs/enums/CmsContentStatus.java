package com.mooer.manager.gtrs.enums;



public enum CmsContentStatus {
	
	HIDE("100","隐藏"),
	SHOW("200","正常");
	
	private final String code;
    private final String message;
	
	private CmsContentStatus(String code, String message) {
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
