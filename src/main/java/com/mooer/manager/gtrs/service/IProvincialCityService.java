package com.mooer.manager.gtrs.service;

import com.mooer.manager.gtrs.pojo.ProvincialCity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
public interface IProvincialCityService extends IService<ProvincialCity> {

    List<ProvincialCity> selectList();

    List<ProvincialCity> selectProvincial();

    List<ProvincialCity> selectCityByProvincial(String pname);

}
