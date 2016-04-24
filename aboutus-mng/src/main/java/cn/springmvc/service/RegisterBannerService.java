package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.RegisterBannerEntity;
 
/**
 * 
* @author 刘利 
* @Description: 注册界面轮播图 
* @since 
* @date 2016-3-19 下午10:08:26
 */
public interface RegisterBannerService {
	
	/**
	 * 新增注册界面轮播图
	 * @param entity 注册界面轮播图实体
	 * @return 0：数据为空;-1：该名称的注册界面轮播图已存在;1:添加成功
	 */
	public int insertRegisterBanner(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 删除注册界面轮播图
	 * @param id 注册界面轮播图id
	 * @return 0：失败；1成功
	 */
	public int deleteRegisterBannerByID(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 修改注册界面轮播图
	 * @param entity 注册界面轮播图实体
	 * @return 0：失败；1成功;-1：该名称的注册界面轮播图已存在
	 */
	public int updateRegisterBannerByID(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	 /**
	 * 停用或启用注册界面轮播图信息
	 * @param entity 注册界面轮播图实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateRegisterBannerStatuByID(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 分页查询注册界面轮播图
	 * @param pageEntity 分页实体 map{bannerTitle,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<RegisterBannerEntity> selectRegisterBannerListpage(PageEntity pageEntity);
	
	/**
	 * 上移或下移注册界面轮播图
	 * @param entity 首页轮播图实体 map{iid(ID),flag(大于0上移,小于0下移)}
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownRegisterBannerByID(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 根据id查询注册界面轮播图
	 * @param id 注册界面轮播图id
	 * @return  registerBannerEntity 
	 */
	public  RegisterBannerEntity  selectRegisterBannerByID(int id);
	
	/**
	 * 前台查询注册界面轮播图
	 * @param  pageEntity 分页实体类
	 * @return
	 */
	public List<RegisterBannerEntity> selectRegisterBannerfront();
}
