package cn.springmvc.controller.config; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.FinancialSettingService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description:  债权转让设置控制器
* @date 2016-4-13 下午2:42:47 
*/
@Controller
@RequestMapping("config")
public class CreditorController {
	
	@Resource(name="creditorServiceImpl")
	private CreditorService creditorService;
	
	@Resource(name="financialSettingServiceImpl")
	private FinancialSettingService financialSettingService;
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到债权转让设置页面
	 * @return String  
	 * @date 2016-4-13 下午2:34:47
	 * @throws 
	 */
	@RequestMapping("/toAssignmentPage")
	public String toAssignmentPage(HttpServletRequest req){
		CreditorEntity creditorEntity = creditorService.findAllCreditor();
		req.setAttribute("creditorEntity", creditorEntity);
		return "config/assignment-set";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 添加债转让权设置
	 * @param param 债权转让实体
	 * @param type 
	 * @return int  
	 * @date 2016-4-13 下午4:32:19
	 * @throws 
	 */
	@RequestMapping("/addCreditor")
	@ResponseBody
	public int addCreditor(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60104(债权转让设置)
		//optID=6010401(修改)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60104);
		logEntity.setlOptId(6010401);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		CreditorEntity entity = creditorService.findAllCreditor();//查询数据库中是否存在数据
		CreditorEntity param = new CreditorEntity();//插入实体
		Map<String, Object> map = new HashMap<String,Object>();//修改参数map
		
		//获取解密参数，不用判断是否空值，js控制
		String type = req.getParameter("type");
		if("0".equals(type)){
			map.put("type", type);
			int holdDay = Integer.parseInt(req.getParameter("holdDay"));
			param.setHoldDay(holdDay);
			map.put("holdDay", holdDay);
			int rangeDay = Integer.parseInt(req.getParameter("rangeDay"));
			param.setRangeDay(rangeDay);
			map.put("rangeDay", rangeDay);
			int interestDay = Integer.parseInt(req.getParameter("interestDay"));
			param.setInterestDay(interestDay);
			map.put("interestDay", interestDay);
			int mngFee = IntegerAndString.StringToInt(req.getParameter("mngFee"));
			param.setMngFee(mngFee);
			map.put("mngFee",mngFee);
			int mngType = Integer.parseInt(req.getParameter("mngType"));
			param.setMngType(mngType);
			map.put("mngType", mngType);
		}else if("1".equals(type)){
			map.put("type", type);
			int checkType = Integer.parseInt(req.getParameter("checkType"));
			map.put("checkType", checkType);
			param.setCheckType(checkType);
		}else if("2".equals(type)){
			map.put("type", type);
			int loanType = Integer.parseInt(req.getParameter("loanType"));
			map.put("loanType", loanType);
			param.setLoanType(loanType);
		}else if("3".equals(type)){
			map.put("type", type);
			int interestType = Integer.parseInt(req.getParameter("interestType"));
			map.put("interestType",interestType);
			param.setInterestType(interestType);
		}
		
		int result=0;
		if(null != entity){
			result = creditorService.updateCreditor(map,logEntity,sIpInfo);
		}else{
			result = creditorService.inserCreditor(param,logEntity,sIpInfo);
		}
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到提现审核设置页面
	 * @return String  
	 * @date 2016-4-13 下午2:34:47
	 * @throws 
	 */
	@RequestMapping("/toCashExamPg")
	public String toCashExamPg(HttpServletRequest req){
		List<WithdrawalsFeeEntity> result = financialSettingService.selectWithdrawalsFee();
		req.setAttribute("result", result.get(0));
		return "config/cash-exam";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 保存提现审核设置
	 * @param param
	 * @return int  
	 * @date 2016-4-13 下午5:21:57
	 * @throws 
	 */
	@RequestMapping("/addCashExam")
	@ResponseBody
	public int addCashExam(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60103(提现审核)
		//optID=6010301(审核)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60103);
		logEntity.setlOptId(6010301);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		WithdrawalsFeeEntity param = new WithdrawalsFeeEntity();
		List<WithdrawalsFeeEntity> entity = financialSettingService.selectWithdrawalsFee();
		int check_Type = Integer.parseInt(req.getParameter("check_Type"));
		param.setCheck_Type(check_Type);
		int result=0;
		if(entity.size()>0){
			for(WithdrawalsFeeEntity item:entity){
				item.setCheck_Type(check_Type);
				result = financialSettingService.updateWithdrawalsFee(item,logEntity,sIpInfo);
			}
		}else{
			result = financialSettingService.insertWithdrawalsFee(param,logEntity,sIpInfo);
		}
		return result;
	}
	
}

