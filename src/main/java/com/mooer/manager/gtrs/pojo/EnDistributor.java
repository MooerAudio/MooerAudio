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
@TableName("m_en_distributor")
public class EnDistributor extends Model<EnDistributor> {

    private static final long serialVersionUID=1L;

    /**
     * 经销商id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 分洲id
     */
    private String continentId;

    /**
     * 分洲名
     */
    private String continentName;

    /**
     * 具体国家区域名字
     */
    private String region;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 网址
     */
    private String website;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String email;


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

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "EnDistributor{" +
        "id=" + id +
        ", continentId=" + continentId +
        ", continentName=" + continentName +
        ", region=" + region +
        ", company=" + company +
        ", website=" + website +
        ", address=" + address +
        ", telephone=" + telephone +
        ", email=" + email +
        "}";
    }
}
