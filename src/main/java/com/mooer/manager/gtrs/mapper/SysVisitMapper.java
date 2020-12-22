package com.mooer.manager.gtrs.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.pojo.SysVisit;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
public interface SysVisitMapper extends BaseMapper<SysVisit> {
	
	
	@Select("select count(1)  from ( SELECT 1 FROM `m_sys_visit` where CONVERT (create_time, date)=CONVERT (NOW(), date) group by ip) a ")
	int sysVisitInDay();

	@Select("select count(1) as num,b.date from  (select a.ip,a.date from (SELECT ip,CONVERT (create_time, date) as date FROM `m_sys_visit` where create_time>=#{startTime} and create_time<=#{endTime}) a group by ip,date) b group by b.date")
	List<SysVisistEntity> getNumberOfDayUsers(@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

	@Select("select count(1) as num,b.country as flied from  (SELECT ip,country FROM `m_sys_visit` where create_time>=#{startTime} and create_time<=#{endTime} group by ip,country) b group by b.country order by num desc")
	List<SysVisistEntity> getNumberOfCountryUsers(@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

	@Select("select count(1)  from ( SELECT 1 FROM `m_sys_visit` where create_time>=#{startTime} and create_time<=#{endTime} group by ip) a ")
	int sysVisitUser(@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);
	
	@Select("select count(1)  from ( SELECT 1 FROM `m_sys_visit` group by ip) a ")
	int sysAllVisitUser();
}
