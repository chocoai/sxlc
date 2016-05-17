
package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.AdminGMEntity;
import cn.springmvc.model.CompensationStatisticsEntity;
import cn.springmvc.model.GuaranteeAdminEntity;
import cn.springmvc.model.GuaranteeBankCard;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.InstitutionsRecordsEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.model.MemberThirdAuthInfoEntity;
import cn.springmvc.model.OverdueCompensationEntity;



/** 
 * 保荐机构信息查询
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午11:07:40  */
public interface SelectGuaranteeInfoDao {
	
	/** 
	* selectGuaranteeInfoById  根据担保机构id 查询担保机构信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectGuaranteeInfoById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return GuaranteeInfoEntity 返回类型 
	* @date 2016-3-21 上午11:11:54
	* @throws 
	*/
	public GuaranteeInfoEntity selectGuaranteeInfoById(Map<String, Object> map);
	
	
	/** 
	* selectAllGuaranteeInfo 分页查询所有担保机构信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllGuaranteeInfo 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<GuaranteeInfoEntity> 返回类型 
	* @date 2016-3-21 上午11:13:20
	* @throws 
	*/
	public List<GuaranteeInfoEntity> selectAllGuaranteeInfo(PageEntity pageEntity);
	
	
	/** 
	* selectGuaranteeCertificate 根据担保机构id查询证件信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectGuaranteeCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<GuaranteeCertificateEntity> 返回类型 
	* @date 2016-3-21 上午11:18:08
	* @throws 
	*/
	public List<GuaranteeCertificateEntity> selectGuaranteeCertificate(Map<String, Object> map);
	
	
	/** 
	* selectManagementInfoById 根据资产管理方id 查询资产管理方信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectManagementInfoById 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return ManagementInfoEntity 返回类型 
	* @date 2016-3-21 上午11:20:03
	* @throws 
	*/
	public ManagementInfoEntity selectManagementInfoById(Map<String, Object> map);
	
	
	/** 
	* selectAllManagementInfo 分页查询所有资产管理方信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllManagementInfo 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<ManagementInfoEntity> 返回类型 
	* @date 2016-3-21 上午11:23:06
	* @throws 
	*/
	public List<ManagementInfoEntity> selectAllManagementInfo(PageEntity pageEntity);
	
	
	/** 
	* selectManagementCertificate 根据资产管理方id查询证件信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectManagementCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<ManagementCertificateEntity> 返回类型 
	* @date 2016-3-21 上午11:27:22
	* @throws 
	*/
	public List<ManagementCertificateEntity> selectManagementCertificate(Map<String, Object> map);
	
	
	/** 
	* selectGuaranteeBorrowing(根据保荐机构id查询担保机构担保借款范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectGuaranteeBorrowing 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<GuaranteeBorrowingEntity> 返回类型 
	* @date 2016-3-21 下午5:10:55
	* @throws 
	*/
	public List<GuaranteeBorrowingEntity> selectGuaranteeBorrowing(Map<String, Object> map);
	
	
	/** 
	* selectGuaranteePeriod(根据保荐机构id,期限类型查询担保机构期限范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectGuaranteePeriod 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<GuaranteePeriodEntity> 返回类型 
	* @date 2016-3-21 下午5:12:51
	* @throws 
	*/
	public List<GuaranteePeriodEntity> selectGuaranteePeriod(Map<String, Object> map);
	
	/** 
	* selectGuaranteeRelational(根据保荐机构id,查询担保项目类型) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectGuaranteeRelational 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<GuaranteeRelationalEntity> 返回类型 
	* @date 2016-3-21 下午5:14:36
	* @throws 
	*/
	public List<GuaranteeRelationalEntity> selectGuaranteeRelational(Map<String, Object> map);
	
	
	/** 
	* findGuaranteeAdmin(根据保荐机构id,查询担保机构管理员信息) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findGuaranteeAdmin 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<GuaranteeAdminEntity> 返回类型 
	* @date 2016-4-20 上午10:39:11
	* @throws 
	*/
	public List<GuaranteeAdminEntity> findGuaranteeAdmin(PageEntity pageEntity);
	
	
	/** 
	* InstitutionsToRaiseCashRecords 分页查询担保机构 充值或提现记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: InstitutionsToRaiseCashRecords 
	* @Description: TODO 
	* @param @param pageEntity map:{dealType:交易类型 0：充值 1：提现;
	* startdealTime:交易时间 开始；enddealTime：交易时间结束；merBillno：平台订单号；thirdMerBillno：第三方流水号
	* statu：状态： 0：失败 1：成功； 排序 ：amountStatu 1：降序 2 升序}
	* @param @return 设定文件 
	* @return List<InstitutionsRecordsEntity> 返回类型 
	* @date 2016-4-25 下午4:57:19
	* @throws 
	*/
	public List<InstitutionsRecordsEntity> InstitutionsToRaiseCashRecords(PageEntity pageEntity);
	
	
	/** 
	* CompensationStatistics 查询担保机构代偿统计信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CompensationStatistics 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return CompensationStatisticsEntity 返回类型 
	* @date 2016-4-29 下午2:20:56
	* @throws 
	*/
	public CompensationStatisticsEntity CompensationStatistics(Map<String, Object> map);
	 /**
     * 根据会员id,与会员type查询会员第三方账户信息
     * @author    
     * @Description: TODO 
     * @param map查询参数
     * @return MemberThirdAuthInfoEntity 会员第三方授权实体
     * @date 2016-3-25 上午11:59:16
     */
    public MemberThirdAuthInfoEntity selectMemberThirdAuthInfoone(Map<String,Object> map);
    
   
	
	/** 
	* findManagementAdmin  根据资产管理方id查询管理员信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findManagementAdmin 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<GuaranteeAdminEntity> 返回类型 
	* @date 2016-5-4 下午5:27:39
	* @throws 
	*/
	public List<GuaranteeAdminEntity> findManagementAdmin(PageEntity pageEntity);
	
	
	/** 
	* Overduecompensation 查询逾期代偿列表
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: Overduecompensation 
	* @Description: TODO 
	* @param @param pageEntity 
	* @param @return 设定文件 
	* @return List<OverdueCompensationEntity> 返回类型 
	* @date 2016-5-6 下午5:30:13
	* @throws 
	*/
	public List<OverdueCompensationEntity> Overduecompensation(PageEntity pageEntity);
	
	/** 
	* PtOverduecompensation 查询平台代偿记录列表 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PtOverduecompensation 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<OverdueCompensationEntity> 返回类型 
	* @date 2016-5-6 下午5:55:24
	* @throws 
	*/
	public List<OverdueCompensationEntity> PtOverduecompensation(PageEntity pageEntity);
	
	
	/** 
	* PaymentOverduecompensation 查询平台代偿回款记录列表
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PaymentOverduecompensation 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<OverdueCompensationEntity> 返回类型 
	* @date 2016-5-6 下午7:14:14
	* @throws 
	*/
	public List<OverdueCompensationEntity> PaymentOverduecompensation(PageEntity pageEntity);
	
	
	/** 
	* findbankcardforguaranteeID 查询银行卡信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findbankcardforguaranteeID 
	* @Description: TODO 
	* @param @param pageEntity guaranteeID  担保机构ID
	* @param @return 设定文件 
	* @return List<GuaranteeBankCard> 返回类型 
	* @date 2016-5-6 下午7:36:56
	* @throws 
	*/
	public List<GuaranteeBankCard> findbankcardforguaranteeID(PageEntity pageEntity);
	
	
	
	/** 
	* selectAdmin 查询单个管理员
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAdmin 
	* @Description: TODO 
	* @param @param adminID
	* @param @return 设定文件 
	* @return AdminGMEntity 返回类型 
	* @date 2016-5-17 下午5:18:15
	* @throws 
	*/
	public AdminGMEntity selectAdmin(long adminID); 
}

