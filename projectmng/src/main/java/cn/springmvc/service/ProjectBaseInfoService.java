package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.model.ProjectTypeTermEntity;
  
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
public interface ProjectBaseInfoService {

	 /**
	 * 停用或启用项目类型信息
	 * @param entity 项目类型实体 statu(0：停用 1：启用) id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity,
			InsertAdminLogEntity adminlogentity, String[] sIpInfo);
	/**
	 * 分页查询项目类型
	 * @param pageEntity 分页实体   map{projectName,statu(-1全部  0：停用 1：启用)}
	 * @return 项目类型列表
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoListpage(PageEntity pageEntity);
	/**
	 * 根据id查询项目类型
	 * @param entity 项目类型实体
	 * @return  PartnersEntity 
	 */
	public  ProjectBaseInfoEntity  selectProjectBaseInfoById(long id);
	/**
	 * 查询项目类型列表
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList();
	/**
	 * 项目类型列表 下拉
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoCombox();
	
	/**
	 * 添加项目类型
	 * @param map  { projectName项目名称 ,minAmount最低借款金额,maxAmount最高借款金额 0：表示无上限,
	 * minRate最低年化利率,maxRate最高年化利率,singleMin最小投资金额 
	 * ,investMax最大投资比例,minStart起投金额,briefIntroduction项目类型简介 ,applyMember 申请会员限制 0：无限制 1：个人会员 2：企业会员	,
	 *  picUrl展示图片 ,picIcon显示小图标 ,isMortgage是否需要抵押 0：否 1：是, contentg申请指南内容 
	 * ,contentr 还款指南类容 ,
	 * unitD天, minDaytimeD最小借款时间 ,maxDaytimeD最大借款时间 0：表示无上限, 
	 * unitM月 ,minDaytimeM, maxDaytimeM,
	 * unitY年 ,  minDaytimeY,maxDaytimeY
	 *  ,Datum(借款所需认证项拼接（认证类型 0 企业认证 1 个人认证，认证项类型ID；认证类型，认证项类型ID；认证类型，认证项类型ID；）)}
	 * @return	0：失败	1：成功
	 */
	public int addProjectBaseType(Map<String,Object> map,
			InsertAdminLogEntity adminlogentity, String[] sIpInfo); 
	
	/**
	 * 通过ID修改项目类型信息
	 * @param map  {lId借款类型ID, projectName项目名称 ,minAmount最低借款金额,maxAmount最高借款金额 0：表示无上限,
	 * minRate最低年化利率,maxRate最高年化利率,singleMin最小投资金额 
	 * ,investMax最大投资比例,minStart起投金额,briefIntroduction项目类型简介 ,applyMember 申请会员限制 0：无限制 1：个人会员 2：企业会员	,
	 *  picUrl展示图片 ,picIcon显示小图标 ,isMortgage是否需要抵押 0：否 1：是, contentg申请指南内容 
	 * ,contentr 还款指南类容 ,
	 * unitD天, minDaytimeD最小借款时间 ,maxDaytimeD最大借款时间 0：表示无上限, 
	 * unitM月 ,minDaytimeM, maxDaytimeM,
	 * unitY年 ,  minDaytimeY,maxDaytimeY
	 *  ,Datum(借款所需认证项拼接（认证类型 0 企业认证 1 个人认证，认证项类型ID；认证类型，认证项类型ID；认证类型，认证项类型ID；）)}
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProjectBaseType(Map<String,Object> map,
			InsertAdminLogEntity adminlogentity, String[] sIpInfo); 
	 
	/**
	 * 删除项目类型
	 * @param id 项目类型id
	 * @return 0：失败；1成功
	 */
	public int deleteProjectBaseInfoByID(long id,InsertAdminLogEntity 
			adminlogentity, String[] sIpInfo); 
	/**
	 * 查询项目类型所需认证项
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectType项目类型ID
	 * @param @return 设定文件 
	 * @return List<MemberAttestTypeEntity> 返回类型 
	 * @date 2016-4-22 下午2:17:30
	 */
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(long projectType);
	
	/**
	 * 查询项目类型申请条件列表
	 * @param projectType 项目类型ID
	 * @return
	 */
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(ProjectTypeDatumEntity projectTypeDatumEntity);
	
	/**
	 * 根据项目类型id，与借款类型（0：天 1：月 2：年）查询项目类型期限
	 * @param entity 项目类型期限实体
	 * @return  ProjectTypeTermEntity 
	 */
	public  ProjectTypeTermEntity  selectProjectTypeTermById(ProjectTypeTermEntity entity); 
	/**
	 * 根据项目类型id查询项目类型期限
	 * @param projectID 项目类型ID
	 * @return   List<ProjectTypeTermEntity> 
	 */
	public  List<ProjectTypeTermEntity>  selectProjectTypeTermByID(long projectID);
}
