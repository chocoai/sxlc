
package cn.springmvc.controller.recommend; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.MamberBankCardService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 银行卡管理控制层 
* @since 
* @date 2016-5-6 下午4:52:20
 */
@Controller
@RequestMapping("/bankCard")
public class BankCardController {

	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	@Resource(name="memberBankCardServiceImpl")
	private MamberBankCardService mamberBankCardService;
	
	 
	
	/**
	 * 
	* bankCardList查询银行卡列表 
	* TODO查询银行卡列表
	* @author 杨翰林  
	* * @Title: bankCardList 
	* @Description: 查询银行卡列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午5:02:46
	* @throws
	 */
	@RequestMapping("/bankCardList")
	@ResponseBody
	public PageEntity bankCardList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String memberType = request.getParameter("memberType");
		
		if (!"".equals(memberType)) {
			req.put("memberType", memberType);
		}

		req.put("guaranteeID", userInfo.getStaffId());
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.findbankcardforguaranteeID(pager);
		
		return pager;
		
	}
	
	/**
	 * 
	* queryBankInfo查询银行信息
	* TODO查询银行信息
	* @author 杨翰林  
	* * @Title: queryBankInfo 
	* @Description: 查询银行信息 
	* @param @return 设定文件 
	* @return List<BankCodeEntity> 返回类型 
	* @date 2016-5-9 下午3:41:37
	* @throws
	 */
	@RequestMapping("/queryBankInfo")
	@ResponseBody
	public List<BankCodeEntity> queryBankInfo() {
		
		List<BankCodeEntity>  list = mamberBankCardService.
				selectBankInfo();
		
		return list;
	}
	
	/**
	 * 
	* queryProvinceInfo查询省份信息 
	* TODO查询省份信息
	* @author 杨翰林  
	* * @Title: queryProvinceInfo 
	* @Description: 查询省份信息 
	* @param @return 设定文件 
	* @return List<ProvinceDictionaryEntity> 返回类型 
	* @date 2016-5-9 下午4:02:16
	* @throws
	 */
	@RequestMapping("/queryProvinceInfo")
	@ResponseBody
	public List<ProvinceDictionaryEntity> queryProvinceInfo() {
		
		List<ProvinceDictionaryEntity>  list = mamberBankCardService.
				selectProvinceDictionary();
		
		return list;
	}
	
	/**
	 * 
	* queryCityInfo根据省份id查询城市信息
	* TODO根据省份id查询城市信息
	* @author 杨翰林  
	* * @Title: queryCityInfo 
	* @Description: 根据省份id查询城市信息 
	* @param @return 设定文件 
	* @return List<ProvinceDictionaryEntity> 返回类型 
	* @date 2016-5-9 下午4:13:01
	* @throws
	 */
	@RequestMapping("/queryCityInfo")
	@ResponseBody
	public List<CityDictionaryEntity> queryCityInfo(HttpServletRequest request) {
		
		String provinceId = request.getParameter("provinceId");
		List<CityDictionaryEntity>  list = mamberBankCardService.
				selectCityDictionary(Integer.valueOf(provinceId));
		
		return list;
	}
	
	/**
	 * 
	* addBank添加银行卡 
	* TODO添加银行卡
	* @author 杨翰林  
	* * @Title: addBank 
	* @Description: 添加银行卡 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-10 上午9:32:31
	* @throws
	 */
	@RequestMapping("/add")
	@ResponseBody
	public int addBank(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String branch = request.getParameter("branch");
		String bankNo = request.getParameter("cardNo");
		String bankPhone = request.getParameter("phone");
		String memberType = request.getParameter("memberType");
		String bank = request.getParameter("bank");
		
		BankCardInfoEntity bankCard = new BankCardInfoEntity();
		MemberBankCardEntity memberBankCard = new MemberBankCardEntity();
		
		bankCard.setBankNo(bankNo);
		bankCard.setBankPhone(bankPhone);
		bankCard.setBranch(branch);
		bankCard.setCardCity(Integer.valueOf(cityId));
		bankCard.setCardProvince(Integer.valueOf(provinceId));
		bankCard.setBranchAddress("");
		bankCard.setBankId(IntegerAndString.StringToInt(bank, -1));
		
		memberBankCard.setMemberID(userInfo.getStaffId());
		memberBankCard.setMemberType(IntegerAndString.StringToInt(memberType, -1));
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90701);
		entity.setlModuleId(907);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = mamberBankCardService.insertMemberBackCard(bankCard, memberBankCard);
		
		return num;
	}
	
	/**
	 * 
	* delBank删除银行卡 
	* TODO删除银行卡
	* @author 杨翰林  
	* * @Title: delBank 
	* @Description: 删除银行卡 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-10 上午9:32:52
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int delBank(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String bankCardId = request.getParameter("bankCardId");
		
		req.put("receiveCard", bankCardId);
		req.put("memberID", userInfo.getStaffId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90703);
		entity.setlModuleId(907);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = mamberBankCardService.deleteMemberBankCard(req);
		
		return num;
	}
	
	/**
	 * 
	* modBank修改银行卡 
	* TODO修改银行卡
	* @author 杨翰林  
	* * @Title: modBank 
	* @Description: 修改银行卡 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-10 上午9:41:59
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int modBank(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String branch = request.getParameter("branch");
		String bankNo = request.getParameter("cardNo");
		String bankPhone = request.getParameter("phone");
		String bankCardId = request.getParameter("bankCardId");
		String memberType = request.getParameter("memberType");
		String bank = request.getParameter("bank");
		
		BankCardInfoEntity bankCard = new BankCardInfoEntity();
		
		bankCard.setBankNo(bankNo);
		bankCard.setBankPhone(bankPhone);
		bankCard.setBranch(branch);
		bankCard.setCardCity(Integer.valueOf(cityId));
		bankCard.setCardProvince(Integer.valueOf(provinceId));
		bankCard.setBranchAddress("");
		bankCard.setBankId(IntegerAndString.StringToInt(bank, -1));
		bankCard.setBankCardId(IntegerAndString.StringToLong(bankCardId, -1));
		
		req.put("bankNo", bankNo);
		req.put("receiveCard", bankCardId);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90702);
		entity.setlModuleId(907);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request)); 
		
		int num = mamberBankCardService.updateBankCardInfo(bankCard, req, userInfo.getStaffId(), IntegerAndString.StringToInt(memberType, -1));
		return num;
	}
	
	/**
	 * 
	* selectMemberBankCardByID根据id查询银行卡 
	* TODO根据id查询银行卡
	* @author 杨翰林  
	* * @Title: selectMemberBankCardByID 
	* @Description: 根据id查询银行卡
	* @param @return 设定文件 
	* @return BankCardInfoEntity 返回类型 
	* @date 2016-5-18 下午2:41:10
	* @throws
	 */
	@RequestMapping("/queryBank")
	@ResponseBody
	public BankCardInfoEntity selectMemberBankCardByID(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String bankCardId = request.getParameter("bankCardId");
		BankCardInfoEntity bankCardInfoEntity = mamberBankCardService
				.selectMemberBankCardByID(IntegerAndString.StringToLong(bankCardId, -1), userInfo.getStaffId());
		
		return bankCardInfoEntity;
	}
	
	
}

