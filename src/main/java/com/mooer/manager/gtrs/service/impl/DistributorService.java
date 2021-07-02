package com.mooer.manager.gtrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Distributor;
import com.mooer.manager.gtrs.mapper.DistributorMapper;
import com.mooer.manager.gtrs.pojo.TypeTemplate;
import com.mooer.manager.gtrs.service.IDistributorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2021-07-01
 */
@Service
public class DistributorService extends ServiceImpl<DistributorMapper, Distributor> implements IDistributorService {

    @Autowired
    DistributorMapper distributorMapper;

    @Override
    public IPage<Distributor> query(Distributor condition, Pageable pageable) {
        QueryWrapper<Distributor> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(condition.getDistributor())) //
        {
            wrapper.like("UPPER(distributor)", condition.getDistributor().toUpperCase());
        }

        if (!StringUtils.isEmpty(condition.getProvincial())) //
        {
            wrapper.eq("provincial", condition.getProvincial());
        }

        if (!StringUtils.isEmpty(condition.getCity())) //
        {
            wrapper.eq("city", condition.getCity());
        }

        wrapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

        Page<Distributor> page = new Page<>(pageable.getPage(), pageable.getSize());
        IPage<Distributor> iPage = distributorMapper.selectPage(page, wrapper);

        return iPage;
    }
}
