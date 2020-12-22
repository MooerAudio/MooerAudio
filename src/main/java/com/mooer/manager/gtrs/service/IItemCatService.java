package com.mooer.manager.gtrs.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.entity.itemcat.ItemCatInsert;
import com.mooer.manager.gtrs.entity.itemcat.ItemCatUpdate;
import com.mooer.manager.gtrs.pojo.ItemCat;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author main
 * @since 2020-05-20
 */
public interface IItemCatService extends IService<ItemCat> {

	public ItemCat add(ItemCatInsert itemCat);
	
	public List<ItemCat> query(ItemCat itemCat);
	
	public ItemCat update(ItemCatUpdate itemCat);
	
	List<ItemCat> findByParentId(Long parentId);
	
	int resetChildSum(Long id);
	
}
