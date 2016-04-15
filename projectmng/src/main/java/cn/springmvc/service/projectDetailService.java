

/** 
* @Title: projectDetailService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午2:10:02 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;
  
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.MemberInfoEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInformationEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;

/** 
 * @author 刘利 
 * @Description: 查询投资项目详情 
 * @since 
 * @date 2016-3-21 下午2:10:02  */

public interface projectDetailService {
	/** 
	 * 根据项目申请记录id查询项目详情  
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param projectID  项目申请记录id 
	 * @return ProjectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppRecordEntity  selectProjectDetailByID(int projectID);
	/** 
	 * 根据借款项目id查询借款会员基本信息 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: 查询借款会员基本信息 
	 * @param  projectID 借款项目id
	 * @return MemberInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public MemberInfoEntity selectMemberInfo(int projectID);
  
    /** 
     * 根据项目申请记录id查询项目所需会员认证项 
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目所需会员认证项 
	 * @param id  项目申请记录id 
	 * @return ProjectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestByProjectID(int id);
	/** 
	 * 通过项目id查询还款计划 
	 * @author 刘利   
	 * @Description: 通过项目id查询还款计划
	 * @param projectID 项目id
	 * @return List<LoanRepayEntity> 还款计划实体
	 * @date 2016-3-21 下午5:46:42 
	 */
	public List<LoanRepayEntity> selectReplayByProjectID(int projectID);
	/**  
	 * 通过项目id查询投资记录
	 * @author 刘利   
	 * @Description: 通过项目id查询投资记录
	 * @param projectID 项目id
	 * @return List<InvestEntity> 投资记录
	 * @date 2016-3-21 下午5:46:42 
	 */
	public List<InvestEntity> selectInvestRecordByProjectID(int projectID);
	/** 
	 * 根据项目申请记录id项目进程记录
	 * @author 刘利   
	 * @Description: 根据项目申请记录id项目进程记录
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppProcessEntity  selectProjectAppProcess(int id);
	/**  
	 * 通过项目id查询真实还款记录
	 * @author 刘利   
	 * @Description: 通过项目id查询真实还款记录
	 * @param projectID 项目id
	 * @return List<LoanRealRepayEntity> 真实还款计划实体
	 * @date 2016-3-21 下午5:46:42 
	 */
	public List<LoanRealRepayEntity> selectLoanRealReplay(int projectID);
	/**
	 *   通过项目申请id查询资质证照
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID 项目申请id
	 * @param @return 设定文件 
	 * @return List<ProjectCheckAttachEntity>  审核附件列表
	 * @date 2016-3-22 上午11:23:46 
	 */
	public List<ProjectCheckAttachEntity>  selectProjectCheckAttach(int projectID);
	/** 
	 * 根据项目申请id查询借款描述
	 * @author 刘利   
	 * @Description: 根据项目申请id查询借款描述
	 * @param  projectID 项目申请id 
	 * @return  String 项目基本信息实体类
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
     * 查询项目直投剩余可投金额-已投资总额-转让本金 
     * @author 刘利   
     * @Description: TODO 
     * @param map {applyID，sKey}
     * @param @return 设定文件 
     * @return  ProjectAppRecordEntity  返回类型 
     * @date 2016-4-13 上午10:59:30
     */
    public  ProjectAppRecordEntity  selectInvestAvailableaAmount(long applyID); 
}

