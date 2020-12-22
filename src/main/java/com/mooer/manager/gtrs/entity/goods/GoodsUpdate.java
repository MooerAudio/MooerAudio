package com.mooer.manager.gtrs.entity.goods;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author main
 * @since 2020-05-25
 */
public class GoodsUpdate {
	
	@NotBlank(message = "商品ID不能为空")
    private Long id;
    /**
     * SPU名
     */
    private String goodsName;

    /**
     * 默认SKU
     */
    private Long defaultItemId;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    private Long category1Id;

    /**
     * 二级类目
     */
    private Long category2Id;

    /**
     * 三级类目
     */
    private Long category3Id;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    private Long typeTemplateId;

    /**
     * 是否启用规格
     */
    private String isEnableSpec;

    /**
     * 是否删除
     */
    private String isDelete;
    
    /**
     * 小图
     */
    private String smallPic;
    
    /**
     * 大图
     */
    private String largePic;
    
    
    /**
     * 描述
     */
    private String introduction;

    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;

    /**
     * 自定义属性（参数结果）
     */
    private String customAttributeItems;

    private String itemImages;

    /**
     * 包装列表
     */
    private String packageList;

    /**
     * 售后服务
     */
    private String saleService;
    
    private String videoUrl;
    
    private String features;

    private String buyUrl;
    
    private String description;
    
    /**
     * 连接方式
     */
    private String connections;

    /**
     * 附加说明书
     */
    private String attachments;
    
    /**
     * 说明书
     */
    private String instructions;
    
    /**
     * banner链接
     */
    private String bannerUrl;
    
    private String descImgUrl;

    private String audioUrl;
    
    private String attachmentsDesc;
    
    private String specificationLine;

	public String getSpecificationLine() {
		return specificationLine;
	}

	public void setSpecificationLine(String specificationLine) {
		this.specificationLine = specificationLine;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public String getAttachmentsDesc() {
		return attachmentsDesc;
	}

	public void setAttachmentsDesc(String attachmentsDesc) {
		this.attachmentsDesc = attachmentsDesc;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
    
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getDefaultItemId() {
		return defaultItemId;
	}

	public void setDefaultItemId(Long defaultItemId) {
		this.defaultItemId = defaultItemId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Long getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
	}

	public Long getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Long category2Id) {
		this.category2Id = category2Id;
	}

	public Long getCategory3Id() {
		return category3Id;
	}

	public void setCategory3Id(Long category3Id) {
		this.category3Id = category3Id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getTypeTemplateId() {
		return typeTemplateId;
	}

	public void setTypeTemplateId(Long typeTemplateId) {
		this.typeTemplateId = typeTemplateId;
	}

	public String getIsEnableSpec() {
		return isEnableSpec;
	}

	public void setIsEnableSpec(String isEnableSpec) {
		this.isEnableSpec = isEnableSpec;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getSmallPic() {
		return smallPic;
	}

	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}

	public String getLargePic() {
		return largePic;
	}

	public void setLargePic(String largePic) {
		this.largePic = largePic;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSpecificationItems() {
		return specificationItems;
	}

	public void setSpecificationItems(String specificationItems) {
		this.specificationItems = specificationItems;
	}

	public String getCustomAttributeItems() {
		return customAttributeItems;
	}

	public void setCustomAttributeItems(String customAttributeItems) {
		this.customAttributeItems = customAttributeItems;
	}

	public String getItemImages() {
		return itemImages;
	}

	public void setItemImages(String itemImages) {
		this.itemImages = itemImages;
	}

	public String getPackageList() {
		return packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public String getSaleService() {
		return saleService;
	}

	public void setSaleService(String saleService) {
		this.saleService = saleService;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getBuyUrl() {
		return buyUrl;
	}

	public void setBuyUrl(String buyUrl) {
		this.buyUrl = buyUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConnections() {
		return connections;
	}

	public void setConnections(String connections) {
		this.connections = connections;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getDescImgUrl() {
		return descImgUrl;
	}

	public void setDescImgUrl(String descImgUrl) {
		this.descImgUrl = descImgUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	
}
