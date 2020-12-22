package com.mooer.manager.gtrs.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mooer.manager.gtrs.pojo.CmsContent;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author main
 * @since 2020-04-29
 */
public interface ICmsContentService extends IService<CmsContent> {
	
	/**
	 * 创建首页产品内容
	 * @param content
	 * @return
	 */
	CmsContent createHomeProduct(CmsContent content);
	
	/**
	 * 首页产品内容
	 * @param record
	 * @param pageable
	 * @return
	 */
	List<CmsContent> queryHomeBanner(CmsContent record);
	
	/**
	 * 创建首页产品内容
	 * @param content
	 * @return
	 */
	CmsContent createHomeBanner(CmsContent content);
	
	/**
	 * 首页产品内容
	 * @param record
	 * @param pageable
	 * @return
	 */
	List<CmsContent> queryHomeProduct(CmsContent record);
	
	/**
	 * 更新内容
	 * @param record
	 * @return
	 */
	CmsContent update(CmsContent record);
	
	/**
	 * 删除内容
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 隐藏内容
	 * @param id
	 * @return
	 */
	int hideCmsContent(Long id);
	
	/**
	 * 显示内容
	 * @param id
	 * @return
	 */
	int showCmsContent(Long id);

	CmsContent createHomeGoods(CmsContent record);

	List<CmsContent> queryHomeGoods(CmsContent record);

	CmsContent createHomeCategory(CmsContent record);

	List<CmsContent> queryHomeCategory(CmsContent record);

	CmsContent createShopBanner(CmsContent content);

	List<CmsContent> queryShopBanner(CmsContent record);

	CmsContent queryHomeProductMore();

	CmsContent createHomeProductMore(CmsContent record);

	CmsContent createSupportNews(CmsContent record);

	List<CmsContent> querySupportNews(CmsContent record);
}
