package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.LoginBannerEntity;
 
/**
 * 
* @author 刘利 
* @Description: 登录界面轮播图
* @since 
* @date 2016-3-19 下午10:06:48
 */
public interface LoginBannerService {
	/**
	 * 新增登录界面轮播图
	 * @param entity 登录界面轮播图实体
	 * @return 0：数据为空;-1：该名称的登录界面轮播图已存在;1:添加成功
	 */
	public int insertLoginBanner(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 删除登录界面轮播图
	 * @param id 登录界面轮播图id
	 * @return 0：失败；1成功
	 */
	public int deleteLoginBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 修改登录界面轮播图
	 * @param entity 登录界面轮播图实体
	 * @return 0：失败；1成功;-1：该名称的登录界面轮播图已存在
	 */
	public int updateLoginBannerByID(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	 /**
	 * 停用或启用登录界面轮播图信息
	 * @param entity 登录界面轮播图实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateLoginBannerStatuByID(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 分页查询登录界面轮播图
	 * @param pageEntity 分页实体 map{bannerTitle,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<LoginBannerEntity> selectLoginBannerListpage(PageEntity pageEntity);
	
	/**
	 * 上移或下移登录界面轮播图
	 * @param map集合  map{iid(ID),flag(大于0上移,小于0下移)} 
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownLoginBannerByID(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 根据id查询登录界面轮播图
	 * @param id 登录界面轮播图id
	 * @return  LoginBannerEntity 
	 */
	public  LoginBannerEntity  selectLoginBannerByID(long id);
	
	/**
	 * 登录界面轮播图前台 
	 * @return
	 */
	public List<LoginBannerEntity> selectLoginBannerfront(); 
}
