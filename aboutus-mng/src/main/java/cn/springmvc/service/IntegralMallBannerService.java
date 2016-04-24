package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.IntegralMallBannerEntity;
 
/**
 * 
* @author 刘利 
* @Description: 积分商城的增加、删除、修改、查询功能
* @since 
* @date 2016-3-19 下午8:27:46
 */
public interface IntegralMallBannerService {
	/**
	 * 新增积分商城轮播图
	 * @param entity 积分商城轮播图实体
	 * @return 0：数据为空;-1：该名称的积分商城轮播图已存在;1:添加成功
	 */
	public int insertIntegralMallBanner(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除积分商城轮播图
	 * @param id 积分商城轮播图id
	 * @return 0：失败；1成功
	 */
	public int deleteIntegralMallBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改积分商城轮播图
	 * @param entity 积分商城轮播图实体
	 * @return 0：失败；1成功 -1：该名称的积分商城轮播图已存在;
	 */
	public int updateIntegralMallBannerByID(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	 /**
	 * 停用或启用积分商城轮播图信息
	 * @param entity 积分商城轮播图实体  statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateIntegralMallBannerStatuByID(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 分页查询积分商城轮播图
	 * @param pageEntity 分页实体类 map{bannerTitle,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<IntegralMallBannerEntity> selectIntegralMallBannerListpage(PageEntity pageEntity);
	/**
	 * 上移或下移积分商城轮播图
	 * @param map集合    map{iid(ID),flag(大于0上移,小于0下移)} 
	 * @return -1失败，1成功
	 */
	public int moveAndDownIntegralMallBannerByID(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 根据id查询积分商城轮播图
	 * @param id 积分商城轮播图id
	 * @return  integralMallBannerEntity 
	 */
	public  IntegralMallBannerEntity  selectIntegralMallBannerByID(long id);
	/**
	 * 查询积分商城轮播图 前台
	 * @return
	 */
	public List<IntegralMallBannerEntity> selectIntegralMallBannerfront(); 

}
