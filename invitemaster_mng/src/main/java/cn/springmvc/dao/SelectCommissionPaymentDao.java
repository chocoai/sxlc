
package cn.springmvc.dao; 

import java.util.List;

import cn.invitemastermng.model.CommissionPaymentRecordsEntity;
import cn.invitemastermng.model.PlatformAccountRecordEntity;

import product_p2p.kit.pageselect.PageEntity;


/** 
 * 佣金统计
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-26 上午11:00:00  */
public interface SelectCommissionPaymentDao {
	
	/** 
	* CommissionPaymentRecords 分页查询佣金发放记录 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CommissionPaymentRecords 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<CommissionPaymentRecordsEntity> 返回类型 
	* @date 2016-4-26 下午2:17:31
	* @throws 
	*/
	public List<CommissionPaymentRecordsEntity> CommissionPaymentRecords(PageEntity pageEntity);
	
	
	/** 
	* CommissionPaymentRecords 分页查询佣金统计 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CommissionPaymentRecords 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<CommissionPaymentRecordsEntity> 返回类型 
	* @date 2016-4-26 下午8:46:19
	* @throws 
	*/
	public List<CommissionPaymentRecordsEntity> CommissionStatisticsCount(PageEntity pageEntity);
	
	
	/** 
	* PlatformAccountRecord 分页查询平台账户交易记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PlatformAccountRecord 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<PlatformAccountRecordEntity> 返回类型 
	* @date 2016-4-28 上午11:08:34
	* @throws 
	*/
	public List<PlatformAccountRecordEntity> PlatformAccountRecord(PageEntity pageEntity);
}

