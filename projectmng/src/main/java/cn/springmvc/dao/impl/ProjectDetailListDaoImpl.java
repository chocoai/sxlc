

/** 
* @Title: projectDetailListDao.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午1:59:58 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 
import cn.springmvc.dao.ProjectDetailListDao;
import cn.springmvc.model.CompanyInfoEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.MemberInfoEntity;
import cn.springmvc.model.PersonalBaseInfoEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInformationEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;

/** 
 * @author 刘利 
 * @Description: TODO 查询投资项目详情
 * @since 
 * @date 2016-3-21 下午1:59:58  */
@Repository("projectDetailListDaoImpl")
public class ProjectDetailListDaoImpl extends SqlSessionDaoSupport implements ProjectDetailListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 

	@Override
	public ProjectAppRecordEntity selectProjectDetailByID(Map<String,Object> map) {

		ProjectAppRecordEntity projectAppRecordEntity = null;
		projectAppRecordEntity = getSqlSession().selectOne("projectDetail.selectProjectdetail",map);
		return  projectAppRecordEntity;

	}
 
	@Override
	public long selectInvestTotalAmount(Map<String,Object> map) {

		long investTotal = getSqlSession().selectOne("projectDetail.selectProjectdetail",map);
		return investTotal;

	}
 
	
	@Override
	public MemberInfoEntity selectMemberInfo(Map<String,Object> map) {
		
		MemberInfoEntity memberInfoEntity = getSqlSession().selectOne("memberInfoProject.selectMemberInfoByProjectID",map);
		return memberInfoEntity;
	}
 
	
	
	 
	
	@Override
	public MemberAttestTypeEntity selectMemberAttestByProjectID(int id) {
		
		MemberAttestTypeEntity memberAttestTypeEntity = null;
		memberAttestTypeEntity = getSqlSession().selectOne("projectDetail.selectMemberAttestByProjectID",id);
		return  memberAttestTypeEntity;
		
	}

	 
	@Override
	public List<LoanRepayEntity> selectReplayByProjectID(Map<String,Object> map) {
		
		List<LoanRepayEntity> loanReplayList = null;
		loanReplayList = getSqlSession().selectList("replay.selectReplayByProjectID",map);
		return loanReplayList;
	}

	 
	
	@Override
	public List<InvestEntity> selectInvestRecordByProjectID(Map<String,Object> map) {
		
		List<InvestEntity>  investList = null;
		investList=getSqlSession().selectList("investRecord.selectInvestRecordByProjectID",map);
		return investList;
		
	}
 
	@Override
	public ProjectAppProcessEntity selectProjectAppProcess(int id) {
		
		ProjectAppProcessEntity projectAppProcessEntity = null;
		projectAppProcessEntity = getSqlSession().selectOne("projectDetail.selectProjectAppProcess",id);
		return  projectAppProcessEntity;
		
	}

	 
	@Override
	public List<LoanRealRepayEntity> selectLoanRealReplay(Map<String,Object> map) {
		
		List<LoanRealRepayEntity>  LoanRealRepayList=null;
		LoanRealRepayList = getSqlSession().selectList("replay.selectLoanRealReplay",map);
		return LoanRealRepayList;
	}

	  
	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttach(int projectID) {
		
		List<ProjectCheckAttachEntity>  projectCheckAttachList = null;
		projectCheckAttachList = getSqlSession().selectList("projectCheckAttach.selectProjectCheckAttach",projectID);
		return projectCheckAttachList;
		
	}

	 
	@Override
	public String selectProjectDescript(int projectID) {
		 
		return getSqlSession().selectOne("projectDetail.selectProjectDescript",projectID);
		  
	}

	 
	@Override
	public List<ProjectAfterLoanAttachmentEntity> selectProjectAfterLoanAttach(
			int projectID) {
		
		List<ProjectAfterLoanAttachmentEntity>  projectAfterLoanAttachmentList = null;
		projectAfterLoanAttachmentList=getSqlSession().selectList("ProjectAfterLoanAttach.selectProjectAfterLoanAttach",projectID);
		return projectAfterLoanAttachmentList;
		
	}

	 
	@Override
	public PersonalBaseInfoEntity selectMemberInfoPersonByID(long personalID) {
		
		PersonalBaseInfoEntity personalBaseInfoEntity = getSqlSession().selectOne("memberInfoProject.selectMemberInfoPersonByID",personalID);
		return personalBaseInfoEntity;
	
		
	}

	 
	@Override
	public CompanyInfoEntity selectMemberInfoCompanByID(long companyID) {
		
		CompanyInfoEntity companyInfoEntity = getSqlSession().selectOne("memberInfoProject.selectMemberInfoCompanByID",companyID);
		return companyInfoEntity;
		
	}

	@Override
	public  ProjectAppRecordEntity selectInvestAvailableaAmount(
			Map<String, Object> map) { 
		
		return getSqlSession().selectOne("projectDetail.selectInvestAvailableaAmount",map);
	  
	}

}

