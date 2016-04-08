package cn.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.model.PartnersEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
/**
 * 
* @author 刘利 
* @Description: 平台公告
* @since 
* @date 2016-3-19 下午10:07:51
 */
public interface PlatformAnnouncementService {
	/**
	 * 新增平台公告
	 * @param entity 平台公告实体
	 * @return 0：数据为空;-1：该名称的平台公告已存在;1:添加成功
	 */
	public int insertPlatform(PlatformAnnouncementEntity entity); 
	/**
	 * 删除平台公告
	 * @param id 平台公告id
	 * @return 0：失败；1成功
	 */
	public int deletePlatform(int id); 
	/**
	 * 修改平台公告信息
	 * @param entity 平台公告实体
	 * @return 0：失败；1成功;-1：该名称的平台公告已存在
	 */
	public int updatePlatform(PlatformAnnouncementEntity entity);  
	/**
	 * 停用或启用平台公告信息
	 * @param entity 平台公告实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updatePlatformStatuByID(PlatformAnnouncementEntity entity);
	/**
	 * 分页查询平台公告
	 * @param pageEntity 分页实体类  map{title,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<PlatformAnnouncementEntity> selectPlatformList(PageEntity pageEntity); 
	/**
	 * 根据id查询平台公告
	 * @param id 平台公告id
	 * @return  PlatformAnnouncementEntity 
	 */
	public  PlatformAnnouncementEntity  selectPlatformByID(int id);
}
