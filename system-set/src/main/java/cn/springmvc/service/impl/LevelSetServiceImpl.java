
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleLeveSetDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
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
	@Override
	public List<MemberLevelEntity> selectAllMemberLevel(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.selectAllMemberLevel(pageEntity);
	}

	@Override
	public MemberLevelEntity findMemberLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.findMemberLevelById(map);
	}

	@Override
	public List<CreditLevelEntity> selectAllCreditLevel(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.selectAllCreditLevel(pageEntity);
	}

	@Override
	public CreditLevelEntity findCreditLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectLeveSetDaoImpl.findCreditLevelById(map);
	}

	@Override
	public int insertMemberLevel(MemberLevelEntity memberLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.insertMemberLevel(memberLevelEntity);
	}

	@Override
	public int updateMemberLevelById(MemberLevelEntity memberLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.updateMemberLevelById(memberLevelEntity);
	}

	@Override
	public int deleteMemberLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.deleteMemberLevelById(map);
	}

	@Override
	public int insertCreditLevel(CreditLevelEntity creditLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.insertCreditLevel(creditLevelEntity);
	}

	@Override
	public int updateCreditLevelById(CreditLevelEntity creditLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.updateCreditLevelById(creditLevelEntity);
	}

	@Override
	public int deleteCreditLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleLeveSetDaoImpl.deleteCreditLevelById(map);
	}
}

