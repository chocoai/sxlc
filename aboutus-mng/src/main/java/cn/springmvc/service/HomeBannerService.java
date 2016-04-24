package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.HomeBannerEntity;
 
/**
 * 
* @author 刘利 
* @Description: 首页轮播图的查询接口类 
* @since 
* @date 2016-3-19 下午8:18:09
 */
public interface HomeBannerService {
	/**
	 * 新增首页轮播图
	 * @param entity 首页轮播图实体
	 * @return 0：数据为空;-1：该名称的首页轮播图已存在;1:添加成功
	 */
	public int insertHomeBanner(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除首页轮播图
	 * @param id 首页轮播图id
	 * @return 0：失败；1成功
	 */
	public int deleteHomeBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改首页轮播图
	 * @param entity 首页轮播图实体
	 * @return 0：失败；1成功；-1：该名称的首页轮播图已存在;
	 */
	public int updateHomeBannerByID(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	 /**
	 * 停用或启用首页轮播图信息
	 * @param entity 首页轮播图实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateHomeBannerStatuByID(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 分页查询首页轮播图
	 * @param pageEntity 分页实体 map{bannerTitle,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<HomeBannerEntity> selectHomeBannerListpage(PageEntity pageEntity);
	/**
	 * 上移或下移首页轮播图
	 * @param map集合   {iid(ID),flag(大于0上移,小于0下移)} 
	 * @return -1失败，1成功
	 */
	public int moveAndDownHomeBannerByID(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 根据id查询首页轮播图
	 * @param id 首页轮播图id
	 * @return  homeBannerEntity 
	 */
	public  HomeBannerEntity  selectHomeBannerByID(long id);
	/**
	 * 前台查询首页轮播图 
	 * @return
	 */
	public List<HomeBannerEntity> selectHomeBannerfront(); 
}
