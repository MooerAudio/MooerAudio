package com.mooer.manager.gtrs.mapper;

import com.mooer.manager.gtrs.pojo.Country;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author main
 * @since 2022-01-11
 */
public interface CountryMapper extends BaseMapper<Country> {

    @Select("SELECT * FROM m_country WHERE continent_id = #{continentId}")
    List<Country> getCountryListByContinentId(String continentId);
}
