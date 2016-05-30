package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.membermng.model.BorrowingType;
import cn.membermng.model.BorrowingTypeInfo;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.RealNameAuth;


/***
* 会员的认证信息服务
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-23 上午10:54:28 
*
*/
public interface IBorrowingCertificationServer {

	
	
	/***
	* 根据会员获取会员的认证列表
	* 
	* @author 李杰
	* @param memberType
	* @param memberId
	* @return
	* @date 2016-4-26 下午1:50:25
	 */
	public List<BorrowingType> getAllByMember(int memberType,long memberId);
	
	/***
	* 个人会员实名认证
	* 
	* @author 李杰
	* @Title authRealName
	* @param mid							会员编号
	* @param realName						会员真实姓名
	* @param sex							会员性别
	* @param national						民族编号
	* @param idCard							会员身份证好号
	* @param birthplace						会员籍贯
	* @param positive						会员身份证正面
	* @param reverse						会员身份证反面
	* @return								-2身份證已被使用、-1 已存在认证记录、0提交认证申请成功 
	* @date 2016-3-23 上午11:25:59
	 */
	public int authRealName(Long mid,String realName, Integer sex, Integer national,String idCard, String birthplace, String positive, String reverse,String endTime);

	/***
	* 根据会员编号获取实名认证信息
	* 
	* @author 李杰
	* @Title: showAuthRealName
	* @param memberId							会员编号
	* @return									会员实名认证信息
	* @date 2016-3-24 上午10:09:36
	*/
	public RealNameAuth showAuthRealName(Long memberId);
	
	/***
	* 个人会员实名认证修改
	* 
	* @author 李杰
	* @Title: editAuthRealName
	* @param realName				真实姓名
	* @param sex					性别
	* @param national				民族
	* @param idCard					身份证号
	* @param birthplace				籍贯
	* @param positive				身份证正面
	* @param reverse				身份证反面
	* @return
	* @date 2016-3-24 下午3:30:44
	*/
	public int editAuthRealName(Long mid,String realName, Integer sex, Integer national,String idCard, String birthplace, String positive, String reverse);

	
	
	
	/***
	* 企业|个人会员通用认证
	* 
	* @author 李杰
	* @Title currencyAuth
	* @param mid							会员编号
	* @param memberType						会员类型
	* @param enclosure						附件,多个用逗号隔开
	* @param endTime						有效期|登记日期
	* @param typeId							认证类型编号
	* @return  -2认证项不存在、-1已存在认证信息、0提交认证信息成功
	* @Description: TODO
	* @date 2016-3-23 下午5:26:48
	 */
	public int currencyAuth(Long mid,Integer memberType,String enclosure,String endTime,Integer typeId);
	
	/***
	* 查看企业|个人会员通用认证
	* 
	* @author 李杰
	* @Title: showCurrencyAuth
	* @param memberId   		 		会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午4:30:52
	*/
	public CurrencyAuth showCurrencyAuth(Long memberId,int memberType,int typeId);
	
	/***
	* 修改企业|个人会员通用认证
	* 
	* @author 李杰
	* @Title currencyAuth
	* @param mid							会员编号
	* @param memberType						会员类型
	* @param enclosure						附件,多个用逗号隔开
	* @param endTime						有效期|登记日期
	* @param typeId							认证类型编号
	* @return								
	* @Description: TODO
	* @date 2016-3-23 下午5:26:48
	 */
	public int editCurrencyAuth(Long mid, Integer memberType, String enclosure,String endTime,int typeId);
	
	
	
	
	
	
	/***
	* 个人会员居住地址认证 
	*
	* @author 李杰
	* @Title: authAddress
	* @param mid							会员编号
	* @param address						会员地址信息
	* @param endTime						有效期
	* @param enclosure						附件信息
	* @return		-1已存在认证信息、0提交认证信息成功
	* @Description: TODO
	* @date 2016-3-23 下午5:58:23
	 */
	public int authAddress(Long mid,String address,String endTime,String enclosure);
	
	/***
	* 获取个人住址认证信息
	* 
	* @author 李杰
	* @Title: showAuthAddress
	* @param memberId						会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午5:58:39
	 */
	public CurrencyAuth showAuthAddress(Long memberId);
	
	/***
	* 修改个人地址认证信息
	* 
	* @author 李杰
	* @Title: editAuthAddress
	* @param memberId						会员编号
	* @param address						详细地址信息
	* @param ednTime						有效期|登记时间|有效期
	* @param enclosure						附件信息、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午6:59:12
	*/
	public int editAuthAddress(long memberId, String address, String ednTime,String enclosure);
	
	
	
	
	
	/***
	* 个人会员房产认证
	* 
	* @author 李杰
	* @Title: authHousing
	* @param mid							会员编号
	* @param iaddress						房产位置
	* @param iArea							面积	
	* @param ivalue							价值
	* @param endTime						登记日期
	* @param enclosure						附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-23 下午6:21:29
	 */
	public int authHousing(Long mid,int memberType,String iaddress,String iArea,String ivalue,String endTime,String enclosure);
	
	/***
	* 查看个人会员房产认证信息
	* 
	* @author 李杰
	* @Title: showAuthHousing
	* @param memberId						会员编号
	* @return
	* @date 2016-3-25 上午9:13:39
	 */
	public  List<CurrencyAuth>  showAuthHousing(long memberId);
	
	/**
	 * 查看个人会员房产认证信息 通过rid
	 * TODO
	 * 创建日期：2016-5-5上午10:17:04
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	public  CurrencyAuth  showAuthHousingOne(long rid);
	
	/***
	* 修改个人房产认证信息
	* 
	* @author 李杰
	* @Title: editAuthHousing
	* @param memberId				会员编号
	* @param cid					认证记录编号
	* @param 
	* @param string2
	* @param string3
	* @param string4
	* @param string5
	* @return
	* @Description: TODO
	* @date 2016-3-24 上午9:35:29
	*/
	public int editAuthHousing(long memberId,int memberType, long cid, String iaddress,String iArea, String ivalue, String endTime, String enclosure);


	
	
	
	/***
	* 个人会员车产认证 
	*
	* @author 李杰
	* @Title: authProduction
	* @param mid									会员编号
	* @param iBrand									车辆品牌
	* @param iModel									车辆型号
	* @param iLicensePlate							车牌号
	* @param ivalue									价值
	* @param endTime								首次登记日期
	* @param enclosure								附件
	* @return										-1 当前车牌已被认证、-2当前车牌在审核中、0申请成功
	* @Description: TODO
	* @date 2016-3-23 下午6:30:54
	 */
	public int authProduction(Long mid,int memberType,String iBrand,String iModel,String iLicensePlate,String ivalue,String endTime,String enclosure);
	
	/***
	* 查看个人会员车产认证
	* 
	* @author 李杰
	* @Title: showAuthProduction
	* @param memberid							 	会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-24 上午10:36:16
	*/
	public List<CurrencyAuth> showAuthProduction(long memberId);
	
	
	/**
	 * 查看个人会员车产认证通过认证id
	 * TODO
	 * 创建日期：2016-5-5上午10:06:22
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<CurrencyAuth>
	 */
	public CurrencyAuth showAuthProductionOne(long rid);

	/***
	* 修改个人会员车产认证
	* 
	* @author 李杰
	* @Title: editAuthProduction
	* @param memberId								会员编号
	* @param cid									认证记录编号
	* @param iBrand									车辆品牌
	* @param iModel									车辆型号
	* @param iLicensePlate							车牌号
	* @param ivalue									价值
	* @param endTime								登记时间
	* @param enclosure								附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 上午11:21:07
	*/
	public int editAuthProduction(long memberId, int memberType, long cid, String iBrand,String iModel, String iLicensePlate, String ivalue, String endTime,String enclosure);
	
	
	
	
	
	
	/***
	* 个人会员婚姻认证
	* 
	* @author 李杰
	* @Title: authMarriage
	* @param mid								会员编号
	* @param integer							婚姻状态
	* @param endTime							登记日期
	* @param enclosure							附件 多个用逗号隔开
	* @return									-1存在认证记录不能再次申请、0提交认证申请成功
	* @Description: TODO
	* @date 2016-3-23 下午6:36:15
	 */
	public int authMarriage(Long mid,Integer integer,String endTime,String enclosure);

	/***
	* 查看个人会员婚姻认证信息
	* 
	* @author 李杰
	* @Title: showAuthMarriage
	* @param memberId							会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午1:51:08
	*/
	public CurrencyAuth showAuthMarriage(Long memberId);
	
	/***
	* 修改个人会员婚姻认证信息
	* 
	* @author 李杰
	* @Title: editAuthMarriage
	* @param memberId									会员编号
	* @param integer									婚姻状态
	* @param endTime									登记日期
	* @param enclosure									附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午2:27:05
	 */
	public int editAuthMarriage(long memberId, int integer, String endTime, String enclosure);

	
	
	
	
	
	/***
	* 添加个人会员学历人认证
	* 
	* @author 李杰
	* @Title: authEducation
	* @param memberId									会员编号
	* @param education									学历序号
	* @param enclosure									附件，多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午2:47:30
	 */
	public int authEducation(long memberId, int education, String enclosure ,String endTime);

	/***
	* 查看个人会员学历认证信息
	* 
	* @author 李杰
	* @Title: showAuthEducation
	* @param memberId									会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午2:49:35
	 */
	public CurrencyAuth showAuthEducation(long memberId);

	/**
	* 修改个人会员学历认证
	* 
	* @author 李杰
	* @Title: editAuthEducation
	* @param memberId									会员编号
	* @param education									学历
	* @param enclosure									附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午3:27:52
	 */
	public int editAuthEducation(long memberId, int education, String enclosure,String endTime);

	

/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/
	
	
	/***
	* 企业会员营业执照认证
	* 
	* @author 李杰
	* @Title: businessLicense
	* @param businessLicenseNumber									营业执照号码
	* @param companyName										公司名称
	* @param regAddress												注册地址
	* @param regPerson												注册法人
	* @param regCapital												注册资金
	* @param businessScope											经营范围
	* @param CompanyType											公司类型
	* @param regDate												注册时间
	* @param endTime												有效期
	* @param enclosure												附件、多个用逗号隔开
	* @return
	* @date 2016-3-24 下午4:10:30
	 */
	public int  businessLicense(long memberId,String businessLicenseNumber,String companyName,String regAddress,String regPerson,String regCapital,String businessScope,String CompanyType,String regDate,String endTime,String enclosure);
	
	/***
	* 查看企业会员营业执照认证
	*
	* @author 李杰
	* @Title: showBusinessLicense
	* @param MemberId
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午4:15:12
	 */
	public Map<String,Object> showBusinessLicense(long MemberId);
	
	/***
	* 修改企业会员营业执照认证
	* 
	* @author 李杰
	* @Title: businessLicense
	* @param memberId												会员编号
	* @param businessLicenseNumber									营业执照号码
	* @param regAddress												注册地址
	* @param regPerson												注册法人
	* @param regCapital												注册资金
	* @param businessScope											经营范围
	* @param CompanyType											公司类型
	* @param regDate												注册时间
	* @param endTime												有效期
	* @param enclosure												附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午4:10:30
	 */
	public int editBusinessLicense(long memberId,String businessLicenseNumber,String companyName,String regAddress,String regPerson,String regCapital,String businessScope,String CompanyType,String regDate,String endTime,String enclosure);

	
	
	
	/***
	* 工商执照认证
	* 
	* @author 李杰
	* @Title: commercialLicense
	* @param memberId								会员编号
	* @param address								住所
	* @param regPserson								注册法人
	* @param regCapital								注册资金
	* @param companyType							公司类型
	* @param paidCapital							实收资金
	* @param businessScope							经营范围
	* @param regDate								注册时间
	* @param endTime								有效期
	* @param enclosure								附加、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-28 上午11:54:04
	 */
	public int commercialLicense(long memberId, String address, String regPserson,String regCapital, String companyType, String paidCapital, String businessScope,String regDate, String endTime, String enclosure);
	
	/***
	* 查看企业会员工商认证信息
	* 
	* @author 李杰
	* @Title: showCommercialLicense
	* @param memberId								会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午2:23:33
	 */
	public Map<String,Object> showCommercialLicense(long memberId);
	
	/***
	* 修改工商执照认证
	* 
	* @author 李杰
	* @Title: editCommercialLicense
	* @param memberId								会员编号
	* @param address								住所
	* @param regPserson								注册法人
	* @param regCapital								注册资金
	* @param companyType							公司类型
	* @param paidCapital							实收资金
	* @param businessScope							经营范围
	* @param regDate								注册时间
	* @param endTime								有效期
	* @param enclosure								附加、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午2:24:25
	 */
	public int editCommercialLicense(long memberId, String address, String regPserson,String regCapital, String companyType, String paidCapital, String businessScope,String regDate, String endTime, String enclosure);

	
	
	
	/***
	* 组织机构认证
	* 
	* @author 李杰
	* @Title: organizational
	* @param memberId										会员编号
	* @param organizationalCode								组织机构代码
	* @param startTime										有效期开始时间
	* @param endTime										有效期结束时间
	* @param enclosure										附件、多个用逗号隔开
	* @return
	* @date 2016-3-28 下午3:12:55
	*/
	public int organizational(long memberId, String organizationalCode, String startTime,String endTime, String enclosure);

	/***
	* 查看组织机构代码认证信息
	* 
	* @author 李杰
	* @Title: showOrganizational
	* @param memberId										会员编号
	* @return
	* @date 2016-3-28 下午3:16:58
	 */
	public Map<String, Object> showOrganizational(long memberId);
	
	/***
	* 修改组织机构代码认证信息
	* 
	* @author 李杰
	* @Title: editOrganizational
	* @param memberId										会员编号
	* @param organizationalCode								组织机构代码
	* @param startTime										有效期开始时间
	* @param endTime										有效期结束时间
	* @param enclosure										附件、多个用逗号隔开
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午3:18:51
	 */
	public int editOrganizational(long memberId, String organizationalCode, String startTime,String endTime, String enclosure);

	
	
	
	
	/***
	* 开户许可认证
	* 
	* @author 李杰
	* @Title: accountOpening
	* @param memberId										会员编号
	* @param accountOpeningCode								开户银行许可证编号
	* @param opBank											开户银行
	* @param bankAccount									银行账户
	* @param enclosure										附件
	* @param endTime										有效期
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午4:54:05
	 */
	public int accountOpening(long memberId,String accountOpeningCode,String opBank,String bankAccount,String enclosure,String endTime);

	
	/***
	* 查看开户许可认证
	* 
	* @author 李杰
	* @Title: showAccountOpening
	* @param memberId										会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午4:57:02
	 */
	public Map<String, Object> showAccountOpening(long memberId);

	
	/**
	* 修改开户许可认证
	* 
	* @author 李杰
	* @Title: editAccountOpening
	* @param memberId										会员编号
	* @param accountOpeningCode								开户银行许可证编号
	* @param opBank											开户银行
	* @param bankAccount									银行账户
	* @param enclosure										附件
	* @param endTime										有效期
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午4:58:46
	 */
	public int editAccountOpening(long memberId,String accountOpeningCode,String opBank,String bankAccount,String enclosure,String endTime);

	
	
	
	
	
	/***
	* 添加税务登记认证 
	* 
	* @author 李杰
	* @Title: taxRegistration
	* @param memberId									会员编号
	* @param credentialsNO								证件编号
	* @param issueOrgan									证件颁发机构
	* @param enclosure									附件、多个用逗号隔开
	* @param endTime									有效期
	* @return
	* @date 2016-3-28 下午7:17:57
	 */
	public int taxRegistration(long memberId, String credentialsNO, String issueOrgan,String enclosure, String endTime);
	
	/***
	* 查看税务登记认证
	* 
	* @author 李杰
	* @Title: showTaxRegistration
	* @param memberId 									会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午7:20:13
	 */
	public Map<String, Object> showTaxRegistration(long memberId);
	
	/***
	* 修改税务登记认证 
	* 
	* @author 李杰
	* @Title: editTaxRegistration
	* @param memberId									会员编号
	* @param credentialsNO								证件编号
	* @param issueOrgan									证件颁发机构
	* @param enclosure									附件、多个用逗号隔开
	* @param endTime									有效期
	* @return
	* @date 2016-3-28 下午7:18:50
	 */
	public int editTaxRegistration(long memberId, String credentialsNO, String issueOrgan,String enclosure, String endTime);

	
	
	
	
	/***
	* 批文认证
	* 
	* @author 李杰
	* @Title: authApproval
	* @param memberId									会员编号
	* @param fileSummary								文件概要
	* @param issueOrgan									颁发机构
	* @param issueDate									发布时间
	* @param enclosure									附件、多个用逗号隔开
	* @param endTime									有效期
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午7:55:27
	 */
	public int authApproval(long memberId,String fileSummary,String issueOrgan,String issueDate,String enclosure,String endTime);

	
	/***
	* 查看批文认证
	* 
	* @author 李杰
	* @Title: showAuthApproval
	* @param memberId									会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午7:57:21
	 */
	public Map<String, Object> showAuthApproval(long memberId);

	/***
	* 修改批文认证
	* 
	* @author 李杰
	* @Title: editAuthApproval
	* @param memberId									会员编号
	* @param fileSummary								文件概要
	* @param issueOrgan									颁发机构
	* @param issueDate									发布时间
	* @param enclosure									附件、多个用逗号隔开
	* @param endTime									有效期
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午7:55:27
	 */
	public int editAuthApproval(long memberId,String fileSummary,String issueOrgan,String issueDate,String enclosure,String endTime);

	
	
/***
* =========================================================================================================================================
* 
* 额外方法，根据借款类型获取当前会员的认证信息
* 
* 
* ========================================================================================================================================
***/
	
	/***
	* 根据会员和借款类型获取会员的认证列表
	* 
	* @author 李杰
	* @param projectId				项目编号
	* @return
	* @date 2016-4-26 下午1:50:25
	 */
	public List<BorrowingTypeInfo> getAllByMemberAndLoanType(long projectId);
	
	
	
	
	
	
	
	
	
}

