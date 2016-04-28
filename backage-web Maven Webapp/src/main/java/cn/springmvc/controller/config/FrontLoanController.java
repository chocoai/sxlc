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
import cn.springmvc.model.Admin;
import cn.springmvc.model.ProjectPurposeSetEntity;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.service.ProjectPurposeSetService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 前台借款信息填写配置
 * @date:2016-4-12 下午4:08:39
 **/


@Controller
@RequestMapping("/front")
public class FrontLoanController {
	
	@Resource(name="")
	private  ProjectPurposeSetService projectPurposeSetService ;
	
	
	/**
	 * 查询借款信息填写配置
	 * TODO
	 * 创建日期：2016-4-26下午2:52:37
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<ProjectPurposeSetEntity>
	 */
	@RequestMapping(value ="/getFront", method = RequestMethod.POST)
	@ResponseBody
	public List<ProjectPurposeSetEntity>   getFront(){
		List<ProjectPurposeSetEntity> list  = projectPurposeSetService.selectProjectPurposeSetListpage();
		return list;
	}
	
	
	/**
	 * 保存借款信息填写配置
	 * TODO
	 * 创建日期：2016-4-26下午2:53:34
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveFrontConfig")
	@ResponseBody
	public int savePlatConfig(HttpServletRequest request){
		String checkList = request.getParameter("checkList");
		String[] strlist = {};
		if(checkList.indexOf(";")>0){
			strlist = checkList.split(";");
		}else{
			strlist[0] = checkList;
		}
		List<ProjectPurposeSetEntity> entitys = new ArrayList<ProjectPurposeSetEntity>();
		ProjectPurposeSetEntity purposeSetEntity = null;;
		for (String str : strlist) {
			String[] keyMap = str.split(",");
			purposeSetEntity = new ProjectPurposeSetEntity();
			int type = IntegerAndString.StringToInt(keyMap[0], 0);
			int value = IntegerAndString.StringToInt(keyMap[1], 0);
			purposeSetEntity.setOptionType(type);
			purposeSetEntity.setOptionStatu(value);
			entitys.add(purposeSetEntity);
		}
		
		
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
		entity.setlModuleId(602);
		entity.setlOptId(60201);
		projectPurposeSetService.deleteProjectPurposeSetByType();//删除
		int iResult = projectPurposeSetService.insertProjectPurposeSet(entitys, entity, sIpInfo);
		return  iResult;
	}
	
}
