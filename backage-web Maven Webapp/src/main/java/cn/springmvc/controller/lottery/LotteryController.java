
package cn.springmvc.controller.lottery; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.invitemastermng.model.LotteryActivityEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.PrizeInformationEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.LuckyDrawService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林 
* @Description:  抽奖管理控制层
* @since 
* @date 2016-5-12 上午9:47:52
 */
@Controller
@RequestMapping("/lottery")
public class LotteryController {

	@Resource(name="luckyDrawServiceImpl")
	private LuckyDrawService luckyDrawService;
	
	/**
	 * 
	* winningRecordList中奖纪录 
	* TODO中奖纪录
	* @author 杨翰林  
	* * @Title: winningRecordList 
	* @Description: TODO 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-12 上午9:53:31
	* @throws
	 */
	@RequestMapping("/winningRecordList")
	@ResponseBody
	public PageEntity winningRecordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String prizeName = request.getParameter("prizeName");
		String memberNo = request.getParameter("memberNo");
		String logname = request.getParameter("logname");
		String personalPhone = request.getParameter("personalPhone");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = request.getParameter("startDate1");
		String endDate1 = request.getParameter("endDate1");
		String period = request.getParameter("period");
		String grade = request.getParameter("grade");
		String prizeType = request.getParameter("prizeType");
		
		req.put("Prize_Name", prizeName);
		req.put("Member_No", memberNo);
		req.put("Logname", logname);
		req.put("Personal_Phone", personalPhone);
		req.put("Lottery_Time_Min", startDate);
		req.put("Lottery_Time_Max", endDate);
		req.put("Start_Date_Min", startDate1);
		req.put("Start_Date_Max", endDate1);
		req.put("Period", period);
		req.put("Grade", grade);
		req.put("Prize_Type", prizeType);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		luckyDrawService.getLotteryRecord(pager);
		
		return pager;
	}
	
	/**
	 * 
	* luckyDrawList查询奖品列表 
	* TODO查询奖品列表
	* @author 杨翰林  
	* * @Title: luckyDrawList 
	* @Description: 查询奖品列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-12 上午10:33:19
	* @throws
	 */
	@RequestMapping("/luckyDrawList")
	@ResponseBody
	public PageEntity luckyDrawList(HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		luckyDrawService.selectPrizeInformation(pager);
		
		return pager;
	}
	
	/**
	 * 
	* delete删除奖品 
	* TODO删除奖品
	* @author 杨翰林  
	* * @Title: delete 
	* @Description: 删除奖品 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-12 上午10:56:01
	* @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String prizeID = request.getParameter("prizeID");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(110104);
		entity.setlModuleId(1101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = luckyDrawService.
				PrizeDelete(IntegerAndString.StringToLong(prizeID, -1), entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* selectGrade查询期数下拉 
	* TODO查询期数下拉
	* @author 杨翰林  
	* * @Title: selectGrade 
	* @Description: 查询期数下拉 
	* @param @return 设定文件 
	* @return List<LotteryManage> 返回类型 
	* @date 2016-5-12 上午11:59:20
	* @throws
	 */
	@RequestMapping("/selectperiod")
	@ResponseBody
	public List<LotteryActivityEntity> selectperiod() {
		
		List<LotteryActivityEntity> list = luckyDrawService.selectperiod();
		
		return list;
	}
	
	/**
	 * 
	* selectGrade查询等级下拉 
	* TODO查询等级下拉
	* @author 杨翰林  
	* * @Title: selectGrade 
	* @Description: 查询等级下拉 
	* @param @return 设定文件 
	* @return List<LotteryActivityEntity> 返回类型 
	* @date 2016-5-12 下午12:02:25
	* @throws
	 */
	@RequestMapping("/selectGrade")
	@ResponseBody
	public List<LotteryManage> selectGrade() {
		
		List<LotteryManage> list = luckyDrawService.selectgrade();
		
		return list;
	}
	
	/**
	 * 
	* selectPrizeTypes查询奖品类型 
	* TODO查询奖品类型
	* @author 杨翰林  
	* * @Title: selectPrizeTypes 
	* @Description: 查询奖品类型 
	* @param @return 设定文件 
	* @return List<PrizeInformationEntity> 返回类型 
	* @date 2016-5-12 下午1:34:09
	* @throws
	 */
	@RequestMapping("/selectPrizeTypes")
	@ResponseBody
	public List<PrizeInformationEntity> selectPrizeTypes() {
		
		List<PrizeInformationEntity> list = luckyDrawService.selectPrizeTypes();
		
		return list;
	}
	
	/**
	 * 
	* PrizeSet添加奖品 
	* TODO添加奖品
	* @author 杨翰林  
	* * @Title: PrizeSet 
	* @Description: 添加奖品 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-19 下午5:37:53
	* @throws
	 */
	@RequestMapping("/addAward")
	@ResponseBody
	public int PrizeSet(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String grade = request.getParameter("grade");
		String prizeType = request.getParameter("prizeType");
		String prizeName = request.getParameter("prizeName");
		String prizeWorths = request.getParameter("prizeWorths");
		String prizeQuantity = request.getParameter("prizeQuantity");
		String winningOdds = request.getParameter("winningOdds");
		String content = request.getParameter("content");
		
		req.put("prizename", prizeName);
		req.put("prizeWorth", prizeWorths);
		req.put("prizeQuantity", prizeQuantity);
		req.put("prizeUrl", content);
		req.put("prizetype", prizeType);
		req.put("grade", grade);
		req.put("WinningOdds", winningOdds);
		req.put("lId", 0);
		
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(110102);
		entity.setlModuleId(1101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		Long PrizeID = luckyDrawService.PrizeSet(req, entity, sIpInfo);
		if (PrizeID != null) {
			req.put("PrizeID", PrizeID);
			req.put("lID", 0);
		}
		int num = luckyDrawService.LotteryManageSet(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* selectLotteryActivitylimit查询最近一期 抽奖活动  
	* TODO查询最近一期 抽奖活动 
	* @author 杨翰林  
	* * @Title: selectLotteryActivitylimit 
	* @Description: 查询最近一期 抽奖活动 
	* @param @return 设定文件 
	* @return LotteryActivityEntity 返回类型 
	* @date 2016-5-19 下午4:42:50
	* @throws
	 */
	@RequestMapping("/query4set")
	@ResponseBody
	public  LotteryActivityEntity selectLotteryActivitylimit() {
		
		LotteryActivityEntity lotteryActivityEntity = luckyDrawService
				.selectLotteryActivitylimit();
		return lotteryActivityEntity;
	}
	
	/**
	 * 
	* LotterySet抽奖活动设置 
	* TODO抽奖活动设置
	* @author 杨翰林  
	* * @Title: LotterySet 
	* @Description: 抽奖活动设置 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-19 下午4:51:47
	* @throws
	 */
	@RequestMapping("/set")
	@ResponseBody
	public  int LotterySet(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String integra = request.getParameter("integra");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String status = request.getParameter("status");
		String lotteryID = request.getParameter("lotteryID");
		
		
		req.put("statu", status);
		req.put("startDate", startDate);
		req.put("endDate", endDate);
		req.put("integra", integra);
		req.put("adminID", userInfo.getId());
		
		if (!"".equals(lotteryID)) {
			req.put("lId", lotteryID);
		}
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(110101);
		entity.setlModuleId(1007);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = luckyDrawService.LotterySet(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* selectPrizeInformationByID根据id查询奖品信息 
	* TODO根据id查询奖品信息
	* @author 杨翰林  
	* * @Title: selectPrizeInformationByID 
	* @Description: 根据id查询奖品信息 
	* @param @param request
	* @param @return 设定文件 
	* @return PrizeInformationEntity 返回类型 
	* @date 2016-5-19 下午7:55:05
	* @throws
	 */
	@RequestMapping("/query4prize")
	@ResponseBody
	public PrizeInformationEntity selectPrizeInformationByID(HttpServletRequest request) {
		
		String prizeID = request.getParameter("prizeID");
		
		PrizeInformationEntity prizeInformationEntity = luckyDrawService.
				selectPrizeInformationByID(IntegerAndString.StringToLong(prizeID, -1));
		
		return prizeInformationEntity;
	}
	
	
}

