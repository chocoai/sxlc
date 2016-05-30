package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectGuaranteeInfoDaoImpl;
import cn.springmvc.model.AdminGMEntity;
import cn.springmvc.model.CompensationStatisticsEntity;
import cn.springmvc.model.GuaranteeAdminEntity;
import cn.springmvc.model.GuaranteeBankCard;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.InstitutionsRecordsEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.model.MemberThirdAuthInfoEntity;
import cn.springmvc.model.OverdueCompensationEntity;
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
		CompensationStatisticsEntity co = selectGuaranteeInfoDaoImpl
				.CompensationStatistics(map);
		if (co != null) {
			co.setNoCompensatoryPayment(co.getAllCompensatoryPayment()
					- co.getTotalCompensationAmount());
		}
		guaranteeInfoDetailsEntity.setCompensationStatisticsEntity(co);
		guaranteeInfoDetailsEntity
				.setMemberThirdAuthInfoEntity(selectGuaranteeInfoDaoImpl
						.selectMemberThirdAuthInfoone(map));
		// TODO Auto-generated method stub return null;
		return guaranteeInfoDetailsEntity;
	}

	@Override
	public List<GuaranteeInfoEntity> selectAllGuaranteeInfo(
			PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		List<GuaranteeInfoEntity> list = selectGuaranteeInfoDaoImpl
				.selectAllGuaranteeInfo(pageEntity);
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
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectManagementInfoById(map);
	}

	@Override
	public List<ManagementInfoEntity> selectAllManagementInfo(
			PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		List<ManagementInfoEntity> list = selectGuaranteeInfoDaoImpl
				.selectAllManagementInfo(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
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
		
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		long guaranteeID = generatorUtil.GetId();
		long personalId = generatorUtil.GetId();
		if (type == 0) {
			map.put("guaranteeID", guaranteeID);
			map.put("personalId", personalId);
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
	public int insertGuaranteeCertificate(long guaranteeID,
			List<ManagementCertificateEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加担保机构证件  :" + list.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("guaranteeID", guaranteeID);
		handleGuaranteeInfoDaoImpl.deleteGuaranteeCertificate(map);
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
	public int handleManagementInfo(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		int type = IntegerAndString
				.StringToInt(map.get("types").toString(), -1);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		long guaranteeID = generatorUtil.GetId();
		long personalId = generatorUtil.GetId();
		if (type == 0) {
			map.put("managementID", guaranteeID);
			map.put("personalId", personalId);
			entity.setsDetail("添加资产管理方信息  :" + map.toString());
		} else {
			entity.setsDetail("修改资产管理方信息  :" + map.toString());
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;

		handleGuaranteeInfoDaoImpl.handleManagementInfo(map);
		int num = IntegerAndString
				.StringToInt(map.get("result").toString(), -1);
		if (num == 0 && type == 0) {
			generatorUtil.SetIdUsed(guaranteeID);
			generatorUtil.SetIdUsed(personalId);
		} else {
			generatorUtil.SetIdUsedFail(guaranteeID);
			generatorUtil.SetIdUsedFail(personalId);
		}
		return num;
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
	public int insertGuaranteeBorrowing(long guaranteeID,List<GuaranteeRelationalEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("设置担保机构担保借款范围:" + list.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("guaranteeID", guaranteeID);
		handleGuaranteeInfoDaoImpl.updateGuaranteeBorrowingByID(map);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeBorrowing(list);
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
	public int insertGuaranteePeriod(long guaranteeID,List<GuaranteePeriodEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("设置担保机构期限范围:" + list.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("guaranteeID", guaranteeID);
		handleGuaranteeInfoDaoImpl.updateGuaranteePeriodByID(map);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteePeriod(list);
	}

	@Override
	public int updateGuaranteePeriodByID(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("根据保荐机构id,期限类型修改担保机构担保期限范围" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateGuaranteePeriodByID(map);
	}

	@Override
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list,
			InsertAdminLogEntity entity, String[] sIpInfo, Map<String, Object> map) {
		int num = new GuaranteeInfoServiceImpl().deleteGuaranteeRelationalByID(map, entity, sIpInfo);
		if (num == 1) {
			entity.setsDetail("添加担保机构担保类型:" + list.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
			// TODO Auto-generated method stub return 0;
			return handleGuaranteeInfoDaoImpl.insertGuaranteeRelational(list);
		}else {
			return 0;
		}
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
		List<GuaranteeAdminEntity> list = selectGuaranteeInfoDaoImpl
				.findGuaranteeAdmin(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public int insertGuaranteeAdmin(long staffId,String adminName,String adminPwd,String adminRemark,int stype,
			InsertAdminLogEntity entity, String[] sIpInfo) {

		if (stype==1) {
			entity.setsDetail("添加担保机构管理员 :管理员名称:" + adminName+"管理员密码:"+adminPwd+"管理员描述:"+adminRemark+"担保机构id:"+staffId);
		}else {
			entity.setsDetail("添加资产管理方管理员 :管理员名称:" + adminName+"管理员密码:"+adminPwd+"管理员描述:"+adminRemark+"资产管理方id:"+staffId);
		}
		
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertGuaranteeAdmin(staffId, adminName, adminPwd, adminRemark, stype);
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
		 pageEntity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		// TODO Auto-generated method stub return null;
		List<InstitutionsRecordsEntity> list = selectGuaranteeInfoDaoImpl
				.InstitutionsToRaiseCashRecords(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public MemberThirdAuthInfoEntity selectMemberThirdAuthInfoone(
			Map<String, Object> map) {

		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectMemberThirdAuthInfoone(map);
	}

	@Override
	public List<GuaranteeAdminEntity> findManagementAdmin(PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		List<GuaranteeAdminEntity> list = selectGuaranteeInfoDaoImpl
				.findManagementAdmin(pageEntity);

		PageUtil.ObjectToPage(pageEntity, list);

		return list;
	}

	@Override
	public int insertManagementAdmin(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {

		// TODO Auto-generated method stub return 0;
		entity.setsDetail("添加资产管理方管理员:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.insertManagementAdmin(map);
	}

	@Override
	public int updateManagementAdmin(Map<String, Object> map,
			InsertAdminLogEntity entity, String[] sIpInfo) {

		// TODO Auto-generated method stub return 0;
		entity.setsDetail("启用禁用资产管理方管理员:" + map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateManagementAdmin(map);
	}

	@Override
	public List<OverdueCompensationEntity> Overduecompensation(
			PageEntity pageEntity) {

		// TODO Auto-generated method stub return null;
		List<OverdueCompensationEntity> list = selectGuaranteeInfoDaoImpl
				.Overduecompensation(pageEntity);

		PageUtil.ObjectToPage(pageEntity, list);

		return list;
	}
	@Override
	public List<OverdueCompensationEntity> PtOverduecompensation(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		List<OverdueCompensationEntity> list = selectGuaranteeInfoDaoImpl
				.PtOverduecompensation(pageEntity);

		PageUtil.ObjectToPage(pageEntity, list);

		return list;
	}
	@Override
	public List<OverdueCompensationEntity> PaymentOverduecompensation(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		List<OverdueCompensationEntity> list = selectGuaranteeInfoDaoImpl
				.PaymentOverduecompensation(pageEntity);

		PageUtil.ObjectToPage(pageEntity, list);

		return list;
	}
	@Override
	public List<GuaranteeBankCard> findbankcardforguaranteeID(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		// TODO Auto-generated method stub return null;
		List<GuaranteeBankCard> list = selectGuaranteeInfoDaoImpl
				.findbankcardforguaranteeID(pageEntity);

		PageUtil.ObjectToPage(pageEntity, list);

		return list;
	}
	@Override
	public int updateMGAdmin(String adminName, String adminPwd,
			String adminRemark, long adminId) {
		
		// TODO Auto-generated method stub return 0;
		return handleGuaranteeInfoDaoImpl.updateMGAdmin(adminName, adminPwd, adminRemark, adminId);
	}
	@Override
	public AdminGMEntity selectAdmin(long adminID) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.selectAdmin(adminID);
	}
	@Override
	public OverdueCompensationEntity OverduecompensationByid(long repayID) {
		
		// TODO Auto-generated method stub return null;
		return selectGuaranteeInfoDaoImpl.OverduecompensationByid(repayID);
	}
}
