package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.membermng.model.BlackLimitEntity;
import cn.membermng.model.BlackRecordEntity;
import cn.membermng.model.BorrowingStatistics;
import cn.membermng.model.ComplanyInfoEntity;
import cn.membermng.model.InvitationMembers;
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberAttestInfo;
import cn.membermng.model.MemberBankICardInfos;
import cn.membermng.model.MemberDetaileInfo;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberInvestmentInfo;
import cn.membermng.model.MemberResetPwdEntity;
import cn.membermng.model.MemberThirdInfo;
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MyRecommand;
import cn.membermng.model.TradingTypeEntity;
import cn.membermng.model.VIPMemberInfos;
import cn.springmvc.dao.IMemberManagerReadDao;
import cn.springmvc.dao.IMemberManagerWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MemberManagerWriteDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.IMemberManangerService;


@Service
public class MemberManagerServiceImpl implements IMemberManangerService{
	
	@Resource(name="memberManagerReadDaoImpl")
	public IMemberManagerReadDao memberManagerDao;
	

	@Resource(name="memberManagerWriteDaoImpl")
	public IMemberManagerWriteDao managerWriteDao;
	//日志
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public List<MemberAll> getMembersByParam(PageEntity pageEntity) {
		List<MemberAll> list = memberManagerDao.getMembersByParam(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list; 
				
	}

	
	@Override
	public MemberDetaileInfo memberInfoById(Long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.memberInfoById(param);
	}

	
	@Override
	public ComplanyInfoEntity companyInfo(Long memberId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.companyInfo(param);
	}
	
	
	@Override
	public int pullBlack(Map<String,Object> param ,InsertAdminLogEntity entity,String[] sIpInfo) {

		IdGeneratorUtil idGeneratorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = idGeneratorUtil.GetId();
		param.put("mid", cid);
		int result = managerWriteDao.pullBlack(param);
		if(result == 0){
			idGeneratorUtil.SetIdUsed(cid);
		}else{
			idGeneratorUtil.SetIdUsedFail(cid);
		}
		return result;
	}

	@Override
	public List<VIPMemberInfos> getVIPMemberByParam(PageEntity pageEntity) {
		List<VIPMemberInfos> list=  memberManagerDao.vipMembersByParam(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	
	@Override
	public List<MemberInfo> registers(PageEntity pageEntity) {
		List<MemberInfo> list =memberManagerDao.registers(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	
	@Override
	public List<MemberInfo> authenticationMember(PageEntity entity) {
		List<MemberInfo> list=  memberManagerDao.authenticationMember(entity);
		PageUtil.ObjectToPage(entity, list);
		return list;
	}
	
	@Override
	public List<MemberInfo> loanMember(PageEntity pageEntity) {
		
		List<MemberInfo> list=  memberManagerDao.loanMember(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	
	@Override
	public List<MemberInfo> investmentMember(PageEntity pageEntity) {
		List<MemberInfo>  list = memberManagerDao.investmentMember(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	

	@Override
	public List<MemberInfo> componentMembers(PageEntity pageEntity) {
		List<MemberInfo>  list = memberManagerDao.componentMembers(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	
	@Override
	public List<MemberInfo> blackList(PageEntity pageEntity) {
		List<MemberInfo> list =  memberManagerDao.blackList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public List<MemberBankICardInfos> bankCards(PageEntity entity) {
		
		List<MemberBankICardInfos>  list = memberManagerDao.bankCards(entity);
		PageUtil.ObjectToPage(entity, list);
		return list;
	}
	
	@Override
	public List<InvitationMembers> invitationsByParam(PageEntity entity) {
		List<InvitationMembers>  list =  memberManagerDao.invitationsByParam(entity);
		PageUtil.ObjectToPage(entity, list);
		return list;
	}
	
	@Override
	public MemberInvestmentInfo investment(long memberId, int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberManagerDao.investment(param);
	}
	
	@Override
	public List<MemberAttestInfo> memberConfInfo(long memberId,int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberType", memberType);
		param.put("memberId", memberId);
		return memberManagerDao.memberAttestInfo(param);
	}
	
	@Override
	public MemberThirdInfo memberThirdInfo(long memberId, int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.memberThirdInfo(param);
	}
	
	@Override
	public BorrowingStatistics borrowers(long memberId, int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberManagerDao.borrowers(param);
	}

	@Override
	public List<TradingTypeEntity> memberTradingTypes() {
		return memberManagerDao.memberTradingTypes();
	}


	@Override
	public List<MemberTradingRecordsEntity> memberTradingList(PageEntity entity) {
		return memberManagerDao.memberTradingList(entity);
	}

	@Override
	public void memberResetPwdList(PageEntity entity) {
		List<MemberResetPwdEntity> list  =  memberManagerDao.memberResetPwdList(entity);
		PageUtil.ObjectToPage(entity, list);
	}

	@Override
	public int memberResetPwd(Map<String, Object> param,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("修改密码：会员id  ["+param.get("memberId")+"] ");
		managerWriteDao.memberResetPwd(param);
		int result =(int) param.get("result");
		if(result ==0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result ;
	}


	@Override
	public MyRecommand MyRecommandMan(Map<String, Object> map) {
		return memberManagerDao.MyRecommandMan(map);
	}

	@Override
	public List<MyRecommand> ExceptMyRecommandMan(PageEntity entity) {
		
		List<MyRecommand> list = memberManagerDao.ExceptMyRecommandMan(entity);
		PageUtil.ObjectToPage(entity, list);
		return list;
	}
	@Override
	public void  blackRecord(PageEntity entity){
		List<BlackRecordEntity> list = memberManagerDao.blackRecord(entity);
		PageUtil.ObjectToPage(entity, list);
	}

	@Override
	public int removeBlack(Map<String, Object> param,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("移除黑名单：会员id  ["+param.get("memberId")+"] ");
		managerWriteDao.removeBlack(param);
		int result =(int) param.get("result");
		if(result ==0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result ;
	}

	@Override
	public List<BlackLimitEntity> blackLimtList() {
		return memberManagerDao.blackLimtList();
	}

	@Override
	public int addLimitList(int[] strings, InsertAdminLogEntity entity,
			String[] sIpInfo) {
		entity.setsDetail("添加黑名单受限 ");
		int count = memberManagerDao.countLimit();
		if(count>0){
			managerWriteDao.deleteLimitList();
		}
		int result  = 1;
		if(strings != null){
			 result = managerWriteDao.addLimitList(strings);
		}
		
		if(result >0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result ;
	}

	@Override
	public int getAdminIdByPhone(Map<String, Object> param) {
		return memberManagerDao.getAdminIdByPhone(param);
	}


	@Override
	public int updateAdminPwd(Map<String, Object> param) {
		return managerWriteDao.updateAdminPwd(param);
	}

	@Override
	public List<MemberAttestInfo> selectAuditList(Map<String, Object> map) {
		List<MemberAttestInfo>  list =  memberManagerDao.selectAuditList(map);
		return list;
	}


	@Override
	public int updateMyInvete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return managerWriteDao.updateMyInvete(map);
	}

}
