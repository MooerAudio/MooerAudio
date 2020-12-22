package com.mooer.manager.gtrs.enums;



public enum CmsContentType {
	
	HOME_BANNER("HOME_BANNER","首页轮播图"),
	HOME_PRODUCT("HOME_PRODUCT","首页更多产品"),
	HOME_PRODUCT_MORE("HOME_PRODUCT_MORE","首页更多产品文字描述"),
	HOME_GOODS("HOME_GOODS","首页产品轮播图"),
	HOME_CATEGORY("HOME_CATEGORY","首页产品分类"),
	HOME_PIC("HOME_PIC","首页图片列表"),
	HOME_VIDEO("HOME_VIDEO","首页视频列表"),
	SHOP_BANNER("SHOP_BANNER","产品页面轮播图"),
	SUPPORT_NEWS("SUPPORT_NEWS","新闻中心"),
	SUPPORT_VIDEO("SUPPORT_VIDEO","视频中心");
	
	private final String code;
    private final String message;
	
	private CmsContentType(String code, String message) {
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
