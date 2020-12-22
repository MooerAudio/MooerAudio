package com.mooer.manager.gtrs.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.mapper.SysParamMapper;
import com.mooer.manager.gtrs.pojo.SysParam;
import com.mooer.manager.gtrs.service.ISysParamService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
@Service
public class SysParamService extends ServiceImpl<SysParamMapper, SysParam> implements ISysParamService {

	@Autowired
	SysParamMapper sysParamMapper;
	
	@Override
	public List<SysVisistEntity> getNumberOfUsersVisist(Timestamp startTime, Timestamp endTime) {
		
		
		List<SysVisistEntity> result = sysParamMapper.getNumberOfUsersVisist(startTime,endTime);
		
		
		return result;
	}

}
