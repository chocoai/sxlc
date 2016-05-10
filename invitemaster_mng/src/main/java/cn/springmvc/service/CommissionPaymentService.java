
package cn.springmvc.service; 

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.AwardRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.CommissionPaymentRecordsEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.PlatformAccountRecordEntity;


/** 
 * 佣金发放统计
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-26 下午2:14:19  */
public interface CommissionPaymentService {
	
	/** 
	* CommissionPaymentRecords 分页查询佣金发放记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CommissionPaymentRecords 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<CommissionPaymentRecordsEntity> 返回类型 
	* @date 2016-4-26 下午2:17:56
	* @throws 
	*/
	public List<CommissionPaymentRecordsEntity> CommissionPaymentRecords(PageEntity pageEntity);

	
	/** 
	* CommissionStatisticsCount 分页查询佣金统计
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CommissionStatisticsCount 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<CommissionPaymentRecordsEntity> 返回类型 
	* @date 2016-4-26 下午8:48:43
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
	* @date 2016-4-28 下午1:33:23
	* @throws 
	*/
	public List<PlatformAccountRecordEntity> PlatformAccountRecord(PageEntity pageEntity);
}

