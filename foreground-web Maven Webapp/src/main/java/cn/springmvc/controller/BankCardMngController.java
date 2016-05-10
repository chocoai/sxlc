package cn.springmvc.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
import cn.springmvc.service.MamberBankCardService;
import cn.springmvc.util.MemberSessionMng;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping(value="/bankCardMng")
public class BankCardMngController {
	private Logger logger = Logger.getLogger(LoginRegisterController.class);
	@Resource(name="memberBankCardServiceImpl")
	MamberBankCardService bankCardService;
	
	/**
	 * 查询银行信息列表
	* selectBankInfo
	* @author 邱陈东  
	* * @Title: selectBankInfo 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:06:48
	* @throws
	 */
	@RequestMapping(value="/selectBankInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectBankInfo(HttpServletRequest request){
		
		List<BankCodeEntity> list = bankCardService.selectBankInfo();
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	/**
	 *  查询省份信息
	* selectProvinceDictionary
	* @author 邱陈东  
	* * @Title: selectProvinceDictionary 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:11:07
	* @throws
	 */
	@RequestMapping(value="/selectProvinceDictionary",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProvinceDictionary(){
		List<ProvinceDictionaryEntity> list= bankCardService.selectProvinceDictionary();
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	/**
	 *  根据省份ID查询市信息
	* selectCityDictionary
	* @author 邱陈东  
	* * @Title: selectCityDictionary 
	* @param @param provinceId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:11:28
	* @throws
	 */
	@RequestMapping(value="/selectCityDictionary",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCityDictionary(HttpServletRequest request){
		Integer provinceId = IntegerAndString.StringToInt(request.getParameter("provinceId"),0);
		List<CityDictionaryEntity>list = bankCardService.selectCityDictionary(provinceId);
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 新增会员银行卡
	* insertMemberBackCard
	* @author 邱陈东  
	* * @Title: insertMemberBackCard 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:14:01
	* @throws
	 */
	@RequestMapping(value="/insertMemberBackCard",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  insertMemberBackCard(HttpServletRequest request){
		
		Map<String,Object> message = new HashMap<String, Object>();
		BankCardInfoEntity bankCardInfoEntity = new BankCardInfoEntity();//bankId,,cardProvince,,cardCity,,branch,,branchAddress,,bankPhone,,bankNo
		
		
		try {
			//接收参数
			String bankNo = request.getParameter("bankNo");  //银行卡号
			Integer bankId = IntegerAndString.StringToInt(request.getParameter("bankId"),0);
			Integer cardProvince = IntegerAndString.StringToInt(request.getParameter("cardProvince"),0);
			Integer cardCity = IntegerAndString.StringToInt(request.getParameter("cardCity"),0);
			String branch = request.getParameter("branch");
			String branchAddress = request.getParameter("branchAddress");
			String bankPhone = request.getParameter("bankPhone");
			
			if(bankNo==null || bankId==0 || cardProvince ==0 || cardCity==0 || branch==null || branchAddress==null||bankPhone==null){
				//参数错误
				message.put("code", 404);
				message.put("message", "参数错误");
				return JSONObject.toJSONString(message);
			}
			
			bankCardInfoEntity.setBankId(bankId);
			bankCardInfoEntity.setBankNo(bankNo);
			bankCardInfoEntity.setBankPhone(bankPhone);
			bankCardInfoEntity.setBranch(branch);
			bankCardInfoEntity.setBranchAddress(branchAddress);
			bankCardInfoEntity.setCardProvince(cardProvince);
			bankCardInfoEntity.setCardCity(cardCity);
		} catch (NullPointerException e) {
			//参数错误
			message.put("code", 404);
			message.put("message", "参数错误");
			return JSONObject.toJSONString(message);
		}
		
		MemberBankCardEntity memberBankCardEntity = new MemberBankCardEntity();//memberID,,memberType
		
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		memberBankCardEntity.setMemberID(lMemberInfo[0]);
		memberBankCardEntity.setMemberType((int)lMemberInfo[1]);
		int result = bankCardService.insertMemberBackCard(bankCardInfoEntity, memberBankCardEntity);
		message.put("code", 200);
		message.put("message", "添加成功");
		message.put("data",result);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 查询会员已绑定银行卡列表
	* selectMemberBankCardList
	* @author 邱陈东  
	* * @Title: selectMemberBankCardList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:33:21
	* @throws
	 */
	@RequestMapping(value="/selectMemberBankCardList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMemberBankCardList(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		map.put("memberID", lMemberInfo[0]);
		map.put("memberType",lMemberInfo[1] );
		List<MemberBankCardEntity> list= bankCardService.selectMemberBankCardList(map);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "查询成功");
		message.put("data", list);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 根据银行卡ID查询银行卡信息 
	* selectMemberBankCardByID
	* @author 邱陈东  
	* * @Title: selectMemberBankCardByID 
	* @param  设定文件 
	* @return void 返回类型 
	* @date 2016-5-4 上午9:26:53
	* @throws
	 */
	@RequestMapping(value="/selectMemberBankCardByID",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMemberBankCardByID(HttpServletRequest request){
		Long bankCardId = Long.parseLong(request.getParameter("bankCardId"));
		
		long[] lMemberInfo = new long[1] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		BankCardInfoEntity data = bankCardService.selectMemberBankCardByID(bankCardId,lMemberInfo[0]);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "查询成功");
		message.put("data", data);
		return JSONObject.toJSONString(message);
	}
	/**
	 * 修改银行卡信息
	* updateBankCardInfo
	* @author 邱陈东  
	* * @Title: updateBankCardInfo 
	* @param @param request
	* @param @param bankNo
	* @param @param bankId
	* @param @param cardProvince
	* @param @param cardCity
	* @param @param branch
	* @param @param branchAddress
	* @param @param bankPhone
	* @param @param receiveCard
	* @return String 返回类型 
	* @date 2016-4-27 下午8:41:04
	* @throws
	 */
	@RequestMapping(value="/updateBankCardInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateBankCardInfo(HttpServletRequest request){
		
		BankCardInfoEntity bankCardInfoEntity = new BankCardInfoEntity();//bankId,,cardProvince,,cardCity,,branch,,branchAddress,,bankPhone,,bankNo
		//接收参数
		String bankNo = request.getParameter("bankNo");  //银行卡号
		Integer bankId = IntegerAndString.StringToInt(request.getParameter("bankId"),0);
		Integer cardProvince = IntegerAndString.StringToInt(request.getParameter("cardProvince"),0);
		Integer cardCity = IntegerAndString.StringToInt(request.getParameter("cardCity"),0);
		String branch = request.getParameter("branch");
		String branchAddress = request.getParameter("branchAddress");
		String bankPhone = request.getParameter("bankPhone");
		Long bankCardId = Long.parseLong(request.getParameter("bankCardId"));
		String receiveCard = request.getParameter("receiveCard");
		Map<String,Object> message = new HashMap<String, Object>();
		try {
			
			if(bankNo==null || bankId==0 || cardProvince ==0 || cardCity==0 || branch==null || branchAddress==null||bankPhone==null){
				//参数错误
				message.put("code", 404);
				message.put("message", "参数错误");
				return JSONObject.toJSONString(message);
			}
			
			bankCardInfoEntity.setBankId(bankId);
			bankCardInfoEntity.setBankNo(bankNo);
			bankCardInfoEntity.setBankPhone(bankPhone);
			bankCardInfoEntity.setBranch(branch);
			bankCardInfoEntity.setBranchAddress(branchAddress);
			bankCardInfoEntity.setCardProvince(cardProvince);
			bankCardInfoEntity.setCardCity(cardCity);
			bankCardInfoEntity.setBankCardId(bankCardId);
		} catch (NullPointerException e) {
			//参数错误
			message.put("code", 404);
			message.put("message", "参数错误");
			return JSONObject.toJSONString(message);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bankNo", bankNo);
		map.put("receiveCard", receiveCard);
		
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		int result = bankCardService.updateBankCardInfo(bankCardInfoEntity, map,lMemberInfo[0]);
		if(result==1){
			message.put("code", 200);
			message.put("message", "修改成功");
			message.put("data", result);
		}else if(result==-3){
			message.put("code", 403);
			message.put("message", "登录失效");
		}else if(result==-2){
			message.put("code", 403);
			message.put("message", "该银行卡已被绑定");
		}else{
			message.put("code", 403);
			message.put("message", "信息有误");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 移除银行卡 根据银行卡ID
	* deleteMemberBankCard
	* @author 邱陈东  
	* * @Title: deleteMemberBankCard 
	* @param @param request
	* @param @param receiveCard
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午8:46:49
	* @throws
	 */
	@RequestMapping(value="/deleteMemberBankCard",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteMemberBankCard(HttpServletRequest request){
		String receiveCard = request.getParameter("receiveCard");
		
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("receiveCard", receiveCard);
		map.put("memberID", lMemberInfo[0]);
		System.out.println(receiveCard+"===");
		Map<String,Object> message = new HashMap<String, Object>();
		if(receiveCard!=null && !receiveCard.equals("")){
			int result  = bankCardService.deleteMemberBankCard(map);
			message.put("code", 200);
			message.put("message", "删除成功");
			message.put("data", result);
		}else{
			message.put("code", 404);
			message.put("message", "参数不能为空");
		}
		return JSONObject.toJSONString(message);
	}
}
