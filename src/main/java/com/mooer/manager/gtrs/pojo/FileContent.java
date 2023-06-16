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
 * @since 2022-07-29
 */
@TableName("m_file_content")
public class FileContent extends Model<FileContent> {

    private static final long serialVersionUID=1L;

    /**
     * 文件内容id
     */
    private Long id;

    /**
     * 文件路径
     */
    private String fileUrl;

    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 排序
     */
    private Integer orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FileContent{" +
        "id=" + id +
        ", fileUrl=" + fileUrl +
        ", fileId=" + fileId +
        ", orders=" + orders +
        "}";
    }
}
