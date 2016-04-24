package cn.springmvc.dao;
  
import cn.springmvc.model.PlatformIntroduceEntity;
/**
 * 
* @author 刘利 
* @Description: 平台简介 
* @since 
* @date 2016-3-19 下午9:47:36
 */
public interface PlatformIntroduceDao {
	/**
	 * 添加平台简介
	 * @param entity  平台简介实体类
	 * @return	0：失败	1：成功
	 */
	public int insertPlatformIntroduce(PlatformIntroduceEntity entity);
 
	/**
	 * 修改平台简介
	 * @param entity 平台简介实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updatePlatformIntroduce(PlatformIntroduceEntity entity); 
	/**
	 * 删除平台简介 
	 * @return 0:失败 1：成功 
	 */
	public  int  deletePlatformIntroduce();

}
