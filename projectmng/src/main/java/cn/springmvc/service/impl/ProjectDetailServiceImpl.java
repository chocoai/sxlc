

/** 
* @Title: projectDetailServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午2:16:11 
* @version V5.0 */
 
package cn.springmvc.service.impl; 
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
  
import cn.springmvc.dao.ProjectDetailListDao; 
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanMemberInfoEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.MemberInfoEntity; 
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;  
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectDetailTYEntity;
import cn.springmvc.service.projectDetailService;

/** 
 * @author 刘利 
 * @Description: 查询项目详情
 * @since 
 * @date 2016-3-21 下午2:16:11  */
@Service("projectDetailServiceImpl")
public class ProjectDetailServiceImpl  implements projectDetailService {
	@Resource(name="projectDetailListDaoImpl")
	private ProjectDetailListDao projectDetailListDaoImpl;  
	 
	
	@Override
	public ProjectAppRecordEntity selectProjectDetailByID(long projectID) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("id", projectID);
		ProjectAppRecordEntity projectAppRecordEntity = null;
		projectAppRecordEntity = projectDetailListDaoImpl.selectProjectDetailByID(map); 
		return projectAppRecordEntity;
	}

	 
	
	@Override
	public LoanMemberInfoEntity selectMemberInfo(long projectID) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("keys", DbKeyUtil.GetDbCodeKey());
		map.put("projectID", projectID);
		LoanMemberInfoEntity memberInfoEntity = null;
		memberInfoEntity = projectDetailListDaoImpl.selectMemberInfo(map); 
		return memberInfoEntity;
	}



  
	@Override
	public MemberAttestTypeEntity selectMemberAttestByprojectType(long projectType) {
		
		MemberAttestTypeEntity memberAttestTypeEntity  = null;
		memberAttestTypeEntity=projectDetailListDaoImpl.selectMemberAttestByprojectType(projectType);
		return memberAttestTypeEntity;
		
	}

  
	@Override
	public List<LoanRepayEntity> selectReplayByProjectID(long projectID) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		List<LoanRepayEntity> loanReplayList = projectDetailListDaoImpl.selectReplayByProjectID(map); 
		return loanReplayList;
	}
 
	
	@Override
	public List<InvestEntity> selectInvestRecordByProjectID(long projectID) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		List<InvestEntity>  investList = null;
		investList = projectDetailListDaoImpl.selectInvestRecordByProjectID(map);
		return investList;
		
	}
 

	 @Override
	public ProjectAppProcessEntity selectProjectAppProcess(long id) {
		
		 ProjectAppProcessEntity projectAppProcessEntity = null;
		 projectAppProcessEntity = projectDetailListDaoImpl.selectProjectAppProcess(id);
		 return projectAppProcessEntity;
		
	}

 
	@Override
	public List<LoanRealRepayEntity> selectLoanRealReplay(long projectID) {
		
		List<LoanRealRepayEntity>  LoanRealRepayList=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		LoanRealRepayList = projectDetailListDaoImpl.selectLoanRealReplay(map);
		return LoanRealRepayList;
	}


	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttach(long projectID) {
		
		List<ProjectCheckAttachEntity> projectCheckAttachList = null;
		projectCheckAttachList = projectDetailListDaoImpl.selectProjectCheckAttach(projectID);
		return projectCheckAttachList;
	}


 
	@Override
	public String selectProjectDescript(long projectID) {
		 
		return projectDetailListDaoImpl.selectProjectDescript(projectID); 
	}
 
	@Override
	public  ProjectAppRecordEntity  selectInvestAvailableaAmount(
			long applyID) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyID", applyID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return projectDetailListDaoImpl.selectInvestAvailableaAmount(map);
		
	}



	@Override
	public ProjectDetailTYEntity selectProjectdetailByIDbc(long applyId) {
		
		ProjectDetailTYEntity entity = projectDetailListDaoImpl
				.selectProjectdetailByIDbc(applyId);
		if(entity == null) {
			return null;
		}
		//项目为发布管理费计算
		if(entity.getCheckStatu() !=1 ) {
			if(entity.getRiskMarginType() == 0) {
				entity.setRiskMarginFee(entity.getAmount()*entity.getRiskMarginRate()/1000000);
			}
			long mngFeeAmount = 0;//借款管理费
			if(entity.getDeadlineType() == 0) { 
				mngFeeAmount=entity.getAmount()*(entity.getMngFeeRate()+entity.getMngFeeRateIncreace()*entity.getDeadline())/1000000;
				//该会员是VIP会员
				if(entity.getIsVip() > 0 && entity.getVipBorrowMngRate() !=0) {
					mngFeeAmount = mngFeeAmount*entity.getVipBorrowMngRate()/1000000;
				}
				entity.setMngFeeAmount(mngFeeAmount);
			}else if(entity.getDeadlineType() == 1) { 
				mngFeeAmount=entity.getAmount()*entity.getMngFeeRate()*entity.getDeadline()/1000000;
				//该会员是VIP会员
				if(entity.getIsVip() > 0 && entity.getVipBorrowMngRate() !=0) {
					mngFeeAmount = mngFeeAmount*entity.getVipBorrowMngRate()/1000000;
				}
				entity.setMngFeeAmount(mngFeeAmount);
			}else if(entity.getDeadlineType() == 1) { 
				mngFeeAmount=entity.getAmount()*entity.getMngFeeRate()*entity.getDeadline()/1000000;
				//该会员是VIP会员
				if(entity.getIsVip() > 0 && entity.getVipBorrowMngRate() !=0) {
					mngFeeAmount = mngFeeAmount*entity.getVipBorrowMngRate()/1000000;
				}
				entity.setMngFeeAmount(mngFeeAmount);
			}
		}
		return entity;
		
	}



	@Override
	public List<LoanRepayEntity> selectLoanRealReplayprocess(long applyID) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("keys", DbKeyUtil.GetDbCodeKey());
		map.put("projectID", applyID);
		return projectDetailListDaoImpl.selectLoanRealReplayprocess(map);
		
	}
  
}

