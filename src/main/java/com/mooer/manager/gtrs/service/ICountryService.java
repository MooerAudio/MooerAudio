package com.mooer.manager.gtrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Country;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2022-01-11
 */
public interface ICountryService extends IService<Country> {

    List<Country> getCountryListByContinentId(String continentId);

    IPage<Country> query(Country condition, Pageable pageable);
}
