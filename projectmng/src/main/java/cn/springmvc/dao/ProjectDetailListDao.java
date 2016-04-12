

/** 
* @Title: projectDetailDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午1:53:57 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;
  
import cn.springmvc.model.CompanyInfoEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;  
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.MemberInfoEntity;
import cn.springmvc.model.PersonalBaseInfoEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectBaseInformationEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;

/** 
 * @author 刘利 
 * @Description: 实现投资项目详情查询
 * @since 
 * @date 2016-3-21 下午1:53:57  */

public interface ProjectDetailListDao {
	/** 
	 * 根据项目申请记录id查询项目详情  
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppProcessEntity  selectProjectDetailByID(Map<String,Object> map);
	/** 
	 * 根据项目申请记录id查询该项目已投资总额 
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询该项目已投资总额 
	 * @param  projectid 项目申请记录id 
	 * @return 投资总金额
	 * @date 2016-3-21 下午1:57:47 
	 */
	public  long selectInvestTotalAmount(Map<String,Object> map);
	/** 
	 * 查询借款会员基本信息 
	 * @author 刘利   
	 * @Description: 查询借款会员基本信息 
	 * @param projectID 借款项目id
	 * @return MemberInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public MemberInfoEntity selectMemberInfo(Map<String,Object> map);
   
    /** 
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目所需会员认证项 
	 * @param id  项目申请记录id 
	 * @return ProjectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestByProjectID(int id);
	/**  
	 * @author 刘利   
	 * @Description: 通过项目id查询还款计划
	 * @param projectID 项目id
	 * @return List<LoanRepayEntity> 还款计划实体
	 * @date 2016-3-21 下午5:46:42 
	 */
	public List<LoanRepayEntity> selectReplayByProjectID(Map<String,Object> map);
	/**  
	 * @author 刘利   
	 * @Description: 通过项目id查询投资记录
	 * @param projectID 项目id
	 * @return List<InvestEntity> 投资记录
	 * @date 2016-3-21 下午5:46:42 
	 */
	public List<InvestEntity> selectInvestRecordByProjectID(Map<String,Object> map);
	/** 
	 * @author 刘利   
	 * @Description: 根据项目申请记录id项目进程记录
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 项目进程实体
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppProcessEntity  selectProjectAppProcess(int id);
	/**  
	 * @author 刘利   
	 * @Description: 通过项目id查询真实还款记录
	 * @param projectID 项目id
	 * @return List<LoanRealRepayEntity> 真实还款计划列表
	 * @date 2016-3-22 上午9:46:42 
	 */
	public List<LoanRealRepayEntity> selectLoanRealReplay(Map<String,Object> map);
	/**
	 * 通过项目申请id查询资质证照
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  projectID 项目申请id
	 * @param @return 设定文件 
	 * @return List<ProjectCheckAttachEntity>  审核附件列表
	 * @date 2016-3-22 上午11:23:46 
	 */
	public List<ProjectCheckAttachEntity>  selectProjectCheckAttach(int projectID);
	/** 
	 * 根据项目申请id查询借款描述
	 * @author 刘利   
	 * @Description: 根据项目申请id查询借款描述
	 * @param projectID 项目申请id 
	 * @return String 项目基本信息实体类
	 * @date 2016-3-22 上午11:40:00 
	 */
	public  String selectProjectDescript(int projectID);
	/** 
	 * 根据项目id查询贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param projectID 项目申请ID
	 * @return List<ProjectAfterLoanAttachmentEntity> 项目贷后信息附件资料实体
	 * @date 2016-3-22 下午12:04:10 
	 */
	public List<ProjectAfterLoanAttachmentEntity> selectProjectAfterLoanAttach(int projectID);
	/** 
	 * 查询借款个人会员基本信息 
	 * @author 刘利   
	 * @Description: 查询借款个人会员基本信息 
	 * @param personID 会员基本信息ID
	 * @return PersonalBaseInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public PersonalBaseInfoEntity selectMemberInfoPersonByID(long personID);
    /** 
	 * 查询借款企业会员基本信息 
	 * @author 刘利   
	 * @Description: 查询借款企业会员基本信息 
	 * @param personID 会员基本信息ID
	 * @return PersonalBaseInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public CompanyInfoEntity selectMemberInfoCompanByID(long personID);
	 
}

