

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
import cn.springmvc.model.LoanMemberInfoEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;  
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.MemberInfoEntity;
import cn.springmvc.model.PersonalBaseInfoEntity; 
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectAppRecordEntity; 
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectDetailTYEntity;

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
	 * @return projectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppRecordEntity  selectProjectDetailByID(Map<String,Object> map);
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
    public LoanMemberInfoEntity selectMemberInfo(Map<String,Object> map);
   
    /** 
	 * @author 刘利   
	 * @Description: 根据项目类型ID查询项目所需会员认证项 
	 * @param id  项目类型ID
	 * @return ProjectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestByprojectType(long id);
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
	public  ProjectAppProcessEntity  selectProjectAppProcess(long id);
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
	public List<ProjectCheckAttachEntity>  selectProjectCheckAttach(long projectID);
	/** 
	 * 根据项目申请id查询借款描述
	 * @author 刘利   
	 * @Description: 根据项目申请id查询借款描述
	 * @param projectID 项目申请id 
	 * @return String 项目基本信息实体类
	 * @date 2016-3-22 上午11:40:00 
	 */
	public  String selectProjectDescript(long projectID);
	 
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
    /**
     * 查询项目直投剩余可投金额-已投资总额-转让本金 
     * @author 刘利   
     * @Description: TODO 
     * @param map {applyID，sKey}
     * @param @return 设定文件 
     * @return  ProjectAppRecordEntity 返回类型 
     * @date 2016-4-13 上午10:59:30
     */
    public  ProjectAppRecordEntity  selectInvestAvailableaAmount(Map<String,Object> map); 
    
    /**
     * 后台显示项目详情
     * @author 刘利   
     * @Description: TODO 
     * @param @param applyId
     * @param @return 设定文件 
     * @return ProjectDetailTYEntity 返回类型 
     * @date 2016-5-11 下午3:59:37
     */
    public ProjectDetailTYEntity selectProjectdetailByIDbc(long applyId);
    
    /**
     * 项目历程里的还款计划
     * @author 刘利   
     * @Description: TODO 
     * @param @param map
     * @param @return 设定文件 
     * @return List<LoanRepayEntity> 返回类型 
     * @date 2016-5-19 下午8:21:22
     */
    public List<LoanRepayEntity> selectLoanRealReplayprocess(Map<String,Object> map);
}

