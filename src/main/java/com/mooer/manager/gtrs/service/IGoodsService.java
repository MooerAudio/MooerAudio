package com.mooer.manager.gtrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.entity.goods.GoodsInsert;
import com.mooer.manager.gtrs.entity.goods.GoodsQuery;
import com.mooer.manager.gtrs.pojo.Goods;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-05-25
 */
public interface IGoodsService extends IService<Goods> {
	
	Goods add(GoodsInsert goods);

	IPage<GoodsQuery> query(GoodsQuery condition, Pageable pageable);
	
	int delete(Long id);

	GoodsQuery info(Long id);

	int show(Long id);

	int hide(Long id);

}
