package com.mooer.manager.gtrs.plugin;

public class ApiResult<T> {
    
    private int status;
    
    private String message;

    private T data;

    public ApiResult(T data) {
        this(ApiStatus.SUCCESS, data);
    }
    
    public ApiResult(ApiStatus resultCode, T data) {
        this.status = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }
    
    public ApiResult(int code,String msg, T data) {
        this.status = code;
        this.message = msg;
        this.data = data;
    }
    
    public static<T> ApiResult<T> build(int code,String msg, T data) {
        return new ApiResult<T>(code,msg,data);
    }
    
    public static<T> ApiResult<T> build(ApiStatus resultCode, T data) {
        return new ApiResult<T>(resultCode,data);
    }
    
    public static<T> ApiResult<T> build(ApiStatus resultCode) {
		return new ApiResult<T>(resultCode,null);
	}
    
    public static<T> ApiResult<T> failed() {
        return ApiResult.build(ApiStatus.FAILED,null);
    }
    
    public static<T> ApiResult<T> failed(String msg) {
        return ApiResult.build(ApiStatus.FAILED.getCode(),msg,null);
    }

    public static<T> ApiResult<T> success(T data) {
        return new ApiResult<T>(data);
    }

    public static<T> ApiResult<T> success() {
        return new ApiResult<T>(null);
    }
    
	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

}
