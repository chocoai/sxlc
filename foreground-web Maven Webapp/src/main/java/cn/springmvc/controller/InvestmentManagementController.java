package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("investmentManagement")
public class investmentManagementController {
	@RequestMapping("/myInvestment")
	public String myInvestment(){
		return "account/investmentManagement/myInvestment";
	}
	@RequestMapping("/revenuePlan")
	public String revenuePlan(){
		return "account/investmentManagement/revenuePlan";
	}
	@RequestMapping("/revenueRecord")
	public String revenueRecord(){
		return "account/investmentManagement/revenueRecord";
	}
	@RequestMapping("/autoBid")
	public String autoBid(){
		return "account/investmentManagement/autoBid";
	}
	@RequestMapping("/debtAttorn")
	public String debtAttorn(){
		return "account/investmentManagement/debtAttorn";
	}
	@RequestMapping("/incomeList")
	public String incomeList(){
		return "account/investmentManagement/incomeList";
	}
}
