
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.GuaranteeAdminEntity;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.InstitutionsRecordsEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;




/** 
 * 保荐机构相关实现方法
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 下午1:46:36  */
public interface GuaranteeInfoService {
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
	public GuaranteeInfoDetailsEntity selectGuaranteeInfoById(Map<String, Object> map);
	
	
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
	* handleGuaranteeInfo 添加或修改担保机构信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleGuaranteeInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-21 上午11:33:39
	* @throws 
	*/
	public int handleGuaranteeInfo(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* deleteOrStopGuaranteeInfo 删除或启用停用 担保机构
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteOrStopGuaranteeInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:34:20
	* @throws 
	*/
	public int deleteOrStopGuaranteeInfo(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertGuaranteeCertificate 添加担保机构证件 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeCertificate 
	* @Description: TODO 
	* @param @param list
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:35:48
	* @throws 
	*/
	public int insertGuaranteeCertificate(List<ManagementCertificateEntity> list,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* deleteGuaranteeCertificate 根据担保机构id删除所有证件信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteGuaranteeCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:36:38
	* @throws 
	*/
	public int deleteGuaranteeCertificate(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* deleteOrStopManagementInfo 根据资产管理方id 删除或启用停用资产管理方
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteOrStopManagementInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:38:24
	* @throws 
	*/
	public int deleteOrStopManagementInfo(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* handleManagementInfo 添加或修改资产管理方信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleManagementInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-21 上午11:39:17
	* @throws 
	*/
	public Map<String, Object> handleManagementInfo(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertManagementCertificate 添加资产管理方证件 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertManagementCertificate 
	* @Description: TODO 
	* @param @param entities
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:42:01
	* @throws 
	*/
	public int insertManagementCertificate(List<ManagementCertificateEntity> entities,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* deleteManagementCertificate 根据资产管理方id删除所有证件信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteManagementCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:43:21
	* @throws 
	*/
	public int deleteManagementCertificate(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
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
	* insertGuaranteeBorrowing(添加担保机构担保借款范围 ) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeBorrowing 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:11:37
	* @throws 
	*/
	public int insertGuaranteeBorrowing(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* updateGuaranteeBorrowingByID(根据保荐机构id修改担保机构担保借款范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateGuaranteeBorrowingByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:12:10
	* @throws 
	*/
	public int updateGuaranteeBorrowingByID(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* insertGuaranteePeriod(添加担保机构期限范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteePeriod 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:13:26
	* @throws 
	*/
	public int insertGuaranteePeriod(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* updateGuaranteePeriodByID(根据保荐机构id,期限类型修改担保机构担保借款范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateGuaranteePeriodByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:14:00
	* @throws 
	*/
	public int  updateGuaranteePeriodByID(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertGuaranteeRelational(添加担保机构担保类型) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeRelational 
	* @Description: TODO 
	* @param @param list
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:15:46
	* @throws 
	*/
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* deleteGuaranteeRelationalByID 根据担保机构id删除担保机构担保类型 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteGuaranteeRelationalByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:18:29
	* @throws 
	*/
	public int deleteGuaranteeRelationalByID(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* updateGuaranteeAdmin 启用 停用 担保机构管理员
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateGuaranteeAdmin 
	* @Description: TODO 
	* @param @param map statu:1:启用 0：停用  guaranteeID:担保机构id  adminId:管理员id
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 上午10:44:51
	* @throws 
	*/
	public int updateGuaranteeAdmin(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertGuaranteeAdmin 添加担保机构管理员 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeAdmin 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 上午10:46:30
	* @throws 
	*/
	public int insertGuaranteeAdmin(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
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

}


