
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectGuaranteeInfoDao;
import cn.springmvc.model.CompensationStatisticsEntity;
import cn.springmvc.model.GuaranteeAdminEntity;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.InstitutionsRecordsEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;



/** 
 * 保荐机构相关查询实现
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午11:46:13  */
@Component("selectGuaranteeInfoDaoImpl")
public class SelectGuaranteeInfoDaoImpl extends SqlSessionDaoSupport implements SelectGuaranteeInfoDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	/* *  *  * @param map
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectGuaranteeInfoById(java.util.Map) */
	@Override
	public GuaranteeInfoEntity selectGuaranteeInfoById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("GuaranteeInfoXML.selectGuaranteeInfoById",map);
	}

	
	/* *  *  * @param pageEntity
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectAllGuaranteeInfo(product_p2p.kit.pageselect.PageEntity) */
	@Override
	public List<GuaranteeInfoEntity> selectAllGuaranteeInfo(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectAllGuaranteeInfo", pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}

	
	/* *  *  * @param map
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectGuaranteeCertificate(java.util.Map) */
	@Override
	public List<GuaranteeCertificateEntity> selectGuaranteeCertificate(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectGuaranteeCertificate",map);
	}

	
	/* *  *  * @param map
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectManagementInfoById(java.util.Map) */
	@Override
	public ManagementInfoEntity selectManagementInfoById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("GuaranteeInfoXML.selectManagementInfoById", map);
	}

	
	/* *  *  * @param pageEntity
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectAllManagementInfo(product_p2p.kit.pageselect.PageEntity) */
	@Override
	public List<ManagementInfoEntity> selectAllManagementInfo(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectAllManagementInfo", pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}

	
	/* *  *  * @param map
	/* *  *  * @return * @see cn.springmvc.dao.SelectGuaranteeInfoDao#selectManagementCertificate(java.util.Map) */
	@Override
	public List<ManagementCertificateEntity> selectManagementCertificate(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectManagementCertificate",map);
	}


	@Override
	public List<GuaranteeBorrowingEntity> selectGuaranteeBorrowing(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectGuaranteeBorrowing",map);
	}


	@Override
	public List<GuaranteePeriodEntity> selectGuaranteePeriod(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectGuaranteePeriod",map);
	}


	@Override
	public List<GuaranteeRelationalEntity> selectGuaranteeRelational(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectGuaranteeRelational",map);
	}
	
	@Override
	public List<GuaranteeAdminEntity> findGuaranteeAdmin(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.findGuaranteeAdmin", pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}
	@Override
	public List<InstitutionsRecordsEntity> InstitutionsToRaiseCashRecords(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("GuaranteeInfoXML.selectAllGuaranteeInfo", pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}
	@Override
	public CompensationStatisticsEntity CompensationStatistics(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("GuaranteeInfoXML.CompensationStatistics",map);
	}
}

