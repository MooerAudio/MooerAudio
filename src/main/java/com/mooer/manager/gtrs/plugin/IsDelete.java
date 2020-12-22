package com.mooer.manager.gtrs.plugin;

public enum IsDelete {
	
	YES("1"),

    NO("0");
	
	private String code;

    IsDelete(String code) {
        this.code = code;
    }

	public String getCode() {
		return code;
	}

}
