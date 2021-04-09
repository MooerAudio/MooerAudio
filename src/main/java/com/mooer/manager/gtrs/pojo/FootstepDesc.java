package com.mooer.manager.gtrs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author main
 * @since 2021-04-09
 */
@TableName("m_footstep_desc")
public class FootstepDesc extends Model<FootstepDesc> {

    private static final long serialVersionUID=1L;

    /**
     * SPU_ID
     */
    private Long goodsId;

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
     * 模块
     */
    private String modular;

    /**
     * 售后服务
     */
    private String saleService;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 商品特性
     */
    private String features;

    /**
     * 连接方式
     */
    private String connections;

    /**
     * 附加说明
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

    /**
     * 规格是否横向显示
     */
    private String specificationLine;



    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public String getModular(){ return modular; }

    public void setModular(String modular) { this.modular = modular; }

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

    public String getFeatures() { return features; }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getConnections() { return connections; }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
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

    public String getAttachmentsDesc() {
        return attachmentsDesc;
    }

    public void setAttachmentsDesc(String attachmentsDesc) {
        this.attachmentsDesc = attachmentsDesc;
    }

    public String getSpecificationLine() {
        return specificationLine;
    }

    public void setSpecificationLine(String specificationLine) {
        this.specificationLine = specificationLine;
    }

    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }

    @Override
    public String toString() {
        return "GoodsDesc{" +
                "goodsId=" + goodsId +
                ", introduction=" + introduction +
                ", specificationItems=" + specificationItems +
                ", customAttributeItems=" + customAttributeItems +
                ", itemImages=" + itemImages +
                ", packageList=" + packageList +
                ", modular=" + modular +
                ", saleService=" + saleService +
                ", videoUrl=" + videoUrl +
                ", features=" + features +
                ", connections=" + connections +
                ", attachments=" + attachments +
                ", instructions=" + instructions +
                ", bannerUrl=" + bannerUrl +
                ", descImgUrl=" + descImgUrl +
                ", audioUrl=" + audioUrl +
                ", attachmentsDesc=" + attachmentsDesc +
                ", specificationLine=" + specificationLine +
                "}";
    }
}
