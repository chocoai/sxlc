package cn.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import cn.invitemastermng.model.NewbieExperienceSetEntity;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.FriendshipUnitEntity;
import cn.springmvc.model.HomeBannerEntity;
import cn.springmvc.model.IndexStaticsEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LiveBroadcastEntity;
import cn.springmvc.model.LoanRepayEntitys;
import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.PartnersEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.model.PlatformBoothEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.model.SafetyCertificationSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.FriendshipLinkService;
import cn.springmvc.service.HomeBannerService;
import cn.springmvc.service.IndexService;
import cn.springmvc.service.LiveBroadcastService;
import cn.springmvc.service.MediaReportsService;
import cn.springmvc.service.NewbieExperienceService;
import cn.springmvc.service.PartnersService;
import cn.springmvc.service.PlatformAnnouncementService;
import cn.springmvc.service.PlatformBoothService;
import cn.springmvc.service.SafetyCertificationService;
import cn.springmvc.service.SafetyCertificationSetService;
import cn.springmvc.service.SystemSetService;
import cn.springmvc.utitls.RepalyUtitls;

/***
 * 
* @Description: 前台首页
* @since 
* @date 2016-5-5 上午10:38:45
 */
@Controller
//@RequestMapping("index")
public class IndexController {
	
	//首页标管理
	@Resource(name="indexServiceImpl")
	IndexService indexService;
	
	//轮播图管理
	@Resource(name="homeBannerServiceImpl")
	HomeBannerService homeBannerService;
	
	//实时公告管理
	@Resource(name="liveBroadcastServiceImpl")
	LiveBroadcastService liveBroadcastService;
	
	//首页平台宣传点管理
	@Resource(name="platformBoothServiceImpl")
	PlatformBoothService platformBoothService;
	
	//新闻动态
	@Resource(name="mediaReportsServiceImpl")
	MediaReportsService mediaReportsService;
	
	//网站公告
	@Resource(name="platformAnnouncementServiceImpl")
	PlatformAnnouncementService platformAnnouncementService;
	
	//合作伙伴管理
	@Resource(name="partnersServiceImpl")
	PartnersService partnersService;
	
	@RequestMapping("/index")
	public String index(){
		return "index/index";
	}
	
	/**
	 * 查询首页顶部统计
	* selectIndexStatistic
	* @author 邱陈东  
	* * @Title: selectIndexStatistic 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午10:51:32
	* @throws
	 */
	@RequestMapping(value="selectIndexStatistic",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectIndexStatistic(HttpServletRequest request){
		
		IndexStaticsEntity data = indexService.selectIndexStatistic();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",data);
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 首页投资标的列表 
	* selectInvestListIndex
	* @author 邱陈东  
	* * @Title: selectInvestListIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午10:55:51
	* @throws
	 */
	@RequestMapping(value="selectInvestListIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectInvestListIndex(HttpServletRequest request){
		
		List<ProjectAppRecordEntity> list = indexService.selectInvestListIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询当前，当月，本周投资排名
	* selectInvestRecordIndex
	* @author 邱陈东  
	* * @Title: selectInvestRecordIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:02:30
	* @throws
	 */
	@RequestMapping(value="selectInvestRecordIndex",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectInvestRecordIndex(HttpServletRequest request){
		int type = IntegerAndString.StringToInt(request.getParameter("type"),0);//1本月，2本周，其他查询全部
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("nowMonthOrweek", type);
		
		List<InvestEntity> list = indexService.selectInvestRecordIndex(map);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 查询 首页债权转让列表 
	* selectCreditorTransferListIndex
	* @author 邱陈东  
	* * @Title: selectCreditorTransferListIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:03:23
	* @throws
	 */
	@RequestMapping(value="selectCreditorTransferListIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCreditorTransferListIndex(HttpServletRequest request){
		
		List<CreditorTransferListEntity> list = indexService.selectCreditorTransferListIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询首页轮播图
	* selectHomeBannerfront
	* @author 邱陈东  
	* * @Title: selectHomeBannerfront 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:10:55
	* @throws
	 */
	@RequestMapping(value="selectHomeBannerfront",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectHomeBannerfront(HttpServletRequest request){
		
		List<HomeBannerEntity> list = homeBannerService.selectHomeBannerfront();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 查询首页实时公告
	* selectLiveBroadcast
	* @author 邱陈东  
	* * @Title: selectLiveBroadcast 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:18:23
	* @throws
	 */
	@RequestMapping(value="selectLiveBroadcast",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectLiveBroadcast(HttpServletRequest request){
		
		List<LiveBroadcastEntity> list = liveBroadcastService.selectLiveBroadcast();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 查询平台宣传点
	* selectPlatformBooth
	* @author 邱陈东  
	* * @Title: selectPlatformBooth 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:25:51
	* @throws
	 */
	@RequestMapping(value="selectPlatformBooth",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectPlatformBooth(HttpServletRequest request){

		List<PlatformBoothEntity> list = platformBoothService.selectPlatformBooth();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询首页媒体报道(新闻动态)
	* selectMediaReportsListIndex
	* @author 邱陈东  
	* * @Title: selectMediaReportsListIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 上午11:35:47
	* @throws
	 */
	@RequestMapping(value="selectMediaReportsListIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMediaReportsListIndex(HttpServletRequest request){

		List<MediaReportsEntity> list = mediaReportsService.selectMediaReportsListIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 首页查询网站公告
	* selectPlatformListIndex
	* @author 邱陈东  
	* * @Title: selectPlatformListIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午1:58:33
	* @throws
	 */
	@RequestMapping(value="selectPlatformListIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectPlatformListIndex(HttpServletRequest request){

		List<PlatformAnnouncementEntity> list = platformAnnouncementService.selectPlatformListIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询合作伙伴列表
	* selectPartnersListIndex
	* @author 邱陈东  
	* * @Title: selectPartnersListIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午2:10:14
	* @throws
	 */
	@RequestMapping(value="selectPartnersListIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectPartnersListIndex(HttpServletRequest request){

		List<PartnersEntity> list = partnersService.selectPartnersListIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	//友情链接管理
	@Resource(name="friendshipLinkServiceImpl")
	FriendshipLinkService friendshipLinkService;
	
	/**
	 * 查询友情链接列表
	* selectFriendShipLinkfront
	* @author 邱陈东  
	* * @Title: selectFriendShipLinkfront 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午2:12:28
	* @throws
	 */
	@RequestMapping(value="selectFriendShipLinkfront",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectFriendShipLinkfront(HttpServletRequest request){

		List<FriendshipUnitEntity> list = friendshipLinkService.selectFriendShipLinkfront();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	//认证网站管理
	@Resource(name="safetyCertificationServiceImpl")
	SafetyCertificationService safetyCertificationService;
	/**
	 * 查询首页底部已认证网站列表
	* selectSafetyCertificationfront
	* @author 邱陈东  
	* * @Title: selectSafetyCertificationfront 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午2:14:58
	* @throws
	 */
	@RequestMapping(value="selectSafetyCertificationfront",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectSafetyCertificationfront(HttpServletRequest request){

		List<SafetyCertificationEntity> list = safetyCertificationService.selectSafetyCertificationfront();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	@Resource(name="systemSetServiceImpl")
	SystemSetService systemSetService;
	/**
	 * 查询系统设置信息
	* findSystemSet
	* @author 邱陈东  
	* * @Title: findSystemSet 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午2:22:12
	* @throws
	 */
	@RequestMapping(value="findSystemSet",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String findSystemSet(HttpServletRequest request){

		SystemSetEntity data = systemSetService.findSystemSet();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",data);
		
		return JSONObject.toJSONString(message);
	}
	
	@Resource(name="safetyCertificationSetServiceImpl")
	SafetyCertificationSetService certificationSetService;
	/**
	 * 首页弹出框
	* selectSafetyCertificationSetIndex
	* @author 邱陈东  
	* * @Title: selectSafetyCertificationSetIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午2:24:54
	* @throws
	 */
	@RequestMapping(value="selectSafetyCertificationSetIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectSafetyCertificationSetIndex(HttpServletRequest request){

		List<SafetyCertificationSetEntity> list = certificationSetService.selectSafetyCertificationSetIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	@Resource(name="newbieExperienceServiceImpl")
	NewbieExperienceService newbieExperienceService;
	
	/**
	 * 查询首页新手体验标
	* selectNewbieExperienceSetIndex
	* @author 邱陈东  
	* * @Title: selectNewbieExperienceSetIndex 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-10 下午5:52:14
	* @throws
	 */
	@RequestMapping(value="selectNewbieExperienceSetIndex",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectNewbieExperienceSetIndex(HttpServletRequest request){

		NewbieExperienceSetEntity entity = newbieExperienceService.getNewbieExperienceSetIndex();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",entity);
		
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 
	* 收益计算器
	* loadGainCalculator
	* @author 邱陈东  
	* * @Title: loadGainCalculator 
	* @param @param request
	* @param @param amount						投资金额
	* @param @param yearRate					年化利率
	* @param @param moreRate					加息率
	* @param @param dateNum					投资期利限
	* @param @param dateType					投资期限类型			1	日				2	月				3	年
	* @param @param repaymentMethod	还款方式				0	等额本息	1	先息后本	2	到期还本付息		3	等额本金
	* @return String 返回类型 
	* @date 2016-5-26 下午2:38:56
	* @throws
	 */
	@RequestMapping(value="loadGainCalculator",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadGainCalculator(HttpServletRequest request,
			@RequestParam(defaultValue="0",required=true,value="amount")String amount,
			@RequestParam(defaultValue="0",required=true,value="yearRate")int yearRate,
			@RequestParam(defaultValue="0",required=false,value="moreRate")int moreRate,
			@RequestParam(defaultValue="1",required=true,value="dateNum")short dateNum,
			@RequestParam(defaultValue="1",required=true,value="dateType")short dateType,
			@RequestParam(defaultValue="1",required=true,value="repaymentMethod")short repaymentMethod){
		//amount = Long.parseLong(amount)*10000+"";
		//String allRate = ((yearRate+moreRate)*10000)+"";
		String allRate = yearRate+moreRate+"";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		dateType=(short) (dateType+1);
		List<LoanRepayEntitys> list = RepalyUtitls.getIncomePlan2(dateType, amount, allRate, dateNum, repaymentMethod, date);
		
		for(int i=0;i<list.size();i++){
			LoanRepayEntitys entity = list.get(i);
			if(entity!=null){
				entity.setRetrieveDateTime(entity.getRetrieveDateTime().substring(0,10));
			}else{
				list.remove(i);
			}
		}
		
		//预计全部收益
		String allSy = "0.00";
		if(list.size()>0&&list.get(0)!=null){
			allSy = list.get(0).getAllSy().toString();
		}
		//预计基本收益
		String expectedReturn =IntegerAndString.LongToString(IntegerAndString.StringToLong(allSy)*yearRate/(yearRate+moreRate));
		//预计加息收益
		String moreReturn = IntegerAndString.LongToString(IntegerAndString.StringToLong(allSy)-IntegerAndString.StringToLong(expectedReturn));
		
		//基本收益比率
		double num = (double)(yearRate*100000/(yearRate+moreRate))/100000;
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("allSy", allSy);
		message.put("expectedReturn", expectedReturn);
		message.put("moreReturn", moreReturn);
		message.put("list", list);
		message.put("num", num);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 收益计算器
	* incomeCalculation(这里用一句话描述这个方法的作用) 
	* TODO(描述)
	* @author 邱陈东  
	* * @Title: incomeCalculation 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-27 上午9:03:02
	* @throws
	 */
	@RequestMapping("/incomeCalculation")
	public String incomeCalculation(){
		return "invest/incomeCalculation";
	}
}

