

/** 
* @Title: GuaranteeAgenciesListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午5:21:27 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.GuranteeRecordEntity;
import cn.springmvc.model.MemberTradingRecordsEntity;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-13 下午5:21:27  */

public interface GuaranteeAgenciesListDao {
	/**
	 * 查询担保项目信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * 	#{skey}            #{Project_No}            #{Project_Title}
	 *  #{Guarantee_Name}  #{Record_Date_Min}       #{Record_Date_Max}
	 *	#{IsCompensatory}  #{Compensatory_Time_Min} #{Compensatory_Time_Max}
	 *  #{ordercolumn}     #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<GuranteeRecordEntity> 返回类型 
	 * @date 2016-4-13 下午5:49:18
	 */
	public List<GuranteeRecordEntity>  getGuaranteeproject(PageEntity pageEntity);
	/**
	 * 查询代偿记录信息/历史代偿记录信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * 	#{skey}                  #{Project_No}            #{Project_Title}
	 *  #{Personal_Name}         #{Logname}               #{Personal_Phone}
	 *  #{Guarantee_Name}        #{Repay_MaxTime_Min}     #{Repay_MaxTime_Max}
	 *	#{Compensatory_Time_Min} #{Compensatory_Time_Max} #{Statu}
	 *  #{ordercolumn}           #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return List<GuranteeRecordEntity> 返回类型 
	 * @date 2016-4-13 下午5:51:16
	 */
	public List<GuranteeRecordEntity>  getCompensatoryrecord(PageEntity pageEntity);
	/**
	 * 查询代偿回款记录信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}           #{Project_No}     #{Project_Title}
	 * #{Personal_Name}  #{Logname}        #{Guarantee_Name}
	 * #{Repay_Time_Min} #{Repay_Time_Max}#{ordercolumn}
	 * @param @return 设定文件 
	 * @return List<GuranteeRecordEntity> 返回类型 
	 * @date 2016-4-13 下午5:53:46
	 */
	public List<GuranteeRecordEntity>  getReceivablerecords(PageEntity pageEntity);
	/**
	 * 查询交易记录信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}				#{Type_Name} #{Record_Date_Min}
	 * #{Record_Date_Max}   #{ordercolumn}
	 * @param @return 设定文件 
	 * @return List<MemberTradingRecordsEntity> 返回类型 
	 * @date 2016-4-13 下午6:06:37
	 */
	public List<MemberTradingRecordsEntity> getTransaction(PageEntity pageEntity);
}

