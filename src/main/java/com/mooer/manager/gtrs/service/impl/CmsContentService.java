package com.mooer.manager.gtrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooer.manager.gtrs.enums.CmsContentStatus;
import com.mooer.manager.gtrs.enums.CmsContentType;
import com.mooer.manager.gtrs.mapper.CmsContentMapper;
import com.mooer.manager.gtrs.plugin.IsDelete;
import com.mooer.manager.gtrs.plugin.tool.DateUtil;
import com.mooer.manager.gtrs.pojo.CmsContent;
import com.mooer.manager.gtrs.service.ICmsContentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2020-04-29
 */
@Service
public class CmsContentService extends ServiceImpl<CmsContentMapper, CmsContent> implements ICmsContentService {
	
	@Autowired
	CmsContentMapper cmsContentMapper;
	
	private List<CmsContent> query(CmsContent record,String type) {
		if(record==null) {
			record = new CmsContent();
		}
		QueryWrapper<CmsContent> queryWrapper = new QueryWrapper<>();
		record.setType(type);
		queryWrapper.setEntity(record);
		queryWrapper.ne("is_delete", IsDelete.YES.getCode());
		queryWrapper.orderByAsc("sort");
		return cmsContentMapper.selectList(queryWrapper);
	}
	
	private CmsContent create(CmsContent content,String type) {
		int result = 0;
		if(content!=null) {
			content.setCreateTime(DateUtil.now());
			content.setIsDelete("0");
			content.setStatus(CmsContentStatus.HIDE.getCode());
			content.setType(type);
			result = cmsContentMapper.insert(content);
		}
		if(result==1) {
			return content;
		}else {
			return null;
		}
	}

	@Override
	public CmsContent update(CmsContent record) {
		int result = cmsContentMapper.updateById(record);
		if(result==1) {
			return record;
		}else {
			return null;
		}
	}

	@Override
	public int delete(Long id) {
		CmsContent record = new CmsContent();
		record.setId(id);
		record.setIsDelete(IsDelete.YES.getCode());
		return cmsContentMapper.updateById(record);
	}

	@Override
	public int hideCmsContent(Long id) {
		CmsContent record = new CmsContent();
		record.setId(id);
		record.setStatus(CmsContentStatus.HIDE.getCode());
		return cmsContentMapper.updateById(record);
	}

	@Override
	public int showCmsContent(Long id) {
		CmsContent record = new CmsContent();
		record.setId(id);
		record.setStatus(CmsContentStatus.SHOW.getCode());
		return cmsContentMapper.updateById(record);
	}
	
	@Override
	public List<CmsContent> queryHomeProduct(CmsContent record) {
		return this.query(record, CmsContentType.HOME_PRODUCT.getCode());
	}
	
	@Override
	public CmsContent createHomeProduct(CmsContent content) {
		return this.create(content, CmsContentType.HOME_PRODUCT.getCode());
	}

	@Override
	public List<CmsContent> queryHomeBanner(CmsContent record) {
		return this.query(record, CmsContentType.HOME_BANNER.getCode());
	}

	@Override
	public CmsContent createHomeBanner(CmsContent content) {
		return this.create(content, CmsContentType.HOME_BANNER.getCode());
	}

	@Override
	public CmsContent createHomeGoods(CmsContent content) {
		return this.create(content, CmsContentType.HOME_GOODS.getCode());
	}

	@Override
	public List<CmsContent> queryHomeGoods(CmsContent record) {
		return this.query(record, CmsContentType.HOME_GOODS.getCode());
	}

	@Override
	public CmsContent createHomeCategory(CmsContent content) {
		return this.create(content, CmsContentType.HOME_CATEGORY.getCode());
	}

	@Override
	public List<CmsContent> queryHomeCategory(CmsContent record) {
		return this.query(record, CmsContentType.HOME_CATEGORY.getCode());
	}

	@Override
	public CmsContent createShopBanner(CmsContent content) {
		return this.create(content, CmsContentType.SHOP_BANNER.getCode());
	}

	@Override
	public List<CmsContent> queryShopBanner(CmsContent record) {
		return this.query(record, CmsContentType.SHOP_BANNER.getCode());
	}

	@Override
	public CmsContent createHomeProductMore(CmsContent record) {
		return this.create(record, CmsContentType.HOME_PRODUCT_MORE.getCode());
	}

	@Override
	public CmsContent queryHomeProductMore() {
		
		List<CmsContent> result = this.query(null, CmsContentType.HOME_PRODUCT_MORE.getCode());
		if(result!=null&&result.size()>0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public CmsContent createSupportNews(CmsContent record) {
		return this.create(record, CmsContentType.SUPPORT_NEWS.getCode());
	}
	
	@Override
	public List<CmsContent> querySupportNews(CmsContent record) {
		return this.query(record, CmsContentType.SUPPORT_NEWS.getCode());
	}

	public CmsContent createSupportVideo(CmsContent record) {
		return this.create(record, CmsContentType.SUPPORT_VIDEO.getCode());
	}

	public List<CmsContent> querySupportVideo(CmsContent record) {
		return this.query(record, CmsContentType.SUPPORT_VIDEO.getCode());
	}

	public CmsContent createHomePic(CmsContent record) {
		return this.create(record, CmsContentType.HOME_PIC.getCode());
	}

	public List<CmsContent> queryHomePic(CmsContent record) {
		return this.query(record, CmsContentType.HOME_PIC.getCode());
	}

	public CmsContent createHomeVideo(CmsContent record) {
		return this.create(record, CmsContentType.HOME_VIDEO.getCode());
	}

	public List<CmsContent> queryHomeVideo(CmsContent record) {
		return this.query(record, CmsContentType.HOME_VIDEO.getCode());
	}
	
}
