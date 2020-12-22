package com.mooer.manager.gtrs.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.entity.spec.SpecBO;
import com.mooer.manager.gtrs.entity.spec.SpecInsert;
import com.mooer.manager.gtrs.entity.spec.SpecQuery;
import com.mooer.manager.gtrs.entity.spec.SpecUpdate;
import com.mooer.manager.gtrs.pojo.Spec;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-05-12
 */
public interface ISpecService extends IService<Spec> {
	
	
	SpecBO insert(SpecInsert record);

	IPage<SpecQuery> query(SpecQuery condition, Pageable pageable);
	
	int delete(Long id);
	
	SpecQuery update(SpecUpdate record);
	
	SpecBO selectById(Long id);

	List<Spec> list(SpecQuery condition);

}
