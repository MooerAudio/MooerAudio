package com.mooer.manager.gtrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Country;
import com.mooer.manager.gtrs.mapper.CountryMapper;
import com.mooer.manager.gtrs.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2022-01-11
 */
@Service
public class CountryService extends ServiceImpl<CountryMapper, Country> implements ICountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> getCountryListByContinentId(String continentId) {
        return countryMapper.getCountryListByContinentId(continentId);
    }

    @Override
    public IPage<Country> query(Country condition, Pageable pageable) {
        QueryWrapper<Country> wapper = new QueryWrapper<>();
        if (condition.getContinentId()!=""){
            wapper.eq("continent_id", condition.getContinentId());
        }
        if (condition.getCountryName()!=""){
            wapper.like("country_name",condition.getCountryName());
        }

        wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), "country_name");

        Page<Country> page = new Page<>(pageable.getPage(), pageable.getSize());
        IPage<Country> iPage = countryMapper.selectPage(page, wapper);

        return iPage;
    }
}
