package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.BlackLimitEntity;
import cn.membermng.model.BlackRecordEntity;
import cn.membermng.model.BorrowingStatistics;
import cn.membermng.model.InvitationMembers;
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberAttestInfo;
import cn.membermng.model.MemberBankICardInfos;
import cn.membermng.model.MemberDetaileInfo;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberInvestmentInfo;
import cn.membermng.model.MemberThirdInfo;
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MyRecommand;
import cn.membermng.model.TradingTypeEntity;
import cn.membermng.model.VIPMemberInfos;




/***
 * 会员管理
 * @author LiJie
 *
 */
public interface IMemberManangerService {
	
	
	/**
	 * 获取会员列表信息
	 * <br>
	 * memberName				会员登录名称<br>
	 * personalName				会员真实名称<br>
	 * personalPhone			会员联系电话<br>
	 * automaticBidding			是否开启自动投标<br>
	 * automaticRepayment		是否开启自动还款<br>
	 * memberType				会员类型<br>20160506添加
	 * @return
	 */
	public List<MemberAll> getMembersByParam(PageEntity pageEntity);
	
	
	
	/***
	 * 根据会员编号获取会员详细信息
	 * @param memberId					会员编号
	 * @return
	 */
	public MemberDetaileInfo memberInfoById(Long memberId);


	
	/***
	* 拉黑某个会员
	* @author 李杰 
	* @Title  pullBlack 
	* @param  id							管理员编号
	* @param  memberId						会员编号
	* @param  mac							客户端MAC地址
	* @param  ipaddress						客户端IP地址
	* @param  referer						请求来源
	* @param  remark						描述(原因)
	* @param  sessionId						
	* @return -1会员不存在、-2会员已被拉黑				
	* @date 2016-3-21 上午11:51:35
	*/
	public int pullBlack(Map<String,Object> map,InsertAdminLogEntity entity,String[] sIpInfo );
	
	
	
	/***
	* 获取所有VIP会员列表
	* @author 李杰 
	* @Description: TODO 
	* @param userName					用户姓名
	* @param memberName					会员登录名
	* @param phone						会员电话
	* @param memberType					会员类型
	* @return List<MemberInfo> 返回类型 
	* @date 2016-3-21 下午5:17:03
	 */
	public List<VIPMemberInfos> getVIPMemberByParam(PageEntity pageEntity);

	
	
	
	/***
	* 注册会员列表
	* registers :获取所有注册了过后没有进行任何认证项认证的会员
	* 
	* @author 李杰
	* @param  memberName				会员登录名
	* @param  userName					用户姓名
	* @param  phone						会员电话
	* @param  idCard					会员身份证
	* @param  regDate					会员注册时间
	* @param  regType					会员注册客户端类型（PC or Android or IOS）
	* @param  memberType				会员类型
	* @return 会员集合
	* @date   2016-3-22 上午11:10:47
	*/
	public List<MemberInfo> registers(PageEntity entity);



	/***
	* 认证会员
	* 获取注册后至少认证过一项,但没有借款和投资的会员
	* @author 李杰
	* @Title: authenticationMember	
	* @param memberName					会员登录名
	* @param userName					用户姓名
	* @param phone						会员电话
	* @param idCard						会员身份证号
	* @param regDate					会员注册时间段
	* @param endDate					会员注册时间段
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午1:49:49
	*/
	public List<MemberInfo> authenticationMember(PageEntity pageEntity);



	/***
	* 获取借款至少一次的会员
	* 
	* TODO(描述)
	* @author 李杰
	* @Title loanMember
	* @param memberName					会员登录名称
	* @param userName					用户姓名
	* @param phone						用户手机号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午2:44:47
	 */
	public List<MemberInfo> loanMember(PageEntity pageEntity);


	
	/***
	* 投资会员列表
	* @author 李杰
	* @Title investmentMember
	* @param memberName					会员登录名
	* @param userName					用户姓名
	* @param phone						用户手机号
	* @param escrowAccount				用户第三方手机号
	* @return
	* @date 2016-3-22 下午4:24:19
	*/
	public List<MemberInfo> investmentMember(PageEntity pageEntity);

	
	
	/**
	 * 复合会员列表
	 * TODO
	 * 创建日期：2016-4-29下午7:07:37
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<MemberInfo>
	 */
	public List<MemberInfo> componentMembers(PageEntity pageEntity);

	
	
	/***
	* 会员黑名单列表
	* 
	* @author 李杰
	* @Title: blackList
	* @param userName
	* @param memberName
	* @param phone
	* @param startTime
	* @param endTime
	* @param memberType 
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午5:43:58
	*/
	public List<MemberInfo> blackList(PageEntity pageEntity);



	/***
	* 查看会员的银行卡列表
	*
	* @author 李杰
	* @Title: bankCards
	* @param entity
	* memberId					会员编号
	* memberType				会员类型
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午5:07:18
	*/
	public List<MemberBankICardInfos> bankCards(PageEntity entity);



	
	/***
	* 邀请列表
	* 
	* @author 李杰
	* @Title: invitationsByParam
	* @param entity
	* memberNo						会员字符串编号
	* personalName					会员名称
	* personalPhone					会员联系电话
	* startTime						注册时间 开始
	* endTime						注册时间 结束
	* 
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午5:24:06
	*/
	public List<InvitationMembers> invitationsByParam(PageEntity entity);



	
	/***
	* 查看某个会员的投资信息
	* 
	* @author 李杰
	* @Title: investment
	* @param memberId				会员编号
	* @param memberType				会员类型
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午7:24:05
	 */
	public MemberInvestmentInfo investment(long memberId, int memberType);



	/***
	* 查看某个会员的认证资料信息
	* 
	* @author 李杰
	* @Title: memberConfInfo
	* @param  memberId
	* @param  memberType
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午7:56:42
	 */
	public List<MemberAttestInfo> memberConfInfo(long memberId, int memberType);



	/***
	* 查看某个会员的第三方开通信息
	* 
	* @author 李杰
	* @Title: memberThirdInfo
	* @param l
	* @param i
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午8:06:08
	 */
	public MemberThirdInfo memberThirdInfo(long memberId, int memberType);



	/***
	* @author 李杰
	* @Title: borrowers
	* @param memberId					会员编号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午8:29:39
	 */
	public BorrowingStatistics borrowers(long memberId, int memberType);
	
	
	
	/**
	 * 会员交易类型
	 * TODO
	 * 创建日期：2016-5-2下午2:15:26
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<TradingTypeEntity>
	 */
	public List<TradingTypeEntity> memberTradingTypes() ;
	
	
	
	/**
	 * 会员交易列表
	 * TODO
	 * 创建日期：2016-5-2下午2:16:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<MemberTradingRecordsEntity>
	 */
	public List<MemberTradingRecordsEntity> memberTradingList(PageEntity entity);
	
	
	
	/**
	 * 会员重置密码列表
	 * TODO
	 * 创建日期：2016-5-5下午4:02:14
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	public  void memberResetPwdList(PageEntity entity);
	
	
	
	/**
	 * 会员重置密码
	 * TODO
	 * 创建日期：2016-5-5下午7:09:18
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Map<String,Object>
	 */
	public int memberResetPwd(Map<String, Object> param,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/**
	 * 我的邀请人
	 * TODO
	 * 创建日期：2016-5-6上午10:45:23
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MyRecommand
	 */
	public MyRecommand  MyRecommandMan(Map<String,Object> map);
	
	
	/**
	 * 期望的邀請人列表 及排除本人和现在的邀请人
	 * TODO
	 * 创建日期：2016-5-5下午8:35:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	public  List<MyRecommand> ExceptMyRecommandMan(PageEntity entity);
	
	
	/**
	 * 
	 * TODO
	 * 创建日期：2016-5-6下午3:01:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<BlackRecordEntity>
	 */
	public void  blackRecord(PageEntity entity);
	
	/**
	 * 移除黑名单
	 * TODO
	 * 创建日期：2016-5-9下午7:37:02
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int removeBlack(Map<String, Object> param,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/**
	 * 查询黑名单受限
	 * TODO
	 * 创建日期：2016-5-10上午10:45:26
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<BlackLimitEntity>
	 */
	public List<BlackLimitEntity> blackLimtList();
	
	/**
	 * 添加黑名单受限
	 * TODO
	 * 创建日期：2016-5-10上午10:45:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int addLimitList(int[] strings,InsertAdminLogEntity entity,String[] sIpInfo);
}
