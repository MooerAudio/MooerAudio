package com.mooer.manager.gtrs.entity.itemcat;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "修改商品分类字段")
public class ItemCatUpdate {
	
	@NotNull(message = "ID不能为空")
	@ApiModelProperty(value = "ID", required = true)
    private Long id;

	/**
     * 父类目ID=0时，代表的是一级的类目
     */
	@ApiModelProperty(value = "上级ID", required = false)
    private Long parentId;

    /**
     * 类目名称
     */
	@ApiModelProperty(value = "商品分类名称", required = false)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
