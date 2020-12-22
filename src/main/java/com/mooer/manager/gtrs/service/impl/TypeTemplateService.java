package com.mooer.manager.gtrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateInsert;
import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateQuery;
import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateUpdate;
import com.mooer.manager.gtrs.mapper.TypeTemplateMapper;
import com.mooer.manager.gtrs.pojo.TypeTemplate;
import com.mooer.manager.gtrs.service.ITypeTemplateService;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2020-05-14
 */
@Service
public class TypeTemplateService extends ServiceImpl<TypeTemplateMapper, TypeTemplate> implements ITypeTemplateService {

	@Autowired
	TypeTemplateMapper typeTemplateMapper;
	
	@Override
	public TypeTemplate insert(TypeTemplateInsert record) {
		
		TypeTemplate entity = new TypeTemplate();
		
		entity.setCustomAttributeItems(record.getCustomAttributeItems());
		entity.setName(record.getName());
		entity.setSpecIds(record.getSpecIds());
		
		int result = typeTemplateMapper.insert(entity);
		
		if(result==1) {
			return entity;
		}else {
			return null;
		}
		
	}

	@Override
	public IPage<TypeTemplate> query(TypeTemplateQuery condition, Pageable pageable) {
		
		QueryWrapper<TypeTemplate> wrapper = new QueryWrapper<>();

		if (!StringUtils.isEmpty(condition.getId())) //
		{
			wrapper.eq("id", condition.getId());
		}
		
		if (!StringUtils.isEmpty(condition.getName())) //
		{
			wrapper.like("UPPER(name)", condition.getName().toUpperCase());
		}

		wrapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

		Page<TypeTemplate> page = new Page<>(pageable.getPage(), pageable.getSize());
		IPage<TypeTemplate> iPage = typeTemplateMapper.selectPage(page, wrapper);

		return iPage;
	}

	@Override
	public TypeTemplate update(TypeTemplateUpdate record) {
		
		TypeTemplate entity = new TypeTemplate();
		
		entity.setId(record.getId());
		entity.setCustomAttributeItems(record.getCustomAttributeItems());
		entity.setName(record.getName());
		entity.setSpecIds(record.getSpecIds());
		
		int result = typeTemplateMapper.updateById(entity);
		
		if(result==1) {
			return entity;
		}else {
			return null;
		}
	}

}
