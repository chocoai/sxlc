package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.ExchangeRecords;
import cn.membermng.model.Friends;
import cn.membermng.model.IntegralGETRecord;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyPoint;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.RadPackage;
import cn.membermng.model.SecurityInfo;
import cn.membermng.model.UntreatedMessageEntity;


/**
 * 会员数据访问层
 * @author LiJie
 *
 */
public interface IMemberReadDao {

	
	
	/***
	 * 统计当前电话号码的个数
	 * @param param
	 * @return
	 */
	public int countPhone(Map<String,Object> param);
	
	
	
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
	* 根据编号获取个人会员信息
	*
	* @author 李杰
	* @Title: memberPersonalInfo
	* @return
	* @date 2016-3-29 上午10:54:24
	 */
	public MemberInfo memberPersonalInfo(Map<String,Object> param);
	
	/***
	* 根据编号获取企业会员信息
	*
	* @author 李杰
	* @Title: memberPersonalInfo
	* @return
	* @date 2016-3-29 上午10:54:24
	 */
	public MemberInfo memberComplanyInfo(Map<String,Object> param);


	
	/***
	* 分页获取好友邀请信息 
	* 
	* @author 李杰
	* @Title: friendInvitation
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午2:28:02
	 */
	public List<MemberInfo> friendInvitation(PageEntity entity);
	
	/***
	* 会员积分信息
	* 
	* @author 李杰
	* @Title: points
	* @param memberId
	* @param memberType
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午4:01:01
	 */
	public MyPoint points(Map<String,Object> param);
	
	/***
	* 会员获取积分记录
	* 
	* @author 李杰
	* @Title: addPoints
	* @param memberId					会员编号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午4:04:51
	 */
	public List<IntegralGETRecord> addPoints(PageEntity entity);
	

	
	/***
	* 获取我的红包信息
	* 
	* @author 李杰
	* @Title: myRedPackage
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午3:42:30
	 */
	public MyRedPackage myRedPackage(Map<String, Object> param);


	/***
	* 获取我的红包记录
	* 
	* @author 李杰
	* @Title: redPackages
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午3:43:03
	 */
	public List<RadPackage> redPackages(PageEntity entity);


	/***
	* 获取我的代金券
	* 
	* @author 李杰
	* @Title: myVouchers
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午7:31:25
	 */
	public MemberVouchers myVouchers(Map<String, Object> param);


	/***
	* 获取我的代金券列表
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-3-30 下午7:32:33
	 */
	public List<MemberVouchers> vouchers(PageEntity entity);

	/***
	* 我的代金券使用列表
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-9 下午7:47:56
	 */
	public List<MemberVouchers> useVochers(PageEntity entity);

	/***
	* 获取我的总余额
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-5-5 下午2:59:45
	*/
	public long getRemainderTotal(Map<String, Object> param);
	
	
	/**
	* 查询会员信息
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-4-26 上午10:36:37
	 */
	public MemberInfo findMemberInfoByParam(Map<String, Object> param);


	
	/***
	* 获取安全中心信息
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-4-26 下午6:52:20
	 */
	public SecurityInfo securityInfo(Map<String, Object> param);



	/***
	* 获取我的好友列表
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-5 上午10:40:55
	 */
	public List<Friends> friendList(PageEntity entity);


	
	/***
	* 查询陌生人
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-6 下午1:26:02
	 */
	public List<MemberInfo> serachMemberByParam(PageEntity entity);

	/**
	 * 获取待确认好友列表
	* selectConfirmFriendList
	* @author 邱陈东  
	* * @Title: selectConfirmFriendList 
	* @param @param entity
	* @param @return 设定文件 
	* @return List<Friends> 返回类型 
	* @date 2016-5-6 上午11:55:50
	* @throws
	 */
	public List<Friends> selectConfirmFriendList(PageEntity entity);


	/**
	 * 忘记密码-查询登录名与手机号是否匹配
	* selectMemberIsExist
	* @author 邱陈东  
	* * @Title: selectMemberInfoList 
	* @param @param param
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午6:11:01
	* @throws
	 */
	public int selectMemberIsExist(Map<String, Object> param);


	/**
	 * 忘记密码-根据手机号查询用户ID
	* selectMemberIdByPhone
	* @author 邱陈东  
	* * @Title: selectMemberIdByPhone 
	* @param @param param
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午6:25:08
	* @throws
	 */
	public Long selectMemberIdByPhone(Map<String, Object> param);


	
	
	/**
	* 积分兑换记录
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-7 下午3:25:07
	 */
	public List<ExchangeRecords> exchangeRecords(PageEntity entity);



	/**
	 * 个人中心读取当前登录人的姓名，称号，信用等级，积分，签到次数，第三方账号
	* loadMemberInfo
	* @author 邱陈东  
	* * @Title: loadMemberInfo 
	* @param @param param
	* @return Map<String,Object> 返回类型 
	* @date 2016-5-18 下午1:39:03
	* @throws
	 */
	public MemberInfo loadMemberInfo(Map<String, Object> param);
	

	/**
	 * 查询今日签到次数
	* checkTodaySignNum
	* @author 邱陈东  
	* * @Title: checkTodaySignNum 
	* @param @param param
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-18 下午3:53:21
	* @throws
	 */
	public int checkTodaySignNum(Map<String, Object> param);
	
	/**
	 * 读取未读站内信，站内消息，待处理好友申请数
	* loadUntreatedMessage
	* @author 邱陈东  
	* * @Title: loadUntreatedMessage 
	* @param @param param
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-19 上午9:52:52
	* @throws
	 */
	public UntreatedMessageEntity loadUntreatedMessage(Map<String, Object> param);
}
