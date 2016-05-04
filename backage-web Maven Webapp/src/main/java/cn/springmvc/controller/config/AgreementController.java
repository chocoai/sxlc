package cn.springmvc.controller.config;

import java.util.ArrayList;
import java.util.List;

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
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.ProjectPurposeSetEntity;
import cn.springmvc.model.SystemAgreementSetEntity;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.service.ProjectPurposeSetService;
import cn.springmvc.service.SystemAgreementSetService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 协议配置
 * @date:2016-4-27 上午9:53:45
 **/


@Controller
@RequestMapping("/agreement")
public class AgreementController {
	
	@Resource(name="systemAgreementSetServiceImpl")
	private  SystemAgreementSetService systemAgreementSetService;
	
	
	/**
	 * 查询系统协议
	 * TODO
	 * 创建日期：2016-4-27上午10:02:57
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getAgreeList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getFront(HttpServletRequest request){
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		systemAgreementSetService.selectSystemAgreementSetListpage(pageEntity);
		return pageEntity;
	}
	
	
	/**
	 * 保存协议
	 * TODO
	 * 创建日期：2016-4-27上午10:03:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveAgreeConfig")
	@ResponseBody
	public int saveAgreeConfig(HttpServletRequest request){
		
		int agreeType = IntegerAndString.StringToInt(request.getParameter("agreeType"),0);
		String content = request.getParameter("content");
		
		SystemAgreementSetEntity agreementSetEntity = new SystemAgreementSetEntity();
		agreementSetEntity.setAgreementType(agreeType);
		agreementSetEntity.setAgreementDetail(content);
		agreementSetEntity.setAgreementStatu(1);
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
		entity.setlModuleId(610);
		entity.setlOptId(61001);
		int iResult = systemAgreementSetService.insertSystemAgreementSet(agreementSetEntity, entity, sIpInfo);
		return  iResult;
	}
	
	/**
	 * 修改协议
	 * TODO
	 * 创建日期：2016-4-27上午10:03:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateConfig")
	@ResponseBody
	public int updateConfig(HttpServletRequest request){
		
		int agreeType = IntegerAndString.StringToInt(request.getParameter("agreeType"),0);
		String content = request.getParameter("content");
		SystemAgreementSetEntity agreementSetEntity = new SystemAgreementSetEntity();
		agreementSetEntity.setAgreementType(agreeType);
		agreementSetEntity.setAgreementDetail(content);
		agreementSetEntity.setAgreementStatu(1);
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
		entity.setlModuleId(610);
		entity.setlOptId(61002);
		int iResult = systemAgreementSetService.updateSystemAgreementSetByType(agreementSetEntity, entity, sIpInfo);
		return  iResult;
	}
	/**
	 * 停用启用协议
	 * TODO
	 * 创建日期：2016-4-27上午10:03:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/changeAgreeStatu")
	@ResponseBody
	public int changeAgreeStatu(HttpServletRequest request){
		
		int agreeType = IntegerAndString.StringToInt(request.getParameter("agreeType"),0);
		int agreeStatu = IntegerAndString.StringToInt(request.getParameter("agreeStatu"),0);
		SystemAgreementSetEntity agreementSetEntity = new SystemAgreementSetEntity();
		agreementSetEntity.setAgreementType(agreeType);
		agreementSetEntity.setAgreementStatu(agreeStatu);
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
		entity.setlModuleId(610);
		entity.setlOptId(61003);
		int iResult = systemAgreementSetService.updateSystemAgreementSetStatuByType(agreementSetEntity, entity, sIpInfo);
		return  iResult;
	}	
}
