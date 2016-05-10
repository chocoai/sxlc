package cn.springmvc.controller.integralMall; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.integralmall.model.CommodityInfoEntity;
import cn.springmvc.service.CommodityInfoService;



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
@RequestMapping("commodityManager")
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
	@RequestMapping(value="release",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String release(HttpServletRequest request){
		long upId			=	IntegerAndString.StringToLong(request.getParameter("upId"), -1);			//实物还是代金券
		long goodTypeId		=	IntegerAndString.StringToLong(request.getParameter("typeId"),0);			//商品类型编号
		String goodName		=	request.getParameter("goodName");											//商品类型名称
		int		point		=	IntegerAndString.StringToInt(request.getParameter("point"),0);				//所需积分
		String	endTime		= 	request.getParameter("endTime"); 											//结束日期
		String	manufactor	=	request.getParameter("manufactor"); 										//厂家
		String	specifications	=	request.getParameter("specifications");									//规格
		int		stock 		=	IntegerAndString.StringToInt(request.getParameter("stock"),0);				//库存
		int		isVip		=	IntegerAndString.StringToInt(request.getParameter("isVip"), 0);				//是否为VIP,默认为0
 		String	maxPicPath	=	request.getParameter("maxPicPath"); 										//前台展示大图路径
 		String	minPicPath	=	request.getParameter("minPicPath");											//前台展示小图路径
 		int		isActivity	=	IntegerAndString.StringToInt(request.getParameter("isActivity"), 0); 		//是否为活动商品 默认否0
 		
 		
//--------------------------------------写不下去了
 		return null;
	}
	
	
	
	/***
	* 加载商品列表
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-10 下午2:52:59
	*/
	@RequestMapping(value="loadList",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public PageEntity loadList(HttpServletRequest request){
		String	pName			=	request.getParameter("pName");												//商品名称
		String	pNumber			=	request.getParameter("pNumber");											//商品编号
		int		upId			=	IntegerAndString.StringToInt(request.getParameter("upId"), 0); 				//商品类型 代金券 | 实物
		int		status			=	IntegerAndString.StringToInt(request.getParameter("status"),0);				//状态 兑换中|待上架 | 已下架
		int		start			=	IntegerAndString.StringToInt(request.getParameter("start"), 1);				//(dataTable参数)
		int 	length			=	IntegerAndString.StringToInt(request.getParameter("length"), 10);			//(dataTable参数)
		int		order			=	IntegerAndString.StringToInt(request.getParameter("order"),0);				//排序
		
		PageEntity entity = new PageEntity();
		entity.setPageSize(length);
		entity.setPageNum(start);
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
	
	
	
	
	
	
	
	
	
	
	
}

