package cn.springmvc.personalcenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.constant.Constant;

import cn.dictionaries.model.CityInfoEntity;
import cn.dictionaries.model.CountyInfoEntity;
import cn.dictionaries.model.ProvinceInfoEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.MemberInfo;
import cn.springmvc.dao.impl.DictionariesDaoImpl;
import cn.springmvc.service.MamberBankCardService;
@Controller
@RequestMapping("/memberBankCard")
public class MemberBankCardController {
	@Autowired
	private MamberBankCardService MamberBankCardService;
	@Autowired
	private DictionariesDaoImpl dictionaries;
	/**
	 * 
	* 银行卡的查看，添加、修改和删除
	* TODO(描述)
	* @author 吴冬  
	* * @Title: list 
	* @Description: TODO 
	* @param @param request
	* @param @return 设定文件 
	* @return List<MemberBankCardEntity> 返回类型 
	* @date 2016-4-25 下午4:49:33
	* @throws null
	 */
	@RequestMapping("/bankCard")
	public List<MemberBankCardEntity> list(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute(Constant.LOGINUSER);
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("memberID", memberInfo.getId());
		param.put("memberType", memberInfo.getMemberType());
		List<MemberBankCardEntity> list = MamberBankCardService.selectMemberBankCardList(param);
		
		return list;
	}
	
//	@RequestMapping("/addCard")
//	@ResponseBody
//	public List<BankCardInfoEntity> listCard(HttpServletRequest request) {
//		 
//		return list;
//	}
	//public int add(HttpServletRequest request) {
		//省市联动
		//String aa = request.getParameter("aa");
		//Map<String, Object> param = new HashMap<String,Object>();
		//param.put("aa", aa);
		//return 1;
	//}
	
	//省
	@RequestMapping("/getProvince")
	@ResponseBody
	public List<ProvinceInfoEntity> queryProvice() {
		List<ProvinceInfoEntity> list = dictionaries.getProvinceList();
		return list;
	}
	//市
	@RequestMapping("/getCity")
	@ResponseBody
	public List<CityInfoEntity> queryCity(int pid_provice) {
		List<CityInfoEntity> list = dictionaries.getCityList(pid_provice);
		return list;
	}
	//地区
	@RequestMapping("/getCounty")
	@ResponseBody
	public List<CountyInfoEntity> queryCounty(int pid) {
		List<CountyInfoEntity> list = dictionaries.getCountyList(pid);
		return list;
	}
	//开户银行
	
	
}
