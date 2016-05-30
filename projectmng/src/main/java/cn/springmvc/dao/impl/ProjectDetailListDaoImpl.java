

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
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 
import cn.springmvc.dao.ProjectDetailListDao;
import cn.springmvc.model.CompanyInfoEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanMemberInfoEntity;
import cn.springmvc.model.LoanRealRepayEntity;
import cn.springmvc.model.LoanRepayEntity;
import cn.springmvc.model.MemberAttestTypeEntity; 
import cn.springmvc.model.PersonalBaseInfoEntity; 
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity; 
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectDetailTYEntity;

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
	public LoanMemberInfoEntity selectMemberInfo(Map<String,Object> map) {
		
		return getSqlSession().selectOne("memberInfoProject.selectMemberInfoByProjectID",map); 
	}
 
	
	
	 
	
	@Override
	public MemberAttestTypeEntity selectMemberAttestByprojectType(long id) {
		
		MemberAttestTypeEntity memberAttestTypeEntity = null;
		memberAttestTypeEntity = getSqlSession().selectOne("projectDetail.selectMemberAttestByprojectType",id);
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
	public ProjectAppProcessEntity selectProjectAppProcess(long id) {
		
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
	public List<ProjectCheckAttachEntity> selectProjectCheckAttach(long projectID) {
		
		List<ProjectCheckAttachEntity>  projectCheckAttachList = null;
		projectCheckAttachList = getSqlSession().selectList("projectCheckAttach.selectProjectCheckAttach",projectID);
		return projectCheckAttachList;
		
	}

	 
	@Override
	public String selectProjectDescript(long projectID) {
		 
		return getSqlSession().selectOne("projectDetail.selectProjectDescript",projectID);
		  
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

	@Override
	public ProjectDetailTYEntity selectProjectdetailByIDbc(long applyId) {
		
		return getSqlSession().selectOne("projectDetail.selectProjectdetailByIDbc",applyId);
		
	}

	@Override
	public List<LoanRepayEntity> selectLoanRealReplayprocess(
			Map<String, Object> map) {
		
		return getSqlSession().selectList("replay.selectLoanRealReplayprocess",map);
		
	}

}

