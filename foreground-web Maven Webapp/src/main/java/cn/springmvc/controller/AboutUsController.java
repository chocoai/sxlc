package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aboutUs")
public class AboutUsController {
	@RequestMapping("/platformIntroduction")
	public String platformIntroduction(){
		return "aboutUs/platformIntroduction";
	}
	@RequestMapping("/managementTeam")
	public String managementTeam(){
		return "aboutUs/managementTeam";
	}
	@RequestMapping("/expertAdvisor")
	public String expertAdvisor(){
		return "aboutUs/expertAdvisor";
	}
	@RequestMapping("/productIntroduction")
	public String productIntroduction(){
		return "aboutUs/productIntroduction";
	}
	@RequestMapping("/webBoard")
	public String webBoard(){
		return "aboutUs/webBoard";
	}
	@RequestMapping("/webBoardDetail")
	public String webBoardDetail(){
		return "aboutUs/webBoardDetail";
	}
	@RequestMapping("/mediaCoverage")
	public String mediaCoverage(){
		return "aboutUs/mediaCoverage";
	}
	@RequestMapping("/mediaCoverageDetail")
	public String mediaCoverageDetail(){
		return "aboutUs/mediaCoverageDetail";
	}
	@RequestMapping("/securityGuarantee")
	public String securityGuarantee(){
		return "aboutUs/securityGuarantee";
	}
	@RequestMapping("/newbieGuide")
	public String newbieGuide(){
		return "aboutUs/newbieGuide";
	}
	@RequestMapping("/commonProblem")
	public String commonProblem(){
		return "aboutUs/commonProblem";
	}
	@RequestMapping("/legalRegulation")
	public String legalRegulation(){
		return "aboutUs/legalRegulation";
	}
	@RequestMapping("/recruitmentInformation")
	public String recruitmentInformation(){
		return "aboutUs/recruitmentInformation";
	}
}
