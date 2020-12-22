package com.mooer.manager.gtrs.service;

import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Contact;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-08-13
 */
public interface IContactService extends IService<Contact> {

	IPage<Contact> query(Contact condition, Pageable pageable);

	int deal(Long id);

}
