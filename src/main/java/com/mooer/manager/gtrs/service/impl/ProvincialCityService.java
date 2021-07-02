package com.mooer.manager.gtrs.service.impl;

import com.mooer.manager.gtrs.pojo.ProvincialCity;
import com.mooer.manager.gtrs.mapper.ProvincialCityMapper;
import com.mooer.manager.gtrs.service.IProvincialCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
@Service
public class ProvincialCityService extends ServiceImpl<ProvincialCityMapper, ProvincialCity> implements IProvincialCityService {

    @Autowired
    ProvincialCityMapper provincialCityMapper;

    @Override
    public List<ProvincialCity> selectList() {
        return provincialCityMapper.selectList1();
    }

    @Override
    public List<ProvincialCity> selectProvincial() {
        return provincialCityMapper.selectProvincial();
    }

    @Override
    public List<ProvincialCity> selectCityByProvincial(String pname) {
        return provincialCityMapper.selectCityByProvincial(pname);
    }
}
