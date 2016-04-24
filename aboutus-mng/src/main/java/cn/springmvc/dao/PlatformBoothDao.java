package cn.springmvc.dao;
 
 
import java.util.Map;

import cn.springmvc.model.PlatformBoothEntity;
/**
 * 
* @author 刘利 
* @Description: 平台宣传点增删改接口
* @since 
* @date 2016-3-19 下午7:39:18
 */
public interface PlatformBoothDao {
	/**
	 * 添加平台宣传点
	 * @param entity  平台宣传点实体类
	 * @return	0：失败	1：成功
	 */
	public int insertPlatformBooth(PlatformBoothEntity entity); 
	
	/**
	 * 通过ID修改平台宣传点信息
	 * @param entity 平台宣传点实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updatePlatformBoothByID(PlatformBoothEntity entity); 
	/**
	 * 通过ID删除平台宣传点信息
	 * @param id 平台宣传点id
	 * @return 0:失败 1：成功 
	 */
	public  int  deletePlatformBoothByID(long sgID); 
	/**
	 * 停用启用  平台宣传点信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午4:05:19
	 */
	public int updatePlatformBoothStatu(Map<String,Object> map);
	 
}
