package cn.springmvc.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;

import com.alibaba.fastjson.JSONObject;



import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectPurposeEntity;
import cn.springmvc.model.ProjectPurposeSetEntity;
import cn.springmvc.model.ProjectTypeTermEntity;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.ProjectPurposeService;
import cn.springmvc.service.ProjectPurposeSetService;
import cn.springmvc.util.MemberSessionMng;


@Controller
@RequestMapping(value="/borrow")
public class borrowMoneyController {
	private Logger logger = Logger.getLogger(LoginRegisterController.class);
	
	@Resource(name="projectBaseInfoServiceImpl")
	ProjectBaseInfoService projectBaseInfoService;
	
	@Resource(name="projectPurposeSetServiceImpl")
	ProjectPurposeSetService projectPurposeSetService;
	
	@Resource(name="projectPurposeServiceImpl")
	ProjectPurposeService projectPurposeService;
	/**
	 * 
	* selectProjectBaseInfoCombox
	* 查询项目类型列表 for 下拉列表
	* @author 邱陈东  
	* * @Title: selectProjectBaseInfoCombox 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午3:12:09
	* @throws
	 */
	@RequestMapping(value="/selectProjectBaseInfoCombox",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProjectBaseInfoCombox(HttpServletRequest request){
		List<ProjectBaseInfoEntity>  list = projectBaseInfoService.selectProjectBaseInfoCombox();
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 
	* selectProjectPurposeSetValid
	* 查看新增借款需要填写的配置
	* @author 邱陈东  
	* * @Title: selectProjectPurposeSetValid 
	* @Description: TODO 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午3:34:51
	* @throws
	 */
	@RequestMapping(value="/selectProjectPurposeSetValid",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProjectPurposeSetValid(HttpServletRequest request){
		List<ProjectPurposeSetEntity> list= projectPurposeSetService.selectProjectPurposeSetValid();
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	/**
	 * 提交借款申请
	* insertProjectPurposeFront
	* @author 邱陈东  
	* * @Title: insertProjectPurposeFront 
	* @param @param request
	* @param @param uses  借款用途
	* @param @param repaySource 还款来源
	* @param @param amount 借款金额
	* @param @param projectDescript 项目描述
	* @param @param deadline 借款期限 单位：月/天
	* @param @param deadlineType 期限类型  0：天标 1：月标 2：年标
	* @param @param repayWay 还款方式  0：等额本息，1：每月还息，到期还本 2：到期还息本 3:等额本金
	* @param @param yearRate  预计年化收益率(万分之)
	* @return String 返回类型 
	* @date 2016-4-27 下午4:04:39
	* @throws
	 */
	@RequestMapping(value="/insertProjectPurposeFront",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertProjectPurposeFront(HttpServletRequest request){
		String uses = request.getParameter("uses");
		String repaySource = request.getParameter("repaySource");
		String projectDescript = request.getParameter("projectDescript");
		Integer deadline =  IntegerAndString.StringToInt(request.getParameter("deadline"),1);
		Integer deadlineType = IntegerAndString.StringToInt(request.getParameter("deadlineType"),1);
		Integer repayWay = IntegerAndString.StringToInt(request.getParameter("repayWay"),1);
		
		Long amount = IntegerAndString.StringToLong(request.getParameter("amount"));
		Integer yearRate = IntegerAndString.StringToInt(request.getParameter("yearRate"));
		
		//获取登录人（申请人）ID
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		ProjectPurposeEntity entity = new ProjectPurposeEntity();
		entity.setMemberID(lMemberInfo[0]);
		//TODO 测试用
		entity.setMemberID(1L);
		entity.setUses(uses);
		entity.setRepaySource(repaySource);
		entity.setAmount(amount);
		entity.setProjectDescript(projectDescript);
		entity.setDeadline(deadline);
		entity.setDeadlineType(deadlineType);
		entity.setRepayWay(repayWay);
		entity.setYearRate(yearRate);
		int result = projectPurposeService.insertProjectPurposeFront(entity);
		
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == 1){
			message.put("code", 200);
			message.put("message", "提交借款申请成功");
			message.put("data",result);
		}else{
			message.put("code", 500);
			message.put("message", "提交借款申请失败");
			message.put("data",result);
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* selectProjectBaseInfoList
	* 查询项目类型列表 for 详细图文介绍
	* @author 邱陈东  
	* * @Title: selectProjectBaseInfoList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午3:12:09
	* @throws
	 */
	@RequestMapping(value="/selectProjectBaseInfoList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProjectBaseInfoList(HttpServletRequest request){
		List<ProjectBaseInfoEntity>  list = projectBaseInfoService.selectProjectBaseInfoList();
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* selectProjectBaseInfoById
	* 根据id查看借款项目详情   ------------1
	* @author 邱陈东  
	* * @Title: selectProjectBaseInfoById 
	* @param @param request
	* @param @param id  借款类型ID
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午3:13:13
	* @throws
	 */
	@RequestMapping(value="/selectProjectBaseInfoById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProjectBaseInfoById(HttpServletRequest request){
		Integer id = IntegerAndString.StringToInt(request.getParameter("id"), 0);
		
		ProjectBaseInfoEntity entity = projectBaseInfoService.selectProjectBaseInfoById(id);
		Map<String,Object> message = new HashMap<String, Object>();
		if(entity!=null){
			message.put("code", 200);
			message.put("message", "读取成功");
			message.put("data",entity);
		}else{
			message.put("code", 404);
			message.put("message", "没有这个借款类型");
		}
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* selectProjectTypeTermById
	* 根据id查看借款项目详情的期限范围   ----------------2
	* @author 邱陈东  
	* * @Title: selectProjectTypeTermById 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 下午3:12:09
	* @throws
	 */
	@RequestMapping(value="/selectProjectTypeTermById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectProjectTypeTermById(HttpServletRequest request,@RequestParam(value="id", required=true)Integer id){
		List<ProjectTypeTermEntity> list = projectBaseInfoService.selectProjectTypeTermByID(id);
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	
	
	
	/**
	 * 根据借款类型ID查询需要准备的资料列表
	* selectMemberAttestByprojectType
	* @author 邱陈东  
	* * @Title: selectMemberAttestByprojectType 
	* @param @param request
	* @param @param id
	* @return String 返回类型 
	* @date 2016-4-27 下午7:29:02
	* @throws
	 */
	@RequestMapping(value="/selectMemberAttestByprojectType",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMemberAttestByprojectType(HttpServletRequest request,@RequestParam(value="id", required=true)Integer id){
		 List<MemberAttestTypeEntity> list = projectBaseInfoService.selectMemberAttestByprojectType(id);
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		return JSONObject.toJSONString(message);
	}
	
}
