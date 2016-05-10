

/** 
* @Title: FinancialAdvisorAwardExcelController.java 
* @Package cn.springmvc.controller 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-5 下午1:54:00 
* @version V5.0 */
 
package cn.springmvc.controller; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.OutExcel.ExcelKit;
import product_p2p.kit.OutExcel.OutExcel;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.springmvc.service.FinancialAdvisorService; 
import cn.springmvc.util.MemberSessionMng;

/** 
 * @author 刘利 
 * @Description: 理财顾问-提奖统计EXCEl导出
 * @since 
 * @date 2016-5-5 下午1:54:00  */
@Controller
@RequestMapping("financialAdvisorAward")
public class FinancialAdvisorAwardExcelController implements OutExcel{
	
	
	@Autowired
	private FinancialAdvisorService financialAdvisorService;
	
	/**
	 * 理财顾问提奖记录导出
	 * @author 刘利   
	 * @Description: TODO  
	 * @return String 返回类型 
	 * @date 2016-5-3 上午10:17:44
	 */
	@RequestMapping(value="financialAwardRecordexcel",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public void financialAwardRecordexcel(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException{
	    String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		
		//dateStart(1今天，2近一本周，3近一月，4近6月)
		int dateStart    = IntegerAndString.StringToInt(request.getParameter("dateStart"),-1) ; 
	   
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);   
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID", lMemberInfo[0]);
		param.put("skey",     DbKeyUtil.GetDbCodeKey());
		param.put("startTime",   startTime);
		param.put("endTime",       endTime);
		param.put("dateStart",   dateStart); 
		List<InviteMasterAwardRecordEntity> list = financialAdvisorService.getFinancialAdvisorAwardExcel(param);
		
		if(list == null){
			return;
		}
		if(list.size() > 0) {
	 
			//1
			ExcelKit<InviteMasterAwardRecordEntity> kit = new ExcelKit<InviteMasterAwardRecordEntity>();
			//2
			kit.out(response, list, "理财顾问提奖记录", this);
			kit.close(); 
		}
	}
 
	@Override
	public String[] readAttribute(Object obj) {
		
		InviteMasterAwardRecordEntity entity = (InviteMasterAwardRecordEntity)obj; 
		return new String[]{entity.getLogname(),entity.getMemberName(),entity.getLoanTotalAmounts(),
				entity.getLoanAwards(),entity.getInvestTotalAmountValids(),entity.getInvestAwards(),
				String.valueOf(entity.getCountPayVIP()),entity.getVipAwards(),entity.getReplayPrincipals(),
				entity.getRepayAwards(),entity.getAwardTotals()};
	}

	@Override
	public String[] setHead() {
		 
		return new String[]{"用户名","姓名","借款金额","借款提奖金额","有效投资金额","投资提奖金额","购买VIP次数","VIP提奖金额"
				,"成功还本","成功还本提奖总金额","提奖总金额"}; 
	}
}

