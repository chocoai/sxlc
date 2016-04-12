package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.RecruitmentEntity;
/**
 * 
* @author 刘利 
* @Description: 招贤纳士
* @since 
* @date 2016-3-19 下午9:48:18
 */
public interface RecruitmentDao {
	/**
	 * 添加招贤纳士
	 * @param entity  招贤纳士实体类
	 * @return	0：失败	1：成功
	 */
	public int insertRecruitment(RecruitmentEntity entity);
	
	/**
	 * 通过ID修改招贤纳士信息
	 * @param entity 招贤纳士实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateRecruitmentByID(RecruitmentEntity entity); 
	/**
	 * 通过ID删除招贤纳士信息
	 * @param id 招贤纳士id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteRecruitmentByID(int id);  
	/**
	 * 停用或启用招贤纳士
	 * @param entity 招贤纳士实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateRecruitmentStatuByID(RecruitmentEntity entity);
	
}
