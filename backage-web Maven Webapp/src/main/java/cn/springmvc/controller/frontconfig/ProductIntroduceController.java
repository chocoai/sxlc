
package cn.springmvc.controller.frontconfig; 

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
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.HomeBannerEntity;
import cn.springmvc.model.ProductIntroduceEntity;
import cn.springmvc.service.ProductIntroduceService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 * 前台页面配置
 * 产品介绍管理
 * @date:2016-5-20 下午2:31:32
 **/

@Controller
@RequestMapping("/ProductIntroduce")
public class ProductIntroduceController {

	@Autowired
	ProductIntroduceService productIntroduceService;
	
	/**
	 * 查询产品介绍
	 * TODO
	 * 创建日期：2016-5-20下午2:32:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/showProductIntroduce", method = RequestMethod.POST)
	@ResponseBody
	public ProductIntroduceEntity showProductIntroduceList(HttpServletRequest request) {
		
		ProductIntroduceEntity entity = productIntroduceService.selectProductIntroduceList(1);
		return entity;
	}
	
	/**
	 *  保存产品介绍
	 * TODO
	 * 创建日期：2016-5-19下午6:58:51
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveProductIntroduce")
	@ResponseBody
	public int saveProductIntroduce(HttpServletRequest request) {
		ProductIntroduceEntity entity  = new ProductIntroduceEntity();
		String content = request.getParameter("content");
		entity.setContent(content);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
			entity.setOptId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(509);
		logentity.setlOptId(50901);
		int iResult = productIntroduceService.insertProductIntroduce(entity, logentity, sIpInfo);
		return iResult;
	}
	
}

