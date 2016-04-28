package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("integralMall")
public class IntegralMallController {
	@RequestMapping("/mallIndex")
	public String mallIndex(){
		return "integralMall/mallIndex";
	}
	@RequestMapping("/itemList")
	public String itemList(){
		return "integralMall/itemList";
	}
	@RequestMapping("/itemDetail")
	public String itemDetail(){
		return "integralMall/itemDetail";
	}
	@RequestMapping("/exchangeDetail")
	public String exchangeDetail(){
		return "integralMall/exchangeDetail";
	}
	@RequestMapping("/bigWheel")
	public String bigWheel(){
		return "integralMall/bigWheel";
	}
	@RequestMapping("/redEnvelope")
	public String redEnvelope(){
		return "integralMall/redEnvelope";
	}
}
