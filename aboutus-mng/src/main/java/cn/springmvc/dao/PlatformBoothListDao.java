

/** 
* @Title: PlatformBoothDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:15:52 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.PlatformBoothEntity;

/** 
 * @author 刘利 
 * @Description: 平台宣传点
 * @since 
 * @date 2016-4-12 下午7:15:52  */

public interface PlatformBoothListDao {
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
	 * 分页查询平台宣传点
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<PlatformBoothEntity> 返回类型 
	 * @date 2016-4-21 上午9:36:44
	 */
	public List<PlatformBoothEntity> selectPlatformBoothList(PageEntity pageEntity);
	/**
	 * 根据ID查询平台宣传点
	 * selectPlatformBoothByID(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param sgID
	 * @param @return 设定文件 
	 * @return PlatformBoothEntity 返回类型 
	 * @date 2016-4-21 上午9:41:42
	 */
	public PlatformBoothEntity selectPlatformBoothByID(long sgID);
	/**
	 * 查询该名称的平台宣传点是否存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param platformBoothEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 上午9:47:14
	 */
	public int selectPlatformBoothIsExistByTitle(PlatformBoothEntity platformBoothEntity);
}

