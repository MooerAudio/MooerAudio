package com.mooer.manager.gtrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.EnDistributor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2021-11-22
 */
public interface IEnDistributorService extends IService<EnDistributor> {

    IPage<EnDistributor> query(EnDistributor condition, Pageable pageable);
}
