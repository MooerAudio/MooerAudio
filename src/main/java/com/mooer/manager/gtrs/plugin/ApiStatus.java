package com.mooer.manager.gtrs.plugin;

public enum ApiStatus {
	
	SUCCESS(200, "SUCCESS"),

    FAILED(400, "FAILED"),

    VALIDATE_FAILED(401, "VALIDATE_FAILED"),

    ERROR(500, "ERROR");

    private int code;
    private String msg;

    ApiStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
