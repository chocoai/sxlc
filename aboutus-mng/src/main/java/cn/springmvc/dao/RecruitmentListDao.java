package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.RecruitmentEntity;
/**
 * 
* @author 刘利 
* @Description: 招贤纳士
* @since 
* @date 2016-3-19 下午9:48:26
 */
public interface RecruitmentListDao {
	/**
	 * 查询该名称的招贤纳士是否存在
	 * @param entity 招贤纳士实体
	 * @return  RecruitmentEntity 
	 */
	public  RecruitmentEntity  selectRecruitmentIsExistByNAme(RecruitmentEntity entity);
	/**
	 * 分页查询招贤纳士
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<RecruitmentEntity> selectRecruitmentList(PageEntity pageEntity); 
	/**
	 * 通过id查询招贤纳士
	 * @param id 招贤纳士id
	 * @return  RecruitmentEntity 
	 */
	public  RecruitmentEntity  selectRecruitmentByID(long id);
}
