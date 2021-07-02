package com.mooer.manager.gtrs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
@TableName("m_provincial_city")
public class ProvincialCity extends Model<ProvincialCity> {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer id1;

    private String name;

    private String pname;

    /**
     * 简拼
     */
    private String wm;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getWm() {
        return wm;
    }

    public void setWm(String wm) {
        this.wm = wm;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ProvincialCity{" +
        "id=" + id +
        ", id1=" + id1 +
        ", name=" + name +
        ", pname=" + pname +
        ", wm=" + wm +
        "}";
    }
}
