package com.mooer.manager.gtrs.entity.typetemplate;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "新增商品模板字段")
public class TypeTemplateInsert {
	
	/**
     * 模板名称
     */
	@NotBlank(message = "name不能为空")
	@ApiModelProperty(value = "商品模板名称", required = true)
    private String name;

    /**
     * 关联规格
     */
	@NotBlank(message = "specIds不能为空")
	@ApiModelProperty(value = "关联规格格式:[{'id':27,'text':'网络'},{'id':32,'text':'内存'}]" , required = true)
    private String specIds;
	
    /**
     * 自定义属性
     */
	@ApiModelProperty(value = "自定义属性格式:[{'text':'内存大小'},{'text':'颜色'}]" , required = false)
    private String customAttributeItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecIds() {
		return specIds;
	}

	public void setSpecIds(String specIds) {
		this.specIds = specIds;
	}

	public String getCustomAttributeItems() {
		return customAttributeItems;
	}

	public void setCustomAttributeItems(String customAttributeItems) {
		this.customAttributeItems = customAttributeItems;
	}
    
}
