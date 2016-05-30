

/** 
* @Title: PostLoanManageListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午6:05:04 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.PostLoanManageListDao;
import cn.springmvc.model.PostProjectEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAfterLoanInfoEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ReplayStatisticsEntity;

/** 
 * @author 刘利 
 * @Description: 贷后管理
 * @since 
 * @date 2016-4-15 下午6:05:04  */
@Repository("postLoanManageListDaoImpl")
public class PostLoanManageListDaoImpl extends SqlSessionDaoSupport implements
		PostLoanManageListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<PostProjectEntity> getOverdueCollection(
			PageEntity pageEntity) {

		return getSqlSession().selectList("Post_Loan_Manage.getOverdueCollection",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}
	@Override
	public PostProjectEntity getBillingDetails(Map<String, Object> map) {
		
		return getSqlSession().selectOne("Post_Loan_Manage.getBillingDetails",map);
		
	}
	@Override
	public List<ProjectAfterLoanInfoEntity> selectProjectAfterLoanList(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("ProjectAfterLoanAttach.selectProjectAfterLoanList",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<ProjectAfterLoanInfoEntity> selectProjectAfterLoanFront(
			long applyId) {
		
		return getSqlSession().selectList("ProjectAfterLoanAttach.selectProjectAfterLoanFront",applyId);
		
	}
	@Override
	public List<ProjectAfterLoanAttachmentEntity> selectProjectAfterLoanAttach(
			long infoId) {
		
		return getSqlSession().selectList("ProjectAfterLoanAttach.selectProjectAfterLoanAttach",infoId);
		
	}
	@Override
	public ProjectAfterLoanInfoEntity selectProjectAfterLoandetail(long infoId) {
		
		return getSqlSession().selectOne("ProjectAfterLoanAttach.selectProjectAfterLoandetail",infoId);
		
	}
	@Override
	public List<ProjectAppRecordEntity> getProjectLoanList(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getProjectLoanList",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<ReplayStatisticsEntity> getMaturingBillThiree(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getMaturingBillThiree",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
		
	}
	@Override
	public List<ReplayStatisticsEntity> getLatePayments(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getLate_Payments",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<PostProjectEntity> getLoanRepay(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getLoan_Repay",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<PostProjectEntity> getRepayBillingDetails(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getRepayBillingDetails",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<PostProjectEntity> getMaturingBill(PageEntity pageEntity) {
		
		int type = IntegerAndString.StringToInt(pageEntity.getMap().get("staffType").toString(),0);
		List<PostProjectEntity> PostProjectList = null;
		if(type == 0){
			PostProjectList = getSqlSession().selectList("Post_Loan_Manage.getMaturing_Bill",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		}else if(type == 2)
		{
			PostProjectList = getSqlSession().selectList("Post_Loan_Manage.getMaturing_Bill_2",pageEntity.getMap(),
						new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		}else if(type == 3)
		{
			PostProjectList = getSqlSession().selectList("Post_Loan_Manage.getMaturing_Bill_3",pageEntity.getMap(),
						new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		}
		
		return PostProjectList;
	}
	@Override
	public List<PostProjectEntity> getRepaySettled(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Post_Loan_Manage.getRepaySettled",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public Integer getExpirationReminderSet() {
		
		Integer result = getSqlSession().selectOne("getExpirationReminderSet");
		if(result == null ) {
			result = 0;
		}
		return result;
	}
	
	@Override
	public void GetLoanRepayOverdueInfo(long lId, long[] lResult) {
		
		if(lResult==null || lResult.length<2){
			return;
		}
		String sKey = DbKeyUtil.GetDbCodeKey();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lId", lId);
		param.put("sKey", sKey);
		
		getSqlSession().selectOne("Post_Loan_Manage.GetLoanRepayOverdueInfo", param);
		lResult[0] = IntegerAndString.StringToLong(param.get("lOverdueInterest").toString(), 0);
		lResult[1] = IntegerAndString.StringToLong(param.get("lOverdue").toString(), 0);
		
		param = null;
		
	}

}

