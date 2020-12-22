package com.mooer.manager.gtrs.entity.itemcat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "新增商品分类字段")
public class ItemCatInsert {

	/**
     * 父类目ID=0时，代表的是一级的类目
     */
	@NotNull(message = "上级ID不能为空")
	@ApiModelProperty(value = "上级ID", required = true)
    private Long parentId;

    /**
     * 类目名称
     */
	@NotBlank(message = "商品分类名称不能为空")
	@ApiModelProperty(value = "商品分类名称", required = true)
    private String name;

    /**
     * 类型id
     */
	@ApiModelProperty(value = "商品模板ID", required = false)
    private Long typeId;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
    
}
