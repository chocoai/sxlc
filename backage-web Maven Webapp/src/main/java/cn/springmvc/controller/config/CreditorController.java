package cn.springmvc.controller.config; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.FinancialSettingService;

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
	public int addCreditor(CreditorEntity param,String type){
		CreditorEntity entity = creditorService.findAllCreditor();
		int result=0;
		if(null != entity){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("type", type);
			map.put("holdDay", param.getHoldDay());
			map.put("rangeDay", param.getRangeDay());
			map.put("interestDay", param.getInterestDay());
			map.put("mngFee", param.getMngFee());
			map.put("mngType", param.getMngType());
			map.put("checkType", param.getCheckType());
			map.put("loanType", param.getLoanType());
			map.put("interestType", param.getInterestType());
			result = creditorService.updateCreditor(map);
		}else{
			result = creditorService.inserCreditor(param);
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
	public int addCashExam(WithdrawalsFeeEntity param){
		List<WithdrawalsFeeEntity> entity = financialSettingService.selectWithdrawalsFee();
		InsertAdminLogEntity log = new InsertAdminLogEntity();
		String[] sIpInfo={"",""};
		int result=0;
		if(entity.size()>0){
			for(WithdrawalsFeeEntity item:entity){
				item.setCheck_Type(param.getCheck_Type());
				result = financialSettingService.updateWithdrawalsFee(item,log,sIpInfo);
			}
		}else{
			result = financialSettingService.insertWithdrawalsFee(param,log,sIpInfo);
		}
		return result;
	}
	
}

