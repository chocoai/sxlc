package cn.springmvc.controller.integralMall; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.InventoryRecordsEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CommodityInfoService;
import cn.springmvc.util.LoadUrlUtil;



/***
* 
* 商品管理控制器
*
* 
* @author 李杰
* @since 
* @date 2016-5-10 下午2:03:35 
*
*
*/
@Controller
@RequestMapping("/commodityManager")
public class CommodityManagerController {

	
	@Autowired
	private CommodityInfoService commodityInfoService;
	
	
	
	/***
	* 添加商品
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午2:06:38
	*/
	@RequestMapping("/release")
	@ResponseBody
	public Map<String,Object> release(HttpServletRequest request){
		long upId			=	IntegerAndString.StringToLong(request.getParameter("upId"), -1);			//实物还是代金券
		long goodTypeId		=	IntegerAndString.StringToLong(request.getParameter("typeId"),0);			//商品类型编号
		String goodName		=	request.getParameter("goodName");											//商品名称
		int		point		=	IntegerAndString.StringToInt(request.getParameter("point"),0);				//所需积分
		String	endTime		= 	request.getParameter("endTime"); 											//结束日期
		String	manufactor	=	request.getParameter("manufactor"); 										//厂家
		String	specifications	=	request.getParameter("specifications");									//规格
		int		stock 		=	IntegerAndString.StringToInt(request.getParameter("stock"),0);				//库存
		int		isVip		=	IntegerAndString.StringToInt(request.getParameter("isVip"), 0);				//是否为VIP,默认为0
 		String	maxPicPath	=	request.getParameter("maxPicPath"); 										//前台展示大图路径
 		String	minPicPath	=	request.getParameter("minPicPath");											//前台展示小图路径
 		int		isActivity	=	IntegerAndString.StringToInt(request.getParameter("isActivity"), 0); 		//是否为活动商品 默认否0
 		int		denominationVouchers	=	IntegerAndString.StringToInt(request.getParameter("denominationVouchers"), 0);//代金券面额
 		int		marketValue =	IntegerAndString.StringToInt(request.getParameter("marketValue"), 0);		//市场价
 		String	activityStart	=	request.getParameter("activityStart");									//活动开始时间
 		String	activityEnd		=	request.getParameter("activityEnd");									//活动结束时间
 		String	commodDetail	=	request.getParameter("commodDetail");									//描述
 		
 		
 		CommodityInfoEntity entity = new CommodityInfoEntity();
 		entity.setCommodityTypeID(goodTypeId);
 		entity.setCommodityName(goodName);
 		entity.setNeedPoint(point);
 		entity.setEndDate(endTime);
 		entity.setManufacturer(manufactor);
 		entity.setSpecificationsmodels(specifications);
 		entity.setQuantity(stock);
 		entity.setIsVIPExclusive(isVip);
 		entity.setCommoditySmallIcon(maxPicPath);
 		entity.setCommoditylargeIcon(minPicPath);
 		entity.setIsActive(isActivity);
 		entity.setMarketPrice(marketValue);
 		entity.setVouchersAmount(denominationVouchers);
 		entity.setCommodityIntroduction(commodDetail);
 		entity.setCommodityDescribe(commodDetail);
 		
 		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70201);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//1成功 0失败 
 		int result = commodityInfoService.insertCommodityInfo(entity, logentity, sIpInfo);
 		Map<String,Object> message = new HashMap<String,Object>();
 		if(result == 1){
 			message.put("status", "1");
 			message.put("message", "添加成功");
 		}else{
 			message.put("status", "0");
 			message.put("message", "添加失败");
 		}
 		return message;
	}
	
	/***
	* 加载商品列表
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-10 下午2:52:59
	*/
	@RequestMapping("/loadList")
	@ResponseBody
	public PageEntity loadList(HttpServletRequest request){
		String	pName			=	request.getParameter("pName") ;												//商品名称
		String	pNumber			=	request.getParameter("pNumber");											//商品编号
		int		upId			=	IntegerAndString.StringToInt(request.getParameter("upId"), -1); 				//商品类型 代金券 | 实物
		int		status			=	IntegerAndString.StringToInt(request.getParameter("status"),0);				//状态 兑换中|待上架 | 已下架
		int		start			=	IntegerAndString.StringToInt(request.getParameter("start"), 1);				//(dataTable参数)
		int 	length			=	IntegerAndString.StringToInt(request.getParameter("length"), 10);			//(dataTable参数)
		int		order			=	IntegerAndString.StringToInt(request.getParameter("order"),1);				//排序
		
		PageEntity entity = new PageEntity();
		entity.setPageSize(length);
		entity.setPageNum(start/length+1);
		Map<String,Object> parma = new HashMap<String, Object>();
		entity.setMap(parma);
		parma.put("commodityName", pName);
		parma.put("commodityNO", pNumber);
		parma.put("commodityType", upId);
		parma.put("commodityStatu", status);
		parma.put("order", order);
		
		List<CommodityInfoEntity> list = commodityInfoService.selectCommodityInfoList(entity);
		return entity;
	}
	
	/***
	* 获取商品详细信息
	* 
	* @author 李杰
	* @return
	* @date 2016-5-11 下午2:23:42
	*/
	@RequestMapping("/commodInfo/{commodId:[0-9]+}")
	@ResponseBody
	public CommodityInfoEntity commodInfo(HttpServletRequest request,@PathVariable long commodId){
		CommodityInfoEntity	commodityInfoEntity =commodityInfoService.selectCommodityInfoByID(commodId);
		if(commodityInfoEntity != null){
			String hostPath = FtpClientUtil.getFtpFilePath();
			hostPath = hostPath.substring(0, hostPath.length()-1);
			commodityInfoEntity.setPicBasePath(hostPath);
		}
		return commodityInfoEntity;
	}
	
	/***
	 * 修改商品信息
	 * 
	 * @param request
	 * @return
	 * @date 2016-5-10 下午3:18:06
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Map<String,Object> edit(HttpServletRequest request){
		long	goodId		=	IntegerAndString.StringToLong(request.getParameter("goodId"), -1);
		long 	upId		=	IntegerAndString.StringToLong(request.getParameter("upId"), -1);			//实物还是代金券
		long goodTypeId		=	IntegerAndString.StringToLong(request.getParameter("typeId"),0);			//商品类型编号
		String goodName		=	request.getParameter("goodName");											//商品名称
		int		point		=	IntegerAndString.StringToInt(request.getParameter("point"),0);				//所需积分
		String	endTime		= 	request.getParameter("endTime"); 											//结束日期
		String	manufactor	=	request.getParameter("manufactor"); 										//厂家
		String	specifications	=	request.getParameter("specifications");									//规格
		int		stock 		=	IntegerAndString.StringToInt(request.getParameter("stock"),0);				//库存
		int		isVip		=	IntegerAndString.StringToInt(request.getParameter("isVip"), 0);				//是否为VIP,默认为0
 		String	maxPicPath	=	request.getParameter("maxPicPath"); 										//前台展示大图路径
 		String	minPicPath	=	request.getParameter("minPicPath");											//前台展示小图路径
 		int		isActivity	=	IntegerAndString.StringToInt(request.getParameter("isActivity"), 0); 		//是否为活动商品 默认否0
 		int		denominationVouchers	=	IntegerAndString.StringToInt(request.getParameter("denominationVouchers"), 0);//代金券面额
 		int		marketValue =	IntegerAndString.StringToInt(request.getParameter("marketValue"), 0);		//市场价
 		String	activityStart	=	request.getParameter("activityStart");									//活动开始时间
 		String	activityEnd		=	request.getParameter("activityEnd");									//活动结束时间
 		String	commodDetail	=	request.getParameter("commodDetail");									//描述
 		
 		CommodityInfoEntity entity = new CommodityInfoEntity();
 		entity.setCommodityID(goodId);
 		entity.setCommodityTypeID(goodTypeId);
 		entity.setCommodityName(goodName);
 		entity.setNeedPoint(point);
 		entity.setEndDate(endTime);
 		entity.setManufacturer(manufactor);
 		entity.setSpecificationsmodels(specifications);
 		entity.setQuantity(stock);
 		entity.setIsVIPExclusive(isVip);
 		entity.setCommoditySmallIcon(minPicPath);
 		entity.setCommoditylargeIcon(maxPicPath);
 		entity.setIsActive(isActivity);
 		entity.setMarketPrice(marketValue);
 		entity.setVouchersAmount(denominationVouchers);
 		entity.setCommodityIntroduction(commodDetail);
 		entity.setCommodityDescribe(commodDetail);
		
 		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70201);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//1成功 0失败 
 		int result = commodityInfoService.updateCommodityInfo(entity, logentity, sIpInfo);
 		Map<String,Object> message = new HashMap<String,Object>();
 		if(result == 1){
 			message.put("status", "1");
 			message.put("message", "修改成功");
 		}else{
 			message.put("status", "0");
 			message.put("message", "修改失败");
 		}
 		return message;
	}
	
	/***
	* 推荐商品到首页
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午3:18:53
	*/
	@RequestMapping("/configGood")
	@ResponseBody
	public Map<String,Object> configGood(HttpServletRequest request){
		long	goodId		= IntegerAndString.StringToLong(request.getParameter("goodId"), 0);
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70204);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int 	result 		= commodityInfoService.updateCommodityISPush(goodId, 1, logentity, sIpInfo);
		
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "每一类最多设置4件商品");
		}else if(result == 0){
			message.put("status", "0");
			message.put("message", "已经推送到首页了");
		}else if(result == 1){
			message.put("status", "1");
			message.put("message", "设置成功");
		}
		return message;
	}
	
	/***
	* 查看入库记录
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午4:09:10
	 */
	@RequestMapping("/showPutK")
	@ResponseBody
	public PageEntity showPutK(HttpServletRequest request){
		int start			=	IntegerAndString.StringToInt(request.getParameter("start"),1);
		int pageSize		=	IntegerAndString.StringToInt(request.getParameter("length"), 10);
		long	goodId		= 	IntegerAndString.StringToLong(request.getParameter("goodId"), 0);
		PageEntity entity = new PageEntity();
		entity.setPageNum(start);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("commodityID", goodId);
		entity.setMap(param);
		List<InventoryRecordsEntity> entities = commodityInfoService.selectInventoryrecordsIn(entity);
		return entity;
	}
	
	/***
	* 入库
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午5:12:13
	*/
	@RequestMapping("/putk")
	@ResponseBody
	public Map<String,Object> putK(HttpServletRequest request){
		long	goodId		= IntegerAndString.StringToLong(request.getParameter("goodId"), 0);
		int		addNumber	= IntegerAndString.StringToInt(request.getParameter("addNumber"),0);
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70206);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		InventoryRecordsEntity inventoryRecordsEntity = new InventoryRecordsEntity();
		inventoryRecordsEntity.setAdminID(admin.getId());
		inventoryRecordsEntity.setCommodityID(goodId);
		inventoryRecordsEntity.setOperationDirection(1);
		inventoryRecordsEntity.setQuantitys(addNumber);
		
		//-1出库数量大于当期前库存,1成功 0失败
		int result = commodityInfoService.insertInventoryrecords(inventoryRecordsEntity, logentity, sIpInfo);
		Map<String,Object>	message = new HashMap<String,Object>();
		if(result == -1){
			message.put("status","-1");
			message.put("message","出库数量大于库存数量");
		}else if(result == 1){
			message.put("status","1");
			message.put("message","入库成功");
		}else if(result == 0){
			message.put("status","0");
			message.put("message","入库失败");
		}
		return message;
	}
	
	/***
	* 设置VIP折扣
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午5:13:01
	 */
	@RequestMapping("/confvipzk")
	@ResponseBody
	public Map<String,Object> confVipZk(HttpServletRequest request){
		long	goodId		= IntegerAndString.StringToLong(request.getParameter("goodId"), 0);
		int		discount	= IntegerAndString.StringToInt(request.getParameter("discount"),0);
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70206);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//0失败，1成功
		int result = commodityInfoService.updateCommodityVIPDiscount(goodId, discount+"", logentity, sIpInfo);
		Map<String,Object>	message = new HashMap<String,Object>();
		if(result == 1){
			message.put("status","1");
			message.put("message","设置成功");
		}else if(result == 0){
			message.put("status","0");
			message.put("message","设置失败");
		}
		return message;
	}
	
	
	
	/***
	* 下架
	* 
	* @author 李杰
	* @return
	* @date 2016-5-12 下午3:31:03
	 */
	@RequestMapping("/offShelf")
	@ResponseBody
	public Map<String,Object> offShelf(HttpServletRequest request){
		long	commodityId		=	IntegerAndString.StringToLong(request.getParameter("commodityId"), 0);
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70206);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//1成功 0失败
		int result = commodityInfoService.updateCommodityStatu(2, commodityId, admin.getId(), logentity, sIpInfo);
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == 1){
			message.put("status", "1");
			message.put("message", "操作成功");
		}else{
			message.put("status", "0");
			message.put("message", "操作失败");
		}
		return message;
	}
	
	
	/***
	* 上架
	* 
	* @author 李杰
	* @return
	* @date 2016-5-12 下午3:31:42
	 */
	@RequestMapping("/shelves")
	@ResponseBody
	public Map<String,Object> shelves(HttpServletRequest request){
		long	commodityId		=	IntegerAndString.StringToLong(request.getParameter("commodityId"), 0);
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		logentity.setiAdminId(admin.getId());
		logentity.setlModuleId(702);
		logentity.setlOptId(70206);
		
		String[] sIpInfo = new String[6];
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//1成功 0失败
		int result = commodityInfoService.updateCommodityStatu(1, commodityId, admin.getId(), logentity, sIpInfo);
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == 1){
			message.put("status", "1");
			message.put("message", "操作成功");
		}else{
			message.put("status", "0");
			message.put("message", "操作失败");
		}
		return message;
	}
}

