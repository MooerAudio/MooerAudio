package com.mooer.manager.gtrs.mapper;

import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooer.manager.gtrs.pojo.ItemCat;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author main
 * @since 2020-05-20
 */
public interface ItemCatMapper extends BaseMapper<ItemCat> {
	
	
	@Update(
	 "UPDATE m_item_cat c                                          "
	+"SET c.child_sum = (                                          "
	+"	SELECT IFNULL(d.child_sum,0)                                         "
	+"	FROM (                                                     "
	+"		SELECT MIN(a.id) AS id, MIN(a.name) AS name            "
	+"			, COUNT(a.id) AS child_sum                         "
	+"		FROM m_item_cat a                                      "
	+"			LEFT JOIN m_item_cat b ON a.id = b.parent_id       "
	+"		WHERE b.id IS NOT NULL  and a.id= #{id}                "
	+"	) d                                                        "
	+"	WHERE c.id = d.id                                          "
	+")                                                            "
	+"WHERE c.id = #{id}                                           "
	)
	int resetChildSum(Long id);

}
