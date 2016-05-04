

/** 
* @Title: PostLoanManageListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午5:51:23 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.PostProjectEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAfterLoanInfoEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ReplayStatisticsEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 贷后管理
 * @since 
 * @date 2016-4-15 下午5:51:23  */

public interface PostLoanManageListDao {
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
	 * @return List<ProjectCollectionEntity> 返回类型 
	 * @date 2016-4-15 下午5:53:40
	 */
	public List<PostProjectEntity> getOverdueCollection(PageEntity pageEntity);
	/**
	 * 查询账单详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return PostProjectEntity 返回类型 
	 * @date 2016-4-16 下午4:22:29
	 */
	public PostProjectEntity getBillingDetails(Map<String,Object> map);
	//***********成交项目列表*********************//
	
	/**
	 * 成交项目列表:放款后所有项目
	 * getProjectLoanList(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-21 下午4:56:07
	 */
	public List<ProjectAppRecordEntity> getProjectLoanList(PageEntity pageEntity); 
	//***********贷后监管*********************//
	/**
	 * 根据项目ID分页查询其对应的贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * @param @return 设定文件 
	 * @return List<ProjectAfterLoanInfoEntity> 返回类型 
	 * @date 2016-4-21 下午2:51:35
	 */
	public List<ProjectAfterLoanInfoEntity> selectProjectAfterLoanList(PageEntity pageEntity);
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
	//***********贷后监管结束*********************//
	/**
	 * 即将还款统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<WillRepayEntity> 返回类型 
	 * @date 2016-4-21 下午6:30:15
	 */
	public List<ReplayStatisticsEntity> getMaturingBillThiree(PageEntity pageEntity);
	/**
	 * 逾期还款统计:此处统计未还款部分逾期记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<ReplayStatisticsEntity> 返回类型 
	 * @date 2016-4-21 下午6:53:19
	 */
	public List<ReplayStatisticsEntity> getLatePayments(PageEntity pageEntity);
	/**
	 * 催款已还账单查询  --不用了
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<PostProjectEntity> 返回类型 
	 * @date 2016-4-21 下午7:50:12
	 */
	public List<PostProjectEntity> getLoanRepay(PageEntity pageEntity);
	/**
	 * 催收已还 查看账单详情 -- 不用了
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<PostProjectEntity> 返回类型 
	 * @date 2016-4-21 下午8:52:53
	 */
	public List<PostProjectEntity> getRepayBillingDetails(PageEntity pageEntity);
	/**
	 * 即将到期账单
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<PostProjectEntity> 返回类型 
	 * @date 2016-4-21 下午9:18:39
	 */
	public List<PostProjectEntity> getMaturingBill(PageEntity pageEntity);
	/**
	 * 查询催收已还
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 *  #{skey}				#{Project_No}		 #{Project_Title}
	 *  #{Personal_Name}    #{AdminID}          #{Merbill_No}
	 *  #{orderDsec(1升序，0降序)}      #{ordercolumn}
	 * @param @return 设定文件 
	 * @return List<ProjectCollectionEntity> 返回类型 
	 * @date 2016-4-15 下午5:53:40
	 */
	public List<PostProjectEntity> getRepaySettled(PageEntity pageEntity);
	/**
	 * 查询即将到期天数
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return Integer 返回类型 
	 * @date 2016-5-1 下午6:13:18
	 */
	public Integer getExpirationReminderSet();
}

