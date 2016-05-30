
package cn.springmvc.service.impl; 

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.InvestIncomeDao;
import cn.springmvc.dao.InvestIncomeListDao;
import cn.springmvc.dao.impl.HandleThreePartyDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.SelectThreePartyDaoImpl;
import cn.springmvc.dao.impl.sms.SMScontent;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.model.InvestIncomeEntity;
import cn.springmvc.model.InvestRecordInfoEntity;
import cn.springmvc.model.LoanRepayEntitys;
import cn.springmvc.model.ProjectDetailEntity;
import cn.springmvc.service.CompensatoryInterfaceServer;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AccountInterfaceReturnEntity;
import cn.sxlc.account.manager.model.AuditEntity;
import cn.sxlc.account.manager.model.AuditReturnEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceReturnEntity;
import cn.sxlc.account.manager.model.AwardEntity;
import cn.sxlc.account.manager.model.Common;
import cn.sxlc.account.manager.model.HTTPClientUtilsbak;
import cn.sxlc.account.manager.model.InvestRecordEntity;
import cn.sxlc.account.manager.model.LoanInfoBean;
import cn.sxlc.account.manager.model.LoanInfoBeanSubmit;
import cn.sxlc.account.manager.model.LoanInfoSecondaryBean;
import cn.sxlc.account.manager.model.LoanRepayEntity;
import cn.sxlc.account.manager.model.LoanReturnInfoBean;
import cn.sxlc.account.manager.model.LoanTransactionEntity;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.LoanTransferReturnEntity;
import cn.sxlc.account.manager.model.RechargeEntity;
import cn.sxlc.account.manager.model.RechargeReturnEntity;
import cn.sxlc.account.manager.model.RepalyUtitls;
import cn.sxlc.account.manager.model.RepayDetailEntity;
import cn.sxlc.account.manager.model.RepayInterfaceEntity;
import cn.sxlc.account.manager.model.RsaHelper;
import cn.sxlc.account.manager.model.SurpriseRedEntity;
import cn.sxlc.account.manager.model.TransferSubmitEntity;
import cn.sxlc.account.manager.model.WithdrawalsFeeEntity;
import cn.sxlc.account.manager.model.WithdrawsEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceReturnEntity;



/** 
 * 第三方托管接口实现 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-7 下午2:40:03  */
@Service("compensatoryInterfaceServiceImpl")
public class CompensatoryInterfaceServiceImpl implements CompensatoryInterfaceServer{
	@Resource(name="selectThreePartyDaoImpl")
	private SelectThreePartyDaoImpl  selectThreePartyDaoImpl;
	@Resource(name="handleThreePartyDaoImpl")
	private HandleThreePartyDaoImpl  handleThreePartyDaoImpl;
	IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
	@Resource
	private SendSmsUtil sendSmsUtil;
	@Resource(name="sMScontent")
	private SMScontent sMScontent;
	/* *  *  * @param lonmemberId
	/* *  *  * @param lonmembertype
	/* *  *  * @param appplyId
	/* *  *  * @param results
	/* *  *  * @return * @see cn.springmvc.service.ManagedInterfaceServerTestI#RepaymentProcessing(long, int, long, int[]) */
	@Override
	public LoanTransferEntity Compensatory(long appplyId,long repalyId, int[] results,long daicangId,int daicangtype,HttpServletRequest request,String returnURL,String notifyURL) {
		
		// TODO Auto-generated method stub return null;
		RepayInterfaceEntity repayInterfaceEntity=new RepayInterfaceEntity();
		// TODO Auto-generated method stub return null;
		Map<String, Object> mapsMap=new HashMap<String, Object>();
		//判断是否满足代偿
		mapsMap.put("applyId", appplyId);
		int result=selectThreePartyDaoImpl.CompensatoryJudgment(mapsMap);
		results[0]=result;
		if(result==0){//满足条件
			//查询提前还款总共应还本金
			mapsMap.put("skey", DbKeyUtil.GetDbCodeKey());
			mapsMap.put("applyId", appplyId);
			//long lamoney=selectThreePartyDaoImpl.selectAllmoneyForEarlyRepayment(mapsMap);
			//查询违约金收取费率
			
			long investRate=0;//支付投资人
			long pingTaiRate=0;//支付平台
			//查询出所有的投资人以及投资记录
			List<RepayDetailEntity> liDetailEntities=selectThreePartyDaoImpl
																.selectAllInvestForEarlyRepayment(mapsMap);
			//总还款金额
			long lallmoney=0;
			//总还款本金
			long lPrincipal=0;
			//总还款利息
			long lInterest=0;
			//总还款违约金
			long lPenalty=0;
			//总投资管理费
			long lMngFee=0;
			//总逾期费
			long lOverdue=0;
			//总的逾期利息
			long lOverdueInterest=0;
			String sInfo="";
			if (liDetailEntities.size()>0) {
				//查询出投资会员应收总本金
				for (int i = 0; i < liDetailEntities.size(); i++) {
					Map<String, Object> smap=new HashMap<String, Object>();
					//根据投资记录id、还款计划id 查询会员当期应收本金
					smap.put("skey", DbKeyUtil.GetDbCodeKey());
					smap.put("investId", liDetailEntities.get(i).getiInvestId());
					smap.put("repayId", repalyId);
					liDetailEntities.get(i).setlPrincipal(selectThreePartyDaoImpl.selectPrincipalByID(smap));
					lPrincipal+=liDetailEntities.get(i).getlPrincipal();
					//计算出当期应收收益
					long linver=selectThreePartyDaoImpl.findInterestByOne(smap);//当期还款总需收取利息
					lInterest+=linver;
					liDetailEntities.get(i).setlInterest(linver);//应收当期收益
					//查询投资人乾多多标识
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("memberType", 0);//会员类型
					map.put("memberID", liDetailEntities.get(i).getiMemberId());//会员id
					liDetailEntities.get(i).setsMark(selectThreePartyDaoImpl.findMemberThirdPartyMark(map));
					
					//计算出利息管理费
					long lmng=0;//管理费费率
					long as=linver*lmng/100;
					lMngFee+=as;
					liDetailEntities.get(i).setlMngFee(as);
					liDetailEntities.get(i).setsMngFee(IntegerAndString.LongToString2(as));
					//计算出平台收取提前还款违约金
					if (pingTaiRate>0) {
						long pTaiRate=0;
						linver+=pTaiRate;
						liDetailEntities.get(i).setlPenalty(pTaiRate);
						liDetailEntities.get(i).setsPenalty(IntegerAndString.LongToString2(pTaiRate));
						lPenalty+=pTaiRate;
					}
					//计算出投资人收取提前还款违约金
					if (investRate>0) {
						long ir=0;
						linver+=ir;
						liDetailEntities.get(i).setlPenaltyInvest(ir);
						liDetailEntities.get(i).setsPenaltyInvest(IntegerAndString.LongToString2(investRate));
						lPenalty+=ir;
					}
					linver+=liDetailEntities.get(i).getlPrincipal();//收益总金额
					liDetailEntities.get(i).setlAmount(linver);
					liDetailEntities.get(i).setsAmount(IntegerAndString.LongToString2(linver));
					//计算逾期费
					//long allOverdue=0;//总应收逾期费
					//查询出逾期天数
					Map<String, Object> mapday=new HashMap<String, Object>();
					mapday.put("repayId", repalyId);
					mapday.put("investId", liDetailEntities.get(i).getiInvestId());
					long idays=selectThreePartyDaoImpl.findDayByOverdue(mapday);
					if (idays>0) {//逾期
						//收益计划id
						long incomeId=selectThreePartyDaoImpl.findIncomeId(mapday);
						//查询出逾期利率
						map.put("iDays", idays);//逾期天数
						selectThreePartyDaoImpl.findOverdueFees(map);
						//根据收益计划id查询投资人预计还款逾期罚息和罚金
						mapday.put("skey", DbKeyUtil.GetDbCodeKey());
						mapday.put("incomeId", incomeId);
						Map<String, Object> mapOvder = selectThreePartyDaoImpl
									.InvestIncomeOverdueFee(mapday);
						long repayOverdueInterest=IntegerAndString.StringToLong(mapOvder.get("Repay_Overdue_Interest").toString(), 0);
						long repayOverdue=IntegerAndString.StringToLong(mapOvder.get("Repay_Overdue").toString(),0);
						//查询出之前投资人已收的所有罚金和罚息
						Map<String, Object> mapallOvder = selectThreePartyDaoImpl
								.allInvestRealIncome(mapday);
						long secrepayOverdueInterest=IntegerAndString.StringToLong(mapOvder.get("Repay_Overdue_Interest").toString(),0);
						long secrepayOverdue=IntegerAndString.StringToLong(mapOvder.get("Repay_Overdue").toString(),0);
						//计算出部分还款过后未还完的罚息和罚金
						liDetailEntities.get(i).setlOverdue(secrepayOverdue-repayOverdue);
						liDetailEntities.get(i).setlOverdueInterest(secrepayOverdueInterest-repayOverdueInterest);
						if (liDetailEntities.get(i).getlOverdue()<0) {
							liDetailEntities.get(i).setlOverdue(0);
						}
						if (liDetailEntities.get(i).getlOverdueInterest()<0) {
							liDetailEntities.get(i).setlOverdueInterest(0);
						}
						
						Map<String, Object> ma=new HashMap<String, Object>();
						ma.put("repayId", repalyId);
						Timestamp ttLastPay = null;		//上次计算逾期费时间
						Timestamp ttNow = RepayDetailEntity.GetCurrentDateTime();
						//根据还款计划id查询当期预计还款时间
						//selectThreePartyDaoImpl.overdueRepayMaxTime(mapallOvder);
						
						//根据还款计划id查询最近一次逾期还款时间
						ttLastPay=selectThreePartyDaoImpl.overdueRecvTime(mapallOvder);
						if(ttLastPay!=null){
							idays=RepayDetailEntity.GetDateSub(ttLastPay, ttNow);
						}
						//查询出未收取逾期费用
						// 查找逾期费
						long[] lOverdue1 = {0,0};
						if(idays>0){
							Map<String, Object> mad=new HashMap<String, Object>();
							mad.put("iDays", idays);
							long lRate=selectThreePartyDaoImpl.findOverdueFees(mapallOvder);
							long lYearRate=selectThreePartyDaoImpl.ProjectBaseInfoYearRate(mapsMap);
							RepayDetailEntity.GetYuqiAmount(idays, 
									liDetailEntities.get(i).getlPrincipal(), lYearRate, lOverdue1, lRate);
							liDetailEntities.get(i).setlThisOdInterest(lOverdue1[0]);
							liDetailEntities.get(i).setlThisOverdue(lOverdue1[1]);
							liDetailEntities.get(i).setlOverdue(liDetailEntities.get(i).getlOverdue() + lOverdue1[1]);
							liDetailEntities.get(i).setlOverdueInterest(liDetailEntities.get(i).getlOverdueInterest() + lOverdue1[0]);
							liDetailEntities.get(i).setsOverdue(IntegerAndString.LongToString2(liDetailEntities.get(i).getlOverdue()));
							liDetailEntities.get(i).setsOverdueInterest(IntegerAndString.LongToString2(liDetailEntities.get(i).getlOverdueInterest()));
							lOverdue += liDetailEntities.get(i).getlOverdue();
							lOverdueInterest += liDetailEntities.get(i).getlOverdueInterest();
						}
					}
					long iAmount = (liDetailEntities.get(i).getlPrincipal() + liDetailEntities.get(i).getlInterest() + liDetailEntities.get(i).getlOverdue() + liDetailEntities.get(i).getlOverdueInterest() 
							+ liDetailEntities.get(i).getlPenalty() );
					liDetailEntities.get(i).setlAmount(iAmount);
					liDetailEntities.get(i).setsAmount(IntegerAndString.LongToString2(iAmount));
					liDetailEntities.get(i).setsOrderNo(handleThreePartyDaoImpl.generateorderNo("DC"));//随机订单号生成
					
					liDetailEntities.get(i).setId(selectThreePartyDaoImpl.findIncomeId(mapday));
					
					sInfo = liDetailEntities.get(i).getsDetail();
					if (sInfo==null) {
						sInfo="";
					}
					// 投资记录id+本金+利息+总逾期费+平台收取违约金+投资人收取违约金+投资管理费+0+投资人收取逾期费+预期利息+投资会员id+投资会员类型+该笔平台订单号
					sInfo = sInfo + liDetailEntities.get(i).getiInvestId() + "A" 
								+ liDetailEntities.get(i).getlPrincipal() + "A" 
								+ liDetailEntities.get(i).getlInterest() + "A" 
								+ liDetailEntities.get(i).getlOverdue() + "A" 
								+ liDetailEntities.get(i).getlPenalty() +"A"
								+liDetailEntities.get(i).getsPenaltyInvest()+ "A" 
								+ as + "A" + "1" + "A"+ liDetailEntities.get(i).getlOverdue()
								+ "A"+ liDetailEntities.get(i).getlOverdueInterest() + "A" + liDetailEntities.get(i).getiMemberId() + "A" + liDetailEntities.get(i).getiMemberType()+"A"+liDetailEntities.get(i).getsOrderNo();
					liDetailEntities.get(i).setsDetail(sInfo);
				}
				
				
				repayInterfaceEntity.setDetailList(liDetailEntities);
				lallmoney=lPrincipal+lInterest+lPenalty+lOverdue;
				repayInterfaceEntity.setlAmount(lallmoney);
				repayInterfaceEntity.setsAmount(IntegerAndString.LongToString(lallmoney));
				repayInterfaceEntity.setlInterest(lInterest);
				repayInterfaceEntity.setsInterest(IntegerAndString.LongToString(lInterest));
				repayInterfaceEntity.setlPrincipal(lPrincipal);
				repayInterfaceEntity.setsPrincipal(IntegerAndString.LongToString(lPrincipal));
				repayInterfaceEntity.setlPenalty(lPenalty);
				repayInterfaceEntity.setsPenalty(IntegerAndString.LongToString(lPenalty));
				repayInterfaceEntity.setlMngFee(lMngFee);
				repayInterfaceEntity.setsMngFee(IntegerAndString.LongToString(lMngFee));
				repayInterfaceEntity.setlOverdueInterest(lOverdueInterest);
				//还款会员id
				repayInterfaceEntity.setiMemberId(daicangId);
				repayInterfaceEntity.setiMemberType(daicangtype);
				
				//查询还款会员乾多多标识
				if (daicangtype==1) {
					Map<String, Object> lomap=new HashMap<String, Object>();
					lomap.put("memberType", daicangtype);//会员类型
					lomap.put("memberID", daicangId);//代偿机构id
					repayInterfaceEntity.setsMark(selectThreePartyDaoImpl.findMemberThirdPartyMark(lomap));
					repayInterfaceEntity.setRemark2(daicangId+"A1");
				}else {
					//获得平台乾多多标识
					String pmark="";
					Map<String, Object> maps = new HashMap<String, Object>();
					maps.put("accountTypeID", daicangId);//平台账号类型
					pmark=selectThreePartyDaoImpl.findThirdPartyMark(maps);
					repayInterfaceEntity.setsMark(pmark);
					repayInterfaceEntity.setRemark2(daicangId+"A2");
				}
				repayInterfaceEntity.setRemark3(repalyId+"A"+appplyId);
			}
			LoanTransferEntity loanTransferEntity=earlyRepaymentSubm(repayInterfaceEntity, request, returnURL, notifyURL);
			return loanTransferEntity;
		}else {
			return null;
		}
	}
	@Override
	public LoanTransferEntity earlyRepaymentSubm(
			RepayInterfaceEntity repayInterfaceEntity,HttpServletRequest request,String returnURL,String notifyURL) {
			LoanTransferEntity loanTransferEntity = new LoanTransferEntity();
			//获得平台乾多多标识
			String pmark="";
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("accountTypeID", 1);//平台账号类型
			pmark=selectThreePartyDaoImpl.findThirdPartyMark(maps);
			//转账提交列表
			List<LoanInfoBean> loanReturnInfoBeans=new ArrayList<LoanInfoBean>();
			LoanInfoBean loanInfoBean = new LoanInfoBean();
			String ordernumber = handleThreePartyDaoImpl.generateorderNo("DC");
			RepayDetailEntity repayDetailEntity = new RepayDetailEntity();
			if(repayInterfaceEntity.getDetailList().size()>0){
				for (int i = 0; i < repayInterfaceEntity.getDetailList().size(); i++) {
					repayDetailEntity=repayInterfaceEntity.getDetailList().get(i);
					loanInfoBean.setAdvanceBatchNo("");
					if (repayDetailEntity.getlAmount()>0) {
						loanInfoBean.setAmount(repayDetailEntity.getsAmount());
						
					}
					loanInfoBean.setBatchNo(repayInterfaceEntity.getsOrderNo());
					loanInfoBean.setExchangeBatchNo("");
					loanInfoBean.setFullAmount("");
					loanInfoBean.setLoanInMoneymoremore(repayDetailEntity.getsMark());
					loanInfoBean.setLoanOutMoneymoremore(repayInterfaceEntity.getsMark());
					loanInfoBean.setOrderNo(repayDetailEntity.getsOrderNo());
					ordernumber= loanInfoBean.getOrderNo();
					loanInfoBean.setRemark(repayDetailEntity.getsDetail());
					//管理费
					List<LoanInfoSecondaryBean> loanInfoSecondaryBean = new ArrayList<LoanInfoSecondaryBean>();
					LoanInfoSecondaryBean secondary = new LoanInfoSecondaryBean();
					if (repayDetailEntity.getlMngFee()>0) {
						secondary.setAmount(repayDetailEntity.getsMngFee());
						secondary
								.setLoanInMoneymoremore(pmark);
						secondary.setRemark(repayDetailEntity.getsMngFee());
						secondary.setTransferName("收取投资管理费");
						loanInfoSecondaryBean.add(secondary);
					}
					if (loanInfoSecondaryBean.size()>0) {//将二次分配加入单个还款实体
						String SLoanInMoneymoremore1 = Common
								.JSONEncode(loanInfoSecondaryBean);
						loanInfoBean.setSecondaryJsonList(SLoanInMoneymoremore1);
					}else {
						loanInfoBean.setSecondaryJsonList("");
					}
					loanInfoBean.setTransferName("还款");
					loanReturnInfoBeans.add(loanInfoBean);
				}
			}
			loanTransferEntity.setLoanJsonList(Common.JSONEncode(loanReturnInfoBeans));
			loanTransferEntity.setPlatformMoneymoremore(pmark);
			loanTransferEntity.setTransferAction("2") ;
			loanTransferEntity.setAction("1");
			loanTransferEntity.setTransferType("2") ;
			loanTransferEntity.setNeedAudit("1");
			loanTransferEntity.setRandomTimeStamp("");
			loanTransferEntity.setRemark1(ordernumber);
			loanTransferEntity.setRemark2(repayInterfaceEntity.getRemark2()) ;
			loanTransferEntity.setRemark3(repayInterfaceEntity.getRemark3());
			loanTransferEntity.setSubmitURL("http://218.4.234.150:88/main/loan/loan.action");
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + path + "/";
			loanTransferEntity.setReturnURL(basePath+returnURL);
			loanTransferEntity.setNotifyURL(basePath+notifyURL);
			String privatekey = Common.privateKeyPKCS8;
			String dataStr = loanTransferEntity.getLoanJsonList()
					+ loanTransferEntity.getPlatformMoneymoremore()
					+ loanTransferEntity.getTransferAction() + loanTransferEntity.getAction()
					+ loanTransferEntity.getTransferType() + loanTransferEntity.getNeedAudit()
					+ loanTransferEntity.getRandomTimeStamp() + loanTransferEntity.getRemark1()
					+ loanTransferEntity.getRemark2() + loanTransferEntity.getRemark3()
					+ loanTransferEntity.getReturnURL() + loanTransferEntity.getNotifyURL();
			// 签名
			RsaHelper rsa = RsaHelper.getInstance();
			String SignInfo = rsa.signData(dataStr, privatekey);
			loanTransferEntity.setSignInfo(SignInfo);
			String LoanJsonList = Common.UrlEncoder(loanTransferEntity.getLoanJsonList(),
					"utf-8");
			loanTransferEntity.setLoanJsonList(LoanJsonList);
			//添加开户第三方交互记录
			Map<String, Object> mapsa = new HashMap<String, Object>();
			long id =  generatorUtil.GetId();
			mapsa.put("id", id);//第三方交互记录id
			mapsa.put("merbillNo", ordernumber);//当前操作订单号
			mapsa.put("type", "13");//操作类型
			mapsa.put("interfaceType", 1);//第三方接口提供商
			mapsa.put("detail", dataStr);//加密前数据
			mapsa.put("detailEncrypt", SignInfo);//加密后数据
			mapsa.put("remark", "");//备注
			handleThreePartyDaoImpl.insertThirdInterfaceRecord(maps);	
			generatorUtil.SetIdUsed(id);
			loanTransferEntity.setStatu(0);//提交信息处理成功
			// TODO Auto-generated method stub return null;
			return loanTransferEntity;
	}
	
	@Override
	public void CompensatoryNotify(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			LoanTransferReturnEntity 
					loanTransferReturnEntity=new LoanTransferReturnEntity();
			request.setCharacterEncoding("UTF-8");
			loanTransferReturnEntity.
				setResultCode(request.getParameter("ResultCode"));
			loanTransferReturnEntity
				.setMessage(request.getParameter("Message"));//返回信息
			if(loanTransferReturnEntity.getResultCode()!=null){
				if (loanTransferReturnEntity.getResultCode().equals("88")) {
					loanTransferReturnEntity.setStatu(0);
					loanTransferReturnEntity
					.setLoanJsonList(request.getParameter("LoanJsonList"));
					String fah = request.getParameter("LoanJsonList");
					fah = Common.UrlDecoder(fah, "utf-8");
					List<Object> loaninfolist = Common.JSONDecodeList(fah,
							LoanReturnInfoBean.class);
					loanTransferReturnEntity.setLoaninfolists(loaninfolist);//需要处理的转账信息
					loanTransferReturnEntity
					.setPlatformMoneymoremore(request.getParameter("PlatformMoneymoremore"));
					loanTransferReturnEntity
					.setRemark1(request.getParameter("Remark1"));
					loanTransferReturnEntity
					.setRemark2(request.getParameter("Remark2"));
					loanTransferReturnEntity
					.setRemark3(request.getParameter("Remark3"));
				}else {
					loanTransferReturnEntity.setStatu(1);
				}
			}else {
				loanTransferReturnEntity.setStatu(1);
			}
			if(loanTransferReturnEntity.getStatu()==0){//还款成功
				String detil="";
				String idsa="";
				long ida=0;
				if(loanTransferReturnEntity.getLoaninfolist().size()>0){
					for (int i = 0; i < loanTransferReturnEntity.getLoaninfolist().size(); i++) {
						LoanReturnInfoBean lrib = (LoanReturnInfoBean) loanTransferReturnEntity.getLoaninfolist()
								.get(i);//批量还款信息
						ida=generatorUtil.GetId();
						if (!detil.equals("")) {
							detil+="B"+lrib.getRemark()+"A"+ida+"A"+lrib.getLoanNo();
						}else {
							detil+=lrib.getRemark()+"A"+ida+"A"+lrib.getLoanNo();
						}
						if (!idsa.equals("")) {
							idsa+=","+idsa;
						}else {
							idsa+=idsa;
						}
					}
					String [] repay=loanTransferReturnEntity.getRemark2().split("A");
					String [] idString=loanTransferReturnEntity.getRemark3().split("A");
					//repalyId+"A"+appplyId
					//daicangId+"A"+daicangtype
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("detail", detil);//交易记录id
					map.put("applyId", IntegerAndString.StringToLong(idString[1].toString(), 0));//
					map.put("repayMemberId",IntegerAndString.StringToLong(repay[0].toString(), 0) );//
					map.put("repayMemberType", IntegerAndString.StringToLong(repay[1].toString(), 0) );//
					map.put("thirdBillNo", loanTransferReturnEntity.getRemark1());//平台订单号
					long repaythredId=generatorUtil.GetId();
					map.put("repaythredId", repaythredId);//代偿方交易记录id
					long rePayRecordID = generatorUtil.GetId();
					map.put("rePayRecordID", rePayRecordID);//代偿方记录id
					map.put("repalyId", IntegerAndString.StringToLong(idString[0].toString(), 0));
					map.put("skey", DbKeyUtil.GetDbCodeKey());//秘钥
					int result=handleThreePartyDaoImpl.CompensatoryRepayBack(map);
					String [] iStrings = idsa.split(",");
					for (int i = 0; i < iStrings.length; i++) {
						if (result>0) {
							generatorUtil.SetIdUsed(IntegerAndString.StringToLong(iStrings[i], 0));
						}else {
							generatorUtil.SetIdUsedFail(IntegerAndString.StringToLong(iStrings[i], 0));
						}
					}
					if (result>0) {
						generatorUtil.SetIdUsed(rePayRecordID);
						generatorUtil.SetIdUsed(repaythredId);
					}else {
						generatorUtil.SetIdUsedFail(rePayRecordID);
						generatorUtil.SetIdUsedFail(repaythredId);
					}
				}
				
			}else {//还款失败
				loanTransferReturnEntity.getMessage();//失败原因
			}
			response.setContentType("text/plain;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("SUCCESS");
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block e.printStackTrace();
			e.printStackTrace();
		}
		// TODO Auto-generated method stub 
		 
		
	}
	@Override
	public String CompensatoryReturn(HttpServletRequest request,
			HttpServletResponse response) {
		String retur="SUCCESS";
		try {
			LoanTransferReturnEntity 
					loanTransferReturnEntity=new LoanTransferReturnEntity();
//			ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//			HttpServletRequest request = attributes.getRequest();
			request.setCharacterEncoding("UTF-8");
			loanTransferReturnEntity.
				setResultCode(request.getParameter("ResultCode"));
			loanTransferReturnEntity
				.setMessage(request.getParameter("Message"));//返回信息
			if(loanTransferReturnEntity.getResultCode()!=null){
				if (loanTransferReturnEntity.getResultCode().equals("88")) {
					loanTransferReturnEntity.setStatu(0);
					loanTransferReturnEntity
					.setLoanJsonList(request.getParameter("LoanJsonList"));
					String fah = request.getParameter("LoanJsonList");
					fah = Common.UrlDecoder(fah, "utf-8");
					List<Object> loaninfolist = Common.JSONDecodeList(fah,
							LoanReturnInfoBean.class);
					loanTransferReturnEntity.setLoaninfolists(loaninfolist);//需要处理的转账信息
					loanTransferReturnEntity
					.setPlatformMoneymoremore(request.getParameter("PlatformMoneymoremore"));
					loanTransferReturnEntity
					.setRemark1(request.getParameter("Remark1"));
					loanTransferReturnEntity
					.setRemark2(request.getParameter("Remark2"));
					loanTransferReturnEntity
					.setRemark3(request.getParameter("Remark3"));
				}else {
					loanTransferReturnEntity.setStatu(1);
				}
			}else {
				loanTransferReturnEntity.setStatu(1);
			}
			if(loanTransferReturnEntity.getStatu()==0){//还款成功
				if(loanTransferReturnEntity.getLoaninfolist().size()>0){
				}
			}else {//还款失败
				loanTransferReturnEntity.getMessage();//失败原因
				retur="FAIL";
			}
			
		} catch (Exception e) {
			retur="ERRO";
			// TODO Auto-generated catch block e.printStackTrace();
			e.printStackTrace();
		}
		// TODO Auto-generated method stub return null;
		return retur;
		
	}
}

