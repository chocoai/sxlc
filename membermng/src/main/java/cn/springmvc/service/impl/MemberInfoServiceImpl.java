package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.CompanyInfo;
import cn.membermng.model.IntegralRecords;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.PersonalBaseInfo;
import cn.membermng.model.RadPackage;
import cn.springmvc.dao.IMemberReadDao;
import cn.springmvc.dao.IMemberWriteDao;
import cn.springmvc.service.IMemberService;

@Service
public class MemberInfoServiceImpl implements IMemberService{
	
	@Resource(name="memberInfoReadDaoImpl")
	private IMemberReadDao memberDao;
	
	@Resource(name="memberInfoWriteDaoImpl")
	private IMemberWriteDao memberWriteDao;
	
	
	
	@Override
	public int individualMember(MemberInfo member,PersonalBaseInfo baseInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("skey", 		DbKeyUtil.GetDbCodeKey());
		param.put("mid", 		member.getId());
		param.put("memberNo", member.getMemberNo());
		param.put("lognName", 	member.getLogname());
		param.put("personalPhone", baseInfo.getPersonalPhone());
		param.put("personalPwd", member.getMemberPwd());
		param.put("beinvitateCode", member.getBeinvitateCode());
		param.put("invitateCode", member.getInvitateCode());
		param.put("memberType", member.getMemberType());
		param.put("result", 1);
		return memberWriteDao.individualMember(param);
	}

	
	@Override
	public int corporateMember(MemberInfo member,CompanyInfo companyInfo) {
		
		
		
		return 0;
	}



	
	
	@Override
	public int login(String userName, String password, int userType,String ipAddress,String[] ipInfo,String sourceUrl) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("skey", 				DbKeyUtil.GetDbCodeKey());
		param.put("userName", 			userName);
		param.put("userPwd", 			password);
		param.put("userType", 			userType);
		param.put("ipaddress", 			ipAddress);
		param.put("scountry", 			ipInfo[0]);
		param.put("sregion", 			ipInfo[1]);
		param.put("sprovince",			ipInfo[2]);
		param.put("scity",				ipInfo[3]);
		param.put("sarea", 				ipInfo[4]);
		param.put("ISP", 				ipInfo[5]);
		param.put("sourceUrl", 			sourceUrl);
		param.put("result", 			1);
		return memberWriteDao.login(param);
	}

	
	
	
	@Override
	public int chechPhone(String phone) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("phone", phone);
		return memberDao.countPhone(param);
	}


	
	
	@Override
	public int countName(String userName) {

		return memberDao.countName(userName);
	}



	
	@Override
	public int countInvitateCode(String invitateCode) {

		return memberDao.countInvitateCode(invitateCode);
	}
	

	@Override
	public MemberInfo memberPersonalInfo(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberDao.memberPersonalInfo(param);
	}
	
	
	@Override
	public int editMemberPersonalInfo(long memberId,int sexid, String qqNumber,String homeTown, String currAddress, int provinceId, int cityId,int countyId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", memberId);
		param.put("sexId", sexid);
		param.put("qqNumber", qqNumber);
		param.put("address", currAddress);
		param.put("homeTown", homeTown);
		param.put("provinceId", provinceId);
		param.put("cityId", cityId);
		param.put("countyId", countyId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberWriteDao.editMemberPersonalInfo(param);
	}
	
	
	
	
	@Override
	public MemberInfo memberComplanyInfo(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return memberDao.memberComplanyInfo(param);
	}
	
	
	@Override
	public int editMemberComplanyInfo(long memberId,int provinceId, int cityId, int countyId,String contactsName,
			String contactsPhone, String contactQQ,String contactEmail, String companyProfile) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", memberId);
		param.put("provinceId", provinceId);
		param.put("cityId", cityId);
		param.put("countyId", countyId);
		param.put("contactsName", contactsName);
		param.put("contactsPhone", contactsPhone);
		param.put("contactsQQ", contactQQ);
		param.put("contactsEmail", contactEmail);
		param.put("companyProfile", companyProfile);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return memberWriteDao.editMemberComplanyInfo(param);
	}
	
	
	@Override
	public List<MemberInfo> friendInvitation(PageEntity entity) {
		
		return memberDao.friendInvitation(entity);
	}
	
	
	@Override
	public Map<String, Object> points(long memberId,int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberDao.points(param);
	}
	
	@Override
	public List<IntegralRecords> addPoints(PageEntity entity) {
		
		return memberDao.addPoints(entity);
	}
	
	
	
	
	
	@Override
	public MyRedPackage myRedpackage(int memberType, long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberDao.myRedPackage(param);
	}
	
	@Override
	public List<RadPackage> redPackages(PageEntity entity) {
		
		return memberDao.redPackages(entity);
	}
	
	
	@Override
	public MemberVouchers myVouchers(long memberId, int memberType) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		return memberDao.myVouchers(param);
	}
	
	
	@Override
	public List<MemberVouchers> vouchers(PageEntity entity) {
		
		return memberDao.vouchers(entity);
	}
	
	
}
