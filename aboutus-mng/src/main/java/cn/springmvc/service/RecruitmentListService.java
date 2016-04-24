package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.RecruitmentEntity;
 
/**
 * 
* @author 刘利 
* @Description: 招贤纳士 
* @since 
* @date 2016-3-19 下午10:08:20
 */
public interface RecruitmentListService {
	
	/**
	 * 新增招贤纳士
	 * @param entity 招贤纳士实体
	 * @return 0：数据为空;-1：该名称的招贤纳士已存在;1:添加成功
	 */
	public int insertRecruitments(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 删除招贤纳士
	 * @param id 招贤纳士id
	 * @return 0：失败；1成功
	 */
	public int deleteRecruitments(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 修改招贤纳士信息
	 * @param entity 招贤纳士实体
	 * @return 0：失败；1成功;-1：该名称的招贤纳士已存在
	 */
	public int updateRecruitments(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	
	/**
	 * 停用或启用招贤纳士信息
	 * @param entity 招贤纳士实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateRecruitmentStatuByID(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 分页查询招贤纳士
	 * @param   pageEntity 分页实体  map{name,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<RecruitmentEntity> selectRecruitmentsList(PageEntity pageEntity);
	
	/**
	 * 通过id查询招贤纳士
	 * @param id 招贤纳士id
	 * @return  RecruitmentEntity 
	 */
	public  RecruitmentEntity  selectRecruitmentByID(long id);
}
