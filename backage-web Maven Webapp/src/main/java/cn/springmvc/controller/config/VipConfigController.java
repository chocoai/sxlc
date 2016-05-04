package cn.springmvc.controller.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.VIPSetSubEntity;
import cn.springmvc.service.VIPSetSubService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * vip配置
 * @date:2016-4-26 下午4:26:39
 **/


@Controller
@RequestMapping("/vip")
public class VipConfigController {
	
	@Resource(name="vipSetSubServiceImpl")
	private  VIPSetSubService vipSetSubService;
	
	
	/**
	 * 查询vip配置
	 * TODO
	 * 创建日期：2016-4-26下午4:31:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return VIPSetSubEntity
	 */
	@RequestMapping(value ="/getVipConfig", method = RequestMethod.POST)
	@ResponseBody
	public VIPSetSubEntity  getVipConfig(){
		VIPSetSubEntity entity =  vipSetSubService.selectVIPSetSubList();
		if(entity==null){
			entity = new VIPSetSubEntity();
		}
		return entity;
	}
	
	
	/**
	 *  保存vip配置
	 * TODO
	 * 创建日期：2016-4-26下午4:31:33
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveVipConfig")
	@ResponseBody
	public int saveVipConfig(HttpServletRequest request){
		VIPSetSubEntity vipSetSubEntity = new VIPSetSubEntity();
		
		int vipAttest = IntegerAndString.StringToInt(request.getParameter("vip_Attest"));
		long investtotal = IntegerAndString.StringToLong(request.getParameter("invest_total"));
		int investFee = IntegerAndString.StringToInt(request.getParameter("invest_Fee"));
		int borrowFee = IntegerAndString.StringToInt(request.getParameter("borrow_Fee"));
		vipSetSubEntity.setVipAttest(vipAttest);
		vipSetSubEntity.setVipInvest(investtotal);
		vipSetSubEntity.setBorrowMngRate(borrowFee);
		vipSetSubEntity.setInvestMngRate(investFee);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(609);
		entity.setlOptId(60901);
		 int iResult =vipSetSubService.insertVIPSetSub(vipSetSubEntity, entity, sIpInfo);
		return  iResult;
	}
	
}
