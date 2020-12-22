package com.mooer.manager.gtrs.entity.spec;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "修改规格字段")
public class SpecUpdate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规格", required = true)
	SpecUpdateInner spec;

	@ApiModelProperty(value = "规格项", required = true)
	List<SpecOptionUpdateInner> specOptions;

	public SpecUpdateInner getSpec() {
		return spec;
	}

	public void setSpec(SpecUpdateInner spec) {
		this.spec = spec;
	}

	public List<SpecOptionUpdateInner> getSpecOptions() {
		return specOptions;
	}

	public void setSpecOptions(List<SpecOptionUpdateInner> specOptions) {
		this.specOptions = specOptions;
	}

	@ApiModel(value = "规格")
	public static class SpecUpdateInner {
		
		public SpecUpdateInner() {
			
		}
		
		@ApiModelProperty(value = "规格id", required = true)
	    private Long id;
		
		@ApiModelProperty(value = "规格名称", required = true)
		private String specName;

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
	}

	@ApiModel(value = "规格项")
	public static class SpecOptionUpdateInner {
		
		public SpecOptionUpdateInner() {
			
		}
		
		@ApiModelProperty(value = "规格项id(如果没有id，则代表新增规格项)", required = false)
	    private Long id;
		
		@ApiModelProperty(value = "规格id(如果没有specId，则代表删除规格项)", required = false)
	    private Long specId;
		
		@ApiModelProperty(value = "规格项名称", required = true)
		private String optionName;

		@ApiModelProperty(value = "排序", required = true)
		private Integer orders;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public Long getSpecId() {
			return specId;
		}

		public void setSpecId(Long specId) {
			this.specId = specId;
		}

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
