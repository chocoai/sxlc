
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.impl.HandleGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.SelectGuaranteeInfoDaoImpl;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.service.GuaranteeInfoService;



/** 
 * 保荐机构相关 操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 下午1:50:51  */
@Service("guaranteeInfoServiceImpl")
public class GuaranteeInfoServiceImpl implements
 GuaranteeInfoService {
	@Resource(name="selectGuaranteeInfoDaoImpl")
	private SelectGuaranteeInfoDaoImpl  selectGuaranteeInfoDaoImpl;
	@Resource(name="handleGuaranteeInfoDaoImpl")
	private HandleGuaranteeInfoDaoImpl  handleGuaranteeInfoDaoImpl;
	
	@Override
	public GuaranteeInfoEntity selectGuaranteeInfoById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectGuaranteeInfoById(map);
	}

	@Override
	public List<GuaranteeInfoEntity> selectAllGuaranteeInfo(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectAllGuaranteeInfo(pageEntity);
	}

	@Override
	public List<GuaranteeCertificateEntity> selectGuaranteeCertificate(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectGuaranteeCertificate(map);
	}

	@Override
	public ManagementInfoEntity selectManagementInfoById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectManagementInfoById(map);
	}

	@Override
	public List<ManagementInfoEntity> selectAllManagementInfo(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectAllManagementInfo(pageEntity);
	}

	@Override
	public List<ManagementCertificateEntity> selectManagementCertificate(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectManagementCertificate(map);
	}

	@Override
	public Map<String, Object> handleGuaranteeInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return handleGuaranteeInfoDaoImpl.handleGuaranteeInfo(map);
	}

	@Override
	public int deleteOrStopGuaranteeInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteOrStopGuaranteeInfo(map);
	}

	@Override
	public int insertGuaranteeCertificate(List<ManagementCertificateEntity> list) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeCertificate(list);
	}

	@Override
	public int deleteGuaranteeCertificate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteGuaranteeCertificate(map);
	}

	@Override
	public int deleteOrStopManagementInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteOrStopManagementInfo(map);
	}

	@Override
	public Map<String, Object> handleManagementInfo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return handleGuaranteeInfoDaoImpl.handleManagementInfo(map);
	}

	@Override
	public int insertManagementCertificate(
			List<ManagementCertificateEntity> entities) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertManagementCertificate(entities);
	}

	@Override
	public int deleteManagementCertificate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteManagementCertificate(map);
	}

	@Override
	public List<GuaranteeBorrowingEntity> selectGuaranteeBorrowing(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectGuaranteeBorrowing(map);
	}

	@Override
	public List<GuaranteePeriodEntity> selectGuaranteePeriod(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectGuaranteePeriod(map);
	}

	@Override
	public List<GuaranteeRelationalEntity> selectGuaranteeRelational(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectGuaranteeRelational(map);
	}

	@Override
	public int insertGuaranteeBorrowing(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeBorrowing(map);
	}

	@Override
	public int updateGuaranteeBorrowingByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteeBorrowingByID(map);
	}

	@Override
	public int insertGuaranteePeriod(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteePeriod(map);
	}

	@Override
	public int updateGuaranteePeriodByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteePeriodByID(map);
	}

	@Override
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeRelational(list);
	}

	@Override
	public int deleteGuaranteeRelationalByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteGuaranteeRelationalByID(map);
	}

}

