package cn.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.constant.Constant;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import product_p2p.kit.redisPlug.Core;
import cn.dictionaries.model.NationInfoEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.membermng.model.BorrowingType;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.ExchangeRecords;
import cn.membermng.model.Friends;
import cn.membermng.model.IntegralGETRecord;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberMessageConfig;
import cn.membermng.model.MemberStationLetterEntity;
import cn.membermng.model.MyPoint;
import cn.membermng.model.RealNameAuth;
import cn.membermng.model.SecurityInfo;
import cn.membermng.model.SendSetEntity;
import cn.membermng.model.UntreatedMessageEntity;
import cn.membermng.model.VIPPurchaseRecordsEntity;
import cn.springmvc.dao.impl.sms.SendEmail;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.service.EmailBindingService;
import cn.springmvc.service.FinancialAdvisorService;
import cn.springmvc.service.IBorrowingCertificationServer;
import cn.springmvc.service.IMemberService;
import cn.springmvc.service.InviteMasterApplyService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.MemberMsgSetService;
import cn.springmvc.service.MemberStationService;
import cn.springmvc.service.MobilePhoneBindingService;
import cn.springmvc.service.UpdatePasswordService;
import cn.springmvc.util.MemberSessionMng;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;
import cn.sxlc.account.manager.model.LoanTransferEntity;

import com.alibaba.fastjson.JSONObject;

/***
 * 个人中心控制器
 * 
 * @author 李杰
 * @since
 * @date 2016-4-25 上午11:51:41
 * 
 */
@Controller
@RequestMapping("personalCenter")
public class PersonalCenterController{

	private Logger logger = Logger.getLogger(LoginRegisterController.class);

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IBorrowingCertificationServer borrowingCertificationServer;

	@Autowired
	private MobilePhoneBindingService mobilePhoneBindingService;

	@Autowired
	private EmailBindingService emailBindingService;

	@Resource
	private SendSmsUtil sendSmsUtil;

	@Autowired
	private SendEmail sendEmail;
	
	@Autowired
	private ManagedInterfaceServerTestI interfaceServerTestI;

	@Autowired
	private UpdatePasswordService passwordService;
	@Autowired
	private CertificationAuditService auditService;
	
	@Autowired
	private MemberMsgSetService memberMsgSetService;
	
	@Autowired
	private FinancialAdvisorService financialAdvisorService;
	
	@Autowired
	private InviteMasterApplyService inviteMasterApplyService;

	
	/****
	 * 会员基本信息
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:54:18
	 */
	@RequestMapping(value = "/baseInformationForPerson")
	public String baseInformationForPerson(HttpServletRequest request) {
		MemberInfo loginMember = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		MemberInfo memberInfo = null;

		//企业会员处理
		if (loginMember.getMemberType().intValue() == 1) {
			memberInfo = memberService.memberComplanyInfo(loginMember.getId());
			if (memberInfo.getBaseInfo().getPersonalPhone() != null && memberInfo.getBaseInfo().getPersonalPhone().length() == 11) {
				memberInfo.getBaseInfo().setPersonalPhone(memberInfo.getBaseInfo().getPersonalPhone().substring(0, 3)+ " **** "+ memberInfo.getBaseInfo().getPersonalPhone().substring(memberInfo.getBaseInfo().getPersonalPhone().length() - 3,memberInfo.getBaseInfo().getPersonalPhone().length()));
			}
			if (memberInfo.getBaseInfo().getQq() != null
					&& memberInfo.getBaseInfo().getQq().length() >= 5) {
				memberInfo.getBaseInfo().setQq(memberInfo.getBaseInfo().getQq().substring(0, 2)+ " **** "+ memberInfo.getBaseInfo().getQq().substring(memberInfo.getBaseInfo().getQq().length() - 2,memberInfo.getBaseInfo().getQq().length()));
			}
			request.setAttribute("userInfo", memberInfo);
			return "account/personalCenter/baseInformationForEnterprise";
		}
		
		//个人会员处理
		memberInfo = memberService.memberPersonalInfo(loginMember.getId());
		if (memberInfo.getBaseInfo().getPersonalPhone() != null && memberInfo.getBaseInfo().getPersonalPhone().length() == 11) {
			memberInfo.getBaseInfo().setPersonalPhone(memberInfo.getBaseInfo().getPersonalPhone().substring(0, 3)+ " **** "+ memberInfo.getBaseInfo().getPersonalPhone().substring(memberInfo.getBaseInfo().getPersonalPhone().length() - 3,memberInfo.getBaseInfo().getPersonalPhone().length()));
		}
		if (memberInfo.getBaseInfo().getQq() != null && memberInfo.getBaseInfo().getQq().length() >= 5) {
			memberInfo.getBaseInfo().setQq(memberInfo.getBaseInfo().getQq().substring(0, 2)+ " **** "+ memberInfo.getBaseInfo().getQq().substring(memberInfo.getBaseInfo().getQq().length() - 2,memberInfo.getBaseInfo().getQq().length()));
		}
		if(memberInfo.getBaseInfo().getPersonalEmail() != null){
			if(memberInfo.getBaseInfo().getPersonalEmail().indexOf("@") >= 3){
				memberInfo.getBaseInfo().setPersonalEmail(memberInfo.getBaseInfo().getPersonalEmail().substring(0,3)+" **** "+memberInfo.getBaseInfo().getPersonalEmail().substring(memberInfo.getBaseInfo().getPersonalEmail().indexOf("@"), memberInfo.getBaseInfo().getPersonalEmail().length()));
			}else{
				memberInfo.getBaseInfo().setPersonalEmail(memberInfo.getBaseInfo().getPersonalEmail().substring(0,memberInfo.getBaseInfo().getPersonalEmail().indexOf("@"))+" **** "+memberInfo.getBaseInfo().getPersonalEmail().substring(memberInfo.getBaseInfo().getPersonalEmail().indexOf("@"), memberInfo.getBaseInfo().getPersonalEmail().length()));
			}
		}
		if(memberInfo.getBaseInfo().getPersonalIDCard() != null && memberInfo.getBaseInfo().getPersonalIDCard().length() == 18){
			SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
			String years  = memberInfo.getBaseInfo().getPersonalIDCard().substring(6,10);
			String mothd  = memberInfo.getBaseInfo().getPersonalIDCard().substring(10,12);
			String day	  = memberInfo.getBaseInfo().getPersonalIDCard().substring(12,14);
			Date cTime    = new Date();
			Date userBirthDay = null;
			try {
				userBirthDay = yyyy_MM_dd.parse(years+"-"+mothd+"-"+day);
			} catch (ParseException e) {
				logger.info("投资详情：计算借款人生日出现异常");
			}
			if(userBirthDay != null){
				long time = cTime.getTime()-userBirthDay.getTime();
				int age = (int) ((time)/1000/60/60/24/365);
				request.setAttribute("memberInfoAge", age);
				request.setAttribute("memberInfoBirthDay", years+"-"+mothd+"-"+day);
			}else{
				request.setAttribute("memberInfoAge", 0);
				request.setAttribute("memberInfoBirthDay", "---");
			}
			int sex = IntegerAndString.StringToInt(memberInfo.getBaseInfo().getPersonalIDCard().charAt(17)+"",0);
			if(sex %2 == 0 ){
				request.setAttribute("memberInfoSex", "女");
			}else{
				request.setAttribute("memberInfoSex", "男");
			}
			memberInfo.getBaseInfo().setPersonalIDCard(memberInfo.getBaseInfo().getPersonalIDCard().substring(0, 3)+" ********* "+memberInfo.getBaseInfo().getPersonalIDCard().substring(15));
			//
		}else if(memberInfo.getBaseInfo().getPersonalIDCard() != null && memberInfo.getBaseInfo().getPersonalIDCard().length() == 15){
			memberInfo.getBaseInfo().setPersonalIDCard(memberInfo.getBaseInfo().getPersonalIDCard().substring(0, 6)+" **** "+memberInfo.getBaseInfo().getPersonalIDCard().substring(11));
		}
		
		request.setAttribute("userInfo", memberInfo);
		return "account/personalCenter/baseInformationForPerson";
	}

	/***
	 * 修改个人会员信息
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:54:42
	 */
	@RequestMapping(value = "editPsersonInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editPersonInfo(HttpServletRequest request) {
		String memberQQ 	= request.getParameter("memberQQ");
		String address 		= request.getParameter("address");
		String hjdz 		= request.getParameter("hjdz");
		String provinceId 	= request.getParameter("provinceId");
		String cityId 		= request.getParameter("cityId");
		String countyId 	= request.getParameter("countyId");
		// String sexId = request.getParameter("sexId");

		Map<String, Object> message = new HashMap<String, Object>();
		if ((memberQQ == null) || (!StringUtils.checkQQ(memberQQ))) {
			message.put("qq", "请输入QQ号码");
		}
		if ((address == null) || (address.trim().length() < 3)) {
			message.put("address", "请输入详细地址信息");
		}
		if ((hjdz == null) || (hjdz.trim().length() <= 2)) {
			message.put("hjdz", "请输入户籍地址");
		}

		int iprovinceId = -1;
		if ((provinceId != null) && (provinceId.trim().length() > 0)) {
			try {
				iprovinceId = Integer.parseInt(provinceId);
			} catch (Exception e) {
				message.put("provinceId", "地区信息选择错误");
			}
		}
		int icityId = -1;
		if ((cityId != null) && (cityId.trim().length() > 0)) {
			try {
				icityId = Integer.parseInt(cityId);
			} catch (Exception e) {
				message.put("cityId", "地区信息选择错误");
			}
		}
		int icountyId = -1;
		if ((countyId != null) && (countyId.trim().length() > 0)) {
			try {
				icountyId = Integer.parseInt(countyId);
			} catch (Exception e) {
				message.put("countyId", "地区信息选择错误");
			}
		}
		/*
		 * int isexId = 0; try { isexId = Integer.parseInt(sexId); } catch
		 * (Exception e) { message.put("sex", "请选择有效性别"); }
		 */

		if (message.keySet().size() > 1) {
			message.put("statu", "2");
			return JSONObject.toJSONString(message);
		}

		MemberInfo loginMember = (MemberInfo) request.getSession().getAttribute("loginUser");
		int result = this.memberService.editMemberPersonalInfo(loginMember.getId().longValue(), 1, memberQQ, hjdz, address, iprovinceId,icityId, icountyId);
		if (result == 0) {
			message.put("statu", result);
			message.put("message", "修改成功");
		} else {
			message.put("statu", result);
			message.put("message", "修改失败");
		}
		return JSONObject.toJSONString(message);
	}

	/***
	 * 修改企业会员信息
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:55:01
	 */
	@RequestMapping(value = "editComplanyInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editComplanyInfo(HttpServletRequest request) {
		MemberInfo loginMember = (MemberInfo) request.getSession().getAttribute("loginUser");
		if (loginMember.getMemberType().intValue() == 0) {
			return null;
		}
		String provinceId 	= request.getParameter("provinceId");
		String cityId 		= request.getParameter("cityId");
		String countyId		= request.getParameter("countyId");
		String contactName 	= request.getParameter("contactName");
//		String contactPhone = request.getParameter("contactPhone");
		String contactQQ 	= request.getParameter("contactQQ");
//		String contactEmail = request.getParameter("contactEmail");
		String companyProfile = request.getParameter("companyProfile");

		Map<String, Object> message = new HashMap<String, Object>();
		if ((contactName == null) || (!StringUtils.checkUserName(contactName))) {
			message.put("contactName", "请输入联系人姓名");
		}
//		if ((contactPhone == null) || (!StringUtils.checkPhone(contactPhone))) {
//			message.put("contactPhone", "请输入联系人电话号码");
//		}
		if ((contactQQ == null) || (!StringUtils.checkQQ(contactQQ))) {
			message.put("contactQQ", "请输入联系人QQ号码");
		}
//		if ((contactEmail == null) || (!StringUtils.checkMail(contactEmail))) {
//			message.put("contactEmail", "请输入联系邮箱地址");
//		}
		if (companyProfile.length() > 512) {
			message.put("contactEmail", "公司简介信息超出512个字");
		}
		int iprovinceId = -1;
		if ((provinceId != null) && (provinceId.trim().length() > 0)) {
			try {
				iprovinceId = Integer.parseInt(provinceId);
			} catch (Exception e) {
				message.put("provinceId", "地区信息选择错误");
			}
		}
		int icityId = -1;
		if ((cityId != null) && (cityId.trim().length() > 0)) {
			try {
				icityId = Integer.parseInt(cityId);
			} catch (Exception e) {
				message.put("cityId", "地区信息选择错误");
			}
		}
		int icountyId = -1;
		if ((countyId != null) && (countyId.trim().length() > 0)) {
			try {
				icountyId = Integer.parseInt(countyId);
			} catch (Exception e) {
				message.put("countyId", "地区信息选择错误");
			}
		}

		if (message.keySet().size() > 1) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}

		int result = this.memberService.editMemberComplanyInfo(loginMember
				.getId().longValue(), iprovinceId, icityId, icountyId,
				contactName, "", contactQQ, "",
				companyProfile);
		if (result == 0) {
			message.put("status", result);
			message.put("message", "修改成功");
		} else {
			message.put("status", result);
			message.put("message", "修改失败");
		}
		return JSONObject.toJSONString(message);
	}

	/***
	 * 获取省列表
	 * 
	 * @author 李杰
	 * @return
	 * @date 2016-4-27 上午9:55:33
	 */
	@RequestMapping(value = "provinceList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getProvinceList() {
		return JSONObject.toJSONString(this.memberService.getProvinceList());
	}

	/***
	 * 根据省列表获取市列表
	 * 
	 * @author 李杰
	 * @Title: citys
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:55:51
	 */
	@RequestMapping(value = { "citys" }, produces = { "text/html;charset=UTF-8" })
	@ResponseBody
	public String citys(HttpServletRequest request) {
		int proId = Integer.parseInt(request.getParameter("proId"));
		return JSONObject.toJSONString(this.memberService.getCityList(proId));
	}

	/***
	 * 根据市获取区县列表
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:56:20
	 */
	@RequestMapping(value = { "countys" }, produces = { "text/html;charset=UTF-8" })
	@ResponseBody
	public String countys(HttpServletRequest request) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		return JSONObject.toJSONString(this.memberService.getCountyList(cid));
	}
	
	@RequestMapping({ "/baseInformationForEnterprise" })
	public String baseInformationForEnterprise() {
		return "account/personalCenter/baseInformationForEnterprise";
	}

	/***
	 * 去安全中心
	 * 
	 * @author 李杰
	 * @Title: securityCenter
	 * @return
	 * @date 2016-4-27 上午9:53:25
	 */
	@RequestMapping(value = "/securityCenter")
	public String securityCenter(HttpServletRequest request) {
		MemberInfo info = (MemberInfo) request.getSession().getAttribute("loginUser");
		SecurityInfo securityInfo = memberService.securityInfo(info.getId(), info.getMemberType());
		if (info.getMemberType().intValue() == 1) {
			Map<String, Object> map = borrowingCertificationServer.showBusinessLicense(info.getId().longValue());
			if(map == null){
				map = new HashMap<String,Object>();
				map.put("status", 0);
			}
			request.setAttribute("businessInfo", map);
		} else {
			RealNameAuth realNameInfo = borrowingCertificationServer.showAuthRealName(info.getId());
			if ((realNameInfo.getRealName() != null) && (realNameInfo.getRealName().length() > 0)){
				realNameInfo.setRealName(realNameInfo.getRealName().substring(0, 1)+ "**");
			}else{
				realNameInfo.setRealName("");
			}
			if ((realNameInfo.getPersonalIDCard() != null) && (realNameInfo.getPersonalIDCard().length() >= 18)){
				realNameInfo.setPersonalIDCard("("+ realNameInfo.getPersonalIDCard().substring(0, 4)+"****"+ realNameInfo.getPersonalIDCard().substring(realNameInfo.getPersonalIDCard().length() - 4)+ ")");
			}else{
				realNameInfo.setPersonalIDCard("");
			}
			securityInfo.setRealName(realNameInfo.getRealName() + realNameInfo.getPersonalIDCard());
			securityInfo.setRealNameStatus(realNameInfo.getStatus());
		}
		
		
		if(securityInfo.getPersonalPhone() != null && securityInfo.getPersonalPhone().length() >= 11){
			securityInfo.setPersonalPhone(securityInfo.getPersonalPhone().substring(0, 3)+"****"+securityInfo.getPersonalPhone().substring(securityInfo.getPersonalPhone().length()-4, securityInfo.getPersonalPhone().length()));
		}
		if(securityInfo.getPersonalEmail() != null){
			if(securityInfo.getPersonalEmail().indexOf("@") >= 3){
				securityInfo.setPersonalEmail(securityInfo.getPersonalEmail().substring(0,3)+"****"+securityInfo.getPersonalEmail().substring(securityInfo.getPersonalEmail().indexOf("@"), securityInfo.getPersonalEmail().length()));
			}else{
				securityInfo.setPersonalEmail(securityInfo.getPersonalEmail().substring(0,securityInfo.getPersonalEmail().indexOf("@"))+"****"+securityInfo.getPersonalEmail().substring(securityInfo.getPersonalEmail().indexOf("@"), securityInfo.getPersonalEmail().length()));
			}
		}
		request.setAttribute("securityInfo", securityInfo);
		return "account/personalCenter/securityCenter";
	}

	
	@RequestMapping({ "/SC_realNameAuthentication" })
	public String SC_realNameAuthentication() {
		return "account/personalCenter/SC_realNameAuthentication";
	}

	@RequestMapping({ "/SC_realNameAuthentication_c" })
	public String SC_realNameAuthentication_c() {
		return "account/personalCenter/SC_realNameAuthentication_c";
	}

	@RequestMapping({ "/SC_phonebinding" })
	public String SC_phonebinding() {
		return "account/personalCenter/SC_phonebinding";
	}

	@RequestMapping({ "/SC_emailbinding" })
	public String SC_emailbinding() {
		return "account/personalCenter/SC_emailbinding";
	}

	@RequestMapping({ "/SC_emailChange" })
	public String SC_emailChange() {
		return "account/personalCenter/SC_emailChange";
	}

	@RequestMapping({ "/SC_resetPWD" })
	public String SC_resetPWD() {
		return "account/personalCenter/SC_resetPWD";
	}

	
	
	/***
	* 我的VIP
	* 
	* @author 李杰
	* @return
	* @date 2016-5-7 下午4:09:26
	 */
	@RequestMapping(value="/myVIP/{cpage:[0-9]+}")
	public String myVIP(HttpServletRequest request,@PathVariable int cpage) {
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		//查询我的VIP购买列表
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(10);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("memberId", memberInfo.getId());
		//查询VIP年费
		long vipYearMoney = interfaceServerTestI.findYearMoney();
		List<VIPPurchaseRecordsEntity> list = auditService.VipPurchaseRecords(entity, null);
		request.setAttribute("list", list); 
		request.setAttribute("cpage", cpage);
		request.setAttribute("pageSize", 10);
		request.setAttribute("tol",entity.getRecordsTotal());
		request.setAttribute("vipYearMoney", IntegerAndString.LongToString(vipYearMoney));
		return "account/personalCenter/myVIP";
	}

	/***
	* 提交VIP申请
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-7 下午8:29:50
	 */
	@RequestMapping(value="vipApply",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String applyVip(HttpServletRequest request){
		String startTime 	= request.getParameter("startTime");				//VIP 开始时间
		String years 		= request.getParameter("years");					//年数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Date   startDate	= null;
		Date   cDate		= new Date();
		try {
			startDate		= sdf.parse(startTime + " 23:59:59");
			if(startDate.before(cDate)){										//购买时间必须是在今天之后
				request.setAttribute("message", "VIP开始时间无效");
				return "account/personalCenter/buyVipFail";
			}
		} catch (Exception e) {
			request.setAttribute("message", "VIP开始时间无效");
			return "account/personalCenter/buyVipFail";
		}
		
		try {
			Integer.parseInt(years);
		} catch (Exception e) {
			request.setAttribute("message", "年限输入有误");
			return "account/personalCenter/buyVipFail";
		}
		
		MemberInfo info = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		LoanTransferEntity entity = interfaceServerTestI.PurchaseVIP(info.getMemberId(),Integer.parseInt(years),startTime + " 00:00:01",request,"personalCenter/buyVipCallBackPage.html","personalCenter/buyVipCallBack.html");
		if(entity.getStatu() == 2){				//后台设置的费用为0 直接购买成功
			return "account/personalCenter/buyVipSuccess";
		}else if(entity.getStatu() == 1){		//余额不足  购买失败
			request.setAttribute("message", "余额不足  购买失败");
			return "account/personalCenter/buyVipFail";
		}else{									//提交第三方转账
			request.setAttribute("loanTransferEntity", entity);
			return "dryLot/loantransfertest";	
		}
	}

	
	/***
	* 购买VIP回调页面
	* 
	* @author 李杰
	* @return
	* @date 2016-5-20 上午10:22:22
	 */
	@RequestMapping(value="buyVipCallBackPage")
	public String buyVipCallBackPage(HttpServletRequest request,HttpServletResponse response){
		String result = interfaceServerTestI.PurchaseVipReturn(request, response);
		if(result.toLowerCase().equals("success")){
			return "account/personalCenter/buyVipSuccess";
		}else{
			return "account/personalCenter/buyVipFail";
		}
	}
	
	
	/***
	* 购买VIP回调无页面
	* 
	* @author 李杰
	* @date 2016-5-20 上午10:23:21
	 */
	@RequestMapping(value="buyVipCallBack")
	public void buyVipCallBack(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.PurchaseVipBack(request, response);
	}
	
	
	/***
	* 积分管理
	* <br>
	* 当type等于1的时候返回的
	* @author 李杰
	* @param request
	* @param page
	* @param type
	* @return
	* @date 2016-5-6 下午7:27:36
	 */
	@RequestMapping(value="/integralManagement/{page:[0-9]+}/{type:[1|2]}")
	public String integralManagement(HttpServletRequest request,@PathVariable int page,@PathVariable int type) {
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		//查询我的积分
		MyPoint myPoint = memberService.points(memberInfo.getId(), memberInfo.getMemberType());
		request.setAttribute("myPoint", myPoint);
		request.setAttribute("type", type);
		request.setAttribute("cpage", page);
		request.setAttribute("pageSize", 10);
		
		
		PageEntity entity = new PageEntity();
		entity.setPageNum(page);
		entity.setPageSize(10);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", memberInfo.getId());
		entity.setMap(param);
		if(type == 1){				//查询出积分获取记录
			List<IntegralGETRecord> list = memberService.addPoints(entity);
			request.setAttribute("pointList", list);
			request.setAttribute("tol", entity.getRecordsTotal());
		}else{						//查询出积分使用记录
			List<ExchangeRecords> list = memberService.exchangeRecords(entity);
			request.setAttribute("pointList", list);
			request.setAttribute("tol", entity.getRecordsTotal());
		}
		return "account/personalCenter/integralManagement";
	}
	
	/***
	* 确认收货
	* 
	* @author 李杰
	* @return
	* @date 2016-5-9 上午9:53:58
	*/
	@RequestMapping(value="confirmReceipt",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String confirmReceipt(HttpServletRequest request){
		long exchangeId		=	IntegerAndString.StringToLong(request.getParameter("exchangeId"),-1);
		if(exchangeId == -1){
			return null;
		}
		MemberInfo memberinfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", memberinfo.getId());
		param.put("eId", exchangeId);
		int result = memberService.confirmReceipt(param);
		Map<String,Object> message = new HashMap<String,Object>();
		
		if(result == 1){
			message.put("status", 1);
			message.put("message", "操作成功");
		}
		
		return JSONObject.toJSONString(message);
	}
	
	
	/***
	* 银行卡
	* 
	* @author 李杰
	* @return
	* @date 2016-5-9 下午3:13:38
	 */
	@RequestMapping({ "/bankCard" })
	public String bankCard() {
		return "account/personalCenter/bankCard";
	}

	@RequestMapping({ "/friendManagement" })
	public String friendManagement() {
		return "account/personalCenter/friendManagement";
	}

	/***
	 * 借款认证认证列表
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:50:40
	 */
	@RequestMapping({ "/loanCertification" })
	public String loanCertification(HttpServletRequest request) {
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(
				"loginUser");

		List<BorrowingType> list = this.borrowingCertificationServer
				.getAllByMember(memberInfo.getMemberType().intValue(),
						memberInfo.getId().longValue());
		request.setAttribute("list", list);
		if (memberInfo.getMemberType().intValue() == 1) {
			return "account/personalCenter/loanCertification_company";
		}
		return "account/personalCenter/loanCertification";
	}

	/***
	 * 去认证详细信息添加页面
	 * 
	 * @author 李杰
	 * @Title: authInfo
	 * @param request
	 * @param typeId
	 *            认证类型编号
	 * @return
	 * @date 2016-4-27 上午9:51:07
	 */
	@RequestMapping(value = "authInfo/{typeId:[0-9]+}", method = RequestMethod.GET)
	public String authInfo(HttpServletRequest request,
			@PathVariable("typeId") Integer typeId) {
		String pagePath = "";
			
		switch(typeId){
			case 1:
				List<NationInfoEntity> nationList = this.memberService
				.GetNationList();
				request.setAttribute("nationList", nationList);
				pagePath = "account/personalCenter/LC_personal_realNameAuthentication";				
			break;
			case 2 :
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 3:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;	
			case 4:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 5:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;	
			case 6:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 7:
				pagePath = "account/personalCenter/LC_personal_freehold";
			break;
			case 8:
				pagePath = "account/personalCenter/LC_personal_voiture";
			break;
			case 9:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 10:
				pagePath = "account/personalCenter/LC_personal_marriage";
			break;	
			case 11:
				pagePath = "account/personalCenter/LC_personal_education";
			break;	
			case 1136091:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;	
			case 12:
				pagePath = "account/personalCenter/LC_company_BL";
			break;
			case 13:
				pagePath = "account/personalCenter/LC_company_ICL";
			break;
			case 14:
				pagePath = "account/personalCenter/LC_company_OC";
			break;
			case 15:
				pagePath = "account/personalCenter/LC_company_AL";
			break;
			case 16:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 17:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 18:
				pagePath = "account/personalCenter/LC_company_TR";
			break;	
			case 19:
				pagePath = "account/personalCenter/LC_company_approval";
			break;
			case 20:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 21:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 22:
				pagePath = "account/personalCenter/LC_personal_freehold";
			break;
			case 23:
				pagePath = "account/personalCenter/LC_personal_voiture";
			break;	
			case 24:
				pagePath = "account/personalCenter/LC_personal_scene";
			break;
			case 25:
				pagePath = "account/personalCenter/LC_company_corporation";
			break;				
		}

		request.setAttribute("type",typeId);
		
		return pagePath;
	}

	/**
	 * 查看借款认证信息
	* authInfo_v(这里用一句话描述这个方法的作用) 
	* TODO(描述)
	* @author 邱陈东  
	* * @Title: authInfo_v 
	* @Description: TODO 
	* @param @param request
	* @param @param typeId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-24 上午9:25:14
	* @throws
	 */
	@RequestMapping(value = "authInfo_v/{typeId:[0-9]+}", method = RequestMethod.GET)
	public String authInfo_v(HttpServletRequest request,
			@PathVariable("typeId") Integer typeId) {
		String pagePath = "";
			
		switch(typeId){
			case 1:
				List<NationInfoEntity> nationList = this.memberService
				.GetNationList();
				request.setAttribute("nationList", nationList);
				pagePath = "account/personalCenter/LC_personal_realNameAuthentication_v";				
			break;
			case 2 :
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 3:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;	
			case 4:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 5:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;	
			case 6:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 7:
				pagePath = "account/personalCenter/LC_personal_freehold_v";
			break;
			case 8:
				pagePath = "account/personalCenter/LC_personal_voiture_v";
			break;
			case 9:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 10:
				pagePath = "account/personalCenter/LC_personal_marriage_v";
			break;	
			case 11:
				pagePath = "account/personalCenter/LC_personal_education_v";
			break;	
			case 1136091:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;	
			case 12:
				pagePath = "account/personalCenter/LC_company_BL_v";
			break;
			case 13:
				pagePath = "account/personalCenter/LC_company_ICL_v";
			break;
			case 14:
				pagePath = "account/personalCenter/LC_company_OC_v";
			break;
			case 15:
				pagePath = "account/personalCenter/LC_company_AL_v";
			break;
			case 16:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 17:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 18:
				pagePath = "account/personalCenter/LC_company_TR_v";
			break;	
			case 19:
				pagePath = "account/personalCenter/LC_company_approval_v";
			break;
			case 20:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 21:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 22:
				pagePath = "account/personalCenter/LC_personal_freehold_v";
			break;
			case 23:
				pagePath = "account/personalCenter/LC_personal_voiture_v";
			break;	
			case 24:
				pagePath = "account/personalCenter/LC_personal_scene_v";
			break;
			case 25:
				pagePath = "account/personalCenter/LC_company_corporation_v";
			break;				
		}

		request.setAttribute("type",typeId);
		
		return pagePath;
	}
	
	/**
	 * 读取实名认证信息
	* showAuthRealName
	* @author 邱陈东  
	* * @Title: showAuthRealName 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-17 下午2:51:33
	* @throws
	 */
	@RequestMapping(value="showAuthRealName",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showAuthRealName(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		RealNameAuth data = borrowingCertificationServer.showAuthRealName(lMemberInfo[0]);

		if(data!=null){
			data.setAttachPrefix(FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	 * 个人会员实名认证/修改
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:52:20
	 */
	@RequestMapping(value="personalRealName",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String personalRealName(HttpServletRequest request) {
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String userName = request.getParameter("userName");
		int nationId = 0;
		try {
			nationId = Integer.parseInt(request.getParameter("nationId"));
		} catch (Exception e) { 
		}
		String idCard = request.getParameter("idCard");
		String homeTown = request.getParameter("homeTown");
		String endTime = request.getParameter("endTime");
		String annex = request.getParameter("annex"); 
		Integer sex =(Integer.valueOf(idCard.charAt(16))+1)%2;//0 男 \ 1女    身份证倒数第二位  偶数女    奇数男

		Map<String, Object> message = new HashMap<String, Object>();
		if ((userName == null) || (!StringUtils.checkUserName(userName))) {
			message.put("message", "请输入用户名");
		}
		if ((idCard == null) || (!StringUtils.checkIdCard(idCard))) {
			message.put("message", "请输入身份证号");
		}
		if (homeTown == null) {
			//message.put("message", "请输入籍贯");
		}
		if (endTime == null) {
			//message.put("message", "请选择有效期");
		}else if(endTime.equals("请选择有效期") || endTime == null || endTime.trim().length() == 0){
			endTime="";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("message", "请选择有效期");
			}
		}
		String[] annexArray = null;
		annexArray = annex.split(",");
		if(annexArray == null || annexArray.length != 2){
			annexArray = new String[]{"",""};
		}
		if (message.keySet().size() > 0) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authRealName(memberInfo.getId(), userName, sex, nationId, idCard, homeTown, annexArray[0], annexArray[1],endTime);
		}else{
			result = borrowingCertificationServer.editAuthRealName(lMemberInfo[0], userName, sex, nationId, idCard, homeTown, annexArray[0], annexArray[1]);
		}
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在申请记录");
		}else if(result==-2){
			message.put("status", "-2");
			message.put("message", "身份证号已被注册");
		}else if(result==0){
			message.put("status", "0");
			message.put("message", "保存实名认证信息成功");
		}else{
			message.put("status", "-3");
			message.put("message", "未知的错误，请联系我们的客服人员");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 根据type和人的ID获取通用的通用认证信息
	* loadCurrencyAuth
	* @author 邱陈东  
	* * @Title: loadCurrencyAuth 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:09:49
	* @throws
	 */
	@RequestMapping(value="/loadCurrencyAuth",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadCurrencyAuth(HttpServletRequest request){
		int type = IntegerAndString.StringToInt(request.getParameter("type"), -1);
		Map<String, Object> message = new HashMap<String, Object>();
		
		if(type==-1){
			message.put("message", "请选择认证类型");
			message.put("status", -1);
			return JSONObject.toJSONString(message);
		}
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		CurrencyAuth data = borrowingCertificationServer.showCurrencyAuth(lMemberInfo[0], (int)lMemberInfo[1], type);

		if(data!=null){
			data.setAttachPrefix(FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 现场认证/征信认证/职称认证/社保认证/其他(通用认证类型，只有附件和有效期)新增
	* commonAuth
	* @author 邱陈东  
	* * @Title: commonAuth 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 上午10:57:58
	* @throws
	 */
	@RequestMapping(value="/currencyAuth",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String currencyAuth(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		int type = IntegerAndString.StringToInt(request.getParameter("type"), -1);
		String endTime = request.getParameter("endTime");
		String annex = request.getParameter("annex"); 

		Map<String, Object> message = new HashMap<String, Object>();
		
		if(type==-1){
			message.put("message", "请选择认证类型");
			return JSONObject.toJSONString(message);
		}
		if (endTime == null) {
			message.put("message", "请选择有效期");
			return JSONObject.toJSONString(message);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("message", "请选择有效期");
				return JSONObject.toJSONString(message);
			}
		}
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}

		if (message.keySet().size() > 0) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		//根据type的值，分发任务
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.currencyAuth(lMemberInfo[0], (int)lMemberInfo[1], annex, endTime, type);
		}else{
			result = borrowingCertificationServer.editCurrencyAuth(lMemberInfo[0], (int)lMemberInfo[1], annex, endTime, type);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在申请记录");
		}else{
			message.put("status", "0");
			message.put("message", "提交申请成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 读取个人现居住地址认证信息
	* loadAuthAddress
	* @author 邱陈东  
	* * @Title: loadAuthAddress 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:11:29
	* @throws
	 */
	@RequestMapping(value="/loadAuthAddress",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthAddress(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		CurrencyAuth data = borrowingCertificationServer.showAuthAddress(lMemberInfo[0]);
		
		if(data!=null){
			data.setAttachPrefix(FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 新增（修改）现居住地址认证
	* authAddress
	* @author 邱陈东  
	* * @Title: authAddress 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午1:51:07
	* @throws
	 */
	@RequestMapping(value="/authAddress",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authAddress(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String address = request.getParameter("address");
		String endTime = request.getParameter("endTime");
		String annex = request.getParameter("annex"); 
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		if (endTime == null) {
			message.put("message", "请选择有效期");
			return JSONObject.toJSONString(message);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("message", "请选择有效期");
				return JSONObject.toJSONString(message);
			}
		}
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authAddress(lMemberInfo[0], address, endTime, annex);
		}else{
			result = borrowingCertificationServer.editAuthAddress(lMemberInfo[0], address, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* loadAuthHousing
	* 获取个人房产认证信息
	* @author 邱陈东  
	* * @Title: loadAuthHousing 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:14:26
	* @throws
	 */
	@RequestMapping(value="/loadAuthHousing",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthHousing(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		 List<CurrencyAuth> data = borrowingCertificationServer.showAuthHousing(lMemberInfo[0]);
		
		if(data.size()>0){
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* authHousing
	* 新增/修改房产认证
	* @author 邱陈东  
	* * @Title: authHousing 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:20:19
	* @throws
	 */
	@RequestMapping(value="/authHousing",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authHousing(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String address = request.getParameter("address");//房产地址
		String endTime = request.getParameter("endTime");//有效期
		String annex = request.getParameter("annex"); //附件
		String area = request.getParameter("area");//面积
		String value = request.getParameter("value");//价值
		Long cid = 0L;
		if(editType!=0){
			cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		}
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		if (endTime == null) {
			message.put("message", "请选择有效期");
			return JSONObject.toJSONString(message);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("message", "请选择有效期");
				return JSONObject.toJSONString(message);
			}
		}
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authHousing(lMemberInfo[0], (int)lMemberInfo[1],address, area, value, endTime, annex);
		}else{
			result = borrowingCertificationServer.editAuthHousing(lMemberInfo[0],(int)lMemberInfo[1],cid, address, area, value, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 *
	* loadAuthProduction
	* 读取车产认证
	* @author 邱陈东  
	* * @Title: loadAuthProduction 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:21:30
	* @throws
	 */
	@RequestMapping(value="/loadAuthProduction",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthProduction(HttpServletRequest request){
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		List<CurrencyAuth> data = borrowingCertificationServer.showAuthProduction(lMemberInfo[0]);
		
		if(data.size()>0){
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* authProduction
	* 新增/修改车产认证
	* @author 邱陈东  
	* * @Title: authProduction 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:22:58
	* @throws
	 */
	@RequestMapping(value="/authProduction",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authProduction(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String endTime = request.getParameter("endTime");//首次登记日期
		String annex = request.getParameter("annex"); //附件
		String brand = request.getParameter("brand");//车辆品牌
		String model = request.getParameter("model");//车辆型号
		String licensePlate = request.getParameter("licensePlate");//车牌号
		String value = request.getParameter("value");//价值
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		if (endTime == null) {
		}else if(endTime.equals("")){
			endTime = null;
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("endTime", "请选择有效期");
			}
		}
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authProduction(lMemberInfo[0], (int)lMemberInfo[1], brand, model, licensePlate, value, endTime, annex);
		}else{
			result = borrowingCertificationServer.editAuthProduction(lMemberInfo[0], (int)lMemberInfo[1], cid, brand, model, licensePlate, value, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* loadAuthEducation
	* 读取个人学历认证
	* @author 邱陈东  
	* * @Title: loadAuthEducation 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:27:54
	* @throws
	 */
	@RequestMapping(value="/loadAuthEducation",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthEducation(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		CurrencyAuth data = borrowingCertificationServer.showAuthEducation(lMemberInfo[0]);
		
		if(data!=null){
			data.setAttachPrefix(FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* authEducation
	* 新增/修改学籍认证
	* @author 邱陈东  
	* * @Title: authEducation 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:31:05
	* @throws
	 */
	@RequestMapping(value="/authEducation",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authEducation(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String annex = request.getParameter("annex"); //附件
		int education =IntegerAndString.StringToInt(request.getParameter("education"), 0) ;// 学历序号 外键id
		education = 5;
		Long cid = 0L;
		if(editType==1&&request.getParameter("cid")!=null && !request.getParameter("cid").equals("")){
			cid = Long.parseLong(request.getParameter("cid"));//修改时 使用 要修改的认证资料ID
		}
		String endTime = request.getParameter("endTime");//首次登记日期
		if (endTime == null) {
			//message.put("endTime", "请选择有效期");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("endTime", "请选择有效期");
				return JSONObject.toJSONString(message);
			}
		}
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authEducation(lMemberInfo[0], education, annex,endTime);
		}else{
			result = borrowingCertificationServer.editAuthEducation(lMemberInfo[0], education, annex,endTime);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* loadAuthMarriage
	* 查询个人婚姻认证信息
	* @author 邱陈东  
	* * @Title: loadAuthMarriage 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:52:06
	* @throws
	 */
	@RequestMapping(value="/loadAuthMarriage",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthMarriage(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		CurrencyAuth data = borrowingCertificationServer.showAuthMarriage(lMemberInfo[0]);
		
		if(data!=null){
			data.setAttachPrefix(FtpClientUtil.getFtpFilePath());
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* authMarriage
	* 新增/修改个人婚姻认证信息
	* @author 邱陈东  
	* * @Title: authMarriage 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:52:41
	* @throws
	 */
	@RequestMapping(value="/authMarriage",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authMarriage(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		Integer marriageType = IntegerAndString.StringToInt(request.getParameter("marriageType"), 0);//婚宴状态
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		//Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authMarriage(lMemberInfo[0], marriageType, endTime, annex);
		}else{
			result = borrowingCertificationServer.editAuthMarriage(lMemberInfo[0], marriageType, endTime,annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
 //=================================================================================================================
//企业认证
//=================================================================================================================
	/**
	 * 查询企业营业执照
	* loadBusinessLicense
	* @author 邱陈东  
	* * @Title: loadBusinessLicense 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-11 上午9:11:41
	* @throws
	 */
	@RequestMapping(value="/loadBusinessLicense",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadBusinessLicense(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showBusinessLicense(lMemberInfo[0]);
		
		if( data!=null){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增/修改企业营业执照认证
	* commercialLicense
	* @author 邱陈东  
	* * @Title: commercialLicense 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-11 上午9:11:41
	* @throws
	 */
	@RequestMapping(value="/businessLicense",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String businessLicense(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String businessLicenseNumber = request.getParameter("businessLicenseNumber");//营业执照号码
		String companyName = request.getParameter("companyName");//公司名称
		String regAddress = request.getParameter("regAddress");//注册地址
		String regPerson = request.getParameter("regPerson");//注册法人
		String regCapital = request.getParameter("regCapital");//注册资金
		String businessScope = request.getParameter("businessScope");//经营范围
		String CompanyType = request.getParameter("CompanyType");//公司类型
		String regDate = request.getParameter("regDate");//注册时间
		
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.businessLicense(lMemberInfo[0], businessLicenseNumber, companyName,regAddress, regPerson, regCapital, businessScope, CompanyType, regDate, endTime, annex);
		}else{
			result = borrowingCertificationServer.editBusinessLicense(lMemberInfo[0], businessLicenseNumber, companyName,regAddress, regPerson, regCapital, businessScope, CompanyType, regDate, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	//工商执照认证
	/**
	 * 查询企业工商执照认证
	* loadCommercialLicense
	* @author 邱陈东  
	* * @Title: loadCommercialLicense 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 上午11:36:18
	* @throws
	 */
	@RequestMapping(value="/loadCommercialLicense",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadCommercialLicense(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showCommercialLicense(lMemberInfo[0]);
		
		if(data!=null&&data.size()>0){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增/修改企业工商执照认证
	* commercialLicense
	* @author 邱陈东  
	* * @Title: commercialLicense 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午4:05:31
	* @throws
	 */
	@RequestMapping(value="/commercialLicense",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String commercialLicense(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String address = request.getParameter("address");//地址
		String regPserson = request.getParameter("regPserson");//注册法人
		String regCapital = request.getParameter("regCapital");//注册资金
		String companyType = request.getParameter("companyType");//公司类型
		String paidCapital = request.getParameter("paidCapital");//实收资金
		String businessScope = request.getParameter("businessScope");//经营范围
		String regDate = request.getParameter("regDate");//注册时间
		
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.commercialLicense(lMemberInfo[0], address, regPserson, regCapital, companyType, paidCapital, businessScope, regDate, endTime, annex);
		}else{
			result = borrowingCertificationServer.editCommercialLicense(lMemberInfo[0], address, regPserson, regCapital, companyType, paidCapital, businessScope, regDate, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* loadAuthApproval
	* 读取批文认证（行业许可证）
	* @author 邱陈东  
	* * @Title: loadAuthApproval 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:25:55
	* @throws
	 */
	@RequestMapping(value="/loadAuthApproval",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAuthApproval(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showAuthApproval(lMemberInfo[0]);
		
		if(data!=null){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* authApproval
	* 新增/修改  批文认证（行业许可证）
	* @author 邱陈东  
	* * @Title: authApproval 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-3 下午2:24:56
	* @throws
	 */
	@RequestMapping(value="/authApproval",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String authApproval(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String fileSummary = request.getParameter("fileSummary");//文件概要
		String issueOrgan = request.getParameter("issueOrgan");//颁发机构
		String issueDate = request.getParameter("issueDate");//发布时间
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.authApproval(lMemberInfo[0], fileSummary, issueOrgan, issueDate, annex, endTime);
		}else{
			result = borrowingCertificationServer.editAuthApproval(lMemberInfo[0], fileSummary, issueOrgan, issueDate, annex, endTime);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询企业会员的组织机构代码认证
	* loadOrganizational
	* @author 邱陈东  
	* * @Title: loadOrganizational 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:08:14
	* @throws
	 */
	@RequestMapping(value="/loadOrganizational",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadOrganizational(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showOrganizational(lMemberInfo[0]);
		
		if(data!=null&&data.size()>0){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix",FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增/修改组织机构代码认证
	* organizational
	* @author 邱陈东  
	* * @Title: organizational 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:14:33
	* @throws
	 */
	@RequestMapping(value="/organizational",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String organizational(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String organizationalCode = request.getParameter("organizationalCode");//组织机构代码
		String startTime = request.getParameter("startTime");//有效期开始时间
		String endTime=request.getParameter("endTime");//有效期结束时间
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.organizational(lMemberInfo[0], organizationalCode, startTime, endTime, annex);
		}else{
			result = borrowingCertificationServer.editOrganizational(lMemberInfo[0], organizationalCode, startTime, endTime, annex);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查看企业用户的开户许可证认证资料
	* loadAccountOpening
	* @author 邱陈东  
	* * @Title: loadAccountOpening 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:23:53
	* @throws
	 */
	@RequestMapping(value="/loadAccountOpening",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadAccountOpening(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showAccountOpening(lMemberInfo[0]);
		
		if(data!=null&&data.size()>0){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增/修改开户许可证认证资料
	* accountOpening
	* @author 邱陈东  
	* * @Title: accountOpening 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:27:14
	* @throws
	 */
	@RequestMapping(value="/accountOpening",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String accountOpening(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String accountOpeningCode = request.getParameter("accountOpeningCode");//开户银行许可证编号
		String opBank = request.getParameter("opBank");//开户银行
		String bankAccount = request.getParameter("bankAccount");//银行账户
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.accountOpening(lMemberInfo[0], accountOpeningCode, opBank, bankAccount, annex, endTime);
		}else{
			result = borrowingCertificationServer.editAccountOpening(lMemberInfo[0], accountOpeningCode, opBank, bankAccount, annex, endTime);
		}
		
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询企业用户税务登记认证的资料
	* loadTaxRegistration
	* @author 邱陈东  
	* * @Title: loadTaxRegistration 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:40:42
	* @throws
	 */
	@RequestMapping(value="/loadTaxRegistration",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadTaxRegistration(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String, Object> data = borrowingCertificationServer.showTaxRegistration(lMemberInfo[0]);
		
		if(data!=null&&data.size()>0){
			message.put("status", 0);
			message.put("message", "读取信息成功");
			message.put("data", data);
			message.put("attachPrefix", FtpClientUtil.getFtpFilePath());
		}else{
			message.put("status", -1);
			message.put("message", "没有数据");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增/修改企业用户的税务登记认证
	* taxRegistration
	* @author 邱陈东  
	* * @Title: taxRegistration 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午2:41:43
	* @throws
	 */
	@RequestMapping(value="/taxRegistration",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String taxRegistration(HttpServletRequest request){
		Integer editType = IntegerAndString.StringToInt(request.getParameter("editType"), 0);//0--新增   1--修改 
		
		String credentialsNO = request.getParameter("credentialsNO");//证件编号
		String issueOrgan = request.getParameter("issueOrgan");//证件颁发机构
		String endTime=request.getParameter("endTime");//登记日期
		String annex = request.getParameter("annex"); //附件
		
		Long cid = Long.parseLong( request.getParameter("cid"),10);//修改时 使用 要修改的认证资料ID
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		String[] annexArray = annex.split(",");
		if (annexArray.length == 0) {
			message.put("status", "-1");
			message.put("message", "请上传认证资料");
			return JSONObject.toJSONString(message);
		}
		
		//获取登录人信息
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = -1;
		if(editType==0){
			result = borrowingCertificationServer.taxRegistration(lMemberInfo[0], credentialsNO, issueOrgan, annex, endTime);
		}else{
			result = borrowingCertificationServer.editTaxRegistration(lMemberInfo[0], credentialsNO, issueOrgan, annex, endTime);
		}
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在记录");
		}else{
			message.put("status", "0");
			message.put("message", "保存成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	
//=================================================================================================================
// 
//  上面是借款 认证
//
//================================================================================================================
	
	
	
	/**
	 * 获取邀请好友列表
	* loadFriendInviteList
	* @author 邱陈东  
	* * @Title: loadFriendInviteList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午9:39:10
	* @throws
	 */
	@RequestMapping(value="loadFriendInviteList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadFriendInviteList(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		List<MemberInfo> list = memberService.friendInvitation(entity);
		PageUtil.ObjectToPage(entity, list);
		
		return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 获取站内好友列表
	* loadFriendList
	* @author 邱陈东  
	* * @Title: loadFriendList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-11 下午2:50:15
	* @throws
	 */
	@RequestMapping(value="loadFriendList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadFriendList(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		List<Friends> list = memberService.friendList(entity);
		PageUtil.ObjectToPage(entity, list);
		
		return JSONObject.toJSONString(entity);
	}
	

	/**
	 * 获取待确认好友列表
	* selectConfirmFriendList
	* @author 邱陈东  
	* * @Title: selectConfirmFriendList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午1:44:24
	* @throws
	 */
	@RequestMapping(value="selectConfirmFriendList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectConfirmFriendList(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		List<Friends> list = memberService.selectConfirmFriendList(entity);
		entity.getMap().remove("skey");
		PageUtil.ObjectToPage(entity, list);
		
		return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 查找陌生人
	* serachMemberByParam
	* @author 邱陈东  
	* * @Title: serachMemberByParam 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午1:59:50
	* @throws
	 */
	@RequestMapping(value="serachMemberByParam", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String serachMemberByParam(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		String memberName = request.getParameter("memberName");    			//会员用户名or姓名or手机号
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberName", memberName);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		List<MemberInfo> list = memberService.serachMemberByParam(entity);
		entity.getMap().remove("skey");
		PageUtil.ObjectToPage(entity, list);
		
		return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 请求添加好友
	* applyAddFriends
	* @author 邱陈东  
	* * @Title: applyAddFriends 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午2:13:06
	* @throws
	 */
	@RequestMapping(value="applyAddFriends",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String applyAddFriends(HttpServletRequest request){

		Long newFriendId =Long.parseLong(request.getParameter("newFriendId"));    			//想添加好友的人的ID
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result =  memberService.applyAddFriends(lMemberInfo[0],newFriendId);
		
		Map<String,Object> message = new HashMap<String, Object>();
		if(result==1){
			message.put("statu", 0);
			message.put("message", "好友申请成功");
			message.put("data",result);
		}else if(result==-1){
			message.put("statu", 1);
			message.put("message", "好友不存在");
			message.put("data",result);
		}else if(result==-2){
			message.put("statu", 1);
			message.put("message", "等待对方确认");
			message.put("data",result);
		}else if(result==-3){
			message.put("statu", 1);
			message.put("message", "以经是好友了");
			message.put("data",result);
		}
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 同意好友请求
	* agreeAapplyForFriend
	* @author 邱陈东  
	* * @Title: agreeAapplyForFriend 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-11 下午2:45:52
	* @throws
	 */
	@RequestMapping(value="agreeAapplyForFriend",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String agreeAapplyForFriend(HttpServletRequest request){

		Long newFriendId =Long.parseLong(request.getParameter("newFriendId"));    			//发来好友申请人的ID
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result =  memberService.agreeAapplyForFriend(lMemberInfo[0],newFriendId);
		
		Map<String,Object> message = new HashMap<String, Object>();
		if(result==0){
			message.put("statu", 0);
			message.put("message", "添加好友成功");
			message.put("data",result);
		}else if(result==-1){
			message.put("statu", 1);
			message.put("message", "已经是好友了");
			message.put("data",result);
		}else if(result==-2){
			message.put("statu", 1);
			message.put("message", "没有这条好友申请");
			message.put("data",result);
		}
		
		return JSONObject.toJSONString(message);
	}

	/**
	 * 个人中心读取当前登录人的姓名，称号，信用等级，积分，签到次数，第三方账号,身份认证状态,手机绑定状态，邮箱绑定状态，第三方开通状态
	* loadMemberInfo
	* @author 邱陈东  
	* * @Title: loadMemberInfo 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-18 上午11:47:26
	* @throws
	 */
	@RequestMapping(value="loadMemberInfo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadMemberInfo(HttpServletRequest request){
		Map<String,Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		MemberInfo memberInfo = memberService.loadMemberInfo(lMemberInfo[0],(int)lMemberInfo[1]);
		//对登录名做加密处理
		String logname = memberInfo.getLogname();
		logname = logname.charAt(0)+"***"+logname.charAt(logname.length()-1);
		memberInfo.setLogname(logname);
		message.put("statu", 0);
		message.put("message", "查询成功");
		message.put("data",memberInfo);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 用户签到
	* sign
	* @author 邱陈东  
	* * @Title: sign 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-19 上午9:40:27
	* @throws
	 */
	@RequestMapping(value="sign", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sign(HttpServletRequest request){
		Map<String,Object> message = new HashMap<String, Object>();
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		int result = memberService.sign(lMemberInfo[0]);
		if(result==-1){
			message.put("message", "今日已经签到,不能重复签到");
		}else if(result==1){
			message.put("message", "签到成功");
		}else{
			message.put("messsage", "签到失败");
		}
		message.put("statu", result);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 读取未读站内信，站内消息，待处理好友申请数
	* loadUntreatedMessage
	* @author 邱陈东  
	* * @Title: loadUntreatedMessage 
	* @param @param request
	* @return String 返回类型 
	* @date 2016-5-19 上午9:42:52
	* @throws
	 */
	@RequestMapping(value="loadUntreatedMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadUntreatedMessage(HttpServletRequest request){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 

		
		UntreatedMessageEntity entity = memberService.loadUntreatedMessage(lMemberInfo[0]); 
		

		return JSONObject.toJSONString(entity); 
	}

	
	/***
	 * 设置会员登录验证方式
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:52:49
	 */
	public String configLoginCheckType(HttpServletRequest request) {
		int checkType = Integer.parseInt(request.getParameter("checkType"));
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(
				"loginUser");

		return null;
	}

	/***
	 * 发送修改手机绑定短信验证码
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:45:11
	 */
	@RequestMapping(value = "sendEditBindPhoneCheckCode", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendEditBindPhoneCheckCode(HttpServletRequest request) {
		String phone 		= request.getParameter("phone");
		String imgCheckCode = request.getParameter("imgCheckCode"); 
		Map<String, Object> message = new HashMap<String, Object>();
		if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString() == null){
			message.put("message", "页面已失效，请刷新后再试");
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}else if ((phone == null) || (!StringUtils.checkPhone(phone))) {
			message.put("message", "请输入手机号");
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}else if(imgCheckCode == null || imgCheckCode.trim().length() == 0){
			message.put("message", "请输入图形验证码");
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}else if(!imgCheckCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())){
			message.put("message", "图形验证码错误");
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}

//		String sCode = Core.getEditBindPhoneCode(phone);
//		if (sCode != null) {
//			this.logger.debug("用户修改手机绑定手机短信验证码发送成功：" + phone + " : " + sCode);
//			message.put("status", Integer.valueOf(1));
//			message.put("message", "验证码发送成功,请注意查收");
//			return JSONObject.toJSONString(message);
//		}
		
		String code = StringUtils.varCode();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("phone", phone);
		param.put("code", code);
		int iresult = Core.putEditBindPhoneCode(phone, code);
		if (iresult == 1) {
			String[] result = sendSmsUtil.SendSms(param,0,0,null);
			if (IntegerAndString.StringToInt(result[0],-1) >= 0) {
				this.logger
						.debug("用户修改手机绑定手机短信验证码发送成功：" + phone + " : " + code);
				message.put("status", "1");
				message.put("message", "验证码发送成功,请注意查收");
			} else {
				this.logger
						.debug("用户修改手机绑定手机短信验证码发送失败：" + phone + " : " + code);
				message.put("status", "0");
				message.put("message", "验证码发送失败,请重试!");
			}
		} else {
			this.logger.debug("用户注册手机短信验证码发送失败：" + phone + " : " + code);
			message.put("status", "0");
			message.put("message", "验证码发送失败,请重试!");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	* 检查原电话号码是否存在
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-16 下午3:00:55
	*/
	@RequestMapping(value="checkOldPhone",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkOldPhone(HttpServletRequest request){
		String 		oldPhone 	= request.getParameter("phone");
		MemberInfo 	memberInfo 	= (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if(oldPhone == null || oldPhone.trim().length() == 0){
			Map<String,String> messge = new HashMap<String,String>();
			messge.put("status", "-2");
			messge.put("message", "请输入原手机号码");
			return JSONObject.toJSONString(messge);
		}else if(oldPhone.equals(mobilePhoneBindingService.selectOldPhone(memberInfo.getId()))){
			Map<String,String> messge = new HashMap<String,String>();
			messge.put("status", "1");
			messge.put("message", "");
			return JSONObject.toJSONString(messge);
		}else{
			Map<String,String> messge = new HashMap<String,String>();
			messge.put("status", "-3");
			messge.put("message", "原手机号码错误");
			return JSONObject.toJSONString(messge);
		}
	}
	
	/***
	 * 检查用户电话号码是否存在
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-5-17 上午10:38:52
	 */
	@RequestMapping(value="/checkPhone",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkPhone(HttpServletRequest request){
		String phone = request.getParameter("phone");
		Map<String,Object> param = new HashMap<String, Object>();
		if(phone == null || phone.trim().length() != 11){
			param.put("status", "0");
			param.put("message", "请输入联系电话");
			return JSONObject.toJSONString(param);
		}else if(!StringUtils.checkPhone(phone)){
			param.put("status", "0");
			param.put("message", "请输入有效电话");
			return JSONObject.toJSONString(param);
		}
		int result = memberService.chechPhone(phone);
		if(result == 0){
			param.put("status", "y");
			param.put("info", "");
		}else{
			param.put("status", "n");
			param.put("info", "已被使用");
		}
		return JSONObject.toJSONString(param);
	}
	
	/***
	 * 修改手机绑定
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:45:43
	 */
	@RequestMapping(value = "editBindPhone", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editBindPhone(HttpServletRequest request) {
		String oldPhone = request.getParameter("oldPhone");							//原手机号
		String newPhone = request.getParameter("newPhone");							//新手机号
		String chekcCode = request.getParameter("imgCheckCode");					//图形验证吗
		String phoneCode = request.getParameter("phoneCode");						//短信验证码

		Map<String, Object> param = new HashMap<String, Object>();
		if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION") == null){
			param.put("message", "页面已失效,请刷新后再试");
		}else if ((oldPhone == null) || (!StringUtils.checkPhone(oldPhone))) {
			param.put("message", "请输入原来手机号码");
		}else if ((newPhone == null) || (!StringUtils.checkPhone(newPhone))) {
			param.put("message", "请输入新手机号码");
		}else  if ((chekcCode == null) || (chekcCode.trim().length() == 0)){
			param.put("message", "请输入验证码");
		}else if (!chekcCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			param.put("message", "验证码错误");
		}else if ((phoneCode == null) || (phoneCode.trim().length() == 0)){
			param.put("message", "请输入短信验证码");
		}else if (!phoneCode.equals(Core.getEditBindPhoneCode(newPhone))) {
			param.put("message", "手机验证码错误");
		}

		if ((oldPhone != null) && (newPhone != null)
				&& (oldPhone.equals(newPhone))) {
			param.put("message", "新号码和原手机号码不能相同");
		}

		if (param.keySet().size() > 0) {
			param.put("status", "-2");
			return JSONObject.toJSONString(param);
		}

		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if (oldPhone.equals(mobilePhoneBindingService.selectOldPhone(memberInfo.getId()))) {
			Map<String, Object> param2 = new HashMap<String, Object>();
			param2.put("personalPhone", newPhone);
			param2.put("personalID", memberInfo.getPersonalId());
			int result = this.mobilePhoneBindingService.updatepersonPhone(param2);
			if (result == 1) {
				param.put("status", "1");
				param.put("message", "修改成功");
			} else if (result == -1) {
				param.put("status", "-1");
				param.put("message", "手机号已被使用");
			} else {
				param.put("status", "0");
				param.put("message", "修改失败");
			}
		} else {
			param.put("status", "-3");
			param.put("message", "原始手机号错误");
		}
		return JSONObject.toJSONString(param);
	}
	
	
	/***
	 * 检查原邮箱是否正确
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "checkOldEmail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkOldEmail(HttpServletRequest request){
		String email 	= request.getParameter("email");			//用户邮箱
		Map<String,String> message = new HashMap<String,String>();
		if(email == null || email.trim().length() == 0){
			message.put("message","请输入邮箱地址");
		}else if(!StringUtils.checkMail(email)){
			message.put("message","请输入有效邮箱地址");
		}
		if(message.keySet().size() > 0){
			message.put("status","-2");
			return JSONObject.toJSONString(message);
		}
		MemberInfo 	memberInfo 	= (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("personalEmail",  email);
		param.put("personalID", 	memberInfo.getPersonalId());
		if(emailBindingService.checkEmail(param) == 1){
			message.put("status","1");
			message.put("message","原邮箱输入正确");
		}else{
			message.put("status","-1");
			message.put("message","原邮箱输入错误");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	 * 检查用户邮箱是否已被使用
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-5-23 下午4:54:38
	 */
	@RequestMapping(value = "checkEmail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkEmail(HttpServletRequest request){
		String email 	= request.getParameter("email");			//用户邮箱
		Map<String,String> message = new HashMap<String,String>();
		if(email == null || email.trim().length() == 0){
			message.put("message","请输入邮箱地址");
		}else if(!StringUtils.checkMail(email)){
			message.put("message","请输入有效邮箱地址");
		}
		if(message.keySet().size() > 0){
			message.put("status","-2");
			return JSONObject.toJSONString(message);
		}
		
		if(memberService.countEmail(email) > 0){
			message.put("status","-1");
			message.put("message","邮箱已被使用");
		}else{
			message.put("status","1");
			message.put("message","可以使用当前邮箱");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	 * 发送绑定邮箱验证码
	 * 
	 * @author 李杰
	 * @return
	 * @date 2016-4-28 上午9:12:10
	 */
	@RequestMapping(value = "sendBindEmailCheckCode", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendBindEmailCheckCode(HttpServletRequest request) {
		String email		 = request.getParameter("email");
		String imgCheckCode  = request.getParameter("imgCheckCode");
		Map<String, Object> message = new HashMap<String, Object>();
		if ((email == null) || (!StringUtils.checkMail(email))) {
			message.put("message", "请输入邮箱");
			message.put("status", -2);
			return JSONObject.toJSONString(message);
		}else if(imgCheckCode == null || imgCheckCode.trim().length() == 0){
			message.put("message", "请输入图形验证码");
			message.put("status", -2);
			return JSONObject.toJSONString(message);
		}else if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString() == null){
			message.put("message", "页面失效,请刷新后再试");
			message.put("status", -2);
			return JSONObject.toJSONString(message);
		}else if(!imgCheckCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())){
			message.put("message", "图形验证码错误");
			message.put("status", -2);
			return JSONObject.toJSONString(message);
		}

//		String sCode = Core.getBindEmailCode(email);
//		if (sCode != null) {
//			this.logger.debug("用户绑定邮箱邮箱证码发送成功：" + email + " : " + sCode);
//			message.put("status", 1);
//			message.put("message", "验证码发送成功,请注意查收");
//			return JSONObject.toJSONString(message);
//		}
		
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		
		String code = StringUtils.varCode();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
		param.put("code", code);
		int iresult = Core.putBindEmailCode(email, code);
		if (iresult == 1) {
			short memberType = (short) memberInfo.getMemberType().intValue();
			int result = sendEmail.checkEmail(email, "您的邮箱绑定验证码为："+code+"", request, memberInfo.getId(),memberType , (short)0, 0L);// 处理发送------------------------------------------------------------------------
			if (result == 1) {
				this.logger.debug("用户绑定邮箱邮箱证码发送成功：" + email + " : " + code);
				message.put("status", "1");
				message.put("message", "验证码发送成功,请注意查收");
			} else {
				this.logger.debug("用户绑定邮箱邮箱证码发送失败：" + email + " : " + code);
				message.put("status", "-1");
				message.put("message", "验证码发送失败,请重试!");
			}
		} else {
			this.logger.debug("用户绑定邮箱邮箱证码发送失败：" + email + " : " + code);
			message.put("status", "-1");
			message.put("message", "验证码发送失败,请重试!");
		}
		return JSONObject.toJSONString(message);
	}

	/***
	 * 绑定邮箱
	 * 
	 * @author 李杰
	 * @Title: bindEmail
	 * @return
	 * @date 2016-4-27 上午11:04:31
	 */
	@RequestMapping(value = "bindEmail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String bindEmail(HttpServletRequest request) {
		String email = request.getParameter("email"); 					// 邮箱地址
		String imgCheckCode = request.getParameter("checkCode"); 		// 验证码
		String emailCheckCode = request.getParameter("emailCheckCode"); // 邮箱验证码

		Map<String, Object> param = new HashMap<String, Object>();
		if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString() == null){
			param.put("message", "请输入邮箱地址");
		}else if (email == null || email.trim().length() <= 0) {
			param.put("message", "请输入邮箱地址");
		} else if (!StringUtils.checkMail(email)) {
			param.put("message", "请输入有效邮箱地址");
		}
		if (imgCheckCode == null || imgCheckCode.trim().length() <= 0) {
			param.put("message", "请输入图形验证码");
		} else if (!imgCheckCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			param.put("message", "图形验证码错误");
		}
		if (emailCheckCode == null || emailCheckCode.trim().length() <= 0) {
			param.put("message", "请输入邮箱验证码");
		} else if (!emailCheckCode.equals(Core.getBindEmailCode(email))) {
			param.put("message", "邮箱验证码错误");
		}

		if (param.keySet().size() > 0) {
			param.put("status", "-2");
			return JSONObject.toJSONString(param);
		}

		MemberInfo memberinfo = (MemberInfo) request.getSession().getAttribute(
				Constant.LOGINUSER);
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("personalEmail", email);
		parameter.put("personalID", memberinfo.getPersonalId());
		int result = emailBindingService.updatepersonEmail(parameter);
		if (result == 1) {
			param.put("status", "1");
			param.put("message", "修改成功");
		} else if (result == 0) {
			param.put("status", "0");
			param.put("message", "修改失败");
		} else if (result == -1) {
			param.put("status", "-1");
			param.put("message", "邮箱已被使用");
		}
		return JSONObject.toJSONString(param);
	}
	
	/***
	 * 修改邮箱绑定信息
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午11:05:07
	 */
	@RequestMapping(value = "editBindEmail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editBindEmail(HttpServletRequest request) {
		String oldEmail = request.getParameter("oldEmail");					//原一邮箱地址
		String newEmail = request.getParameter("newEmail");					//新邮箱地址
		String checkCode = request.getParameter("checkCode");				//图形验证码
		String emailCode = request.getParameter("emailCode");				//邮箱验证码

		Map<String, Object> message = new HashMap<String, Object>();
		if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString() == null){
			message.put("message", "页面已失效,请刷新后重试");
		}else if (oldEmail == null || oldEmail.trim().length() <= 0) {
			message.put("message", "请输入邮箱地址");
		} else if (!StringUtils.checkMail(oldEmail)) {
			message.put("message", "请输入有效有限地址");
		}else if (newEmail == null || newEmail.trim().length() <= 0) {
			message.put("message", "请输入有效邮箱地址");
		}else if (!StringUtils.checkMail(newEmail)) {
			message.put("message", "请输入有效邮箱地址");
		}else if (newEmail != null && oldEmail != null && newEmail.equals(oldEmail)) {
			message.put("message", "新邮箱和旧邮箱不能一致");
		}else if (checkCode == null || checkCode.trim().length() <= 0) {
			message.put("message", "请输入图形验证码");
		} else if (!checkCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			message.put("message", "图形验证码错误");
		}else if (emailCode == null || emailCode.trim().length() <= 0) {
			message.put("message", "请输入邮箱验证码");
		} else if (!emailCode.equals(Core.getBindEmailCode(newEmail))) {
			message.put("message", "邮箱验证码错误");
		}

		if (message.keySet().size() > 0) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}

		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		String saveOldEmail = emailBindingService.selectOldEmail(memberInfo.getId());
		if (saveOldEmail == null) {
			message.put("status", "-1");
			message.put("message", "原邮箱错误");
			return JSONObject.toJSONString(message);
		} else if (!saveOldEmail.equals(oldEmail)) {
			message.put("status", "-1");
			message.put("message", "原邮箱输入错误");
			return JSONObject.toJSONString(message);
		}

		Map<String, Object> paramter = new HashMap<String, Object>();
		paramter.put("personalEmail", newEmail);
		paramter.put("personalID", memberInfo.getPersonalId());
		int result = emailBindingService.updatepersonEmail(paramter);

		if (result == 1) {
			message.put("status", "1");
			message.put("message", "修改成功");
		} else if (result == 0) {
			message.put("status", "0");
			message.put("message", "修改失败");
		} else if (result == -1) {
			message.put("status", "-1");
			message.put("message", "邮箱已被使用");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	 * 开通第三方
	 * 
	 * @author 李杰
	 * @return
	 * @date 2016-4-27 下午7:59:07
	 */
	@RequestMapping(value = "openAccount", produces = "text/html;charset=UTF-8")
	public String openThirdAccount(HttpServletRequest request) {
		 AccountInterfaceEntity accountInterfaceEntity = new
		 AccountInterfaceEntity();
		 MemberInfo memberInfo = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
		 accountInterfaceEntity.setMemberType(memberInfo.getMemberType());
		 accountInterfaceEntity.setId(memberInfo.getId());
		 accountInterfaceEntity = interfaceServerTestI.testAccountInterfaceQDD(accountInterfaceEntity,"personalCenter/openThirdAccountCallbackPage.html","personalCenter/openThirdAccountCallback.html",request);
		 request.setAttribute("accountInterfaceEntity", accountInterfaceEntity);
		return "dryLot/loanregisterbindtest";
	}

	/***
	 * 开户返回页面
	 * 
	 * @author 李杰
	 * @return
	 * @date 2016-4-28 下午7:46:50
	 */
	@RequestMapping(value="openThirdAccountCallbackPage")
	public String openThirdAccountCallback(HttpServletRequest request,HttpServletResponse response){
		String result = interfaceServerTestI.testLoanRegisterBindReturn(request, response);
		request.setAttribute("title", "开户");
		if(result.toLowerCase().equals("success")){
			request.setAttribute("detail", "开户成功");
			return "account/personalCenter/optionSuccess";
		}else{
			request.setAttribute("detail", "开户失败");
			return "account/personalCenter/optionFall";
		}
	}
	
	/***
	* 开户返回 回调
	* 
	* @author 李杰
	* @return
	* @date 2016-4-28 下午7:47:16
	 */
	@RequestMapping(value="openThirdAccountCallback",produces = "text/html;charset=UTF-8")
	public void openThirdAccountCallback1(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.testLoanRegisterBindNotify(request, response);
	}
	
	/***
	* 重置用户密码
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-4-28 下午9:36:27
	 */
	@RequestMapping(value="resetPassword",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String resetPassword(HttpServletRequest request){
		String oldPassword = request.getParameter("oldPassword");					//原始密码
		String newPassword = request.getParameter("newPassword");					//新密码
		String confirmPwd  = request.getParameter("confirmPwd");					//确认密码
		String imgCheckCode= request.getParameter("imgCheckCode");					//图形验证码
		
		Map<String,Object> message = new HashMap<String,Object>();
		if(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION") == null){
			message.put("message", "页面已失效,请刷新后再试");
		}else if(oldPassword == null || oldPassword.trim().length() <= 0){
			message.put("message", "请输入用户原密码");
		}else if(newPassword == null || newPassword.trim().length() <= 0){
			message.put("message", "请输入新密码");
		}else if(confirmPwd == null || confirmPwd.trim().length() <= 0){
			message.put("message", "请输入确认密码");
		}else if(newPassword != null && confirmPwd != null && !newPassword.equals(confirmPwd)){
			message.put("message", "两次输入密码不一致");
		}else if(imgCheckCode == null || imgCheckCode.trim().length() <= 0){
			message.put("message", "请输入图形验证码");
		}else if(!imgCheckCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())){
			message.put("message", "图形验证码输入错误");
		}else if(newPassword.equals(oldPassword)){
			message.put("message", "新密码不能和旧密码相同");
		}
		
		if(message.keySet().size() > 0){
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}
		
		MemberInfo memberinfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberPwd", oldPassword);
		param.put("memberID", memberinfo.getId());
		int isEntity = passwordService.checkPassword(param);
		if(isEntity == 1){
			param.put("memberPwd", newPassword);
			int result = passwordService.updatepersonPassword(param);
			if(result == 1){
				message.put("status", "1");
				message.put("message", "密码修改成功");
				
				//清空当前Sesssion
				request.getSession().removeAttribute(Constant.LOGINUSER);
				request.getSession().removeAttribute(Constant.publicKey);
				request.getSession().removeAttribute(Constant.privateKey);
			}else{
				message.put("status", "-1");
				message.put("message", "修改失败");
			}
		}else{
			message.put("status", "-1");
			message.put("message", "原密码输入错误");
		}
		return JSONObject.toJSONString(message);
	}
	
	/***
	* 二次分配授权
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-4-29 上午9:41:22
	 */
	@RequestMapping(value="authorized")
	public String authorized(HttpServletRequest request){
		AuthorizeInterfaceEntity entity = new AuthorizeInterfaceEntity();
		MemberInfo memberInfo = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
		entity.setMemberId(memberInfo.getId());
		entity.setMemberType(memberInfo.getMemberType());
		entity.setAuthorizeTypeOpen("3");
		interfaceServerTestI.testLoanAuthorize(entity,"personalCenter/authorizedCallBackPage.html","personalCenter/authorizedCallBack.html",request);
		request.setAttribute("accountInterfaceEntity", entity);
		return "dryLot/loanauthorizetest";
	}
	
	/***
	* 二次分配授权回调
	* @author 李杰
	* @return
	* @date 2016-4-29 上午11:32:17
	 */
	@RequestMapping(value="authorizedCallBackPage")
	public String authorizedCallBackPage(HttpServletRequest request,HttpServletResponse response){
		String result = interfaceServerTestI.testLoanAuthorizeReturn(request, response);
		request.setAttribute("title", "授权");
		if(result == "SUCCESS"){
			request.setAttribute("detail", "授权成功");
			return "account/personalCenter/optionSuccess";
		}else{
			request.setAttribute("detail", "授权失败");
			return "account/personalCenter/optionFall";
		}
	}
	
	/***
	* 二次分配授权回调
	* 
	* @author 李杰
	* @Title: authorizedCallBack
	* @param request
	* @param response
	* @date 2016-4-29 下午12:46:19
	*/
	@RequestMapping(value="authorizedCallBack")
	public void authorizedCallBack(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.testLoanAuthorizeNotify(request,response);
	}
	
	
	
	
	
	
	
	@RequestMapping({ "/LC_personal_scene" })
	public String LC_personal_scene() {
		return "account/personalCenter/LC_personal_scene";
	}

	@RequestMapping({ "/LC_personal_scene_c" })
	public String LC_personal_scene_c() {
		return "account/personalCenter/LC_personal_scene_c";
	}

	@RequestMapping({ "/LC_personal_scene_v" })
	public String LC_personal_scene_v() {
		return "account/personalCenter/LC_personal_scene_v";
	}

	@RequestMapping({ "/LC_personal_credit" })
	public String LC_personal_credit() {
		return "account/personalCenter/LC_personal_credit";
	}

	@RequestMapping({ "/LC_personal_credit_c" })
	public String LC_personal_credit_c() {
		return "account/personalCenter/LC_personal_credit_c";
	}

	@RequestMapping({ "/LC_personal_credit_v" })
	public String LC_personal_credit_v() {
		return "account/personalCenter/LC_personal_credit_v";
	}

	@RequestMapping({ "/LC_personal_address" })
	public String LC_personal_address() {
		return "account/personalCenter/LC_personal_address";
	}

	@RequestMapping({ "/LC_personal_address_v" })
	public String LC_personal_address_v() {
		return "account/personalCenter/LC_personal_address_v";
	}

	@RequestMapping({ "/LC_personal_address_c" })
	public String LC_personal_address_c() {
		return "account/personalCenter/LC_personal_address_c";
	}

	@RequestMapping({ "/LC_personal_title" })
	public String LC_personal_title() {
		return "account/personalCenter/LC_personal_title";
	}

	@RequestMapping({ "/LC_personal_title_v" })
	public String LC_personal_title_v() {
		return "account/personalCenter/LC_personal_title_v";
	}

	@RequestMapping({ "/LC_personal_title_c" })
	public String LC_personal_title_c() {
		return "account/personalCenter/LC_personal_title_c";
	}

	@RequestMapping({ "/LC_personal_socialSecurity" })
	public String LC_personal_socialSecurity() {
		return "account/personalCenter/LC_personal_socialSecurity";
	}

	@RequestMapping({ "/LC_personal_socialSecurity_v" })
	public String LC_personal_socialSecurity_v() {
		return "account/personalCenter/LC_personal_socialSecurity_v";
	}

	@RequestMapping({ "/LC_personal_socialSecurity_c" })
	public String LC_personal_socialSecurity_c() {
		return "account/personalCenter/LC_personal_socialSecurity_c";
	}

	@RequestMapping({ "/LC_personal_freehold" })
	public String LC_personal_freehold() {
		return "account/personalCenter/LC_personal_freehold";
	}

	@RequestMapping({ "/LC_personal_freehold_v" })
	public String LC_personal_freehold_v() {
		return "account/personalCenter/LC_personal_freehold_v";
	}

	@RequestMapping({ "/LC_personal_freehold_c" })
	public String LC_personal_freehold_c() {
		return "account/personalCenter/LC_personal_freehold_c";
	}

	@RequestMapping({ "/LC_personal_voiture" })
	public String LC_personal_voiture() {
		return "account/personalCenter/LC_personal_voiture";
	}

	@RequestMapping({ "/LC_personal_voiture_c" })
	public String LC_personal_voiture_c() {
		return "account/personalCenter/LC_personal_voiture_c";
	}

	@RequestMapping({ "/LC_personal_voiture_v" })
	public String LC_personal_voiture_v() {
		return "account/personalCenter/LC_personal_voiture_v";
	}

	@RequestMapping({ "/LC_personal_education" })
	public String LC_personal_education() {
		return "account/personalCenter/LC_personal_education";
	}

	@RequestMapping({ "/LC_personal_education_v" })
	public String LC_personal_education_v() {
		return "account/personalCenter/LC_personal_education_v";
	}

	@RequestMapping({ "/LC_personal_education_c" })
	public String LC_personal_education_c() {
		return "account/personalCenter/LC_personal_education_c";
	}

	@RequestMapping({ "/LC_personal_marriage" })
	public String LC_personal_marriage() {
		return "account/personalCenter/LC_personal_marriage";
	}

	@RequestMapping({ "/LC_personal_marriage_v" })
	public String LC_personal_marriage_v() {
		return "account/personalCenter/LC_personal_marriage_v";
	}

	@RequestMapping({ "/LC_personal_marriage_c" })
	public String LC_personal_marriage_c() {
		return "account/personalCenter/LC_personal_marriage_c";
	}

	@RequestMapping({ "/LC_personal_detailedStatement" })
	public String LC_personal_detailedStatement() {
		return "account/personalCenter/LC_personal_detailedStatement";
	}

	@RequestMapping({ "/LC_personal_detailedStatement_c" })
	public String LC_personal_detailedStatement_c() {
		return "account/personalCenter/LC_personal_detailedStatement_c";
	}

	@RequestMapping({ "/LC_personal_detailedStatement_v" })
	public String LC_personal_detailedStatement_v() {
		return "account/personalCenter/LC_personal_detailedStatement_v";
	}

	@RequestMapping({ "/LC_company_BL" })
	public String LC_company_BL() {
		return "account/personalCenter/LC_company_BL";
	}

	@RequestMapping({ "/LC_company_BL_v" })
	public String LC_company_BL_v() {
		return "account/personalCenter/LC_company_BL_v";
	}

	@RequestMapping({ "/LC_company_BL_c" })
	public String LC_company_BL_c() {
		return "account/personalCenter/LC_company_BL_c";
	}

	@RequestMapping({ "/LC_company_ICL" })
	public String LC_company_ICL() {
		return "account/personalCenter/LC_company_ICL";
	}

	@RequestMapping({ "/LC_company_ICL_c" })
	public String LC_company_ICL_c() {
		return "account/personalCenter/LC_company_ICL_c";
	}

	@RequestMapping({ "/LC_company_ICL_v" })
	public String LC_company_ICL_v() {
		return "account/personalCenter/LC_company_ICL_v";
	}

	@RequestMapping({ "/LC_company_OC" })
	public String LC_company_OC() {
		return "account/personalCenter/LC_company_OC";
	}

	@RequestMapping({ "/LC_company_OC_v" })
	public String LC_company_OC_v() {
		return "account/personalCenter/LC_company_OC_v";
	}

	@RequestMapping({ "/LC_company_OC_c" })
	public String LC_company_OC_c() {
		return "account/personalCenter/LC_company_OC_c";
	}

	@RequestMapping({ "/LC_company_AL" })
	public String LC_company_AL() {
		return "account/personalCenter/LC_company_AL";
	}

	@RequestMapping({ "/LC_company_AL_v" })
	public String LC_company_AL_v() {
		return "account/personalCenter/LC_company_AL_v";
	}

	@RequestMapping({ "/LC_company_AL_c" })
	public String LC_company_AL_c() {
		return "account/personalCenter/LC_company_AL_c";
	}

	@RequestMapping({ "/LC_company_DS" })
	public String LC_company_DS() {
		return "account/personalCenter/LC_company_DS";
	}

	@RequestMapping({ "/LC_company_DS_v" })
	public String LC_company_DS_v() {
		return "account/personalCenter/LC_company_DS_v";
	}

	@RequestMapping({ "/LC_company_DS_c" })
	public String LC_company_DS_c() {
		return "account/personalCenter/LC_company_DS_c";
	}

	@RequestMapping({ "/LC_company_scene" })
	public String LC_company_scene() {
		return "account/personalCenter/LC_company_scene";
	}

	@RequestMapping({ "/LC_company_scene_v" })
	public String LC_company_scene_v() {
		return "account/personalCenter/LC_company_scene_v";
	}

	@RequestMapping({ "/LC_company_scene_c" })
	public String LC_company_scene_c() {
		return "account/personalCenter/LC_company_scene_c";
	}

	@RequestMapping({ "/LC_company_TR" })
	public String LC_company_TR() {
		return "account/personalCenter/LC_company_TR";
	}

	@RequestMapping({ "/LC_company_TR_v" })
	public String LC_company_TR_v() {
		return "account/personalCenter/LC_company_TR_v";
	}

	@RequestMapping({ "/LC_company_TR_c" })
	public String LC_company_TR_c() {
		return "account/personalCenter/LC_company_TR_c";
	}

	@RequestMapping({ "/LC_company_approval" })
	public String LC_company_approval() {
		return "account/personalCenter/LC_company_approval";
	}

	@RequestMapping({ "/LC_company_approval_v" })
	public String LC_company_approval_v() {
		return "account/personalCenter/LC_company_approval_v";
	}

	@RequestMapping({ "/LC_company_approval_c" })
	public String LC_company_approval_c() {
		return "account/personalCenter/LC_company_approval_c";
	}

	@RequestMapping({ "/LC_company_FD" })
	public String LC_company_FD() {
		return "account/personalCenter/LC_company_FD";
	}

	@RequestMapping({ "/LC_company_FD_c" })
	public String LC_company_FD_c() {
		return "account/personalCenter/LC_company_FD_c";
	}

	@RequestMapping({ "/LC_company_FD_v" })
	public String LC_company_FD_v() {
		return "account/personalCenter/LC_company_FD_v";
	}

	@RequestMapping({ "/LC_company_SU" })
	public String LC_company_SU() {
		return "account/personalCenter/LC_company_SU";
	}

	@RequestMapping({ "/LC_company_SU_c" })
	public String LC_company_SU_c() {
		return "account/personalCenter/LC_company_SU_c";
	}

	@RequestMapping({ "/LC_company_SU_v" })
	public String LC_company_SU_v() {
		return "account/personalCenter/LC_company_SU_v";
	}

	@RequestMapping({ "/LC_company_freehold" })
	public String LC_company_freehold() {
		return "account/personalCenter/LC_company_freehold";
	}

	@RequestMapping({ "/LC_company_freehold_v" })
	public String LC_company_freehold_v() {
		return "account/personalCenter/LC_company_freehold_v";
	}

	@RequestMapping({ "/LC_company_freehold_c" })
	public String LC_company_freehold_c() {
		return "account/personalCenter/LC_company_freehold_c";
	}

	@RequestMapping({ "/LC_company_voiture" })
	public String LC_company_voiture() {
		return "account/personalCenter/LC_company_voiture";
	}

	@RequestMapping({ "/LC_company_voiture_v" })
	public String LC_company_voiture_v() {
		return "account/personalCenter/LC_company_voiture_v";
	}

	@RequestMapping({ "/LC_company_voiture_c" })
	public String LC_company_voiture_c() {
		return "account/personalCenter/LC_company_voiture_c";
	}

	@RequestMapping({ "/LC_company_GI" })
	public String LC_company_GI() {
		return "account/personalCenter/LC_company_GI";
	}

	@RequestMapping({ "/LC_company_GI_v" })
	public String LC_company_GI_v() {
		return "account/personalCenter/LC_company_GI_v";
	}

	@RequestMapping({ "/LC_company_GI_c" })
	public String LC_company_GI_c() {
		return "account/personalCenter/LC_company_GI_c";
	}

	@RequestMapping({ "/LC_company_corporation" })
	public String LC_company_corporation() {
		return "account/personalCenter/LC_company_corporation";
	}

	@RequestMapping({ "/LC_company_corporation_v" })
	public String LC_company_corporation_v() {
		return "account/personalCenter/LC_company_corporation_v";
	}

	@RequestMapping({ "/LC_company_corporation_c" })
	public String LC_company_corporation_c() {
		return "account/personalCenter/LC_company_corporation_c";
	}

	@RequestMapping({ "/mail" })
	public String mail() {
		return "account/personalCenter/mail";
	}

	
	//站内信
	@Resource(name="memberStationServiceImpl")
	MemberStationService memberStationService;
	
	@RequestMapping({ "/M_receivedDetail" })
	public String M_receivedDetail(HttpServletRequest req) {
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		String letterID =req.getParameter("start");
		
		Map<String,Object> param=new HashMap<String,Object>();
		
		param.put("memberID", lMemberInfo[0]);
		param.put("letterID", letterID);
		param.put("keys", DbKeyUtil.GetDbCodeKey());//加密解密用的秘钥
		
		MemberStationLetterEntity entity = memberStationService.selectRecLetterDetail(param);
		if(entity!=null){
			//设为已读
			int result = memberStationService.updateRecStationRead(Integer.parseInt(letterID));
		}
		req.setAttribute("mail", entity);
		return "account/personalCenter/M_receivedDetail";
	}

	@RequestMapping({ "/M_sentDetail" })
	public String M_sentDetail(HttpServletRequest req) {
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		String letterID =req.getParameter("start");
		
		Map<String,Object> param=new HashMap<String,Object>();
		
		param.put("memberID", lMemberInfo[0]);
		param.put("letterID", letterID);
		param.put("keys", DbKeyUtil.GetDbCodeKey());//加密解密用的秘钥
		
		MemberStationLetterEntity entity = memberStationService.selectSendLetterDetail(param);
		req.setAttribute("mail", entity);
		return "account/personalCenter/M_sentDetail";
	}

	@RequestMapping({ "/M_sent" })
	public String M_sent() {
		return "account/personalCenter/M_sent";
	}

	@RequestMapping({ "/M_write" })
	public String M_write() {
		return "account/personalCenter/M_write";
	}

	@RequestMapping({ "/stationMessage" })
	public String stationMessage() {
		return "account/personalCenter/stationMessage";
	}

	
	/***
	* 消息提醒设置
	* 
	* @author 李杰
	* @return
	* @date 2016-5-9 下午3:18:57
	*/
	@RequestMapping(value="/messageAlert")
	public String messageAlert(HttpServletRequest request) {
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		
		//查询出配置列表
		List<MemberMessageConfig> list = memberMsgSetService.memberMessageConfig(memberInfo.getId());
		
		request.setAttribute("list", list);
		return "account/personalCenter/messageAlert";
	}

	
	/***
	* 设置消息提醒设置
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-9 下午3:32:18
	*/
	@RequestMapping(value="messageConfig",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String messageConfig(HttpServletRequest request){
		String projectId 	= request.getParameter("projectId");			//类型
		String typeId		= request.getParameter("typeId");				//1短信 、2站内信 、3邮件
		String option		= request.getParameter("option");				//0 取消 1是设置
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		
		SendSetEntity entity  = new SendSetEntity();
		entity.setTypeID(Long.parseLong(projectId));
		entity.setMemberID(memberInfo.getMemberId());
		entity.setStatu(Integer.parseInt(option));
		
		int result 			= -2;
		if(typeId != null){
			if(typeId.equals("1")){
				result = memberMsgSetService.insertMemberSmsSendSet(entity);
			}else if(typeId.equals("2")){
				result = memberMsgSetService.insertMemberLetterSendSet(entity);
			}else if(typeId.equals("3")){
				result = memberMsgSetService.insertMemberEmailSendSet(entity);
			}
		}
		Map<String,Object> param = new HashMap<String, Object>();
		if(result == -2){
			param.put("status", "-2");
			param.put("message", "参数错误");
		}else if(result == -1){
			param.put("status", "-1");
			param.put("message", "参数错误");
		}else if(result == -2){
			param.put("status", "-3");
			param.put("message", "平台未开通该消息提醒");
		}else if(result == 1){
			param.put("status", "1");
			param.put("message", "设置成功");
		}else{
			param.put("status", "0");
			param.put("message", "设置失败");
		}
		return JSONObject.toJSONString(param);
	}
	
	
	@RequestMapping(value="/recommendedTalent") 
	public String recommendedTalent(HttpServletRequest request) { 	
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		InviteMasterAwardRecordEntity entity = inviteMasterApplyService.selectInviteMasterStatistic(lMemberInfo[0]); 
		if(entity == null) {
			entity = new InviteMasterAwardRecordEntity(0,0,0,0,0,0,0,0,0,0);
		}
		request.setAttribute("entityAward", entity);
		return "account/personalCenter/recommendedTalent";
	}

	@RequestMapping({ "/financialAdvisor" })
	public String financialAdvisor(HttpServletRequest request) {
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		InviteMasterAwardRecordEntity entity = financialAdvisorService.selectFinancialMasterStatistic(lMemberInfo[0]);
		if(entity == null) {
			entity = new InviteMasterAwardRecordEntity(0,0,0,0,0,0,0,0,0,0);
		}
		request.setAttribute("advisorGenneral", entity);
		return "account/personalCenter/financialAdvisor";
	}
}
