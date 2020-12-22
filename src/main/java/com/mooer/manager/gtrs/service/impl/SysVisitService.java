package com.mooer.manager.gtrs.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.mapper.SysVisitMapper;
import com.mooer.manager.gtrs.plugin.tool.IpUtil;
import com.mooer.manager.gtrs.pojo.SysVisit;
import com.mooer.manager.gtrs.service.ISysVisitService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
@Service
public class SysVisitService extends ServiceImpl<SysVisitMapper, SysVisit> implements ISysVisitService {
	
	@Autowired
	SysVisitMapper sysVisitMapper;

	@Override
	public int sysVisitInDay() {
		return sysVisitMapper.sysVisitInDay();
	}
	
	@Override
	public int sysVisitUser(Timestamp startTime, Timestamp endTime) {
		return sysVisitMapper.sysVisitUser(startTime, endTime);
	}

	@Override
	public List<SysVisistEntity> getNumberOfDayUsers(Timestamp startTime, Timestamp endTime) {
		return sysVisitMapper.getNumberOfDayUsers(startTime, endTime);
	}

	@Override
	public void reloadIpArea() {
		
		QueryWrapper<SysVisit> wrapper = new QueryWrapper<>();
		wrapper.isNull("country");
		List<SysVisit> list = sysVisitMapper.selectList(wrapper);
		
		for(SysVisit s:list) {
			Map<String, String> area = IpUtil.getArea(IpUtil.getIpArea(s.getIp()));
			s.setCountry(area.get("country"));
			s.setRegion(area.get("region"));
			sysVisitMapper.updateById(s);
		}
		
	}

	@Override
	public List<SysVisistEntity> getNumberOfCountryUsers(Timestamp startTime, Timestamp endTime) {
		return sysVisitMapper.getNumberOfCountryUsers(startTime, endTime);
	}

	@Override
	public int sysVisitUser() {
		return sysVisitMapper.sysAllVisitUser();
	}

}
