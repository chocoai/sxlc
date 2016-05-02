package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import product_p2p.kit.datatrans.IntegerAndString;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectGuaranteeInfoDaoImpl;
import cn.springmvc.model.CompensationStatisticsEntity;
import cn.springmvc.model.GuaranteeAdminEntity;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.InstitutionsRecordsEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.service.GuaranteeInfoService;

/**
 * 保荐机构相关 操作
 * 
 * @author 朱祖轶
 * @Description: TODO
 * @since
 * @date 2016-3-21 下午1:50:51
 */
@Service("guaranteeInfoServiceImpl")
public class GuaranteeInfoServiceImpl implements GuaranteeInfoService {
	@Resource(name = "selectGuaranteeInfoDaoImpl")
	private SelectGuaranteeInfoDaoImpl selectGuaranteeInfoDaoImpl;
	@Resource(name = "handleGuaranteeInfoDaoImpl")
	private HandleGuaranteeInfoDaoImpl handleGuaranteeInfoDaoImpl;
	@Resource(name = "optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;

	IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();

	@Override
	public GuaranteeInfoDetailsEntity selectGuaranteeInfoById(
			Map<String, Object> map) {
		GuaranteeInfoDetailsEntity guaranteeInfoDetailsEntity = new GuaranteeInfoDetailsEntity();
		GuaranteeInfoEntity guaranteeInfoEntity = new GuaranteeInfoEntity();
		guaranteeInfoEntity = selectGuaranteeInfoDaoImpl
				.selectGuaranteeInfoById(map);
		guaranteeInfoDetailsEntity.setGuaranteeInfoEntity(guaranteeInfoEntity);
		guaranteeInfoDetailsEntity
				.setlBorrowingEntities(selectGuaranteeInfoDaoImpl
						.selectGuaranteeBorrowing(map));
		guaranteeInfoDetailsEntity
				.setlCertificateEntities(selectGuaranteeInfoDaoImpl
						.selectGuaranteeCertificate(map));
		guaranteeInfoDetailsEntity
				.setlGuaranteePeriodEntities(selectGuaranteeInfoDaoImpl
						.selectGuaranteePeriod(map));
		guaranteeInfoDetailsEntity
				.setlGuaranteeRelationalEntities(selectGuaranteeInfoDaoImpl
						.selectGuaranteeRelational(map));
		CompensationStatisticsEntity co=selectGuaranteeInfoDaoImpl.CompensationStatistics(map);
		if (co!=null) {
			co.setNoCompensatoryPayment(co.getAllCompensatoryPayment()-co.getTotalCompensationAmount());
		}
		guaranteeInfoDetailsEntity.setCompensationStatisticsEntity(co);
		// TODO Auto-generated method stub return null;
		return guaranteeInfoDetailsEntity;
	}

	@Override
	public List<GuaranteeInfoEntity> selectAllGuaranteeInfo(
			PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		List<GuaranteeInfoEntity> list = selectGuaranteeInfoDaoImpl.selectAllGuaranteeInfo(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
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
	public int handleGuaranteeInfo(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		int type = IntegerAndString
				.StringToInt(map.get("types").toString(), -1);
		long guaranteeID = generatorUtil.GetId();
		long personalId = generatorUtil.GetId();
		map.put("guaranteeID", guaranteeID);
		map.put("personalId", personalId);
		if (type == 0) {
			entity.setsDetail("添加担保机构信息  :" + map.toString());
		} else {
			entity.setsDetail("修改担保机构信息  :" + map.toString());
		}

		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;result 0:成功 -1：担保机构名称存在
		// -2：营业执照号已存在
		handleGuaranteeInfoDaoImpl.handleGuaranteeInfo(map);
		int result = IntegerAndString.StringToInt(map.get("result").toString(),
				-1);
		if (result == 0 && type == 0) {
			generatorUtil.SetIdUsed(guaranteeID);
			generatorUtil.SetIdUsed(personalId);
		} else {
			generatorUtil.SetIdUsedFail(guaranteeID);
			generatorUtil.SetIdUsedFail(personalId);
		}
		return result;
	}

	@Override
	public int deleteOrStopGuaranteeInfo(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("删除或启用停用 担保机构  :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteOrStopGuaranteeInfo(map);
	}

	@Override
	public int insertGuaranteeCertificate(
			List<ManagementCertificateEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加担保机构证件  :" + list.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeCertificate(list);
	}

	@Override
	public int deleteGuaranteeCertificate(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据担保机构id删除所有证件信息  :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteGuaranteeCertificate(map);
	}

	@Override
	public int deleteOrStopManagementInfo(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据资产管理方id 删除或启用停用资产管理方  :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteOrStopManagementInfo(map);
	}

	@Override
	public Map<String, Object> handleManagementInfo(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加或修改资产管理方信息 :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleGuaranteeInfoDaoImpl.handleManagementInfo(map);
	}

	@Override
	public int insertManagementCertificate(
			List<ManagementCertificateEntity> entities,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加资产管理方证件:" + entities.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertManagementCertificate(entities);
	}

	@Override
	public int deleteManagementCertificate(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据资产管理方id删除所有证件信息:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
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
	public int insertGuaranteeBorrowing(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加担保机构担保借款范围:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeBorrowing(map);
	}

	@Override
	public int updateGuaranteeBorrowingByID(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据保荐机构id修改担保机构担保借款范围:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteeBorrowingByID(map);
	}

	@Override
	public int insertGuaranteePeriod(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加担保机构期限范围:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteePeriod(map);
	}

	@Override
	public int updateGuaranteePeriodByID(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据保荐机构id,期限类型修改担保机构担保借款范围" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteePeriodByID(map);
	}

	@Override
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加担保机构担保类型:" + list.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeRelational(list);
	}

	@Override
	public int deleteGuaranteeRelationalByID(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据担保机构id删除担保机构担保类型 :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.deleteGuaranteeRelationalByID(map);
	}

	@Override
	public List<GuaranteeAdminEntity> findGuaranteeAdmin(PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.findGuaranteeAdmin(pageEntity);
	}

	@Override
	public int insertGuaranteeAdmin(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {

		// TODO Auto-generated method stub return 0;
		entity.setsDetail("添加担保机构管理员 :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeAdmin(map);
	}

	@Override
	public int updateGuaranteeAdmin(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {

		// TODO Auto-generated method stub return 0;
		entity.setsDetail("启用禁用担保机构管理员(statu:1:启用 0：停用) :" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteeAdmin(map);
	}

	@Override
	public List<InstitutionsRecordsEntity> InstitutionsToRaiseCashRecords(
			PageEntity pageEntity) {
		// pageEntity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl
				.InstitutionsToRaiseCashRecords(pageEntity);
	}
}
