

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:59:16 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil; 
import cn.springmvc.controller.RepalyUtitls;
import cn.springmvc.dao.GenerateRepayListDao; 
import cn.springmvc.dao.ReplayProjectDetailListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.model.LoanRepayEntity; 
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.service.GenerateRepayListService;

/** 
 * @author 刘利 
 * @Description: 项目发布后生成还款计划
 * @since 
 * @date 2016-4-1 下午1:59:16  */
@Service("generateRepayListServiceImpl")
public class GenerateRepayListServiceImpl implements GenerateRepayListService {
	@Resource(name="generateRepayListDaoImpl")
	private  GenerateRepayListDao generateRepayListDao; 
	@Resource(name="replayProjectDetailListDaoImpl")
	private  ReplayProjectDetailListDao replayProjectDetailListDao; 
	@Override
	public int GenerateRepayList(int applyID) {  
		ProjectAppRecordEntity projectAppRecordEntity = null;
		projectAppRecordEntity = replayProjectDetailListDao.selectProjectDetailByID(applyID);
		if(projectAppRecordEntity == null ){
			return -1;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();  
		//3:年、2:月、1:日	 0：天标 1：月标 2：年标
		int deadLineType = projectAppRecordEntity
				.getProjectBaseInfoentity().getDeadlineType() + 1;	 
		//借款金额
		String amounts = projectAppRecordEntity
				.getProjectBaseInfoentity().getAmounts();
		//年化利率
		String yearrates = projectAppRecordEntity
				.getProjectBaseInfoentity().getYearRates();
		//借款期限
		int  deadline = projectAppRecordEntity
				.getProjectBaseInfoentity().getDeadline();
		//还款方式
		int replayway = projectAppRecordEntity
				.getProjectBaseInfoentity().getRepayWay();
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String presentDate3 = sdf3.format(new Date());//获取当前系统时间
		 List<LoanRepayEntity> planList = RepalyUtitls.getIncomePlan2(deadLineType,amounts,yearrates,Short.valueOf(deadline+""),Short.valueOf(replayway+""), presentDate3);
		 LoanRepayEntity planEntity = new LoanRepayEntity();
		 String planStr = "";
		 Long id = generatorUtil.GetId();
		 int iSize = planList.size();
		 for(int m = 0;m < iSize; m++ ){
			System.out.print(id);
			planEntity = planList.get(m); 
			if(planStr.equals("")) {
				planStr = RepalyUtitls.StringToLong(planEntity.getCorpus())+","+RepalyUtitls.StringToLong(planEntity.getInterest())+","+planEntity.getRetrieveDateTime()+","+(m+1) +","+id+"";
			}else{
				planStr = planStr+";"+RepalyUtitls.StringToLong(planEntity.getCorpus())+","+RepalyUtitls.StringToLong(planEntity.getInterest())+","+planEntity.getRetrieveDateTime()+","+(m+1) +","+id+"";
			}   
		 }
		 Map<String,Object> map =new HashMap<String,Object>();
		 map.put("iAppId", applyID);
		 map.put("sInfo", planStr);
		 map.put("sKey", DbKeyUtil.GetDbCodeKey());
		 int iResult  = generateRepayListDao.GenerateRepayList(map); 
		 String[] str = planStr.split(";");
		 if(str.length >0){
			for (int i = 0; i < str.length; i++) {
				String[] info = str[i].split(",");
				if(iResult == 0){
					generatorUtil.SetIdUsed(Long.valueOf(info[4]));
				}else{
					generatorUtil.SetIdUsedFail(Long.valueOf(info[4]));
				}
			}
		 }
		 return iResult; 
	}

}

