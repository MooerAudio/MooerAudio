package com.mooer.manager.gtrs.service;

import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateInsert;
import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateQuery;
import com.mooer.manager.gtrs.entity.typetemplate.TypeTemplateUpdate;
import com.mooer.manager.gtrs.pojo.TypeTemplate;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-05-14
 */
public interface ITypeTemplateService extends IService<TypeTemplate> {

	TypeTemplate insert(TypeTemplateInsert record);

	IPage<TypeTemplate> query(TypeTemplateQuery condition, Pageable pageable);

	TypeTemplate update(TypeTemplateUpdate record);

}
