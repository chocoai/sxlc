

/** 
* @Title: PostLoanManageService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午6:08:23 
* @version V5.0 */
 
package cn.springmvc.service; 
 

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.LoanRepayUrgedRecordEntity;
import cn.springmvc.model.PostProjectEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAfterLoanInfoEntity; 

/** 
 * @author 刘利 
 * @Description: 贷后管理
 * @since 
 * @date 2016-4-15 下午6:08:23  */

public interface PostLoanManageService {
	/**
	 * 查询逾期催收 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * map{
	 * projectNo,借款项目编号
	 * projectTitle,借款项目名称
	 * personalName,借款人
	 * startTime,还款时间开始
	 * endTime,还款时间结束
	 * orderDsec(1还款时间升序,-1还款时间降序,2逾期天数升序,-2逾期天数降序)
	 * }
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-15 下午5:53:40
	 */
	public void getOverdueCollection(PageEntity pageEntity);
	/**
	 * 新催收记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param loanRepayUrgedRecordEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-4-15 下午7:02:31
	 */
	public int insertLoanRepayUrgedRecord(LoanRepayUrgedRecordEntity  loanRepayUrgedRecordEntity
			,InsertAdminLogEntity logentity,String[] sIpInfo);
	/**
	 * 查询逾期账单详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map
	 * @param @return 设定文件 
	 * @return PostProjectEntity 返回类型 
	 * @date 2016-4-16 下午4:22:29
	 */
	public PostProjectEntity getBillingDetails(int repayID);
	
	//***********成交项目列表*********************//
	/**
	 * 成交项目列表:放款后所有项目
	 * getProjectLoanList(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}				#{Project_No}	#{Logname}
	 * #{Personal_Name}		#{Deadline}		#{Real_Amount_Min}
	 * #{Real_Amount_Max}	#{Repay_Way}	#{Repay_MaxTime_Min}
	 * #{Repay_MaxTime_Max}	#{statu}		#{Overdue}
	 * #{ordercolumn}       #{orderDsec(1升序，0降序)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午4:56:07
	 */
	public void getProjectLoanList(PageEntity pageEntity);
	//***********贷后监管*********************//
	/**
	 * 新增贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{applyID项目申请ID,
	 *           adminID,
	 *           abstractMain摘要,
	 *           details详情描述,
	 *           affix附件（附件标题，附件路径；附件标题，附件路径）拼接}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午2:13:08
	 */
	public int insertProjectAfterLoanInfo(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 根据项目ID分页查询其对应的贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity 
	 * map{
	 * startTime;
	 * endTime;
	 * projectID;
	 * }
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午2:51:35
	 */
	public void selectProjectAfterLoanList(PageEntity pageEntity);
	/**
	 * 根据项目ID 查询其贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param applyId
	 * @param @return 设定文件 
	 * @return List<ProjectAfterLoanInfoEntity> 返回类型 
	 * @date 2016-4-21 下午3:16:00
	 */
	public List<ProjectAfterLoanInfoEntity> selectProjectAfterLoanFront(long applyId);
	/**
	 * 根据贷后监管信息ID查询其对应的附件信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param infoId
	 * @param @return 设定文件 
	 * @return List<ProjectAfterLoanAttachmentEntity> 返回类型 
	 * @date 2016-4-21 下午3:17:36
	 */
	public List<ProjectAfterLoanAttachmentEntity> selectProjectAfterLoanAttach(long infoId);
	/**
	 * 根据贷后监管信息ID查询贷后监管详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  infoId
	 * @param @return 设定文件 
	 * @return ProjectAfterLoanInfoEntity 返回类型 
	 * @date 2016-4-21 下午3:23:51
	 */
	public ProjectAfterLoanInfoEntity selectProjectAfterLoandetail(long infoId);
	/**
	 * 删除某条贷后监管信息  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param infoId
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午3:35:33
	 */
	public int deleteProjectAfterLoanInfoByID(long infoId,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	//***********贷后监管结束*********************//
	/**
	 * 即将还款统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * #{skey}                #{Project_No}        #{Project_Title}
	 * #{Personal_Name}       #{Repay_MaxTime_Min} #{Expiration_ReminderSet}
	 * #{Repay_MaxTime_Max}  #{Admin_ID}          #{ordercolumn}
	 * #{orderDsec(1升序，0降序)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午6:30:15
	 */
	public void getMaturingBillThiree(PageEntity pageEntity);
	/**
	 * 逾期还款统计:此处统计未还款部分逾期记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 *  #{skey}                 #{Project_No}      #{Project_Title}
	 *  #{Logname}              #{Personal_Name}    #{Repay_MaxTime_Min}
	 *  #{Repay_MaxTime_Max}    #{orderDsec(1升序，0降序)}
	 *	#{Overdue_Day_Max}      #{Overdue_Day_Min}  #{ordercolumn}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午6:53:19
	 */
	public void getLatePayments(PageEntity pageEntity);
	/**
	 * 催款已还账单查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * #{skey}            #{Project_No}      #{Project_Title}
	 * #{Personal_Name}   #{AdminID}         #{orderDsec(1升序，0降序)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午7:50:12
	 */
	public void getLoanRepay(PageEntity pageEntity);
	/**
	 * 催收已还 查看账单详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * #{skey}   #{Apply_Id}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午8:52:53
	 */
	public void getRepayBillingDetails(PageEntity pageEntity);
	/**
	 * 即将到期账单
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * 	#{skey}				#{Project_No}		 #{Project_Title}
	 *  #{Personal_Name}	#{Repay_MaxTime_Min} #{Expiration_ReminderSet}
	 *	#{Repay_MaxTime_Max}#{Admin_ID}          #{ordercolumn}
	 *  #{orderDsec(1升序，0降序)}                  #{staffType 必填0(会员)2(超级管理员)3(理财顾问)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-21 下午9:18:39
	 */
	public void getMaturingBill(PageEntity pageEntity);
}

