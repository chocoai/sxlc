package cn.springmvc.controller.integralMall; 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.OrderManagerService;
import cn.springmvc.util.LoadUrlUtil;


/***
* 订单管理
* 
* @author 李杰
* @since 
* @date 2016-5-10 下午5:17:31 
*
*/
@Controller
@RequestMapping(value="/orderManager")
public class OrderManagerController {

	
	
	@Autowired
	private OrderManagerService managerService;
	
	
	/***
	* 加载列表
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午5:21:07
	*/
	@RequestMapping(value="/loadList",method=RequestMethod.POST)
	@ResponseBody
	public PageEntity loadList(HttpServletRequest request){
 		String exchangeStartTime	=	request.getParameter("exchangeStartTime");		//兑换开始时间
		String exchangeEndTime		=	request.getParameter("exchangeEndTime");		//兑换结束时间
		String deliveryStartTime	=	request.getParameter("deliveryStartTime");		//发货开始时间
		String deliveryEndTime		=	request.getParameter("deliveryEndTime");		//发货结束时间
		String userName				=	request.getParameter("userName");				//会员用户名
		String memberName			=	request.getParameter("memberName");				//会员登录名
		String contactPhone			=	request.getParameter("contactPhone");			//联系电话
		String   goodId				=	request.getParameter("goodId");					//商品编号
		String goodName				=	request.getParameter("goodName");				//商品名称
		int	   status				=	IntegerAndString.StringToInt(request.getParameter("status"),-1);	//状态
		int    start				=	IntegerAndString.StringToInt(request.getParameter("start"), 1);
		int	   length				=	IntegerAndString.StringToInt(request.getParameter("length"), 10);
		
		PageEntity entity = new PageEntity();
		entity.setPageSize(length);
		entity.setPageNum(start/length+1);
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("commodityName", goodName);
		param.put("commodityNO", goodId);
		param.put("ExchangestartTime", exchangeStartTime);
		param.put("ExchangeendTime", exchangeEndTime);
		param.put("DeliverystartTime", deliveryStartTime);
		param.put("DeliveryendTime", deliveryEndTime);
		param.put("logname", memberName);
		param.put("memberName", userName);
		param.put("personalPhone", contactPhone);
		param.put("orderType", status);
		param.put("skey",DbKeyUtil.GetDbCodeKey());
		entity.setMap(param);
		managerService.selectalldOrder(entity);
		return entity;
	}
	
	
	
	/***
	* 发货
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午5:22:14
	*/
	@RequestMapping(value="/delivery",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delivery(HttpServletRequest request){
		long 	orderId 				= IntegerAndString.StringToLong(request.getParameter("orderId"), -1);
		String	logisticsCompany		= request.getParameter("logisticsCompany");								//物流公司
		String	logisticsNO				= request.getParameter("logisticsNO");									//物流单号
		String	InformationIN			= request.getParameter("InformationIN");								//通知信息内容
		
		
		Map<String,Object> param = new HashMap<String, Object>();
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		param.put("OrderID", 			orderId);
		param.put("adminID", 			admin.getId());
		param.put("logisticsCompany", 	logisticsCompany);
		param.put("logisticsNO", 		logisticsNO);
		param.put("InformationIN", 		InformationIN);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(703);
		logentity.setlOptId(70301);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int result = managerService.deliverGoods(param, logentity, sIpInfo);
		Map<String,Object> message = new HashMap<String,Object>();
		//1成功 0失败 -1 该商品已发货或者已撤销
		if(result == 1){
			message.put("status", "1");
			message.put("message", "发货成功");
		}else if(result == 0){
			message.put("status", "0");
			message.put("message", "发货失败");
		}else if(result == -1){
			message.put("status", "-1");
			message.put("message", "该订单已发货或已撤销");
		}
		return message;
	}
	
	
	/****
	* 撤销订单
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午5:23:02
	*/
	@RequestMapping(value="/revokeOrder",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> revokeOrder(HttpServletRequest request){
		long 	orderId 			= IntegerAndString.StringToLong(request.getParameter("orderId"), -1);			//订单编号
		String	revocationReason	= request.getParameter("revocationReason");										//撤销原因
		Admin 	admin 				= (Admin) request.getSession().getAttribute("LoginPerson");						//管理员
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("OrderID", orderId);
		param.put("adminID", admin.getId());
		param.put("revocationReason", revocationReason);
		 
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(703);
		logentity.setlOptId(70202);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int result = managerService.CancelOrder(param, logentity, sIpInfo);
		//1成功 0失败 -1该商品已发货或者已撤销
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == 1){
			message.put("status", "1"	);
			message.put("message","撤销成功" 	);
		}else if(result == 0){
			message.put("status", "0"	);
			message.put("message","撤销失败" 	);
		}else if(result == -1){
			message.put("status", "-1"	);
			message.put("message","该商品已发货或已撤销" 	);
		}
		return message;
	}
	
	
	
	
	
	
	
}

