package cn.springmvc.controller.member; 

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.BorrowingStatistics;
import cn.membermng.model.ComplanyInfoEntity;
import cn.membermng.model.MemberAttestInfo;
import cn.membermng.model.MemberDetaileInfo;
import cn.membermng.model.MemberInvestmentInfo;
import cn.membermng.model.MemberThirdInfo;
import cn.membermng.model.MyRecommand;
import cn.membermng.model.TradingTypeEntity;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.sms.SendEmail;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.service.CapitalbudgetdetailsService;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.service.IMemberManangerService;
import cn.springmvc.service.InvestmentManagementService;
import cn.springmvc.service.MyBorrowAndInvestService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 全部会员管理控制器 
* @date 2016-4-21 上午10:21:46 
*/
@Controller
@RequestMapping("/member")
public class AllMemberController {
	
	@Autowired
	private IMemberManangerService memberManangerService;
	
	@Autowired
	private MyBorrowAndInvestService myBorrowAndInvestService;
	
	@Autowired
	private CapitalbudgetdetailsService capitalbudgetdetailsService;
	
	@Autowired
	private CertificationAuditService certificationAuditService;
	
	@Autowired
	private InvestmentManagementService investmentManagementService;
	
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	@Autowired
	private SendEmail  sendEmail;
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到全部会员页面
	 * @param req
	 * @return String  
	 * @date 2016-4-21 上午10:25:56
	 */
	@RequestMapping("/toAllMemberPg")
	public String toAllMemberPg(HttpServletRequest req){
		return "member/allMembers";
	}
	
	
/*************************查询会员列表 start*************************************************************/	
	/** 
	 * @author 唐国峰 +pr
	 * @Description: 获取全部会员数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-4-21 上午10:51:37 
	 * 修改日期：2016-4-29上午11:10:39
	 */
	@RequestMapping(value ="/getAllMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getAllMembers(HttpServletRequest req){
		//查询条件
		String memberName = req.getParameter("memberName");
		String personalName = req.getParameter("personalName");
		String personalPhone = req.getParameter("personalPhone");
		int  automaticBidding = IntegerAndString.StringToInt(req.getParameter("automaticBidding"),-1);
		int automaticRepayment =  IntegerAndString.StringToInt(req.getParameter("automaticRepayment"),-1);
		
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("personalName", personalName);
		map.put("personalPhone", personalPhone);
		map.put("automaticBidding", automaticBidding);
		map.put("automaticRepayment", automaticRepayment);
		
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.getMembersByParam(pager);
		return pager;
	}
	
	/**
	 * 条件查询所有vip会员
	 * TODO
	 * 创建日期：2016-4-29上午11:10:39
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getVipMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getVipMembers(HttpServletRequest req){
		//查询条件
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.getVIPMemberByParam(pager);
		return pager;
	}
	
	/**
	 * 条件查询所有注册会员
	 * TODO
	 * 创建日期：2016-4-29上午11:10:39
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getRegMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getRegMembers(HttpServletRequest req){
		//查询条件String memberName, String userName,String phone, String idCard, String regDate, Integer regType
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String idcard = req.getParameter("idcard");
		String startDate = req.getParameter("startDate");
		String endDate  = req.getParameter("endDate");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("idcard", idcard);
		map.put("regDate", startDate);
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.registers(pager);
		return pager;
	}	
	
	/**
	 * 条件查询所有认证会员
	 * TODO
	 * 创建日期：2016-4-29上午11:59:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getIdentyMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getIdentyMembers(HttpServletRequest req){
		//查询条件String memberName,String userName, String phone, String idCard, String regDate,String endDate
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String idcard = req.getParameter("idcard");
		String startDate = req.getParameter("startDate");
		String endDate  = req.getParameter("endDate");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("idcard", idcard);
		map.put("regDate", startDate);
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.authenticationMember(pager);
		return pager;
	}
	/**
	 * 条件查询所有借款会员
	 * TODO
	 * 创建日期：2016-4-29上午11:59:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getLoadMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getLoadMembers(HttpServletRequest req){
		//查询条件String memberName,String userName, String phone, String idCard, String regDate,String endDate
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.loanMember(pager);
		return pager;
	}
	/**
	 * 条件查询所有投资会员
	 * TODO
	 * 创建日期：2016-4-29上午11:59:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getInvestMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getInvestMembers(HttpServletRequest req){
		//查询条件String memberName,String userName, String phone, String idCard, String regDate,String endDate
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.investmentMember(pager);
		return pager;
	}
	/**
	 * 条件查询所有复合会员
	 * TODO
	 * 创建日期：2016-4-29上午11:59:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getComponentMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getComponentMembers(HttpServletRequest req){
		//查询条件String memberName,String userName, String phone, String idCard, String regDate,String endDate
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String memberType =  req.getParameter("memberType");		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.componentMembers(pager);
		return pager;
	}
	/**
	 * 条件查询所有黑名单会员
	 * TODO
	 * 创建日期：2016-4-29上午11:59:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getBlackMembers", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getBlackMembers(HttpServletRequest req){
		//查询条件String userName, String memberName,String phone, String startTime, String endTime
		String memberName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String startTime =req.getParameter("startDate");
		String endTime =req.getParameter("endDate");
		String memberType =  req.getParameter("memberType");	
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("memberType", memberType);
		map.put("memberName", memberName);
		map.put("userName", userName);
		map.put("phone", phone);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		pager.setMap(map);
		memberManangerService.blackList(pager);
		return pager;
	}	
	/*************************查询会员列表 end*************************************************************/	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改会员信息
	 * @param req
	 * @return int  
	 * @date 2016-4-21 上午11:01:40
	 * @throws 
	 */
	@RequestMapping("/updateMemberInfo")
	@ResponseBody
	public int updateMemberInfo(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=504(管理团队管理)
		//optID=50401(添加) 50402 修改
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(504);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MngTeamEntity entity = new  MngTeamEntity();
		//获取解密参数
		String mngName = req.getParameter("mngName");
		entity.setMngName(mngName);
		String mngPost = req.getParameter("mngPost");
		entity.setMngPost(mngPost);
		String portraitUrl = req.getParameter("portraitUrl");
		entity.setPortraitUrl(portraitUrl);
		String profile = req.getParameter("profile");
		entity.setProfile(profile);
		
		entity.setStatu(1);//状态
		entity.setOptId(admin.getId());//操作者id
		
		int result=0;
		String type = req.getParameter("type");
		if(type.equals("1")){//增加操作
			logEntity.setlOptId(50401);
//			result = memberManangerService.(entity,logEntity,sIpInfo);
		}else if(type.equals("2")){//修改操作
			logEntity.setlOptId(50402);
			Long teamId = Long.parseLong(req.getParameter("teamId"));
			entity.setId(teamId);
//			result = memberManangerService.updateMngTeamByID(entity,logEntity,sIpInfo);
		}
		return result;
	}

	
	
/*************************会员操作 start*************************************************************/		
	/**
	 * 会员交易类型
	 * TODO
	 * 创建日期：2016-5-2下午2:13:19
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberDetaileInfo
	 */
	@RequestMapping(value ="/getMemTradeType", method = RequestMethod.POST)
	@ResponseBody
	public List<TradingTypeEntity> getMemTradeType(HttpServletRequest req){
		 List<TradingTypeEntity>  tradingTypeEntities =  memberManangerService.memberTradingTypes();
		 req.setAttribute("TradeType", tradingTypeEntities);
		 return tradingTypeEntities;
	}
	
	/**
	 * 会员交易列表
	 * TODO
	 * 创建日期：2016-5-2下午2:13:19
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberDetaileInfo
	 */
/*	@RequestMapping(value ="/getMemTradeList", method = RequestMethod.POST)
	@ResponseBody
	public List<MemberTradingRecordsEntity>  getMemTradeList(HttpServletRequest req){
		Map<String,Object> map = new HashMap<String, Object>();
		long memberId = IntegerAndString.StringToLong(req.getParameter("memberId"),0);
		int pageSize = IntegerAndString.StringToInt(req.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(req.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		map.put("memberId", memberId);
		pageEntity.setMap(map);
		List<MemberTradingRecordsEntity>   tradingTypeEntities =  memberManangerService.memberTradingList(pageEntity);
		return tradingTypeEntities;//capitalbudgetdetailsService
	}*/
	@RequestMapping(value ="/getMemTradeList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getMemTradeList(HttpServletRequest req){
		Map<String,Object> map = new HashMap<String, Object>();
		long memberId = IntegerAndString.StringToLong(req.getParameter("memberId"),0);
		long memberType = IntegerAndString.StringToLong(req.getParameter("memberType"),0);
		int pageSize = IntegerAndString.StringToInt(req.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(req.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		map.put("memberId", memberId);
		map.put("memberType", memberType);
		pageEntity.setMap(map);
		capitalbudgetdetailsService.selectMemberTradingRecords(pageEntity);
		return pageEntity;//capitalbudgetdetailsService
	}
	
	
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 根据会员id获取会员详细信息
	 * @param req  
	 * @return void  
	 * @date 2016-4-21 下午2:05:03
	 * @throws 
	 */
	@RequestMapping(value ="/getMemDetail", method = RequestMethod.POST)
	@ResponseBody
	public MemberDetaileInfo getMemDetail(HttpServletRequest req){
		 long memberId = IntegerAndString.StringToLong(req.getParameter("memberId"),0);
		 MemberDetaileInfo detail =  memberManangerService.memberInfoById(memberId);
		 if(detail==null){
			 detail = new MemberDetaileInfo();
		 }
		 return detail;
	}

	/**
	 * 根据会员id获取企业会员详细信息
	 * TODO
	 * 创建日期：2016-5-11下午6:35:59
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberDetaileInfo
	 */
	@RequestMapping(value ="/getCompanyDetail", method = RequestMethod.POST)
	@ResponseBody
	public ComplanyInfoEntity getCompanyDetail(HttpServletRequest req){
		 long memberId = IntegerAndString.StringToLong(req.getParameter("memberId"),0);
		 ComplanyInfoEntity detail =  memberManangerService.companyInfo(memberId);
		 if(detail==null){
			 detail = new ComplanyInfoEntity();
		 }
		 return detail;
	}
		
	
	/**
	 * 根据id获取会员第三方信息
	 * TODO
	 * 创建日期：2016-4-28下午5:21:54
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberThirdInfo
	 */
	@RequestMapping(value ="/getMemberThirdInfo", method = RequestMethod.POST)
	@ResponseBody
	public MemberThirdInfo getMemberThirdInfo(HttpServletRequest request){
		
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		MemberThirdInfo info = memberManangerService.memberThirdInfo(memberId, 0);
		 if(info==null){
			 info = new MemberThirdInfo();
		 }
		return info;
	}
	/**
	 * 根据id获取会员认证信息 
	 * TODO
	 * 创建日期：2016-4-28下午5:21:54
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberThirdInfo
	 */
	@RequestMapping(value ="/getMemberIdenty", method = RequestMethod.POST)
	@ResponseBody
	public List<MemberAttestInfo> getMemberIdenty(HttpServletRequest request){
		
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		List<MemberAttestInfo> info = memberManangerService.memberConfInfo(memberId, 0);
		return info;
	}
	/**
	 *  根据id获取会员会员借款信用统计
	 * TODO
	 * 创建日期：2016-4-29上午9:55:36
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return BorrowingStatistics
	 */
	@RequestMapping(value ="/getMemberborrowers", method = RequestMethod.POST)
	@ResponseBody
	public BorrowingStatistics getMemberborrowers(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		BorrowingStatistics info = memberManangerService.borrowers(memberId, 0);
		if(info==null){
			info = new BorrowingStatistics();
			info.setInvestmentCount(0);
			info.setLoanCount(0);
			info.setOverdueRepaymentCount(0);
			info.setRepaymentCount(0);
		}
		return info;
	}
	/**
	 * 根据id获取会员的投资信息
	 * TODO
	 * 创建日期：2016-4-29上午9:15:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<MemberAttestInfo>
	 */
	@RequestMapping(value ="/getMemberInvestMess", method = RequestMethod.POST)
	@ResponseBody
	public MemberInvestmentInfo getMemberInvestMess(HttpServletRequest request){
		
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		MemberInvestmentInfo investment= memberManangerService.investment(memberId, 0);
		if(investment==null){
			investment = new MemberInvestmentInfo();
			investment.setInvestmentCount(0);
		}
		return investment;
	}
	
	/**
	 * 根据会员id获取会员借款项目
	 * 创建日期：2016-4-28上午11:52:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getBorrowProject", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getBorrowProject(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		String Project_No = request.getParameter("b_no"); //项目编号
		String Record_Date_Min =  request.getParameter("startDate2");//借款意向时间
		String Record_Date_Max =  request.getParameter("endDate2");
		String Project_Title =  request.getParameter("b_name"); //项目名称
		String Release_Date_Min =  request.getParameter("startDate3"); //借款发布时间
		String Release_Date_Max =  request.getParameter("endDate3"); //借款发布时间
		String Settle_Date_Min =  request.getParameter("startDate1");//结清时间
		String Settle_Date_Max =  request.getParameter("endDate1");//结清时间
		String Statu =request.getParameter("p_statu");  //项目状态
		String Hold_Date_Min =  request.getParameter("startDate"); //放款时间
		String Hold_Date_Max =  request.getParameter("endDate");
		String Guarantee_Name =  request.getParameter("gua_name");//担保人
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("Project_No", Project_No);
		map.put("Record_Date_Min",Record_Date_Min);map.put("Record_Date_Max",Record_Date_Max );
		map.put("Project_Title",Project_Title );
		map.put("Release_Date_Min",Release_Date_Min );map.put("Release_Date_Max", Release_Date_Max);
		map.put("Guarantee_Name",Guarantee_Name );
		map.put("Settle_Date_Min",Settle_Date_Min );map.put("Settle_Date_Max",Settle_Date_Max );
		map.put("Statu",Statu );
		map.put("Hold_Date_Min",Hold_Date_Min );map.put("Hold_Date_Max", Hold_Date_Max);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		myBorrowAndInvestService.getBorrowing(pageEntity);
		return pageEntity;
	}
	
	/**
	 * 根据会员id获取会员投资项目
	 * TODO
	 * 创建日期：2016-4-28上午11:52:54
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberDetaileInfo
	 */
	@RequestMapping(value ="/getInvestProject", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getInvestProject(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		String Project_No = request.getParameter("p_no"); //项目编号
		String Invest_Date_Min =  request.getParameter("startDate");//投资时间
		String Invest_Date_Max =  request.getParameter("endDate");
		String Project_Title =  request.getParameter("p_name"); //项目名称
		String Hold_Date_Min =  request.getParameter("startDate1"); //放款时间
		String Hold_Date_Max =  request.getParameter("endDate1"); //
		map.put("Project_No", Project_No);
		map.put("Invest_Date_Min", Invest_Date_Min);
		map.put("Invest_Date_Max", Invest_Date_Max);
		map.put("Project_Title", Project_Title);
		map.put("Hold_Date_Min", Hold_Date_Min);
		map.put("Hold_Date_Max", Hold_Date_Max);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		myBorrowAndInvestService.getInvestmentProject(pageEntity);
		return pageEntity;
	}
	
	
	/**
	 * 根据会员id获取会员充值列表
	 * TODO
	 * 创建日期：2016-5-6下午3:33:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getMemberRecharge", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getMemberRecharge(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		int memberType =IntegerAndString.StringToInt(request.getParameter("memberType"),0); 
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String threeNum = request.getParameter("threeNum");
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), -1);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("memberType", memberType);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("threeNum", threeNum);
		map.put("statu", statu);
		
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		capitalbudgetdetailsService.selectWithdrawalList(pageEntity);
		return pageEntity;
	}
	
	/**
	 * 根据会员id获取会员提现
	 * TODO
	 * 创建日期：2016-5-6下午3:33:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getMemberWithdrow", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getMemberWithdrow(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		int memberType =IntegerAndString.StringToInt(request.getParameter("memberType"),0); 
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = request.getParameter("startDate1");
		String endDate1 = request.getParameter("endDate1");
		String threeNum = request.getParameter("threeNum");
		String tradeNum = request.getParameter("tradeNum");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("memberType", memberType);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("startDate1", startDate1);
		map.put("endDate1", endDate1);
		map.put("threeNum", threeNum);
		map.put("tradeNum", tradeNum);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		capitalbudgetdetailsService.selectWithdrawalList(pageEntity);
		return pageEntity;
	}
	/**
	 * 根据会员id获取会员债权转让
	 * TODO
	 * 创建日期：2016-5-9下午7:52:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getMemberTrans", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getMemberTrans(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		investmentManagementService.getCreditorTransferBack(pageEntity);
		return pageEntity;
	}	
	
	/**
	 * 根据会员id获取会员银行卡
	 * TODO
	 * 创建日期：2016-4-28下午3:39:58
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getBankCard", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getBankCard(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		memberManangerService.bankCards(pageEntity);
		return pageEntity;
	}
	/**
	 * 根据会员id获取会员邀请会员列表
	 * TODO
	 * 创建日期：2016-4-28下午4:10:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getInviteList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getInviteList(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		memberManangerService.invitationsByParam(pageEntity);
		return pageEntity;
	}
	/**
	 * 根据会员id获取会员vip购买记录
	 * TODO
	 * 创建日期：2016-5-4下午9:07:22
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getVipBuyList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getVipBuyList(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(1000);
		pageEntity.setMap(map);
		certificationAuditService.VipPurchaseRecords(pageEntity, map);
		return pageEntity;
	}
	/**
	 * 拉黑某个会员
	 * TODO
	 * 创建日期：2016-4-28下午4:32:00
	 * 修改日期：
	 * 作者：pengran
	 * @param  id							管理员编号
	 * @param  memberId						会员编号
	 * @param  mac							客户端MAC地址
	 * @param  ipaddress					客户端IP地址
	 * @param  referer						请求来源
	 * @param  sessionId						
	 * @return -1会员不存在、-2会员已被拉黑		
	 * return PageEntity
	 */
	@RequestMapping(value ="/pullBlackMember", method = RequestMethod.POST)
	@ResponseBody
	public int pullBlackMember(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		long id = 0;
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			id= loginAdmin.getId();
		}
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("aid", id);
		param.put("memberId", memberId);
		IdGeneratorUtil idGeneratorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long cid = idGeneratorUtil.GetId();
		param.put("mid", cid);
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null && userInfo.getId()>0) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10501);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult = memberManangerService.pullBlack(param,entity,sIpInfo);
		return iResult;
	}
	/**
	 * 根据会员id获取会员重置密码列表
	 * TODO
	 * 创建日期：2016-5-5下午4:05:44
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getResetPwdList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getResetPwdList(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		memberManangerService.memberResetPwdList(pageEntity);
		return pageEntity;
	}

	
	/**
	 * 根据会员id修改会员密码
	 * TODO
	 * 创建日期：2016-5-5下午4:05:44
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/memberResetPwd", method = RequestMethod.GET)
	@ResponseBody
	public int  memberResetPwd(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("content"),0);
		String pwd = request.getParameter("start");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("pwd", pwd);
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null && userInfo.getId()>0) {
			entity.setiAdminId(userInfo.getId());
			map.put("adminId", userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10501);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult = memberManangerService.memberResetPwd(map,entity,sIpInfo);
		return iResult;
	}
	
	/**
	 * 我的邀请人
	 * TODO
	 * 创建日期：2016-5-6上午10:41:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MyRecommand
	 */
	@RequestMapping(value ="/MyInviteMan", method = RequestMethod.POST)
	@ResponseBody
	public List<MyRecommand> MyInviteMan(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		MyRecommand myRecommand = memberManangerService.MyRecommandMan(map);
		List<MyRecommand> list = new ArrayList<MyRecommand>();
		if(myRecommand ==null){
			MyRecommand entity = new MyRecommand();
			entity.setMemberNo("");
			entity.setPhone("");
			entity.setRealName("");
			list.add(entity);
		}
		return list ;
	}
	
	/**
	 * 期望的我的邀请人
	 * TODO
	 * 创建日期：2016-5-6上午10:41:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MyRecommand
	 */
	@RequestMapping(value ="/expectMyInviteMan", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity expectMyInviteMan(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		String memeberNo = request.getParameter("memberNo");
		String realName = request.getParameter("realName");
		String phone = request.getParameter("phone");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("realName", realName);
		map.put("memeberNo", memeberNo);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		memberManangerService.ExceptMyRecommandMan(pageEntity);
		return pageEntity;
	}	
	
	/**
	 * 修改我的邀请人
	 * TODO
	 * 创建日期：2016-5-18下午4:29:14
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * int
	 */
	@RequestMapping(value ="/updateMyInvete", method = RequestMethod.POST)
	@ResponseBody
	public int updateMyInvete(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		long inveteId = IntegerAndString.StringToLong(request.getParameter("inviteId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("inviteId", inveteId);
		int iResult = memberManangerService.updateMyInvete(map);
		return iResult ;
	}
	/**
	 * 拉黑记录查看
	 * TODO
	 * 创建日期：2016-5-6下午3:10:46
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/blackRemoveList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity blackRemoveList(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		memberManangerService.blackRecord(pageEntity);
		return pageEntity;
	}
	
	/**
	 * 取消会员拉黑记录
	 * TODO
	 * 创建日期：2016-5-9上午9:50:33
	 * 修改日期：
	 * 作者：pengran      getCreditorTransferBack
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/removeBlack", method = RequestMethod.POST)
	@ResponseBody
	public int  removeBlack(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		String remark = request.getParameter("content");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("remark", remark);
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null && userInfo.getId()>0) {
			entity.setiAdminId(userInfo.getId());
			map.put("adminId", userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10501);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult = memberManangerService.removeBlack(map, entity, sIpInfo);
		return iResult;
	}
	/**
	 * 发送消息
	 * TODO
	 * 创建日期：2016-5-9上午9:55:25
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public int  sendMessage(HttpServletRequest request){
		//type  1 发送短信  2 发送邮箱  3发送站内信息
		int type = IntegerAndString.StringToInt(request.getParameter("type"), 0);
		String phone ="";	//电话号码
		String email = "";//邮箱
		
		Map<String,Object> map = new HashMap<String, Object>();
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		int  memberType = IntegerAndString.StringToInt(request.getParameter("memberId"), 0);
		String remark = request.getParameter("remark");
		map.put("memberType", memberType);
		map.put("memberId", memberId);
		map.put("content", remark);
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		long lAdminId = 0;
		if (userInfo != null && userInfo.getId()>0) {
			lAdminId =  userInfo.getId();
		}
		int iResult = 1;
		if(type ==1){	//发送短信
			phone = request.getParameter("phone");
			map.put("phone", phone);
			Timestamp d = new Timestamp(System.currentTimeMillis()); 
			String [] mess =  sendSmsUtil.SendSms(map, 1, lAdminId,d);
			if(!mess[0].equals("-100")){
				iResult = 0; //发送成功
			}
		}else if(type==2){//发送邮箱
			email =request.getParameter("email");
			map.put("email", email);
			iResult = sendEmail.checkEmail(email, remark, request, memberId, memberType, (short)1, lAdminId);
		}else if(type==3){//发送站内信
			String vTmp = memberType+","+memberId;
			iResult = sendEmail.sendLetter(vTmp, lAdminId, (short)1, remark);
		}
		return iResult;
	}
	/**
	 * 会员已认证列表
	 * TODO
	 * 创建日期：2016-5-18下午1:39:32
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/selectAuditList", method = RequestMethod.POST)
	@ResponseBody
	public List<MemberAttestInfo> selectAuditList(HttpServletRequest request){
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		List<MemberAttestInfo> list = memberManangerService.selectAuditList(map);
		return list;
	}
	
	/*************************会员操作 end *************************************************************/		
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("remark", "你好？");
		map.put("phone", "18302827040");
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		long lAdminId =1;
		String [] mess = 	new SendSmsUtil().SendSms(map, 2, lAdminId,d);
		System.out.println(mess[0]+"==="+mess[1]);
	}
	

}

