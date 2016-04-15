

/** 
* @Title: BorrowingManagementListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午1:36:22 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 借款管理
 * @since 
 * @date 2016-4-13 下午1:36:22  */

public interface BorrowingManagementListDao {
	/**
	 * 查询申请失败列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}           #{Project_No}      #{Logname}
	 * #{Record_Date_Min}#{Record_Date_Max} #{Personal_Name}
	 * #{Check_Date_Min} #{Check_Date_Max}  #{ordercolumn}
	 * #{Amount_Min}     #{Amount_Max}      #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午1:49:25
	 */
	public List<ProjectAppRecordEntity> getApplyFailure(PageEntity pageEntity);
	/**
	 * 查询审核中（申请状态为未审核）项目列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}         #{Project_No}     #{Logname}
	 * #{Personal_Name}#{Record_Date_Min}#{Record_Date_Max}
	 * #{Amount_Min}   #{Amount_Max}     #{ordercolumn}     #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:17:41
	 */
	public List<ProjectAppRecordEntity> getInReview(PageEntity pageEntity);
	/**
	 * 查询未发布（最后一步未审核，倒数第二步已通过）项目列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}         #{Project_No}     #{Logname}
	 * #{Personal_Name}#{Record_Date_Min}#{Record_Date_Max}
	 * #{Amount_Min}   #{Amount_Max}     #{ordercolumn}      #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:19:09
	 */
	public List<ProjectAppRecordEntity> getNotRelease(PageEntity pageEntity);
	/**
	 * 查询投资中项目列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}          #{Project_No}     #{Logname}
	 * #{Personal_Name} #{Record_Date_Min}#{Record_Date_Max}
	 * #{Deadline}      #{Deadline_Type}  #{ordercolumn}
	 * #{Amount_Min}    #{Amount_Max}     #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:21:12
	 */
	public List<ProjectAppRecordEntity> getInvestment(PageEntity pageEntity);
	/**
	 * 查询待放款项目列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}          #{Project_No}      #{Logname}
	 * #{Personal_Name} #{Record_Date_Min} #{Record_Date_Max}
	 * #{Deadline}      #{Deadline_Type}   #{Amount_Min}
	 * #{Amount_Max}    #{ordercolumn}     #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:24:16
	 */
	public List<ProjectAppRecordEntity> getForLending(PageEntity pageEntity);
	/**
	 * 查询已流标项目列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}          #{Project_No}        #{Logname}
	 * #{Personal_Name} #{Record_Date_Min}   #{Record_Date_Max}   #{Deadline}
	 * #{Deadline_Type} #{Real_End_Date_Min} #{Real_End_Date_Max}
	 * #{Amount_Min}    #{Amount_Max}        #{ordercolumn}       #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:26:00
	 */
	public List<ProjectAppRecordEntity> getInvestFailure(PageEntity pageEntity);
	/**
	 * 查询还款中项目列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}           #{Project_No}              #{Logname}
	 * #{Personal_Name}  #{Release_Date_Min}        #{Release_Date_Max}
	 * #{Deadline}       #{Deadline_Type}           #{Amount_Min}
	 * #{Amount_Max}     #{Invest_Amount_Valid_Min} #{Invest_Amount_Valid_MAX}
	 * #{Repay_Time_Min} #{Repay_Time_Max}          #{ordercolumn} 
	 * #{orderDsec(0降序，1升序)}       
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:30:21
	 */
	public List<ProjectAppRecordEntity> getInPayment(PageEntity pageEntity);
	/**
	 * 查询已结清项目列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}          #{Project_No}       #{Logname}
	 * #{Personal_Name} #{Release_Date_Min} #{Release_Date_Max}
	 * #{Deadline_Type} #{Amount_Min}       #{Amount_Max}
	 * #{Deadline}     #{ordercolumn}       #{ordercolumn} 
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:38:28
	 */
	public List<ProjectAppRecordEntity> getSettlementOff(PageEntity pageEntity);
	/**
	 * 借款项目查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * @param @return 设定文件 
	 * #{skey}				#{Project_No}      #{Project_Title}
	 * #{Record_Date_Min}   #{Record_Date_Max} #{Release_Date_Min}
	 * #{Release_Date_Max}  #{Hold_Date_Min}   #{Hold_Date_Max}
	 * #{Settle_Date_Min}   #{Settle_Date_Max} #{Guarantee_Name}
	 * #{Statu}             #{Type}            #{ordercolumn}
	 * #{orderDsec(0降序，1升序)} 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:42:53
	 */
	public List<ProjectAppRecordEntity> getBorrowing(PageEntity pageEntity);
	/**
	 * 投资项目查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}             #{Project_No}      #{Project_Title}
	 * #{Invest_Date_Min}  #{Invest_Date_Max} #{Hold_Date_Min}
	 * #{Hold_Date_Max}    #{ordercolumn}     #{orderDsec(0降序，1升序)}
     * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-13 下午2:50:18
	 */
	public List<InvestEntity> getInvestmentProject(PageEntity pageEntity);
	/**
	 * 查看投资记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}          #{Logname}       #{Personal_Name}
	 * #{Hold_Date_Min} #{Hold_Date_Max} #{ordercolumn}
	 * #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-13 下午3:12:17
	 */
	public List<InvestEntity> getInvestmentRecord(PageEntity pageEntity); 
}

