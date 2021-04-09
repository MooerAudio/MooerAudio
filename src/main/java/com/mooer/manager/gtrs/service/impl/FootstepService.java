package com.mooer.manager.gtrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooer.manager.gtrs.entity.footstep.FootstepInsert;
import com.mooer.manager.gtrs.entity.footstep.FootstepQuery;
import com.mooer.manager.gtrs.entity.footstep.FootstepUpdate;
import com.mooer.manager.gtrs.enums.FootstepStatus;
import com.mooer.manager.gtrs.mapper.FootstepDescMapper;
import com.mooer.manager.gtrs.plugin.IsDelete;
import com.mooer.manager.gtrs.plugin.pojo.Pageable;
import com.mooer.manager.gtrs.pojo.Footstep;
import com.mooer.manager.gtrs.mapper.FootstepMapper;
import com.mooer.manager.gtrs.pojo.FootstepDesc;
import com.mooer.manager.gtrs.service.IFootstepService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2021-04-09
 */
@Service
public class FootstepService extends ServiceImpl<FootstepMapper, Footstep> implements IFootstepService {
    @Autowired
    FootstepMapper footstepMapper;

    @Autowired
    FootstepDescMapper footstepDescMapper;

    @Override
    @Transactional
    public Footstep add(FootstepInsert footstep) {
        // 商品基本信息
        Footstep entity = new Footstep();
        entity.setStatus(FootstepStatus.HIDE.getCode());
        entity.setCaption(footstep.getCaption());
        entity.setCategory1Id(footstep.getCategory1Id());
        entity.setCategory2Id(footstep.getCategory2Id());
        entity.setCategory3Id(footstep.getCategory3Id());
        entity.setDefaultItemId(footstep.getDefaultItemId());
        entity.setGoodsName(footstep.getGoodsName());
        entity.setIsDelete(IsDelete.NO.getCode());
//		entity.setIsEnableSpec(footstep.getIsEnableSpec());
//		entity.setIsMarketable(footstep.getis);
        entity.setLargePic(footstep.getLargePic());
        entity.setPrice(footstep.getPrice());
        entity.setSmallPic(footstep.getSmallPic());
        entity.setTypeTemplates(footstep.getTypeTemplates());
        entity.setTypeTemplateId(footstep.getTypeTemplateId());
        entity.setBuyUrl(footstep.getBuyUrl());
        entity.setDescription(footstep.getDescription());
        int result = footstepMapper.insert(entity);

        if (result > 0) {
            // 商品详情信息
            FootstepDesc desc = new FootstepDesc();
            desc.setGoodsId(entity.getId());
            desc.setCustomAttributeItems(footstep.getCustomAttributeItems());
            desc.setIntroduction(footstep.getIntroduction());
            desc.setItemImages(footstep.getItemImages());
            desc.setPackageList(footstep.getPackageList());
            desc.setModular(footstep.getModular());
            desc.setSaleService(footstep.getSaleService());
            desc.setSpecificationItems(footstep.getSpecificationItems());
            desc.setVideoUrl(footstep.getVideoUrl());
            desc.setFeatures(footstep.getFeatures());
            desc.setConnections(footstep.getConnections());
            desc.setAttachments(footstep.getAttachments());
            desc.setInstructions(footstep.getInstructions());
            desc.setBannerUrl(footstep.getBannerUrl());
            desc.setDescImgUrl(footstep.getDescImgUrl());
            desc.setAudioUrl(footstep.getAudioUrl());
            desc.setAttachmentsDesc(footstep.getAttachmentsDesc());
            desc.setSpecificationLine(footstep.getSpecificationLine());
            footstepDescMapper.insert(desc);
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public IPage<FootstepQuery> query(FootstepQuery condition, Pageable pageable) {

        QueryWrapper<FootstepQuery> wapper = new QueryWrapper<>();

        wapper.eq("a.is_delete", IsDelete.NO.getCode());

        wapper.orderBy(true, (pageable.getOrder().equals("asc") ? true : false), pageable.getSort());

        Page<FootstepQuery> page = new Page<>(pageable.getPage(), pageable.getSize());
        IPage<FootstepQuery> iPage = footstepMapper.query(page, wapper);

        return iPage;
    }

    @Override
    public int delete(Long id) {
        // 删除
        Footstep entity = new Footstep();
        entity.setId(id);
        entity.setIsDelete(IsDelete.YES.getCode());
        return footstepMapper.updateById(entity);
    }

    @Override
    public FootstepQuery info(Long id) {
        return footstepMapper.info(id);
    }

    public int update(FootstepUpdate goods) {
        // 商品基本信息
        Footstep entity = new Footstep();
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
        entity.setTypeTemplates(goods.getTypeTemplates());
        entity.setTypeTemplateId(goods.getTypeTemplateId());
        entity.setBuyUrl(goods.getBuyUrl());
        entity.setDescription(goods.getDescription());
        int result = footstepMapper.updateById(entity);

        if (result > 0) {
            // 商品详情信息
            FootstepDesc desc = new FootstepDesc();
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

            QueryWrapper<FootstepDesc> condition = new QueryWrapper<>();
            condition.eq("goods_id", entity.getId());
            return footstepDescMapper.update(desc, condition);
        } else {
            return 0;
        }
    }

    @Override
    public int show(Long id) {
        Footstep goods = new Footstep();
        goods.setId(id);
        goods.setStatus(FootstepStatus.SHOW.getCode());
        return footstepMapper.updateById(goods);
    }

    @Override
    public int hide(Long id) {
        Footstep goods = new Footstep();
        goods.setId(id);
        goods.setStatus(FootstepStatus.HIDE.getCode());
        return footstepMapper.updateById(goods);
    }

}
