package com.mooer.manager.gtrs.entity.spec;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "规格字段")
public class SpecQuery extends Model<SpecQuery> {

	private static final long serialVersionUID = 1L;
	
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

	/**
	 * 名称
	 */
	@ApiModelProperty(value = "规格名称")
	private String specName;

	/**
	 * 参数列表
	 */
	@ApiModelProperty(value = "规格项名称")
	private String optionNames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getOptionNames() {
		return optionNames;
	}

	public void setOptionNames(String optionNames) {
		this.optionNames = optionNames;
	}

}
