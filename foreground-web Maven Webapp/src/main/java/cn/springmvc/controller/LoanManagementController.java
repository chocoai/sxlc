package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loanManagement")
public class loanManagementController {
	@RequestMapping("/LR_financing")
	public String LR_financing(){
		return "account/loanManagement/LR_financing";
	}
	@RequestMapping("/LR_financed")
	public String LR_financed(){
		return "account/loanManagement/LR_financed";
	}
	@RequestMapping("/LR_repay")
	public String LR_repay(){
		return "account/loanManagement/LR_repay";
	}
	@RequestMapping("/LR_failure")
	public String LR_failure(){
		return "account/loanManagement/LR_failure";
	}
	@RequestMapping("/LR_clearing")
	public String LR_clearing(){
		return "account/loanManagement/LR_clearing";
	}
	@RequestMapping("/applyRecord")
	public String applyRecord(){
		return "account/loanManagement/applyRecord";
	}
	@RequestMapping("/TBC_apply")
	public String TBC_apply(){
		return "account/loanManagement/TBC_apply";
	}
	@RequestMapping("/repayPlan")
	public String repayPlan(){
		return "account/loanManagement/repayPlan";
	}
	@RequestMapping("/repayRecord")
	public String repayRecord(){
		return "account/loanManagement/repayRecord";
	}
	@RequestMapping("/repayManagement")
	public String repayManagement(){
		return "account/loanManagement/repayManagement";
	}
	@RequestMapping("/RM_repayPlan")
	public String RM_repayPlan(){
		return "account/loanManagement/RM_repayPlan";
	}
	@RequestMapping("/autoRepay")
	public String autoRepay(){
		return "account/loanManagement/autoRepay";
	}
}
