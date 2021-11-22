package com.mooer.manager.gtrs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author main
 * @since 2021-11-22
 */
@TableName("m_continent")
public class Continent extends Model<Continent> {

    private static final long serialVersionUID=1L;

    /**
     * 分洲id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 洲名
     */
    private String continentName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Continent{" +
        "id=" + id +
        ", continentName=" + continentName +
        "}";
    }
}
