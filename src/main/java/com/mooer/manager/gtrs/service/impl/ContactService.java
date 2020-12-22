package com.mooer.manager.gtrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.enums.ContactStatus;
import com.mooer.manager.gtrs.mapper.ContactMapper;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Contact;
import com.mooer.manager.gtrs.service.IContactService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2020-08-13
 */
@Service
public class ContactService extends ServiceImpl<ContactMapper, Contact> implements IContactService {

	@Autowired
	ContactMapper contactMapper;
	
	@Override
	public IPage<Contact> query(Contact condition, Pageable pageable) {
		QueryWrapper<Contact> wapper = new QueryWrapper<>();

		if (!StringUtils.isEmpty(condition.getStatus())) //
		{
			wapper.eq("status", condition.getStatus());
		}

		wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

		Page<Contact> page = new Page<>(pageable.getPage(), pageable.getSize());
		IPage<Contact> iPage = contactMapper.selectPage(page, wapper);

		return iPage;
	}

	@Override
	public int deal(Long id) {
		
		Contact entity = new Contact();
		entity.setId(id);
		entity.setStatus(ContactStatus.DEAL.getCode());
		
		return contactMapper.updateById(entity);
	}
	
	
	

}
