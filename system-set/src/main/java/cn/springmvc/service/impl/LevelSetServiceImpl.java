
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleLeveSetDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectLeveSetDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MemberLevelEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.LevelSetService;
import cn.springmvc.service.QuickRechargeFeeService;



/** 
 * 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午8:13:55  */
@Service("levelSetServiceImpl")
public class LevelSetServiceImpl implements
LevelSetService {
	@Resource(name="selectLeveSetDaoImpl")
	private SelectLeveSetDaoImpl  selectLeveSetDaoImpl;
	@Resource(name="handleLeveSetDaoImpl")
	private HandleLeveSetDaoImpl  handleLeveSetDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<MemberLevelEntity> selectAllMemberLevel(PageEntity pageEntity) {
		
		List<MemberLevelEntity> list = selectLeveSetDaoImpl.selectAllMemberLevel(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public MemberLevelEntity findMemberLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.findMemberLevelById(map);
	}

	@Override
	public List<CreditLevelEntity> selectAllCreditLevel(PageEntity pageEntity) {
		List<CreditLevelEntity> list =  selectLeveSetDaoImpl.selectAllCreditLevel(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public CreditLevelEntity findCreditLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.findCreditLevelById(map);
	}

	@Override
	public int insertMemberLevel(MemberLevelEntity memberLevelEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		memberLevelEntity.setId(id);
		int result =  handleLeveSetDaoImpl.insertMemberLevel(memberLevelEntity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		entity.setsDetail("会员等级添加设置 :"+memberLevelEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}

	@Override
	public int updateMemberLevelById(MemberLevelEntity memberLevelEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("会员等级修改 :"+memberLevelEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.updateMemberLevelById(memberLevelEntity);
	}

	@Override
	public int deleteMemberLevelById(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("会员等级删除 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.deleteMemberLevelById(map);
	}

	@Override
	public int insertCreditLevel(CreditLevelEntity creditLevelEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		creditLevelEntity.setId(id);
		int result =  handleLeveSetDaoImpl.insertCreditLevel(creditLevelEntity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		entity.setsDetail("会员信用等级添加 :"+creditLevelEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}

	@Override
	public int updateCreditLevelById(CreditLevelEntity creditLevelEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("会员信用等级修改 :"+creditLevelEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.updateCreditLevelById(creditLevelEntity);
	}

	@Override
	public int deleteCreditLevelById(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("会员信用等级删除 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.deleteCreditLevelById(map);
	}

	@Override
	public int selectMaxScore() {
		return selectLeveSetDaoImpl.selectMaxScore();
		
	}
}

