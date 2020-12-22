package com.mooer.manager.gtrs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author main
 * @since 2020-10-27
 */
@TableName("m_cms_content")
public class CmsContent extends Model<CmsContent> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String menuId;

    /**
     * 中文标题
     */
    private String title;

    /**
     * 中文内容
     */
    private String content;

    /**
     * 外部表id
     */
    private String foreignId;

    /**
     * 外部表名称
     */
    private String foreignName;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 排名
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 类型
     */
    private String type;

    /**
     * 跳转链接
     */
    private String link;

    /**
     * 链接中文名称
     */
    private String linkName;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 图片数组
     */
    private String imgList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getForeignId() {
        return foreignId;
    }

    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CmsContent{" +
        "id=" + id +
        ", menuId=" + menuId +
        ", title=" + title +
        ", content=" + content +
        ", foreignId=" + foreignId +
        ", foreignName=" + foreignName +
        ", imgUrl=" + imgUrl +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateTime=" + updateTime +
        ", updateBy=" + updateBy +
        ", sort=" + sort +
        ", remark=" + remark +
        ", type=" + type +
        ", link=" + link +
        ", linkName=" + linkName +
        ", isDelete=" + isDelete +
        ", imgList=" + imgList +
        "}";
    }
}
