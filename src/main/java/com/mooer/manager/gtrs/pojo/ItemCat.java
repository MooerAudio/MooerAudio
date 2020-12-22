package com.mooer.manager.gtrs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author main
 * @since 2020-07-28
 */
@TableName("m_item_cat")
public class ItemCat extends Model<ItemCat> {

    private static final long serialVersionUID=1L;

    /**
     * 类目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型id
     */
    private Long typeId;

    /**
     * 子个数
     */
    private Integer childSum;

    /**
     * 历代
     */
    private String ancestors;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getChildSum() {
        return childSum;
    }

    public void setChildSum(Integer childSum) {
        this.childSum = childSum;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ItemCat{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", name=" + name +
        ", typeId=" + typeId +
        ", childSum=" + childSum +
        ", ancestors=" + ancestors +
        "}";
    }
}
