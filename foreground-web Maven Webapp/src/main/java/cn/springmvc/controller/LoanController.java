package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loan")
public class LoanController {
	@RequestMapping("/loan")
	public String loan(){
		return "loan/loan";
	}
}
