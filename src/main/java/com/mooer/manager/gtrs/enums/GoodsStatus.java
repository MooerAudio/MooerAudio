package com.mooer.manager.gtrs.enums;



public enum GoodsStatus {
	
	NEW("100","新品"),
	SHOW("200","上架"),
	HIDE("800","下架");
	
	private final String code;
    private final String message;
	
	private GoodsStatus(String code, String message) {
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
