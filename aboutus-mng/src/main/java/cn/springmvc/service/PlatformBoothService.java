

/** 
* @Title: PlatformBoothService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:35:39 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.PlatformBoothEntity;

/** 
 * @author 刘利 
 * @Description: 平台宣传点
 * @since 
 * @date 2016-4-12 下午7:35:39  */

public interface PlatformBoothService {
	/**
	 * 首页查询宣传点 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<PlatformBoothEntity> 返回类型 
	 * @date 2016-4-12 下午7:34:31
	 */
	public List<PlatformBoothEntity> selectPlatformBooth();
	/**
	 * 新增平台宣传点
	 * @param entity 平台宣传点实体
	 * @return 0：数据为空;-1：该名称的平台宣传点已存在;1:添加成功
	 */
	public int insertPlatformBooth(PlatformBoothEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除平台宣传点
	 * @param id 平台宣传点id
	 * @return 0：失败；1成功
	 */
	public int deletePlatformBoothByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改平台宣传点
	 * @param entity 平台宣传点实体
	 * @return 0：失败；1成功;-1：该名称的平台宣传点已存在;
	 */
	public int updatePlatformBoothByID(PlatformBoothEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 分页查询平台宣传点
	 * @param pageEntity 分页实体 map 包含(asTitle) 
	 * @return 平台宣传点列表
	 */
	public void selectPlatformBoothList(PageEntity pageEntity);
	/**
	 * 根据ID查询的平台宣传点
	 * @param id 平台宣传点id
	 * @return  expertTeamEntity 平台宣传点实体
	 */
	public  PlatformBoothEntity  selectPlatformBoothByID(long id);
	/**
	 * 停用启用  平台宣传点信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  statu:(0无效，1有效)
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午4:05:19
	 */
	public int updatePlatformBoothStatu(int statu,long sgID,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
}

