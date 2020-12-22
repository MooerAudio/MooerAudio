package com.mooer.manager.gtrs.service;

import java.sql.Timestamp;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.pojo.SysVisit;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
public interface ISysVisitService extends IService<SysVisit> {
	
	void reloadIpArea();
	
	int sysVisitInDay();
	
	List<SysVisistEntity> getNumberOfDayUsers(Timestamp startTime, Timestamp endTime);
	
	List<SysVisistEntity> getNumberOfCountryUsers(Timestamp startTime, Timestamp endTime);

	int sysVisitUser(Timestamp startTime, Timestamp endTime);

	int sysVisitUser();

}
