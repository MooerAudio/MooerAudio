package com.mooer.manager.gtrs.service;

import com.mooer.manager.gtrs.entity.SysVisistEntity;
import com.mooer.manager.gtrs.pojo.SysParam;

import java.sql.Timestamp;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-08-10
 */
public interface ISysParamService extends IService<SysParam> {

	List<SysVisistEntity> getNumberOfUsersVisist(Timestamp startTime, Timestamp endTime);

}
