package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.dictionaries.model.CityInfoEntity;
import cn.dictionaries.model.CountyInfoEntity;
import cn.dictionaries.model.NationInfoEntity;
import cn.dictionaries.model.ProvinceInfoEntity;
import cn.membermng.model.CompanyInfo;
import cn.membermng.model.ExchangeRecords;
import cn.membermng.model.Friends;
import cn.membermng.model.IntegralGETRecord;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyPoint;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.PersonalBaseInfo;
import cn.membermng.model.RadPackage;
import cn.membermng.model.SecurityInfo;
import cn.membermng.model.UntreatedMessageEntity;




/***
 * 会员相关业务
 * @author LiJie
 *
 */
public interface IMemberService {

	
	
	/***
	 * 个人会员注册
	 * @param member						会员注册信息
	 * @param baseInfo						会员注册基本信息
	 * @return	-1用户名重复、-2电话号码重复、-3邀请码无效、0注册成功
	 */
	public int individualMember(MemberInfo member,PersonalBaseInfo baseInfo);
	
	/***
	 * 企业会员注册
	 * @param member
	 * @param companyInfo
	 * @return
	 */
	public int corporateMember(MemberInfo member,CompanyInfo companyInfo);


	/***
	 * 会员登录
	 * @param userName						会员登录
	 * @param password						登录密码
	 * @param userType						会员类型
	 * @param ip							登录IP
	 * @param country						国家
	 * @param region						地区
	 * @param province						省份
	 * @param city							市区
	 * @param area							地区
	 * @param ISP							网络运营商
	 * @param sourceUrl 					访问来源
	 * @return	0登录成功  -1登录失败
	 */
	public int login(String userName, String password, int userType,String ip,String[] ipInfo,String sourceUrl,String sSessionId);
	
	/***
	 * 检查电话号码是否存在
	 * @param phone							会员电话号码
	 * @return
	 */
	public int chechPhone(String phone);
	
	/***
	 * 检查用户名的个数
	 * @param userName
	 * @return
	 */
	public int countName(String userName);
	
	
	/***
	 * 检查会员邀请码的个数
	 * @param invitateCode
	 * @return
	 */
	public int countInvitateCode(String invitateCode);

	/***
	* 根据会员编号获取会员信息
	* 
	* @author 李杰
	* @Title: memberPersonalInfo
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午5:03:57
	 */
	public MemberInfo memberPersonalInfo(long memberId);

	/***
	* 修改个人会员
	* 
	* 
	* @author 李杰
	* @Title: editMemberPersonalInfo
	* @param memberId							会员编号
	* @param sexid								性别
	* @param qqNumber							QQ号
	* @param homeTown							户籍地址
	* @param currAddress						现居地址
	* @param provinceId							省
	* @param cityId								市
	* @param countyId							县
	* @return 0成功  -1失败
	* @Description: TODO
	* @date 2016-3-29 下午7:39:49
	 */
	public int editMemberPersonalInfo(long memberId,int sexid,String qqNumber,String homeTown,String currAddress,int provinceId,int cityId,int countyId);
	
	
	
	/***
	* 根据编号获取企业会员信息
	* 
	* @author 李杰
	* @Title: memberComplanyInfo
	* @param memberId						会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午7:28:52
	 */
	public MemberInfo memberComplanyInfo(long memberId);
	
	/***
	* 修改企业会员
	*  
	*  
	* @author 李杰
	* @Title: editMemberComplanyInfo
	* @param provinceId								省
	* @param cityId									市
	* @param countyId								县
	* @param contactsName							联系人姓名
	* @param contactsPhone							联系人电话
	* @param contactQQ								联系人QQ
	* @param contactEmail							联系人邮箱
	* @param companyProfile							公司简介
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午7:42:10
	 */
	public int editMemberComplanyInfo(long memberId,int provinceId,int cityId,int countyId,String contactsName,String contactsPhone,String contactQQ,String contactEmail,String companyProfile);
	
	/***
	* 获取好友邀请列表
	* 
	* @author 李杰
	* @Title: friendInvitation
	* @param entity
	* @return
	* @Description: TODO
	* @date 2015-9-1 上午9:35:21
	 */
	public List<MemberInfo> friendInvitation(PageEntity entity);
	
	
	/***
	* 获取好友列表
	* 
	* @author 李杰
	* @param entity
	* 
	* memberName					根据名称模糊查询
	* 
	* @return
	* @date 2016-5-5 上午10:39:00
	 */
	public List<Friends> friendList(PageEntity entity);
	
	
	/**
	 * 获取待确认好友列表
	* selectConfirmFriendList
	* @author 邱陈东  
	* * @Title: selectConfirmFriendList 
	* @param @param entity
	* @param @return 设定文件 
	* @return List<Friends> 返回类型 
	* @date 2016-5-6 上午11:55:59
	* @throws
	 */
	public List<Friends> selectConfirmFriendList(PageEntity entity);
	
	/***
	* 获取会员积分信息
	* 
	* @author 李杰
	* @Title: points
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2015-9-1 上午9:37:00
	 */
	public MyPoint points(long memberId,int memberType);
	
	
	/***
	* 获取积分记录
	* 
	* @author 李杰
	* @Title: addPoints
	* @param memberId
	* @param memberType
	* @return
	* @Description: TODO
	* @date 2016-3-30 上午10:43:04
	 */
	public List<IntegralGETRecord> addPoints(PageEntity entity);
	
	
	/***
	* 获取会员的红包信息
	* 
	* @author 李杰
	* @Title: myRedpackage
	* @param memberType						会员类型
	* @param memberId						会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午1:43:01
	 */
	public MyRedPackage myRedpackage(int memberType,long memberId);
	
	
	
	/***
	* 获取一个会员的红包列表
	* 
	* @author 李杰
	* @Title: redPackages
	* @param memberType
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午2:05:05
	 */
	public List<RadPackage> redPackages(PageEntity entity);
	
	/***
	* 我的代金券
	* @author 李杰
	* @Title: myVouchers
	* @param memberId
	* @param memberType
	* @return
	* @date 2016-3-30 下午5:39:09
	 */
	public MemberVouchers myVouchers(long memberId, int memberType);

	
	/***
	* 我的代金券列表
	* vouchers(这里用一句话描述这个方法的作用)
	* TODO(描述)
	* @author 李杰
	* @Title: vouchers
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午5:40:18
	 */
	public List<MemberVouchers> vouchers(PageEntity entity);
	
	
	/***
	* 我的代金券使用列表
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-9 下午7:39:16
	 */
	public List<MemberVouchers> useVouchers(PageEntity entity);
	
	
	/***
	* 获取会员总余额
	* 
	* @author 李杰
	* @param memberId
	* @return
	* @date 2016-5-5 下午2:55:57
	 */
	public long getRemainderTotal(long memberId);
	
	/***
	* 获取省份列表
	* 
	* @author 李杰
	* @Title: getProvinceList
	* @return
	* @date 2016-4-25 下午5:43:50
	 */
	public List<ProvinceInfoEntity> getProvinceList();
	
	/***
	* 获取城市列表
	* 
	* @author 李杰
	* @Title: getCityList
	* @param pId				省编号
	* @return
	* @date 2016-4-25 下午5:44:34
	 */
	public List<CityInfoEntity> getCityList(int pId);
	
	/***
	* 获取区县列表
	* 
	* @author 李杰
	* @Title: getCountyList
	* @param cId					城市编号
	* @return
	* @date 2016-4-25 下午5:45:14
	 */
	public List<CountyInfoEntity> getCountyList(int cId);

	


	/***
	* 根据条件查询会员信息
	* 
	* @author 李杰	
	* @param logname				登录名有可能为手机号
	* @param memberPwd				登录密码
	* @param memberType				会员类型
	* @return
	* @date 2016-4-26 上午10:33:53
	 */
	public MemberInfo findMemberInfoByParam(String logname, String memberPwd,int memberType);

	/**
	* 获取民族列表
	* @author 李杰
	* @date 2016-4-26 下午3:33:38
	 */
	public List<NationInfoEntity> GetNationList();

	/***
	* 获取认证信息
	* 
	* @author 李杰
	* @param memberId 				会员编号
	* @param memberType				会员类型
	* @return
	* @date 2016-4-26 下午5:40:42
	 */
	public SecurityInfo securityInfo(long memberId, int memberType);


	/***
	* 查找陌生人
	* 
	* @author 李杰
	* @param entity
	* @param memberName				会员用户名or姓名or手机号
	* @return
	* @date 2016-5-6 下午1:22:57
	*/
	public List<MemberInfo> serachMemberByParam(PageEntity entity);
	
	/***
	* 添加好友
	* 
	* @author 李杰
	* @param myId				我的编号
	* @param fId				对方编号
	* @return
	* -1 对方不存在、-2等待对方确认、-3已经是好友了、-4不能添加自己、1提交申请成功、0提交申请失败
	* @date 2016-5-6 下午1:50:29
	 */
	public int applyAddFriends(long myId,long fId);

	
	/***
	* 获取兑换列表
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-6 下午5:35:00
	 */
	public List<ExchangeRecords> exchangeRecords(PageEntity entity);
	
	
	/**
	 * 同意别人发的好友申请
	* agreeAapplyForFriend
	* @author 邱陈东  
	* * @Title: agreeAapplyForFriend 
	* @param @param myId
	* @param @param fId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午2:17:53
	* @throws
	 */
	public int agreeAapplyForFriend(long myId,long fId);
	
	/**
	 * 忘记密码-查询登录名与手机号是否匹配
	* selectMemberIsExist
	* @author 邱陈东  
	* * @Title: selectMemberIsExist 
	* @param @param loginName
	* @param @param phone
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午6:08:45
	* @throws
	 */
	public int selectMemberIsExist(String loginName,String phone);

	/**
	 * 忘记密码-根据手机号查询用户ID
	* selectMemberIdByPhone
	* @author 邱陈东  
	* * @Title: selectMemberIdByPhone 
	* @param @param phone
	* @param @return 设定文件 
	* @return Long 返回类型 
	* @date 2016-5-6 下午6:29:35
	* @throws
	 */
	public Long selectMemberIdByPhone(String loginName,String phone);

	
	/**
	* 确认收货
	* 
	* @author 李杰
	* @param param
	* memberId					会员编号
	* eId						兑换记录编号
	* @return
	* @date 2016-5-9 上午10:06:37
	 */
	public int confirmReceipt(Map<String, Object> param);
	
	/**
	 * 个人中心读取当前登录人的姓名，称号，信用等级，积分，签到次数，第三方账号
	* loadMemberInfo
	* @author 邱陈东  
	* * @Title: loadMemberInfo 
	* @param @param memberId
	* @return Map<String,Object> 返回类型 
	* @date 2016-5-18 下午1:39:23
	* @throws
	 */
	public MemberInfo loadMemberInfo(long memberId,int memberType);
	
	/**
	 * 签到
	* sign
	* @author 邱陈东  
	* * @Title: sign 
	* @param @param memberId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-18 下午3:38:43
	* @throws
	 */
	public int sign(long memberId);
	
	/**
	 * 
	* loadUntreatedMessage
	* @author 邱陈东  
	* * @Title: loadUntreatedMessage 
	* @param @param memberId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-19 上午9:42:34
	* @throws
	 */
	public UntreatedMessageEntity loadUntreatedMessage(long memberId);
}
