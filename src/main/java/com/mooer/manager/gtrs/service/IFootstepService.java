package com.mooer.manager.gtrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooer.manager.gtrs.entity.footstep.FootstepInsert;
import com.mooer.manager.gtrs.entity.footstep.FootstepQuery;
import com.mooer.manager.gtrs.entity.goods.GoodsInsert;
import com.mooer.manager.gtrs.entity.goods.GoodsQuery;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Footstep;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.pojo.Goods;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2021-04-09
 */
public interface IFootstepService extends IService<Footstep> {

    Footstep add(FootstepInsert goods);

    IPage<FootstepQuery> query(FootstepQuery condition, Pageable pageable);

    int delete(Long id);

    FootstepQuery info(Long id);

    int show(Long id);

    int hide(Long id);
}
