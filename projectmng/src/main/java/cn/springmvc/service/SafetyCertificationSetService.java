package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SafetyCertificationSetEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
public interface SafetyCertificationSetService {
	/**
	 * 新增首页全屏弹出框配置
	 * @param entity 首页全屏弹出框配置实体
	 * @return 0：数据为空;-1：该名称的首页全屏弹出框配置已存在;1:添加成功
	 */
	public int insertSafetyCertificationSet(SafetyCertificationSetEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除首页全屏弹出框配置
	 * @param id 首页全屏弹出框配置id
	 * @return 0：失败；1成功
	 */
	public int deleteSafetyCertificationSetByID(int id,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 修改首页全屏弹出框配置
	 * @param entity 首页全屏弹出框配置实体
	 * @return 0：失败；1成功
	 */
	public int updateSafetyCertificationSetByID(SafetyCertificationSetEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo);
	 /**
	 * 停用或启用首页全屏弹出框配置信息
	 * @param entity 首页全屏弹出框配置实体 statu,id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationSetStatuByID(SafetyCertificationSetEntity entity);
	/**
	 * 分页查询首页全屏弹出框配置
	 * @param pageEntity 分页实体   map{startTime，endTime，statu(-1全部)}
	 * @return 首页全屏弹出框配置列表
	 */
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetListpage(PageEntity pageEntity);
	/**
	 * 通过id查询首页全屏弹出框配置
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public  SafetyCertificationSetEntity selectSafetyCertificationSetbyID(int id);
}
