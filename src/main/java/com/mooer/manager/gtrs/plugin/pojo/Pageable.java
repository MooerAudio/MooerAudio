package com.mooer.manager.gtrs.plugin.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "分页字段")
public class Pageable {

	@ApiModelProperty(value = "当前页数",required = true)
	@Min(value = 1, message = "page不能小于1")
	@NotNull(message = "page不能为空")
	int page;

	@ApiModelProperty(value = "页面条数",required = true)
	@Min(value = 1, message = "size不能小于1")
	@NotNull(message = "size不能为空")
	int size;

	@ApiModelProperty(value = "排序字段名称")
	String sort;

	@ApiModelProperty(value = "升序或是降序")
	String order;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSort() {
		if (this.sort == null || "".equals(this.sort)) {
			return "id";
		} else {
			return this.sort;
		}
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		if (this.order == null || "".equals(this.order)) {
			return "asc";
		} else {
			return this.order;
		}
	}

	public void setOrder(String order) {
		this.order = order;
	}

//	public void setSort(String sort) {
//		if(sort==null||"".equals(sort)) {
//			this.sort = "id";
//		}else {
//			this.sort = sort;
//		}
//	}
//
//	public void setOrder(String order) {
//		if(order==null||"".equals(order)) {
//			this.order = "asc";
//		}else {
//			this.order = order;
//		}
//	}

}
