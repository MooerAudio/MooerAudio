package com.mooer.manager.gtrs.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.pojo.SysParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
public interface SysParamMapper extends BaseMapper<SysParam> {
	
	@Select("select count(ip) as num,date from (SELECT ip,CONVERT ( create_time, date ) AS 'date' FROM `m_sys_visit` where create_time>=#{startTime} and create_time<=#{endTime}) a group by date")
	List<SysVisistEntity> getNumberOfUsersVisist(@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

}
