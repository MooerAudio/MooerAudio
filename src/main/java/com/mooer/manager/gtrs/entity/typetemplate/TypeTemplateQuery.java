package com.mooer.manager.gtrs.entity.typetemplate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询商品模板字段")
public class TypeTemplateQuery {
	
	@ApiModelProperty(value = "商品模板ID", required = false)
	private Long id;
	
    /**
     * 模板名称
     */
	@ApiModelProperty(value = "商品模板名称", required = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
