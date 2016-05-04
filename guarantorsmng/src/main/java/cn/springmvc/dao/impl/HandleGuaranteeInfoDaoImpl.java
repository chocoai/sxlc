
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.HandleGuaranteeInfoDao;
import cn.springmvc.dao.SelectGuaranteeInfoDao;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;



/** 
 * 保荐机构相关操作实现
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午11:46:13  */
@Component("handleGuaranteeInfoDaoImpl")
public class HandleGuaranteeInfoDaoImpl extends SqlSessionDaoSupport implements HandleGuaranteeInfoDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Map<String, Object> handleGuaranteeInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("GuaranteeInfoXML.handleGuaranteeInfo", map);
		return map;
	}

	@Override
	public int deleteOrStopGuaranteeInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("GuaranteeInfoXML.deleteOrStopGuaranteeInfo",map);
	}

	@Override
	public int insertGuaranteeCertificate(List<ManagementCertificateEntity> list) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertGuaranteeCertificate", list);
	}

	@Override
	public int deleteGuaranteeCertificate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("GuaranteeInfoXML.deleteGuaranteeCertificate", map);
	}

	@Override
	public int deleteOrStopManagementInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return  getSqlSession().update("GuaranteeInfoXML.deleteOrStopManagementInfo",map);
	}

	@Override
	public Map<String, Object> handleManagementInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("GuaranteeInfoXML.handleManagementInfo",map);
		return map;
	}

	@Override
	public int insertManagementCertificate(
			List<ManagementCertificateEntity> entities) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertManagementCertificate", entities);
	}

	@Override
	public int deleteManagementCertificate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("GuaranteeInfoXML.deleteManagementCertificate", map);
	}

	@Override
	public int insertGuaranteeBorrowing(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertGuaranteeBorrowing", map);
	}

	@Override
	public int updateGuaranteeBorrowingByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("GuaranteeInfoXML.updateGuaranteeBorrowingByID", map);
	}

	@Override
	public int insertGuaranteePeriod(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertGuaranteePeriod", map);
	}

	@Override
	public int updateGuaranteePeriodByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("GuaranteeInfoXML.updateGuaranteePeriodByID", map);
	}

	@Override
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertGuaranteeRelational", list);
	}

	@Override
	public int deleteGuaranteeRelationalByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("GuaranteeInfoXML.deleteGuaranteeRelationalByID", map);
	}


	@Override
	public int insertGuaranteeAdmin(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertGuaranteeAdmin", map);
	}
	@Override
	public int updateGuaranteeAdmin(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("GuaranteeInfoXML.updateGuaranteeAdmin",map);
	}
	@Override
	public int insertManagementAdmin(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("GuaranteeInfoXML.insertManagementAdmin", map);
	}
	@Override
	public int updateManagementAdmin(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("GuaranteeInfoXML.updateManagementAdmin",map);
	}
}

