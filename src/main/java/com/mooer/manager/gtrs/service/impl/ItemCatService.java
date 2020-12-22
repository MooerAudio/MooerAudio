package com.mooer.manager.gtrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.itemcat.ItemCatInsert;
import com.mooer.manager.gtrs.entity.itemcat.ItemCatUpdate;
import com.mooer.manager.gtrs.mapper.ItemCatMapper;
import com.mooer.manager.gtrs.pojo.ItemCat;
import com.mooer.manager.gtrs.service.IItemCatService;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author main
 * @since 2020-05-20
 */
@Service
public class ItemCatService extends ServiceImpl<ItemCatMapper, ItemCat> implements IItemCatService {

	
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	@Override
	public ItemCat add(ItemCatInsert itemCat) {
		Long parentId = itemCat.getParentId();
		String ancestors = "0";
		if(parentId!=0) {
			ItemCat parent = itemCatMapper.selectById(parentId);
			ancestors = parent.getAncestors()+"," + parent.getId();
		}
		ItemCat entity = new ItemCat();
		entity.setName(itemCat.getName());
		entity.setTypeId(itemCat.getTypeId());
		entity.setParentId(parentId);
		entity.setAncestors(ancestors);
		entity.setChildSum(0);
		int result = itemCatMapper.insert(entity);
		
		if(result==1) {
			itemCatMapper.resetChildSum(itemCat.getParentId());
			return entity;
		}else {
			return null;
		}
		
	}

	@Override
	public List<ItemCat> query(ItemCat itemCat) {
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
		
		if(itemCat!=null){			
			if(!StringUtils.isEmpty(itemCat.getName())){
				queryWrapper.like("UPPER(name)", itemCat.getName().toUpperCase());
			}
			
		}
		
		ItemCat condition = new ItemCat();
		condition.setId(itemCat.getId());
		condition.setParentId(itemCat.getParentId());
		queryWrapper.setEntity(condition);
		
		return itemCatMapper.selectList(queryWrapper);
	}
	
	

	@Override
	public ItemCat update(ItemCatUpdate itemCat) {
		
		ItemCat record = itemCatMapper.selectById(itemCat.getId());
		Long oldParentId = record.getParentId();
		ItemCat entity = new ItemCat();
		entity.setName(itemCat.getName());
		entity.setTypeId(itemCat.getTypeId());
		entity.setParentId(itemCat.getParentId());
		entity.setId(itemCat.getId());
		
		int result = itemCatMapper.updateById(entity);
		
		if(result==1) {
			itemCatMapper.resetChildSum(itemCat.getParentId());
			itemCatMapper.resetChildSum(oldParentId);
			return entity;
		}else {
			return null;
		}

	}

	@Override
	public List<ItemCat> findByParentId(Long parentId) {
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("parent_id", parentId);
		return itemCatMapper.selectList(queryWrapper);
	}

	@Override
	public int resetChildSum(Long id) {
		return itemCatMapper.resetChildSum(id);
	}

}
