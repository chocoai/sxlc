

/** 
* @Title: InvestIncomeServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午2:21:32 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil; 
import cn.springmvc.dao.InvestIncomeDao;
import cn.springmvc.dao.InvestIncomeListDao;
import cn.springmvc.dao.ReplayProjectDetailListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.InvestIncomeEntity;
import cn.springmvc.model.InvestRecordInfoEntity;
import cn.springmvc.model.LoanRepayEntitys;
import cn.springmvc.model.ProjectDetailEntity;
import cn.springmvc.service.InvestIncomeService;
import cn.springmvc.utitls.RepalyUtitls;

/** 
 * @author 刘利 
 * @Description: 放款后生成收益计划
 * @since 
 * @date 2016-4-12 下午2:21:32  */
@Service("investIncomeServiceImpl")
public class InvestIncomeServiceImpl implements InvestIncomeService {
	@Resource(name="investIncomeListDaoImpl")
	private  InvestIncomeListDao  investIncomeListDao;
	@Resource(name="investIncomeDaoImpl")
	private  InvestIncomeDao  investIncomeDao;
	@Resource(name="replayProjectDetailListDaoImpl")
	private  ReplayProjectDetailListDao replayProjectDetailListDao; 
	@Override
	public int GenerateInvestIncomeList(int applyID) {
		int result = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectID",             applyID);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		List<InvestRecordInfoEntity> investRecordList = investIncomeListDao.selectInvestListByProjectID(map);
		if(investRecordList == null){
			return -1;
		}
		ProjectDetailEntity projectAppRecordEntity = null;
		projectAppRecordEntity = replayProjectDetailListDao.selectProjectDetailByID(applyID);
		if(projectAppRecordEntity == null ){
			return -1;
		}
		//3:年、2:月、1:日	 0：天标 1：月标 2：年标
		int deadLineType = projectAppRecordEntity
				.getProjectBaseInfoentity().getDeadlineType() + 1;	  
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
		for(int i = 0;i < investRecordList.size();i++ ) {
			 InvestRecordInfoEntity investRecordEntity = new InvestRecordInfoEntity();
			 investRecordEntity = investRecordList.get(i);
			 List<LoanRepayEntitys> planList = RepalyUtitls.getIncomePlan2(deadLineType,investRecordEntity
					 .getInvestAmountValids(),yearrates,Short.valueOf(deadline+""),Short.valueOf(replayway+""), presentDate3);
			 LoanRepayEntitys planEntity = new LoanRepayEntitys();
			 String planStr = ""; 
			 int iSize = planList.size();
			 for(int m = 0;m < iSize; m++ ) { 
				planEntity = planList.get(m); 
				if(planStr.equals("")) {
					planStr = planEntity.getCorpus()+","+planEntity.getInterest()+","+planEntity.getRetrieveDateTime();
				}else {
					planStr = planStr+";"+planEntity.getCorpus()+","+planEntity.getInterest()+","+planEntity.getRetrieveDateTime();
				}   
			 }
			 //生成收益计划
			 result = GenerateInvestIncome(investRecordEntity.getInvestID(),planStr); 
		}
		//收益平账
		if(result == 1) {
			 result = RepayIncomePing(applyID);
		}
		return result;
	} 
	/**
	 * 生成收益计划 
	 * @Description: TODO 
	 * @param   investID 投资ID
	 * @param   planStr
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-12 下午5:12:07
	 */
	public int GenerateInvestIncome(long investID,String planStr) {
		//项目申请ID
		long applyID  = 0;
		//投资会员ID
		long memberID = 0;
		int result = -1;
		String[] sRows = planStr.split(";");
		String[] sCols = null;
		InvestRecordInfoEntity investRecordEntity= investIncomeListDao.
				selectInvestInfoByInvestID(investID);
		
		applyID = investRecordEntity.getProjectId();
		memberID = investRecordEntity.getMemberID();
		//获取还款计划
		List<LoanRepayEntitys> RepayIDList= investIncomeListDao.selectLoanRepayIDByapplyID(applyID);
		int iSize = RepayIDList.size();
		int iLen = sRows.length;
		//还款计划条数与收益计划条数不相等
		if(iSize != iLen){
			return -1;
		}
		int iPrincipal = 0;
		int iInterest = 0;
		Timestamp ttDate = null;
		for(int i=0;i<iSize;i++){
			sCols = sRows[i].split(",");
			if(sCols.length!=3){
				continue;
			}
			iPrincipal = RepalyUtitls.StringToInt(sCols[0]);
			iInterest = RepalyUtitls.StringToInt(sCols[1]);
			ttDate = RepalyUtitls.StringToTimestamp(sCols[2]); 
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance(); 
			long iId    = generatorUtil.GetId() ; 
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("iId",             iId);
			map.put("repayId",   RepayIDList.get(i).getRepayID());
			map.put("investId",            investID);
			map.put("memberId",            memberID);
			map.put("sPrincipal",        iPrincipal);
			map.put("sInterest",          iInterest);
			map.put("ttDate",                ttDate); 
			map.put("sKey",DbKeyUtil.GetDbCodeKey());
			//新增收益计划
			result = investIncomeDao.insertInvestIncome(map);
		    if(result == 1){
		    	generatorUtil.SetIdUsed(iId);
			}else{
				generatorUtil.SetIdUsedFail(iId);
			}
		}
		return result; 
	} 
	/**
	 * 还款收益平账
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyID 项目申请ID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-12 下午3:56:22
	 */
	public int RepayIncomePing(int applyID) {
		int result = -1;
		List<LoanRepayEntitys> RepayIDList= investIncomeListDao.selectLoanRepayIDByapplyID(applyID);
		for(int i = 0;i < RepayIDList.size();i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("replayID",   RepayIDList.get(i).getRepayID());
			map.put("sKey", DbKeyUtil.GetDbCodeKey());
			InvestIncomeEntity investIncomeEntity= investIncomeListDao.selectSumAmount(map);
			String SDRecvMaxTime = investIncomeListDao.selectSDRecvMaxTime(RepayIDList.get(i).getRepayID()); 
			Map<String,Object> mapPlan = new HashMap<String,Object>();
			mapPlan.put("iId",                       RepayIDList.get(i).getRepayID());
			mapPlan.put("iPrincipal",   investIncomeEntity.getTotalSDRecvPrincipal());
			mapPlan.put("iInterest",     investIncomeEntity.getTotalSDRecvInterest());
			mapPlan.put("ttDate",                                      SDRecvMaxTime); 
			mapPlan.put("sKey",                             DbKeyUtil.GetDbCodeKey());
			
			result = investIncomeDao.updateReplay(mapPlan);
		}
		return result;
	}
}

