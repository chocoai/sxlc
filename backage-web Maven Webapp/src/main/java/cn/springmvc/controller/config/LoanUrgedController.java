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
import cn.springmvc.model.LoanRepayUrgedSetEntity;
import cn.springmvc.model.VIPSetSubEntity;
import cn.springmvc.service.LoanRepayUrgedSetService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 账单催收配置
 * @date:2016-4-27 上午10:31:59
 **/

@Controller
@RequestMapping("/loanEerge")
public class LoanUrgedController {
	
	@Resource(name="loanRepayUrgedSetServiceImpl")
	private  LoanRepayUrgedSetService loanRepayUrgedSetService;
	
	
	/**
	 * 查询账单催收配置
	 * TODO
	 * 创建日期：2016-4-27上午10:33:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return VIPSetSubEntity
	 */
	@RequestMapping(value ="/getLoanEerge", method = RequestMethod.POST)
	@ResponseBody
	public LoanRepayUrgedSetEntity  getLoanEerge(){
		LoanRepayUrgedSetEntity entity =  loanRepayUrgedSetService.selectLoanRepayUrgedSetList();
		if(entity==null){
			entity = new LoanRepayUrgedSetEntity();
		}
		return entity;
	}
	
	/**
	 * 保存账单催收配置
	 * TODO
	 * 创建日期：2016-4-27上午10:33:05
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveLoanEerge")
	@ResponseBody
	public int saveLoanEerge(HttpServletRequest request){
		LoanRepayUrgedSetEntity setEntity = new LoanRepayUrgedSetEntity();
		
		int days = IntegerAndString.StringToInt(request.getParameter("billday"),0);
		String billContent = request.getParameter("billContent");
		setEntity.setBillDays(days);
		setEntity.setBillContent(billContent);
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
		entity.setlModuleId(611);
		entity.setlOptId(61101);
		//loanRepayUrgedSetService.deleteLoanRepayUrgedSet();//删除
		int iResult =loanRepayUrgedSetService.insertLoanRepayUrgedSet(setEntity, entity, sIpInfo);
		return  iResult;
	}
	
}
