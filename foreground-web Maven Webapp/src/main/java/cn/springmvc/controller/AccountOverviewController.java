package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accountOverview")
public class AccountOverviewController {
	@RequestMapping("/accountOverview")
	public String accountOverview(){
		return "account/accountOverview/accountOverview";
	}
}
