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
import cn.integralmall.model.CommodityTypeEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CommodityTypeService;


/***
* 商品类型管理控制器
* 
* @author 李杰
* @since 
* @date 2016-5-10 上午10:38:32 
*
*/
@Controller
@RequestMapping("commodityTypeManager")
public class CommodityTypeManagerController {

	
	@Autowired
	private CommodityTypeService commodityTypeService;
	
	/***
	* 发布商品类型
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 上午10:47:40
	*/
	@RequestMapping(value="release",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object release(HttpServletRequest request){
		String	goodTypeName	= request.getParameter("typeName");				//商品类型名称
		String	iocPath			= request.getParameter("iocPath");				//展示图路径
		String	goodDetil		= request.getParameter("describe");				//商品描述
		long	upId			= IntegerAndString.StringToLong(request.getParameter("upId"), -1);	//上级编号
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		
		CommodityTypeEntity entity = new CommodityTypeEntity();
		entity.setAdminID(admin.getId());
		entity.setAdminName(admin.getAdminName());
		entity.setCommodityClassifyPic(iocPath);
		entity.setCommodityClassifyDes(goodDetil);
		entity.setDeleteFlag(0);
		entity.setStatus(1);
		entity.setCommodityType(upId);
		entity.setCommodityClassify(goodTypeName);
		
		int result = commodityTypeService.insertCommodityType(entity);
		Map<String,Object> message = new HashMap<String, Object>();
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
	* 加载商品类型列表
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 上午10:40:10
	 */
	@RequestMapping(value="loadList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object serach(HttpServletRequest request){
		int	goodType	=	IntegerAndString.StringToInt(request.getParameter("goodType"), -1);
		int start		=	IntegerAndString.StringToInt(request.getParameter("start"), 1);
		int length		=	IntegerAndString.StringToInt(request.getParameter("length"), 1);
		
		PageEntity entity = new PageEntity();
		entity.setPageSize(length);
		entity.setPageNum(start/length+1);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("goodType", goodType);
		entity.setMap(param);
		
		commodityTypeService.selectCommodityTypeListPage(entity);
		return entity;
	}
	
	/***
	* 修改商品类型
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 上午10:47:40
	*/
	@RequestMapping(value="edit",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object edit(HttpServletRequest request){
		long	goodId			= IntegerAndString.StringToLong(request.getParameter("tId"),-1);		//自身编号
		String	goodTypeName	= request.getParameter("typeName");										//新名称
		String	iocPath			= request.getParameter("iocPath");										//展示图片路径
		String	goodDetil		= request.getParameter("describe");										//详细描述
		long	upId			= IntegerAndString.StringToLong(request.getParameter("upId"), -1);		//上级编号
		
		Admin admin = (Admin) request.getSession().getAttribute("LoginPerson");
		CommodityTypeEntity entity = new CommodityTypeEntity();
		entity.setAdminID(admin.getId());
		entity.setAdminName(admin.getAdminName());
		entity.setCommodityClassifyPic(iocPath);
		entity.setCommodityClassifyDes(goodDetil);
		entity.setDeleteFlag(0);
		entity.setStatus(1);
		entity.setCommodityType(upId);
		entity.setCommodityClassify(goodTypeName);
		entity.setCommodityTypeID(goodId);
		
		Map<String,Object> message = new HashMap<String,Object>();
		int result = commodityTypeService.updateCommodityTypeByID(entity);
		if(result == -1){
			message.put("status", "-1");
			message.put("message","名称已存在");
		}else if(result == 0){
			message.put("status", "0");
			message.put("message", "修改失败");
		}else if(result == 1){
			message.put("status", "1");
			message.put("message", "修改成功");
		}
		return message;
	}
	
	/***
	* 停用或启用
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 上午10:52:55
	*/
	@RequestMapping(value="off",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public Map<String,Object> off(HttpServletRequest request){
		long 	goodId				=	IntegerAndString.StringToLong(request.getParameter("tId"),-1);
		int		status				= 	IntegerAndString.StringToInt(request.getParameter("status"), 0);
		CommodityTypeEntity entity 	= 	new CommodityTypeEntity();
		entity.setCommodityTypeID(goodId);
		entity.setStatus(status);
		
		int result = commodityTypeService.updateCommodityTypeStatusByID(entity);
		
		Map<String,Object> message = new HashMap<String,Object>();
		if(result == 0){
			message.put("status", "0");
			message.put("message", "失败");
		}else if(result == 1){
			message.put("status", "1");
			message.put("message", "成功");
		}
		return message;
	}
	
	
	/***
	* 根据类型查询商品类型
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 下午2:10:54
	*
	*/
	@RequestMapping(value="serachByType",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object serachByType(HttpServletRequest request){
		int upId		=	IntegerAndString.StringToInt(request.getParameter("upId"), 0);
		List<CommodityTypeEntity> result = commodityTypeService.selectCommodityTypeByID(upId);
		return result;
	}
	
	
	
	
	
}

