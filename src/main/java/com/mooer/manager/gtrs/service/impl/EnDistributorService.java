package com.mooer.manager.gtrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.EnDistributor;
import com.mooer.manager.gtrs.mapper.EnDistributorMapper;
import com.mooer.manager.gtrs.service.IEnDistributorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2021-11-22
 */
@Service
public class EnDistributorService extends ServiceImpl<EnDistributorMapper, EnDistributor> implements IEnDistributorService {

    @Autowired
    private EnDistributorMapper distributorMapper;

    @Override
    public IPage<EnDistributor> query(EnDistributor condition, Pageable pageable) {
        QueryWrapper<EnDistributor> wapper = new QueryWrapper<>();
        if (condition.getContinentId()!=""){
            wapper.eq("continent_id", condition.getContinentId());
        }
        if (condition.getCompany()!=""){
            wapper.like("company",condition.getCompany());
        }

        wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

        Page<EnDistributor> page = new Page<>(pageable.getPage(), pageable.getSize());
        IPage<EnDistributor> iPage = distributorMapper.selectPage(page, wapper);

        return iPage;
    }
}
