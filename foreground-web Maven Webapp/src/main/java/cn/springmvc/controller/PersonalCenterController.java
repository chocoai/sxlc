package cn.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.constant.Constant;
import product_p2p.kit.redisPlug.Core;
import cn.dictionaries.model.NationInfoEntity;
import cn.membermng.model.BorrowingType;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.RealNameAuth;
import cn.membermng.model.SecurityInfo;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.service.EmailBindingService;
import cn.springmvc.service.IBorrowingCertificationServer;
import cn.springmvc.service.IMemberService;
//import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.MobilePhoneBindingService;
//import cn.sxlc.account.manager.model.AccountInterfaceEntity;

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
public class personalCenterController {

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

	// @Autowired
	// private ManagedInterfaceServerTestI interfaceServerTestI;

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
		MemberInfo loginMember = (MemberInfo) request.getSession()
				.getAttribute("loginUser");
		MemberInfo memberInfo = null;

		if (loginMember.getMemberType().intValue() == 1) {
			memberInfo = this.memberService.memberComplanyInfo(loginMember
					.getId().longValue());
			if (memberInfo.getBaseInfo().getPersonalPhone() != null
					&& memberInfo.getBaseInfo().getPersonalPhone().length() == 11) {
				memberInfo.getBaseInfo().setPersonalPhone(
						memberInfo.getBaseInfo().getPersonalPhone()
								.substring(0, 3)
								+ "****"
								+ memberInfo
										.getBaseInfo()
										.getPersonalPhone()
										.substring(
												memberInfo.getBaseInfo()
														.getPersonalPhone()
														.length() - 3,
												memberInfo.getBaseInfo()
														.getPersonalPhone()
														.length()));
			}
			if (memberInfo.getBaseInfo().getQq() != null
					&& memberInfo.getBaseInfo().getQq().length() >= 5) {
				memberInfo.getBaseInfo().setQq(
						memberInfo.getBaseInfo().getQq().substring(0, 2)
								+ "***"
								+ memberInfo
										.getBaseInfo()
										.getQq()
										.substring(
												memberInfo.getBaseInfo()
														.getQq().length() - 2,
												memberInfo.getBaseInfo()
														.getQq().length()));
			}
			request.setAttribute("userInfo", memberInfo);
			return "account/personalCenter/baseInformationForEnterprise";
		}
		memberInfo = this.memberService.memberPersonalInfo(loginMember.getId()
				.longValue());
		if (memberInfo.getBaseInfo().getPersonalPhone() != null
				&& memberInfo.getBaseInfo().getPersonalPhone().length() == 11) {
			memberInfo.getBaseInfo().setPersonalPhone(
					memberInfo.getBaseInfo().getPersonalPhone().substring(0, 3)
							+ "****"
							+ memberInfo
									.getBaseInfo()
									.getPersonalPhone()
									.substring(
											memberInfo.getBaseInfo()
													.getPersonalPhone()
													.length() - 3,
											memberInfo.getBaseInfo()
													.getPersonalPhone()
													.length()));
		}
		if (memberInfo.getBaseInfo().getQq() != null
				&& memberInfo.getBaseInfo().getQq().length() >= 5) {
			memberInfo.getBaseInfo().setQq(
					memberInfo.getBaseInfo().getQq().substring(0, 2)
							+ "***"
							+ memberInfo
									.getBaseInfo()
									.getQq()
									.substring(
											memberInfo.getBaseInfo().getQq()
													.length() - 2,
											memberInfo.getBaseInfo().getQq()
													.length()));
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
		String memberQQ = request.getParameter("memberQQ");
		String address = request.getParameter("address");
		String hjdz = request.getParameter("hjdz");
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String countyId = request.getParameter("countyId");
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
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String countyId = request.getParameter("countyId");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String contactQQ = request.getParameter("contactQQ");
		String contactEmail = request.getParameter("contactEmail");
		String companyProfile = request.getParameter("companyProfile");

		Map<String, Object> message = new HashMap<String, Object>();
		if ((contactName == null) || (!StringUtils.checkUserName(contactName))) {
			message.put("contactName", "请输入联系人姓名");
		}
		if ((contactPhone == null) || (!StringUtils.checkPhone(contactPhone))) {
			message.put("contactPhone", "请输入联系人电话号码");
		}
		if ((contactQQ == null) || (!StringUtils.checkQQ(contactQQ))) {
			message.put("contactQQ", "请输入联系人QQ号码");
		}
		if ((contactEmail == null) || (!StringUtils.checkMail(contactEmail))) {
			message.put("contactEmail", "请输入联系邮箱地址");
		}
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
				contactName, contactPhone, contactQQ, contactEmail,
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
			Map<String, Object> map = this.borrowingCertificationServer.showBusinessLicense(info.getId().longValue());
			request.setAttribute("businessInfo", map);
		} else {
			RealNameAuth realNameInfo = this.borrowingCertificationServer.showAuthRealName(info.getId());
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

	@RequestMapping({ "/myVIP" })
	public String myVIP() {
		return "account/personalCenter/myVIP";
	}

	@RequestMapping({ "/integralManagement" })
	public String integralManagement() {
		return "account/personalCenter/integralManagement";
	}

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
			@PathVariable("typeId") long typeId) {
		String pagePath = "";
		if (typeId == 1L) // 个人会员实名认证
		{
			List<NationInfoEntity> nationList = this.memberService
					.GetNationList();
			request.setAttribute("nationList", nationList);
			pagePath = "account/personalCenter/LC_personal_realNameAuthentication";
		}

		return pagePath;
	}

	/***
	 * 个人会员实名认证
	 * 
	 * @author 李杰
	 * @param request
	 * @return
	 * @date 2016-4-27 上午9:52:20
	 */
	@RequestMapping(value="personalRealName",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String personalRealName(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		int nationId = Integer.parseInt(request.getParameter("nationId"));
		String idCard = request.getParameter("idCard");
		String homeTown = request.getParameter("homeTown");
		String endTime = request.getParameter("endTime");
		String annex = request.getParameter("annex");

		Map<String, Object> message = new HashMap<String, Object>();
		if ((userName == null) || (!StringUtils.checkUserName(userName))) {
			message.put("userName", "请输入用户名");
		}
		if ((idCard == null) || (!StringUtils.checkIdCard(idCard))) {
			message.put("idCard", "请输入身份证号");
		}
		if (homeTown == null) {
			message.put("homeTown", "请输入籍贯");
		}
		if (endTime == null) {
			message.put("endTime", "请选择有效期");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(endTime);
				endTime = sdf.format(date);
			} catch (Exception e) {
				message.put("endTime", "请选择有效期");
			}
		}
		String[] annexArray = annex.split(",");
		if (annexArray.length < 2) {
			message.put("annex", "请上传身份证照片");
		}

		if (message.keySet().size() > 0) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}

		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(
				"loginUser");

		return null;
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
		String phone = request.getParameter("phone");
		Map<String, Object> message = new HashMap<String, Object>();
		if ((phone == null) || (!StringUtils.checkPhone(phone))) {
			message.put("phone", "请输入手机号");
			message.put("status", Integer.valueOf(-2));
			return JSONObject.toJSONString(message);
		}

		String sCode = Core.getEditBindPhoneCode(phone);
		if (sCode != null) {
			this.logger.debug("用户修改手机绑定手机短信验证码发送成功：" + phone + " : " + sCode);
			message.put("status", Integer.valueOf(1));
			message.put("message", "验证码发送成功,请注意查收");
			return JSONObject.toJSONString(message);
		}
		String code = StringUtils.varCode();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("phone", phone);
		param.put("code", code);
		int iresult = Core.putEditBindPhoneCode(phone, code);
		if (iresult == 1) {
			String[] result = { "0", "" };
			if (result[0].equals("0")) {
				this.logger
						.debug("用户修改手机绑定手机短信验证码发送成功：" + phone + " : " + code);
				message.put("status", 1);
				message.put("message", "验证码发送成功,请注意查收");
			} else {
				this.logger
						.debug("用户修改手机绑定手机短信验证码发送失败：" + phone + " : " + code);
				message.put("status", 0);
				message.put("message", "验证码发送失败,请重试!");
			}
		} else {
			this.logger.debug("用户注册手机短信验证码发送失败：" + phone + " : " + code);
			message.put("status", 0);
			message.put("message", "验证码发送失败,请重试!");
		}
		return JSONObject.toJSONString(message);
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
		String oldPhone = request.getParameter("oldPhone");
		String newPhone = request.getParameter("newPhone");
		String chekcCode = request.getParameter("imgCheckCode");
		String phoneCode = request.getParameter("phoneCode");

		Map<String, Object> param = new HashMap<String, Object>();
		if ((oldPhone == null) || (!StringUtils.checkPhone(oldPhone))) {
			param.put("oldPhone", "请输入原来手机号码");
		}
		if ((newPhone == null) || (!StringUtils.checkPhone(newPhone))) {
			param.put("newPhone", "请输入新手机号码");
		}
		if ((chekcCode == null) || (chekcCode.trim().length() == 0))
			param.put("chekcCode", "请输入验证码");
		else if (!chekcCode.equals(request.getSession()
				.getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			param.put("chekcCode", "验证码错误");
		}
		if ((phoneCode == null) || (phoneCode.trim().length() == 0))
			param.put("phoneCode", "请输入短信验证码");
		else if (!phoneCode.equals(Core.getEditBindPhoneCode(newPhone))) {
			param.put("phoneCode", "短信验证码错误");
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
		String phones = mobilePhoneBindingService.selectOldPhone(memberInfo.getId());
		if (oldPhone.equals(mobilePhoneBindingService.selectOldPhone(memberInfo.getId()))) {
			Map<String, Object> param2 = new HashMap<String, Object>();
			param2.put("personalPhone", newPhone);
			param2.put("personalID", memberInfo.getPersonalId());
			int result = this.mobilePhoneBindingService.updatepersonPhone(param2);
			if (result == 1) {
				param.put("status", 1);
				param.put("message", "修改成功");
			} else if (result == -1) {
				param.put("status", -1);
				param.put("message", "手机号已被使用");
			} else {
				param.put("status", 0);
				param.put("message", "修改失败");
			}
		} else {
			param.put("status", "-3");
			param.put("message", "原始手机号错误");
		}
		return JSONObject.toJSONString(param);
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
		String email = request.getParameter("email");
		Map<String, Object> message = new HashMap<String, Object>();
		if ((email == null) || (!StringUtils.checkMail(email))) {
			message.put("email", "请输入邮箱");
			message.put("status", -2);
			return JSONObject.toJSONString(message);
		}

		String sCode = Core.getBindEmailCode(email);
		if (sCode != null) {
			this.logger.debug("用户绑定邮箱邮箱证码发送成功：" + email + " : " + sCode);
			message.put("status", 1);
			message.put("message", "验证码发送成功,请注意查收");
			return JSONObject.toJSONString(message);
		}
		String code = StringUtils.varCode();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
		param.put("code", code);
		int iresult = Core.putBindEmailCode(email, code);
		if (iresult == 1) {
			String[] result = { "0", "" };// 处理发送------------------------------------------------------------------------
			if (result[0].equals("0")) {
				this.logger.debug("用户绑定邮箱邮箱证码发送成功：" + email + " : " + code);
				message.put("status", 1);
				message.put("message", "验证码发送成功,请注意查收");
			} else {
				this.logger.debug("用户绑定邮箱邮箱证码发送失败：" + email + " : " + code);
				message.put("status", -1);
				message.put("message", "验证码发送失败,请重试!");
			}
		} else {
			this.logger.debug("用户注册手机短信验证码发送失败：" + email + " : " + code);
			message.put("status", -1);
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
		String email = request.getParameter("email"); // 邮箱地址
		String imgCheckCode = request.getParameter("checkCode"); // 验证码
		String emailCheckCode = request.getParameter("emailCheckCode"); // 邮箱验证码

		Map<String, Object> param = new HashMap<String, Object>();
		if (email == null || email.trim().length() <= 0) {
			param.put("email", "请输入邮箱地址");
		} else if (!StringUtils.checkMail(email)) {
			param.put("email", "请输入有效邮箱地址");
		}
		if (imgCheckCode == null || imgCheckCode.trim().length() <= 0) {
			param.put("imgCheckCode", "请输入图形验证码");
		} else if (!imgCheckCode.equals(request.getSession()
				.getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			param.put("imgCheckCode", "图形验证码错误");
		}
		if (emailCheckCode == null || emailCheckCode.trim().length() <= 0) {
			param.put("emailCheckCode", "请输入邮箱验证码");
		} else if (!emailCheckCode.equals(Core.getBindEmailCode(email))) {
			param.put("emailCheckCode", "邮箱验证码错误");
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
	 * @Title: editBindEmail
	 * @param request
	 * @return
	 * @date 2016-4-27 上午11:05:07
	 */
	@RequestMapping(value = "editBindEmail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String editBindEmail(HttpServletRequest request) {
		String oldEmail = request.getParameter("oldEmail");
		String newEmail = request.getParameter("newEmail");
		String checkCode = request.getParameter("checkCode");
		String emailCode = request.getParameter("emailCode");

		Map<String, Object> message = new HashMap<String, Object>();
		if (oldEmail == null || oldEmail.trim().length() <= 0) {
			message.put("oldEmail", "请输入邮箱地址");
		} else if (!StringUtils.checkMail(oldEmail)) {
			message.put("oldEmail", "请输入有效有限地址");
		}
		if (newEmail == null || newEmail.trim().length() <= 0) {
			message.put("newEmail", "请输入有效邮箱地址");
		} else if (!StringUtils.checkMail(newEmail)) {
			message.put("newEmail", "请输入有效邮箱地址");
		}
		if (newEmail != null && oldEmail != null && newEmail.equals(oldEmail)) {
			message.put("newEmail", "新邮箱和旧邮箱不能一致");
		}
		if (checkCode == null || checkCode.trim().length() <= 0) {
			message.put("checkCode", "请输入图形验证码");
		} else if (!checkCode.equals(request.getSession()
				.getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())) {
			message.put("checkCode", "图形验证码错误");
		}
		if (emailCode == null || emailCode.trim().length() <= 0) {
			message.put("emailCode", "请输入邮箱验证码");
		} else if (!emailCode.equals(Core.getBindEmailCode(newEmail))) {
			message.put("emailCode", "邮箱验证码错误");
		}

		if (message.keySet().size() > 0) {
			message.put("status", "-2");
			return JSONObject.toJSONString(message);
		}

		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(
				Constant.LOGINUSER);
		String saveOldEmail = emailBindingService.selectOldEmail(memberInfo
				.getId());
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
	@RequestMapping(value = "openAccount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String openThirdAccount(HttpServletRequest request) {
		// AccountInterfaceEntity accountInterfaceEntity = new
		// AccountInterfaceEntity();
		// MemberInfo memberInfo = (MemberInfo)
		// request.getSession().getAttribute(Constant.LOGINUSER);
		// accountInterfaceEntity.setMemberType(memberInfo.getMemberType());
		// accountInterfaceEntity.setId(memberInfo.getId());
		// accountInterfaceEntity =
		// interfaceServerTestI.testAccountInterfaceQDD(accountInterfaceEntity);
		// request.setAttribute("accountInterfaceEntity",
		// accountInterfaceEntity);
		return "dryLot/loanregisterbindtest";
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

	@RequestMapping({ "/M_receivedDetail" })
	public String M_receivedDetail() {
		return "account/personalCenter/M_receivedDetail";
	}

	@RequestMapping({ "/M_sentDetail" })
	public String M_sentDetail() {
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

	@RequestMapping({ "/messageAlert" })
	public String messageAlert() {
		return "account/personalCenter/messageAlert";
	}

	@RequestMapping({ "/recommendedTalent" })
	public String recommendedTalent() {
		return "account/personalCenter/recommendedTalent";
	}

	@RequestMapping({ "/financialAdvisor" })
	public String financialAdvisor() {
		return "account/personalCenter/financialAdvisor";
	}
}
