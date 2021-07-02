package com.mooer.manager.gtrs.mapper;

import com.mooer.manager.gtrs.pojo.ProvincialCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
public interface ProvincialCityMapper extends BaseMapper<ProvincialCity> {

    @Select("SELECT * FROM m_provincial_city")
    List<ProvincialCity> selectList1();

    @Select("SELECT pname FROM m_provincial_city GROUP BY pname")
    List<ProvincialCity> selectProvincial();

    @Select("SELECT name FROM m_provincial_city WHERE pname=#{pname}")
    List<ProvincialCity> selectCityByProvincial(String pname);
}
