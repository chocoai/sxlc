package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.integralmall.model.CommodityInfo;
import cn.integralmall.model.CommodityType;
import cn.integralmall.model.CommodityTypeEntity;
import cn.integralmall.model.ShippingAddress;
import cn.springmvc.model.IntegralMallBannerEntity;
import cn.springmvc.service.CommodityTypeService;
import cn.springmvc.service.IIntegrallService;
import cn.springmvc.service.IntegralMallBannerService;
import cn.springmvc.util.MemberSessionMng;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("integralMall")
public class IntegralMallController {
	
	@Autowired
	private IIntegrallService iIntegrallService;
	
	@Autowired
	private IntegralMallBannerService integralMallBannerService;
	
	@Autowired
	private CommodityTypeService  commodityTypeService;  
	
	
	
	
	
	/**
	 * 积分商城首页列表
	 * mallIndexselect(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午10:24:46
	 */
	@RequestMapping(value="mallIndexselect",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String mallIndexselect(HttpServletRequest request) { 
		List<CommodityType> list = iIntegrallService.indexList();
	    return JSONObject.toJSONString(list);
	}
	
	/**
	 * 积分商城首页轮播图
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午10:27:20
	 */
	@RequestMapping(value="MallBanner",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String MallBanner(HttpServletRequest request) { 
		List<IntegralMallBannerEntity> list = integralMallBannerService.selectIntegralMallBannerfront(); 
	    return JSONObject.toJSONString(list);
	}
	
	
	
	/**
	 * 积分商城列表
	 * goods(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午10:30:48
	 */
	@RequestMapping(value="goods",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String goods(HttpServletRequest request) { 
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		String minPoint              = request.getParameter("minPoint") ;
		String maxPoint              =  request.getParameter("maxPoint")  ; 
		String commodityTypeId       =  request.getParameter("commodityTypeId")  ;
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();  
		param.put("minPoint",                 minPoint);
		param.put("maxPoint",                 maxPoint);
		param.put("commodityTypeId",   commodityTypeId);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<CommodityInfo> list = iIntegrallService.goods(pageEntity); 
	    return JSONObject.toJSONString(list);
	}
	
	
	
	
	/**
	 * 根据商品id查看商品信息详情
	 * commodityInfo(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午10:43:22
	 */
	@RequestMapping(value="commodityInfo_{commodityId:[0-9]+}",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String commodityInfo(HttpServletRequest request,@PathVariable long commodityId) {   
		CommodityInfo  info= iIntegrallService.commodityInfo(commodityId);  
		return JSONObject.toJSONString(info);
	}
	
	
	
	
	/**
	 * 添加收件地址
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午11:24:33
	 */
	@RequestMapping(value="saveShippingAddress",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveShippingAddress(HttpServletRequest request) { 
		//联系人姓名
		String  contactName			    =  request.getParameter("contactName")  ; 
		//省编号
		int  provinceId				    =  IntegerAndString.StringToInt(request.getParameter("provinceId"),-1) ; 
		//市编号
		int  cityId				        =  IntegerAndString.StringToInt(request.getParameter("cityId"),-1) ; 
		//区县编号
		int  countyId				    =  IntegerAndString.StringToInt(request.getParameter("countyId"),-1) ; 
		//详细地址
		String  detailedAddress			=  request.getParameter("detailedAddress")  ; 
		//联系人电话
		String  contactPhone			=  request.getParameter("contactPhone")  ; 
		//送货选择：0不限、1只限工作日、2只限节假日
		int  deliveryChoice			    =  IntegerAndString.StringToInt(request.getParameter("deliveryChoice"),-1); 
		//默认送货地址：1是 0否
		int  isDefaultAddress	        =  IntegerAndString.StringToInt(request.getParameter("isDefaultAddress"),-1);  
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		ShippingAddress entity = new ShippingAddress();  
		entity.setMemberId(lMemberInfo[0]);
		entity.setCityName(contactName);
		entity.setProvince(provinceId);
		entity.setCity(cityId);
		entity.setCounty(countyId);
		entity.setDetailedAddress(detailedAddress);
		entity.setContactPhone(contactPhone);
		entity.setDeliveryChoice(deliveryChoice);
		entity.setiSDefaultAddress(isDefaultAddress);
		int  info= iIntegrallService.saveShippingAddress(entity);  
		Map<String,Object> message =  new HashMap<String, Object>();
		if(info == 1) {
			message.put("result",     info);
			message.put("message",   "添加成功");
		}else if(info == 0) {
			message.put("result",     info);
			message.put("message",   "添加失败");
		}else if(info == -1) {
			message.put("result",     info);
			message.put("message",   "收件地址数量达到上限");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 兑换商品
	 * pointxchange(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午11:45:32
	 */
	@RequestMapping(value="pointxchange",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String pointxchange(HttpServletRequest request) { 
		
		long  commodityId	 =  IntegerAndString.StringToLong(request.getParameter("commodityId"),0)  ;//商品id
		int   quantity	     =  IntegerAndString.StringToInt(request.getParameter("quantity"),0);//数量
		long  addressId	     =  IntegerAndString.StringToLong(request.getParameter("addressId"),0)  ;//地址
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		int  info= iIntegrallService.pointxchange(lMemberInfo[0], commodityId, quantity, addressId);   
		Map<String,Object> message =  new HashMap<String, Object>();
		//1兑换成功、0兑换失败、-1商品不存在、-2该商品已兑换完、-3积分不足、-4商品数量不足、-5
		if(info == 1) {
			message.put("result",     info);
			message.put("message",   "兑换成功");
		}else if(info == 0) {
			message.put("result",     info);
			message.put("message",   "兑换失败");
		}else if(info == -1) {
			message.put("result",     info);
			message.put("message",   "商品不存在");
		}else if(info == -2) {
			message.put("result",     info);
			message.put("message",   "该商品已兑换完");
		}else if(info == -3) {
			message.put("result",     info);
			message.put("message",   "积分不足");
		}else if(info == -4) {
			message.put("result",     info);
			message.put("message",   "商品数量不足");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 到兑换商品页面
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @param commodityId
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午11:42:57
	 */
	@RequestMapping("/exchangeDetail_{commodityId:[0-9]+}")
	public String exchangeDetail(HttpServletRequest request,@PathVariable long commodityId){  
		CommodityInfo  info= iIntegrallService.commodityInfo(commodityId); 
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		List<ShippingAddress>  Address =  iIntegrallService.ShippingAddressList(lMemberInfo[0]);
		request.setAttribute("info", info);
		request.setAttribute("addr", Address);
		return "integralMall/exchangeDetail";
	}
	
	
	
	/**
	 * 根据Id查看收货地址详情
	 * ShippingAddressInfoById(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @param addressID
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 上午11:48:23
	 */
	@RequestMapping(value="ShippingAddressInfoById_{addressID:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ShippingAddressInfoById(HttpServletRequest request,@PathVariable long addressID) { 
		ShippingAddress entity = iIntegrallService.ShippingAddressInfoById(addressID); 
	    return JSONObject.toJSONString(entity);
	}
	
	
	
	/**
	 * 修改收货地址
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-11 下午1:53:12
	 */
	@RequestMapping(value="editShippingAddress",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String editShippingAddress(HttpServletRequest request) {  
		long   addressId                =  IntegerAndString.StringToInt(request.getParameter("addressId"),-1) ; 
		//联系人姓名
		String  contactName			    =  request.getParameter("contactName")  ; 
		//省编号
		int  provinceId				    =  IntegerAndString.StringToInt(request.getParameter("provinceId"),-1) ; 
		//市编号
		int  cityId				        =  IntegerAndString.StringToInt(request.getParameter("cityId"),-1) ; 
		//区县编号
		int  countyId				    =  IntegerAndString.StringToInt(request.getParameter("countyId"),-1) ; 
		//详细地址
		String  detailedAddress			=  request.getParameter("detailedAddress")  ; 
		//联系人电话
		String  contactPhone			=  request.getParameter("contactPhone")  ; 
		//送货选择：0不限、1只限工作日、2只限节假日
		int  deliveryChoice			    =  IntegerAndString.StringToInt(request.getParameter("deliveryChoice"),-1); 
		//默认送货地址：1是 0否
		int  isDefaultAddress	        =  IntegerAndString.StringToInt(request.getParameter("isDefaultAddress"),-1);  
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		ShippingAddress entity = new ShippingAddress();  
		entity.setAddressId(addressId);
		entity.setMemberId(lMemberInfo[0]);
		entity.setCityName(contactName);
		entity.setProvince(provinceId);
		entity.setCity(cityId);
		entity.setCounty(countyId);
		entity.setDetailedAddress(detailedAddress);
		entity.setContactPhone(contactPhone);
		entity.setDeliveryChoice(deliveryChoice);
		entity.setiSDefaultAddress(isDefaultAddress);
		int  info= iIntegrallService.editShippingAddress(entity);  
		Map<String,Object> message =  new HashMap<String, Object>();
		if(info == 1) {
			message.put("result",     info);
			message.put("message",   "修改成功");
		}else if(info == 0) {
			message.put("result",     info);
			message.put("message",   "修改失败");
		} 
		return JSONObject.toJSONString(message);
	}
	
	@RequestMapping("/mallIndex")
	public String mallIndex(){
		return "integralMall/mallIndex";
	}
	
 
	@RequestMapping(value="/itemList",method=RequestMethod.GET)
	public String itemList(HttpServletRequest request){
		//商品类型列表
		List<CommodityTypeEntity> list = commodityTypeService.selectCommodityTypeFront(); 
	    request.setAttribute("CommodityTypeList", list);
		return "integralMall/itemList";
	}
	
	
	@RequestMapping("/itemDetail")
	public String itemDetail(){
		return "integralMall/itemDetail";
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
