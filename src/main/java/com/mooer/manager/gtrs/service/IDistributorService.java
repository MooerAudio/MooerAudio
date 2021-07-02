package com.mooer.manager.gtrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Distributor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
public interface IDistributorService extends IService<Distributor> {

    IPage<Distributor> query(Distributor condition, Pageable pageable);
}
