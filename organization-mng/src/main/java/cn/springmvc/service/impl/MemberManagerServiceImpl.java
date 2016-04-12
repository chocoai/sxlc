package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.Util.StringUtils;
import cn.springmvc.dao.IMemberManagerReadDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.BorrowingStatistics;
import cn.springmvc.model.InvitationMembers;
import cn.springmvc.model.MemberAttestInfo;
import cn.springmvc.model.MemberBankICardInfos;
import cn.springmvc.model.MemberDetaileInfo;
import cn.springmvc.model.MemberInfo;
import cn.springmvc.model.MemberInvestmentInfo;
import cn.springmvc.model.MemberThirdInfo;
import cn.springmvc.model.VIPMemberInfos;
import cn.springmvc.service.IMemberManangerService;


@Service
public class MemberManagerServiceImpl implements IMemberManangerService{
	
	@Resource(name="memberManagerReadDaoImpl")
	public IMemberManagerReadDao memberManagerDao;
	
	

	@Override
	public List<MemberInfo> getMembersByParam(PageEntity pageEntity) {
		
		
		return memberManagerDao.getMembersByParam(pageEntity);
	}

	@Override
	public MemberDetaileInfo memberInfoById(Long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.memberInfoById(param);
	}

	@Override
	public int pullBlack(Long id, Long memberId, String mac, String ipaddress,String referer,String sessionId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("aid", id);
		param.put("memberId", memberId);
		IdGeneratorUtil idGeneratorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = idGeneratorUtil.GetId();
		param.put("mid", cid);
		param.put("umac", mac);
		param.put("ipaddress", ipaddress);
		param.put("linkUrl", referer);
		param.put("sessionId", sessionId);
		int result = memberManagerDao.pullBlack(param);
		if(result == 0){
			idGeneratorUtil.SetIdUsed(cid);
		}else{
			idGeneratorUtil.SetIdUsedFail(cid);
		}
		return result;
	}

	@Override
	public List<VIPMemberInfos> getVIPMemberByParam(String userName,String memberName, String phone) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName",userName);
		param.put("memberName", memberName);
		param.put("phone", phone);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.vipMembersByParam(param);
	}
	
	@Override
	public List<MemberInfo> registers(String memberName, String userName,String phone, String idCard, String regDate, Integer regType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberName", memberName);
		param.put("userName", userName);
		param.put("phone", phone);
		param.put("idCard", idCard);
		param.put("regDate", regDate);
		param.put("regType", regType);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.registers(param);
	}
	
	@Override
	public List<MemberInfo> authenticationMember(String memberName,String userName, String phone, String idCard, String regDate,String endDate) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberName", memberName);
		param.put("userName", userName);
		param.put("phone", phone);
		param.put("idCard", idCard);
		param.put("regDate", regDate);
		if(endDate == null || endDate.trim().length() == 0){
			endDate = StringUtils.fromString();
		}
		param.put("endDate", endDate);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.authenticationMember(param);
	}
	
	@Override
	public List<MemberInfo> loanMember(String memberName, String userName,String phone) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberName", memberName);
		param.put("userName", userName);
		param.put("phone", phone);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return memberManagerDao.loanMember(param);
	}
	
	@Override
	public List<MemberInfo> investmentMember(String memberName,String userName, String phone, String escrowAccount) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberName", memberName);
		param.put("userName", userName);
		param.put("phone", phone);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.investmentMember(param);
	}
	
	@Override
	public List<MemberInfo> blackList(String userName, String memberName,String phone, String startTime, String endTime) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		param.put("memberName", memberName);
		param.put("phone", phone);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberManagerDao.blackList(param);
	}

	@Override
	public List<MemberBankICardInfos> bankCards(PageEntity entity) {
		
		return memberManagerDao.bankCards(entity);
	}
	
	@Override
	public List<InvitationMembers> invitationsByParam(PageEntity entity) {
		return memberManagerDao.invitationsByParam(entity);
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
		return memberManagerDao.memberThirdInfo(param);
	}
	
	@Override
	public BorrowingStatistics borrowers(long memberId, int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberManagerDao.borrowers(param);
	}
}
