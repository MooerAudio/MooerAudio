package com.mooer.manager.gtrs.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.entity.spec.SpecQuery;
import com.mooer.manager.gtrs.pojo.Spec;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author main
 * @since 2020-05-12
 */
public interface SpecMapper extends BaseMapper<Spec> {

	@Select(//
	"SELECT c.id,c.spec_name,c.option_names from ("//
			+ "select "//
			+ "a.id as id,"//
			+ "min(a.spec_name) as spec_name,"//
			+ "GROUP_CONCAT(option_name) as option_names "//
			+ "FROM m_spec a "//
			+ "left join m_spec_option b on a.id=b.spec_id "//
			+ "GROUP BY a.id) c "//
			+ "${ew.customSqlSegment}"//
	) //
	IPage<SpecQuery> query(Page<SpecQuery> page, @Param(Constants.WRAPPER) QueryWrapper<SpecQuery> wapper);

}
