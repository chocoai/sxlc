package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import cn.membermng.model.BorrowingType;
import cn.membermng.model.BorrowingTypeInfo;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.RealNameAuth;
import cn.springmvc.dao.IBorrowingCertificationReadDao;
import cn.springmvc.dao.IBorrowingCertificationWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.IBorrowingCertificationServer;


/***
* 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-23 上午11:33:11 
*
*
*/
@Service
public class BorrowingCertificationServerImpl implements IBorrowingCertificationServer{
	
	@Resource(name="borrowingCertificationReadDaoImpl")
	private IBorrowingCertificationReadDao borrowingCertificationdao;
	
	@Resource(name="borrowingCertificationWriteDaoImpl")
	private IBorrowingCertificationWriteDao borrowingCertificationWritedao;
	
	@Override
	public List<BorrowingType> getAllByMember(int memberType, long memberId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberType", memberType);
		param.put("memberId", memberId);
		return borrowingCertificationdao.getAllByMember(param);
	}
	
	@Override
	public int authRealName(Long mid, String realName, Integer sex,Integer national, String idCard, String birthplace,String positive, String reverse,String endTime) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = generatorUtil.GetId();
		param.put("cid", cid);
		param.put("mid", mid);
		param.put("realName", realName);
		param.put("sex", sex);
		param.put("nation", national);
		param.put("idCard", idCard);
		param.put("homeTown", birthplace);
		param.put("positive", positive);
		param.put("reverse", reverse);
		param.put("endTime", endTime+" 23:59:59");
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("result", 1);
		
		int result = borrowingCertificationWritedao.autnRealName(param);
		if (result == 0) {
			generatorUtil.SetIdUsed(result);
		}else {
			generatorUtil.SetIdUsedFail(result);
		}
		return result;
	}

	@Override
	public RealNameAuth showAuthRealName(Long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		RealNameAuth realNameAuth = borrowingCertificationdao.showAuthRealName(param);
		if(realNameAuth == null){
			realNameAuth = new RealNameAuth();
			realNameAuth.setStatus(0);//未认证
		}
		return realNameAuth;
	}
	

	@Override
	public int editAuthRealName(Long mid, String realName, Integer sex, Integer national,String idCard, String birthplace, String positive, String reverse) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("mid", mid);
		param.put("realName", realName);
		param.put("sex", sex);
		param.put("nation", national);
		param.put("idCard", idCard);
		param.put("homeTown", birthplace);
		param.put("positive", positive);
		param.put("reverse", reverse);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return borrowingCertificationWritedao.editAuthRealName(param);
	}
	
	
	
	
	@Override
	public int currencyAuth(Long mid, Integer memberType, String enclosure,String endTime, Integer typeId) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil idGeneratorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = idGeneratorUtil.GetId();
		param.put("cid", cid);
		param.put("mid", mid);
		param.put("memberType", memberType);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("typeId", typeId);
		
		int result =  borrowingCertificationWritedao.currencyAuth(param);
	
		if(result == 0){
			idGeneratorUtil.SetIdUsed(cid);
		}else{
			idGeneratorUtil.SetIdUsedFail(cid);
		}
		return result;
	}

	@Override
	public CurrencyAuth showCurrencyAuth(Long memberId,int memberType,int typeId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("memberType", memberType);
		param.put("typeId", typeId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showCurrencyAuth(param);
	}
	
	@Override
	public int editCurrencyAuth(Long mid, Integer memberType,String enclosure, String endTime, int typeId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("mid", mid);
		param.put("memberType", memberType);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("typeId", typeId);
		
		int result = borrowingCertificationWritedao.editCurrencyAuth(param);
		return result;
	}
	
	
	
	
	
	@Override
	public int authAddress(Long mid, String address, String endTime,String enclosure) {
		Map<String,Object> parma = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = generatorUtil.GetId();
		parma.put("cid", cid);
		parma.put("mid", mid);
		parma.put("address", address);
		parma.put("endTime", endTime);
		parma.put("enclosure", enclosure);
		parma.put("skey", DbKeyUtil.GetDbCodeKey());
		int result = borrowingCertificationWritedao.authAddress(parma);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public CurrencyAuth showAuthAddress(Long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return borrowingCertificationdao.showAuthAddress(param);
	}
	
	@Override
	public int editAuthAddress(long memberId, String address,String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("mid", memberId);
		param.put("address", address);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		int result = borrowingCertificationWritedao.editAuthAddress(param);
		return result;
	}
	
	
	
	

	@Override
	public int authHousing(Long mid, String iaddress, String iArea,
			String ivalue, String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String,Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = generatorUtil.GetId();
		param.put("cid", cid);
		param.put("mid", mid);
		param.put("iaddress", iaddress);
		param.put("iArea", iArea);
		param.put("ivalue", ivalue);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("result", 1);
		int result = borrowingCertificationWritedao.authHousing(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public List<CurrencyAuth> showAuthHousing(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showAuthHousing(param);
	}
	
	
	@Override
	public CurrencyAuth showAuthHousingOne(long rid) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("rid", rid);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showAuthHousingOne(param);
	}
	
	
	@Override
	public int editAuthHousing(long memberId, long cid, String iaddress,String iArea, String ivalue, String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("cid", cid);
		param.put("mid", memberId);
		param.put("iaddress", iaddress);
		param.put("iArea", iArea);
		param.put("ivalue", ivalue);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("result", 1);
		return borrowingCertificationWritedao.editAuthHousing(param);
	}	


	
	
	
	
	
	
	@Override
	public int authProduction(Long mid, String iBrand, String iModel,String iLicensePlate, 
			String ivalue, String endTime,String enclosure) {
		
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long cid = generatorUtil.GetId();
		
		param.put("cid", cid);
		param.put("mid", mid);
		param.put("iBrand", iBrand);
		param.put("iModel", iModel);
		param.put("iLicensePlate", iLicensePlate);
		param.put("ivalue", ivalue);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		int result = borrowingCertificationWritedao.authProduction(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public List<CurrencyAuth> showAuthProduction(long memberId) {
		
		return borrowingCertificationdao.showAuthProduction(memberId);
	}

	@Override
	public CurrencyAuth showAuthProductionOne(long rid) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("rid", rid);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showAuthProductionOne(param);
	}
	
	@Override
	public int editAuthProduction(long memberId, long cid, String iBrand,String iModel, String iLicensePlate, String ivalue, String endTime,String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("cid", cid);
		param.put("iBrand", iBrand);
		param.put("iModel", iModel);
		param.put("iLicensePlate", iLicensePlate);
		param.put("ivalue", ivalue);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		return borrowingCertificationWritedao.editAuthProduction(param);
	}
	

	
	
	
	
	@Override
	public int authMarriage(Long mid, Integer isMarried, String endTime,String enclosure) {
		Map<String,Object> param = new HashMap<String,Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = generatorUtil.GetId();
		
		param.put("cid", cid);
		param.put("mid", mid);
		param.put("isMarried", isMarried);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		
		int result = borrowingCertificationWritedao.authMarriage(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
		
	}
	
	public CurrencyAuth showAuthMarriage(Long memberId){
		
		return borrowingCertificationdao.showAuthMarriage(memberId);
	}
	
	@Override
	public int editAuthMarriage(long memberId, int integer, String endTime,String enclosure) {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("mid", memberId);
		param.put("isMarried", integer);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		
		int result = borrowingCertificationWritedao.editAuthMarriage(param);
		return result;
	}
	
	
	
	@Override
	public int authEducation(long memberId, int education, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = generatorUtil.GetId();
		param.put("memberId", memberId);
		param.put("education", education);
		param.put("enclosure", enclosure);
		param.put("cid", cid);
		
		int result = borrowingCertificationWritedao.authEducation(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public CurrencyAuth  showAuthEducation(long memberId) {
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showAuthEducation(param);
	}
	
	public int editAuthEducation(long memberId, int education, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("education", education);
		param.put("enclosure", enclosure);
		return borrowingCertificationWritedao.editAuthEducation(param);
	}
	

	
	
	
/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/
	
	
	
	
	@Override
	public int businessLicense(long memberId,String businessLicenseNumber,String companyName, String regAddress,String regPerson, String regCapital, 
			String businessScope,String CompanyType, String regDate, String endTime, String enclosure) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("businessLicenseNumber", businessLicenseNumber);
		param.put("companyName", companyName);
		param.put("cid", id);
		param.put("regAddress", regAddress);
		param.put("regPerson", regPerson);
		param.put("regCapital", regCapital);
		param.put("businessScope", businessScope);
		param.put("companyType", CompanyType);
		param.put("regDate", regDate);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("memberId", memberId);
		
		int result = borrowingCertificationWritedao.businessLicense(param);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}

	@Override
	public Map<String, Object> showBusinessLicense(long memberId) {
		
		return borrowingCertificationdao.showBusinessLicense(memberId);
	}
	
	@Override
	public int editBusinessLicense(long memberId,String businessLicenseNumber,String companyName,String regAddress, String regPerson, String regCapital,
			String businessScope, String CompanyType, String regDate,String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("businessLicenseNumber", businessLicenseNumber);
		param.put("companyName", companyName);
		param.put("regAddress", regAddress);
		param.put("regPerson", regPerson);
		param.put("regCapital", regCapital);
		param.put("businessScope", businessScope);
		param.put("companyType", CompanyType);
		param.put("regDate", regDate);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("memberId", memberId);
		return borrowingCertificationWritedao.editBusinessLicense(param);
	}
	
	
	
	
	
	
	
	
	@Override
	public int commercialLicense(long memberId, String address,String regPserson, String regCapital, String companyType,
			String paidCapital, String businessScope, String regDate,String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long cid = generatorUtil.GetId();
		param.put("memberId", memberId);
		param.put("address", address);
		param.put("regPerson", regPserson);
		param.put("regCapital", regCapital);
		param.put("companyType", companyType);
		param.put("paidCapital", paidCapital);
		param.put("businessScope", businessScope);
		param.put("regDate", regDate);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("cid", cid);
		
		int result = borrowingCertificationWritedao.commercialLicense(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else{
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public Map<String,Object> showCommercialLicense(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("memberId", memberId);
		return borrowingCertificationdao.showCommercialLicense(param);
	}
	
	@Override
	public int editCommercialLicense(long memberId, String address,String regPserson, String regCapital, String companyType,
			String paidCapital, String businessScope, String regDate,String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("address", address);
		param.put("regPerson", regPserson);
		param.put("regCapital", regCapital);
		param.put("companyType", companyType);
		param.put("paidCapital", paidCapital);
		param.put("businessScope", businessScope);
		param.put("regDate", regDate);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return borrowingCertificationWritedao.editCommercialLicense(param);
	}
	
	
	
	
	
	@Override
	public int organizational(long memberId, String organizationalCode,String startTime, String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		
		long cid = generatorUtil.GetId();
		param.put("memberId", memberId);
		param.put("organizationalCode", organizationalCode);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("cid", cid);
		
		int result = borrowingCertificationWritedao.organizational(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else {
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> showOrganizational(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showOrganizational(param);
	}
	
	@Override
	public int editOrganizational(long memberId, String organizationalCode,String startTime, String endTime, String enclosure) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("organizationalCode", organizationalCode);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("enclosure", enclosure);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		int result = borrowingCertificationWritedao.editOrganizational(param);
		return result;
	}
	
	
	
	
	
	
	
	@Override
	public int accountOpening(long memberId, String accountOpeningCode,String opBank, String bankAccount, String enclosure, String endTime) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long cid = generatorUtil.GetId();
		param.put("cid", cid);
		param.put("memberId", memberId);
		param.put("accountOpeningCode", accountOpeningCode);
		param.put("opBank", opBank);
		param.put("bankAccount", bankAccount);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		int result = borrowingCertificationWritedao.accountOpening(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else {
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> showAccountOpening(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showACcountOpening(param);
	}
	
	@Override
	public int editAccountOpening(long memberId, String accountOpeningCode,String opBank, String bankAccount, String enclosure, String endTime) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("accountOpeningCode", accountOpeningCode);
		param.put("opBank", opBank);
		param.put("bankAccount", bankAccount);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationWritedao.editAccountOpening(param);
	}
	
	
	
	
	@Override
	public int taxRegistration(long memberId, String credentialsNO,String issueOrgan, String enclosure, String endTime) {
		Map<String,Object> param = new HashMap<String,Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long cid = generatorUtil.GetId();
		
		param.put("memberId", memberId);
		param.put("cid", cid);
		param.put("credentialsNO", credentialsNO);
		param.put("issueOrgan", issueOrgan);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		int result = borrowingCertificationWritedao.taxRegistration(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else {
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> showTaxRegistration(long memberId) {
		Map<String,Object> param = new  HashMap<String,Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return borrowingCertificationdao.showTaxRegistration(param);
	}
	
	@Override
	public int editTaxRegistration(long memberId, String credentialsNO,String issueOrgan, String enclosure, String endTime) {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("memberId", memberId);
		param.put("credentialsNO", credentialsNO);
		param.put("issueOrgan", issueOrgan);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		return borrowingCertificationWritedao.editTaxRegistration(param);
	}
	
	
	
	
	
	@Override
	public int authApproval(long memberId, String fileSummary,
			String issueOrgan, String issueDate, String enclosure,String endTime) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long cid = generatorUtil.GetId();
		
		param.put("cid", cid);
		param.put("memberId", memberId);
		param.put("fileSummary", fileSummary);
		param.put("issueOrgan", issueOrgan);
		param.put("issueDate", issueDate);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		
		int result = borrowingCertificationWritedao.authApproval(param);
		if(result == 0){
			generatorUtil.SetIdUsed(cid);
		}else {
			generatorUtil.SetIdUsedFail(cid);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> showAuthApproval(long memberId) {
		
		return borrowingCertificationdao.showAuthApproval(memberId);
	}
	
	@Override
	public int editAuthApproval(long memberId, String fileSummary,
			String issueOrgan, String issueDate, String enclosure,String endTime) {
		Map<String,Object> param = new HashMap<String, Object>();
		
		param.put("memberId", memberId);
		param.put("fileSummary", fileSummary);
		param.put("issueOrgan", issueOrgan);
		param.put("issueDate", issueDate);
		param.put("enclosure", enclosure);
		param.put("endTime", endTime);
		
		return borrowingCertificationWritedao.editAuthApproval(param);
	}
	

	
	
	
	
	
	
	
	@Override
	public List<BorrowingTypeInfo> getAllByMemberAndLoanType(long projectId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		return borrowingCertificationdao.getAllByMemberAndLoanType(param);
	}


	
	
	
	
	
}

