package cn.springmvc.controller.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.service.SystemSetService;


/**
 * @author pengran
 * 配置中心
 * 平台配置
 * @date:2016-4-12 下午4:08:39
 **/


@Controller
@RequestMapping("/platform")
public class PlatfromController {
	
	@Resource(name="systemSetServiceImpl")
	private  SystemSetService systemSetService  ;
	
	
	/**
	 * TODO 获取平台配置
	 * 创建日期：2016-4-7下午3:44:00
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/getPlatConfig", method = RequestMethod.POST)
	@ResponseBody
	public SystemInfoSetEntity getPlatConfig(){
		SystemInfoSetEntity entity   = systemSetService.findSystemInfoSet();
		if(entity==null){
			entity  =new SystemInfoSetEntity();
		}
		return entity;
	}
	
	
	/**
	 * 保存平台配置
	 * 创建日期：2016-4-12下午4:11:25
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/savePlatConfig")
	@ResponseBody
	public int savePlatConfig(HttpServletRequest request){
		//平台
		SystemInfoSetEntity systemInfoSetEntity = new SystemInfoSetEntity();

		String systemName = request.getParameter("systemName");//平台名称	
		String backgroundLogo =request.getParameter("backgroundLogo");//平台后台logo
		String forgroundLogo =request.getParameter("forgroundLogo");//平台前台kogo
		String systemHotline = request.getParameter("systemHotline");//系统客服热线
		String systemOfficeHours = request.getParameter("systemOfficeHours");//平台工作时间
		String weiboName= request.getParameter("weiboName");//平台微博名
		String weiboQRCode = request.getParameter("weiboQRCode");//微博二维码地址	
		String qQGroupCode =request.getParameter("qQGroupCode");//平台qq群号	
		String qQGroupQRCode = request.getParameter("qQGroupQRCode");//平台qq群二维码地址	
		String weChatCode =request.getParameter("weChatCode");//平台微信公众号	
		String weChatQRCode =request.getParameter("weChatQRCode");//平台微信二维码地址	
		int  switchStatu  =IntegerAndString.StringToInt(request.getParameter("switchStatu"),0);//	平台开启状态 0：关闭 1：开启
		String riskReserveFund = request.getParameter("riskReserveFund");//前台显示平台风险准备金金额	
		String expectYearRate =request.getParameter("expectYearRate");//平台前台显示逾期年化设置	
		String integralAlias =request.getParameter("integralAlias");//积分别名	
		String welcomeTitle =request.getParameter("welcomeTitle");//平台欢迎语设置
		
		systemInfoSetEntity.setSystemName(systemName);
		systemInfoSetEntity.setBackgroundLogo(backgroundLogo);
		systemInfoSetEntity.setForgroundLogo(forgroundLogo);
		systemInfoSetEntity.setSystemHotline(systemHotline);
		systemInfoSetEntity.setWeiboName(weiboName);
		systemInfoSetEntity.setSystemOfficeHours(systemOfficeHours);
		systemInfoSetEntity.setWeiboQRCode(weiboQRCode);
		systemInfoSetEntity.setqQGroupCode(qQGroupCode);
		systemInfoSetEntity.setqQGroupQRCode(qQGroupQRCode);
		systemInfoSetEntity.setWeChatCode(weChatCode);
		systemInfoSetEntity.setWeChatQRCode(weChatQRCode);
		systemInfoSetEntity.setSwitchStatu(switchStatu);
		systemInfoSetEntity.setRiskReserveFund(riskReserveFund);
		systemInfoSetEntity.setExpectYearRate(expectYearRate);
		systemInfoSetEntity.setIntegralAlias(integralAlias);
		systemInfoSetEntity.setWelcomeTitle(welcomeTitle);
		
		//
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		/*HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
	    long moduleId = IntegerAndString.StringToLong(request.getParameter("moduleId"),0);
		long operationId = IntegerAndString.StringToLong(request.getParameter("operationId"),0);
		entity.setiAdminId(admin.getId());
		entity.setlModuleId(moduleId);
		entity.setlOptId(operationId);*/
		String[] sIpInfo ={};
		
		systemSetService.updateSystemInfoSet();	//保存之前删除
		int iResult = systemSetService.insertSystemInfoSet(systemInfoSetEntity, entity, sIpInfo);//保存
		return  iResult;
	}
	
}
