package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fundManagement")
public class FundManagementController {
	@RequestMapping("/recharge")
	public String recharge(){
		return "account/fundManagement/recharge";
	}
	@RequestMapping("/cash")
	public String cash(){
		return "account/fundManagement/cash";
	}
	@RequestMapping("/incomeExpenditure")
	public String incomeExpenditure(){
		return "account/fundManagement/incomeExpenditure";
	}
	@RequestMapping("/award")
	public String award(){
		return "account/fundManagement/award";
	}	
	@RequestMapping("/rechargeSuccess")
	public String rechargeSuccess(){
		return "account/fundManagement/rechargeSuccess";
	}
	@RequestMapping("/cashSuccess")
	public String cashSuccess(){
		return "account/fundManagement/cashSuccess";
	}
	@RequestMapping("/rechargeFalse")
	public String rechargeFalse(){
		return "account/fundManagement/rechargeFalse";
	}
	@RequestMapping("/cashFalse")
	public String cashFalse(){
		return "account/fundManagement/cashFalse";
	}
}
