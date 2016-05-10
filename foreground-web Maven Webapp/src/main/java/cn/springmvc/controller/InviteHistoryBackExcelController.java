

/** 
* @Title: InviteHistoryBackExcelController.java 
* @Package cn.springmvc.controller 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-5 上午11:42:52 
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
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.springmvc.service.InviteMasterApplyService;
import cn.springmvc.util.MemberSessionMng;

/** 
 * @author 刘利 
 * @Description:推荐达人-历史返现excel导出
 * @since 
 * @date 2016-5-5 上午9:05:20  */
@Controller
@RequestMapping(value="/inviteHistoryBackExcel")
public class InviteHistoryBackExcelController implements OutExcel{
	
	@Autowired
	private InviteMasterApplyService inviteMasterApplyService;
	
	/**
	 * 推荐达人历史返现execl导出
	 * @author 刘利   
	 * @Description: TODO  
	 * @return String 返回类型 
	 * @date 2016-5-3 上午10:17:44
	 */
	@RequestMapping(value="/inviteHistoryBackexcel",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public void inviteHistoryBackexcel(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException{
		
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String month     = request.getParameter("month") ; //(提奖统计月份一月：01，二月:02)
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID", lMemberInfo[0]); 
		param.put("startTime",   startTime);
		param.put("endTime",       endTime);
		param.put("month",           month); 
		List<AwardPaymentRecordEntity> list = inviteMasterApplyService.getInviteMasterHistoryBackExcel(param);

		if(list == null){
			return;
		}
		if(list.size() > 0) {
	 
			//1
			ExcelKit<AwardPaymentRecordEntity> kit = new ExcelKit<AwardPaymentRecordEntity>();
			//2
			kit.out(response, list, "推荐达人历史返现", this);
			kit.close();
		}
	}
 
	@Override
	public String[] readAttribute(Object obj) {
		
		AwardPaymentRecordEntity entity = (AwardPaymentRecordEntity)obj; 
		return new String[]{entity.getStartDate()+"-"+entity.getEndDate(),
				entity.getPersonalName(),entity.getBorrowAmounts(),
				entity.getBorrowAwards(),entity.getInvestAmounts(),entity.getInvestAwards(),
				 entity.getRepayAmounts(),entity.getRepayAwards(),entity.getVipAmounts(),
				entity.getVipAwards(),entity.getAwardAmounts(),entity.getRealAmounts(),entity.getPayStatus()};
	}

	@Override
	public String[] setHead() {
		 
		return new String[]{"统计时间段","姓名","借款金额","借款提奖金额","投资总金额","投资提奖金额",
				"还本总金额","还本提奖金额","购买VIP总金额","VIP提奖金额" ,"提奖总金额","实际提奖金额","提奖发放时间","发放状态"}; 
		 
	}

}

