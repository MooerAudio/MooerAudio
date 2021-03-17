package com.mooer.manager.gtrs.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.entity.goods.GoodsQuery;
import com.mooer.manager.gtrs.pojo.Goods;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author main
 * @since 2020-05-25
 */
public interface GoodsMapper extends BaseMapper<Goods> {

	@Select(//
	"SELECT "//
			+ "a.id,                      "//
			+ "a.goods_name,              "//
			+ "a.default_item_id,         "//
			+ "a.status,                  "//
			+ "a.is_marketable,           "//
			+ "a.caption,                 "//
			+ "a.category1_id,            "//
			+ "a.category2_id,            "//
			+ "a.category3_id,            "//
			+ "a.small_pic,               "//
			+ "a.price,                   "//
			+ "a.type_templates,          "//
			+ "a.type_template_id,        "//
			+ "a.is_enable_spec,          "//
			+ "a.is_delete,               "//
			+ "a.large_pic,               "//
			+ "a.buy_url,                 "// 
			+ "a.description,             "//
			+ "b.introduction,            "//
			+ "b.specification_items,     "//
			+ "b.custom_attribute_items,  "//
			+ "b.item_images,             "//
			+ "b.package_list,            "//
			+ "b.modular,				  "//
			+ "b.sale_service,            "//
			+ "b.video_url,               "//
			+ "b.features,                "//
			+ "b.connections,             "//
			+ "b.instructions,            "//
			+ "b.banner_url,              "//
			+ "b.desc_img_url,            "//
			+ "b.audio_url,               "//
			+ "b.attachments_desc,               "//
			+ "b.specification_line,               "//
			+ "b.attachments              "//
			+ "from m_goods a             "//
			+ "left join m_goods_desc b   "//
			+ "on a.id = b.goods_id       "//
			+ " ${ew.customSqlSegment}"//
	) //
	IPage<GoodsQuery> query(Page<GoodsQuery> page, @Param(Constants.WRAPPER) QueryWrapper<GoodsQuery> wapper);

	@Select(//
			"SELECT "//
					+ "a.id,                      "//
					+ "a.goods_name,              "//
					+ "a.default_item_id,         "//
					+ "a.status,                  "//
					+ "a.is_marketable,           "//
					+ "a.caption,                 "//
					+ "a.category1_id,            "//
					+ "a.category2_id,            "//
					+ "a.category3_id,            "//
					+ "a.small_pic,               "//
					+ "a.price,                   "//
					+ "a.type_templates,          "//
					+ "a.type_template_id,        "//
					+ "a.is_enable_spec,          "//
					+ "a.is_delete,               "//
					+ "a.large_pic,               "//
					+ "a.description,             "//
					+ "a.buy_url,                 "//
					+ "b.introduction,            "//
					+ "b.specification_items,     "//
					+ "b.custom_attribute_items,  "//
					+ "b.item_images,             "//
					+ "b.package_list,            "//
					+ "b.modular,				  "//
					+ "b.sale_service,            "//
					+ "b.video_url,               "//
					+ "b.features,                "//
					+ "b.connections,             "//
					+ "b.instructions,            "//
					+ "b.banner_url,              "//
					+ "b.desc_img_url,            "//
					+ "b.audio_url,               "//
					+ "b.attachments_desc,               "//
					+ "b.specification_line,               "//
					+ "b.attachments              "//
					+ "from m_goods a             "//
					+ "left join m_goods_desc b   "//
					+ "on a.id = b.goods_id       "//
					+ "where a.id=#{id}"//
			) //
	GoodsQuery info(Long id);

}
