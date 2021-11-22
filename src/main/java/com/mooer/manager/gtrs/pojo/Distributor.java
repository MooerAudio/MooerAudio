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
 * @since 2021-07-01
 */
@TableName("m_distributor")
public class Distributor extends Model<Distributor> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 经销商
     */
    private String distributor;

    /**
     * 省份
     */
    private String provincial;

    /**
     * 城市
     */
    private String city;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Distributor{" +
        "id=" + id +
        ", distributor=" + distributor +
        ", provincial=" + provincial +
        ", city=" + city +
        "}";
    }
}
