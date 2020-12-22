package com.mooer.manager.gtrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.spec.SpecBO;
import com.mooer.manager.gtrs.entity.spec.SpecInsert;
import com.mooer.manager.gtrs.entity.spec.SpecQuery;
import com.mooer.manager.gtrs.entity.spec.SpecUpdate;
import com.mooer.manager.gtrs.entity.spec.SpecInsert.SpecInsertInner;
import com.mooer.manager.gtrs.entity.spec.SpecInsert.SpecOptionInsertInner;
import com.mooer.manager.gtrs.entity.spec.SpecUpdate.SpecOptionUpdateInner;
import com.mooer.manager.gtrs.entity.spec.SpecUpdate.SpecUpdateInner;
import com.mooer.manager.gtrs.exception.EmptyException;
import com.mooer.manager.gtrs.mapper.SpecMapper;
import com.mooer.manager.gtrs.mapper.SpecOptionMapper;
import com.mooer.manager.gtrs.pojo.Spec;
import com.mooer.manager.gtrs.pojo.SpecOption;
import com.mooer.manager.gtrs.service.ISpecService;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author main
 * @since 2020-05-12
 */
@Service
public class SpecService extends ServiceImpl<SpecMapper, Spec> implements ISpecService {

	@Autowired
	SpecMapper specMapper;

	@Autowired
	SpecOptionMapper specOptionMapper;

	@Override
	@Transactional
	public SpecBO insert(SpecInsert specInsert) {

		if (specInsert == null) //
		{
			throw new EmptyException("SpecInsert");
		}

		SpecInsertInner specInsertInner = specInsert.getSpec();
		if (specInsertInner == null) //
		{
			throw new EmptyException("spec");
		}

		List<SpecOptionInsertInner> specOptionInsertInner = specInsert.getSpecOptions();
		if (specOptionInsertInner == null || specOptionInsertInner.isEmpty()) //
		{
			throw new EmptyException("specOptions");
		}

		String specName = specInsertInner.getSpecName().trim();
		if (StringUtils.isEmpty(specName)) //
		{
			throw new EmptyException("specName");
		}

		Spec spec = new Spec();
		spec.setSpecName(specName);

		List<SpecOption> specOptions = null;

		SpecBO data = null;

		int result1 = specMapper.insert(spec);
		int result2 = 0;
		if (result1 == 1) //
		{
			specOptions = new ArrayList<>();
			for (SpecOptionInsertInner o : specOptionInsertInner) {
				SpecOption specOption = new SpecOption();
				String optionName = o.getOptionName();
				Integer orders = o.getOrders();
				if (StringUtils.isEmpty(optionName)) //
				{
					throw new EmptyException("optionName");
				}
				if (orders == null) //
				{
					orders = 0;
				}
				specOption.setOptionName(optionName);
				specOption.setOrders(orders);
				specOption.setSpecId(spec.getId());
				result2 += specOptionMapper.insert(specOption);
				specOptions.add(specOption);
			}
		}

		if (result2 == specOptionInsertInner.size()) //
		{
			data = new SpecBO();
			data.setSpec(spec);
			data.setSpecOptions(specOptions);
		} //
		else {
			throw new RuntimeException();
		}

		return data;
	}

	@Override
	public IPage<SpecQuery> query(SpecQuery condition, Pageable pageable) {

		QueryWrapper<SpecQuery> wapper = new QueryWrapper<>();

		if (!StringUtils.isEmpty(condition.getSpecName())) //
		{
			wapper.like("UPPER(c.spec_name)", condition.getSpecName().toUpperCase());
		}

		if (!StringUtils.isEmpty(condition.getOptionNames())) //
		{
			wapper.like("UPPER(c.option_names)", condition.getOptionNames().toUpperCase());
		}

		wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

		Page<SpecQuery> page = new Page<>(pageable.getPage(), pageable.getSize());
		IPage<SpecQuery> iPage = specMapper.query(page, wapper);

		return iPage;
	}

	@Override
	public int delete(Long id) {

		int result = specMapper.deleteById(id);

		if (result == 1) //
		{
			QueryWrapper<SpecOption> wrapper = new QueryWrapper<>();
			SpecOption condition = new SpecOption();
			condition.setSpecId(id);
			wrapper.setEntity(condition);
			specOptionMapper.delete(wrapper);
		}

		return result;
	}

	@Override
	@Transactional
	public SpecQuery update(SpecUpdate record) {

		SpecQuery result = null;

		if (record != null) //
		{
			SpecUpdateInner specUpdateInner = record.getSpec();
			Spec spec = new Spec();
			Long specId = specUpdateInner.getId();
			spec.setId(specId);
			spec.setSpecName(specUpdateInner.getSpecName());
			// 如果更新成功
			if(specMapper.updateById(spec)==1) //
			{
				result = new SpecQuery();
				result.setId(specId);
				result.setSpecName(spec.getSpecName());
				List<String> optionNames = new ArrayList<>();
				
				List<SpecOptionUpdateInner> specOptionUpdateInners = record.getSpecOptions();
				for (SpecOptionUpdateInner specOptionUpdateInner : specOptionUpdateInners) {
					
					SpecOption specOption = new SpecOption();
					// 添加
					if (specOptionUpdateInner.getId() == null)//
					{
						specOption.setOptionName(specOptionUpdateInner.getOptionName());
						specOption.setOrders(specOptionUpdateInner.getOrders());
						specOption.setSpecId(specId);
						specOptionMapper.insert(specOption);
						optionNames.add(specOptionUpdateInner.getOptionName());
					}
					// 保存
					else if (specOptionUpdateInner.getSpecId() != null) //
					{
						specOption.setId(specOptionUpdateInner.getId());
						specOption.setOptionName(specOptionUpdateInner.getOptionName());
						specOption.setOrders(specOptionUpdateInner.getOrders());
						specOptionMapper.updateById(specOption);
						optionNames.add(specOptionUpdateInner.getOptionName());
					}
					// 删除
					else //
					{
						specOptionMapper.deleteById(specOptionUpdateInner.getId());
					}
				}
				result.setOptionNames(org.apache.commons.lang.StringUtils.join(optionNames, ","));
			}

		}
		return result;
	}

	@Override
	public SpecBO selectById(Long id) {

		SpecBO result = null;

		Spec spec = specMapper.selectById(id);

		if (spec != null) //
		{
			QueryWrapper<SpecOption> wrapper = new QueryWrapper<>();
			SpecOption condition = new SpecOption();
			condition.setSpecId(id);
			wrapper.setEntity(condition);
			List<SpecOption> specOptions = specOptionMapper.selectList(wrapper);

			result = new SpecBO();
			result.setSpec(spec);
			result.setSpecOptions(specOptions);
		}

		return result;
	}

	@Override
	public List<Spec> list(SpecQuery condition) {
		QueryWrapper<Spec> wrapper = new QueryWrapper<>();

		if (!StringUtils.isEmpty(condition.getSpecName())) //
		{
			wrapper.like("UPPER(c.spec_name)", condition.getSpecName().toUpperCase());
		}

		if (!StringUtils.isEmpty(condition.getOptionNames())) //
		{
			wrapper.like("UPPER(c.option_names)", condition.getOptionNames().toUpperCase());
		}


		List<Spec> list = specMapper.selectList(wrapper);

		return list;
	}

}
