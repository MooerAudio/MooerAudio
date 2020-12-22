package com.mooer.manager.gtrs.entity.spec;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "新增规格字段")
public class SpecInsert implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规格", required = true)
	SpecInsertInner spec;

	@ApiModelProperty(value = "规格项", required = true)
	List<SpecOptionInsertInner> specOptions;

	public SpecInsertInner getSpec() {
		return spec;
	}

	public void setSpec(SpecInsertInner spec) {
		this.spec = spec;
	}

	public List<SpecOptionInsertInner> getSpecOptions() {
		return specOptions;
	}

	public void setSpecOptions(List<SpecOptionInsertInner> specOptions) {
		this.specOptions = specOptions;
	}

	@ApiModel(value = "规格")
	public static class SpecInsertInner {
		
		public SpecInsertInner() {
			
		}

		@ApiModelProperty(value = "规格名称", required = true)
		private String specName;

		public String getSpecName() {
			return specName;
		}

		public void setSpecName(String specName) {
			this.specName = specName;
		}
	}

	@ApiModel(value = "规格项")
	public static class SpecOptionInsertInner {
		
		public SpecOptionInsertInner() {
			
		}
		
		@ApiModelProperty(value = "规格项名称", required = true)
		private String optionName;

		@ApiModelProperty(value = "排序", required = true)
		private Integer orders;

		public String getOptionName() {
			return optionName;
		}

		public void setOptionName(String optionName) {
			this.optionName = optionName;
		}

		public Integer getOrders() {
			return orders;
		}

		public void setOrders(Integer orders) {
			this.orders = orders;
		}

	}
}
