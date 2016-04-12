

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
  
import cn.springmvc.dao.ProjectDetailListDao;
import cn.springmvc.dao.impl.ProjectDetailListDaoImpl;
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
	public ProjectAppProcessEntity selectProjectDetailByID(int projectID) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("id", projectID);
		ProjectAppProcessEntity projectAppProcessEntity = null;
		projectAppProcessEntity = projectDetailListDaoImpl.selectProjectDetailByID(map); 
		return projectAppProcessEntity;
	}

	 
	
	@Override
	public MemberInfoEntity selectMemberInfo(int projectID) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("keys", DbKeyUtil.GetDbCodeKey());
		map.put("projectID", projectID);
		MemberInfoEntity memberInfoEntity = null;
		memberInfoEntity = projectDetailListDaoImpl.selectMemberInfo(map); 
		return memberInfoEntity;
	}



  
	@Override
	public MemberAttestTypeEntity selectMemberAttestByProjectID(int id) {
		
		MemberAttestTypeEntity memberAttestTypeEntity  = null;
		memberAttestTypeEntity=projectDetailListDaoImpl.selectMemberAttestByProjectID(id);
		return memberAttestTypeEntity;
		
	}

  
	@Override
	public List<LoanRepayEntity> selectReplayByProjectID(int projectID) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		List<LoanRepayEntity> loanReplayList = projectDetailListDaoImpl.selectReplayByProjectID(map); 
		return loanReplayList;
	}
 
	
	@Override
	public List<InvestEntity> selectInvestRecordByProjectID(int projectID) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		List<InvestEntity>  investList = null;
		investList = projectDetailListDaoImpl.selectInvestRecordByProjectID(map);
		return investList;
		
	}
 

	 @Override
	public ProjectAppProcessEntity selectProjectAppProcess(int id) {
		
		 ProjectAppProcessEntity projectAppProcessEntity = null;
		 projectAppProcessEntity = projectDetailListDaoImpl.selectProjectAppProcess(id);
		 return projectAppProcessEntity;
		
	}

 
	@Override
	public List<LoanRealRepayEntity> selectLoanRealReplay(int projectID) {
		
		List<LoanRealRepayEntity>  LoanRealRepayList=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID", projectID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		LoanRealRepayList = projectDetailListDaoImpl.selectLoanRealReplay(map);
		return LoanRealRepayList;
	}


	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttach(int projectID) {
		
		List<ProjectCheckAttachEntity> projectCheckAttachList = null;
		projectCheckAttachList = projectDetailListDaoImpl.selectProjectCheckAttach(projectID);
		return projectCheckAttachList;
	}


 
	@Override
	public String selectProjectDescript(int projectID) {
		 
		return projectDetailListDaoImpl.selectProjectDescript(projectID); 
	}

 
	@Override
	public List<ProjectAfterLoanAttachmentEntity> selectProjectAfterLoanAttach(
			int projectID) {
		
		List<ProjectAfterLoanAttachmentEntity>  projectAfterLoanAttachmentList = null;
		projectAfterLoanAttachmentList = projectDetailListDaoImpl.selectProjectAfterLoanAttach(projectID);
		return projectAfterLoanAttachmentList;
	}
  
}

