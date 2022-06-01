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
 * @since 2022-01-11
 */
@TableName("m_country")
public class Country extends Model<Country> {

    private static final long serialVersionUID=1L;

    /**
     * 国家ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 分洲ID
     */
    private String continentId;

    /**
     * 国家名称
     */
    private String countryName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContinentId() {
        return continentId;
    }

    public void setContinentId(String continentId) {
        this.continentId = continentId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Country{" +
        "id=" + id +
        ", continentId=" + continentId +
        ", countryName=" + countryName +
        "}";
    }
}
