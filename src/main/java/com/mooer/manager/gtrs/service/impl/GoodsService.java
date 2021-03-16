package com.mooer.manager.gtrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.entity.goods.GoodsInsert;
import com.mooer.manager.gtrs.entity.goods.GoodsQuery;
import com.mooer.manager.gtrs.entity.goods.GoodsUpdate;
import com.mooer.manager.gtrs.enums.GoodsStatus;
import com.mooer.manager.gtrs.mapper.GoodsDescMapper;
import com.mooer.manager.gtrs.mapper.GoodsMapper;
import com.mooer.manager.gtrs.plugin.IsDelete;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Goods;
import com.mooer.manager.gtrs.pojo.GoodsDesc;
import com.mooer.manager.gtrs.service.IGoodsService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author main
 * @since 2020-05-25
 */
@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

	@Autowired
	GoodsMapper goodsMapper;

	@Autowired
	GoodsDescMapper goodsDescMapper;

	@Override
	@Transactional
	public Goods add(GoodsInsert goods) {
		// 商品基本信息
		Goods entity = new Goods();
		entity.setStatus(GoodsStatus.HIDE.getCode());
		entity.setCaption(goods.getCaption());
		entity.setCategory1Id(goods.getCategory1Id());
		entity.setCategory2Id(goods.getCategory2Id());
		entity.setCategory3Id(goods.getCategory3Id());
		entity.setDefaultItemId(goods.getDefaultItemId());
		entity.setGoodsName(goods.getGoodsName());
		entity.setIsDelete(IsDelete.NO.getCode());
//		entity.setIsEnableSpec(goods.getIsEnableSpec());
//		entity.setIsMarketable(goods.getis);
		entity.setLargePic(goods.getLargePic());
		entity.setPrice(goods.getPrice());
		entity.setSmallPic(goods.getSmallPic());
		entity.setTypeTemplateId(goods.getTypeTemplateId());
		entity.setBuyUrl(goods.getBuyUrl());
		entity.setDescription(goods.getDescription());
		int result = goodsMapper.insert(entity);

		if (result > 0) {
			// 商品详情信息
			GoodsDesc desc = new GoodsDesc();
			desc.setGoodsId(entity.getId());
			desc.setCustomAttributeItems(goods.getCustomAttributeItems());
			desc.setIntroduction(goods.getIntroduction());
			desc.setItemImages(goods.getItemImages());
			desc.setPackageList(goods.getPackageList());
			desc.setModular(goods.getModular());
			desc.setSaleService(goods.getSaleService());
			desc.setSpecificationItems(goods.getSpecificationItems());
			desc.setVideoUrl(goods.getVideoUrl());
			desc.setFeatures(goods.getFeatures());
			desc.setConnections(goods.getConnections());
			desc.setAttachments(goods.getAttachments());
			desc.setInstructions(goods.getInstructions());
			desc.setBannerUrl(goods.getBannerUrl());
			desc.setDescImgUrl(goods.getDescImgUrl());
			desc.setAudioUrl(goods.getAudioUrl());
			desc.setAttachmentsDesc(goods.getAttachmentsDesc());
			desc.setSpecificationLine(goods.getSpecificationLine());
			goodsDescMapper.insert(desc);
			return entity;
		} else {
			return null;
		}
	}

	@Override
	public IPage<GoodsQuery> query(GoodsQuery condition, Pageable pageable) {

		QueryWrapper<GoodsQuery> wapper = new QueryWrapper<>();

		wapper.eq("a.is_delete", IsDelete.NO.getCode());

		wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

		Page<GoodsQuery> page = new Page<>(pageable.getPage(), pageable.getSize());
		IPage<GoodsQuery> iPage = goodsMapper.query(page, wapper);

		return iPage;
	}

	@Override
	public int delete(Long id) {
		// 删除
		Goods entity = new Goods();
		entity.setId(id);
		entity.setIsDelete(IsDelete.YES.getCode());
		return goodsMapper.updateById(entity);
	}

	@Override
	public GoodsQuery info(Long id) {
		return goodsMapper.info(id);
	}

	public int update(GoodsUpdate goods) {
		// 商品基本信息
		Goods entity = new Goods();
		entity.setId(goods.getId());
//		entity.setStatus(GoodsStatus.NEW.getCode());
		Long category1Id = goods.getCategory1Id()==null?0:goods.getCategory1Id();
		Long category2Id = goods.getCategory2Id()==null?0:goods.getCategory2Id();
		Long category3Id = goods.getCategory3Id()==null?0:goods.getCategory3Id();
		
		entity.setCategory1Id(category1Id);
		entity.setCategory2Id(category2Id);
		entity.setCategory3Id(category3Id);
		entity.setCaption(goods.getCaption());
		entity.setDefaultItemId(goods.getDefaultItemId());
		entity.setGoodsName(goods.getGoodsName());
//		entity.setIsDelete(IsDelete.NO.getCode());
//				entity.setIsEnableSpec(goods.getIsEnableSpec());
//				entity.setIsMarketable(goods.getis);
		entity.setLargePic(goods.getLargePic());
		entity.setPrice(goods.getPrice());
		entity.setSmallPic(goods.getSmallPic());
		entity.setTypeTemplateId(goods.getTypeTemplateId());
		entity.setBuyUrl(goods.getBuyUrl());
		entity.setDescription(goods.getDescription());
		int result = goodsMapper.updateById(entity);

		if (result > 0) {
			// 商品详情信息
			GoodsDesc desc = new GoodsDesc();
//			desc.setGoodsId(entity.getId());
			desc.setCustomAttributeItems(goods.getCustomAttributeItems());
			desc.setIntroduction(goods.getIntroduction());
			desc.setItemImages(goods.getItemImages());
			desc.setPackageList(goods.getPackageList());
			desc.setModular(goods.getModular());
			desc.setSaleService(goods.getSaleService());
			desc.setSpecificationItems(goods.getSpecificationItems());
			desc.setVideoUrl(goods.getVideoUrl());
			desc.setFeatures(goods.getFeatures());
			desc.setConnections(goods.getConnections());
			desc.setAttachments(goods.getAttachments());
			desc.setInstructions(goods.getInstructions());
			desc.setBannerUrl(goods.getBannerUrl());
			desc.setDescImgUrl(goods.getDescImgUrl());
			desc.setAudioUrl(goods.getAudioUrl());
			desc.setAttachmentsDesc(goods.getAttachmentsDesc());
			desc.setSpecificationLine(goods.getSpecificationLine());
			
			QueryWrapper<GoodsDesc> condition = new QueryWrapper<>();
			condition.eq("goods_id", entity.getId());
			return goodsDescMapper.update(desc, condition);
		} else {
			return 0;
		}
	}

	@Override
	public int show(Long id) {
		Goods goods = new Goods();
		goods.setId(id);
		goods.setStatus(GoodsStatus.SHOW.getCode());
		return goodsMapper.updateById(goods);
	}

	@Override
	public int hide(Long id) {
		Goods goods = new Goods();
		goods.setId(id);
		goods.setStatus(GoodsStatus.HIDE.getCode());
		return goodsMapper.updateById(goods);
	}

}
