package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.BorrowingStatistics;
import cn.springmvc.model.InvitationMembers;
import cn.springmvc.model.MemberAttestInfo;
import cn.springmvc.model.MemberBankICardInfos;
import cn.springmvc.model.MemberDetaileInfo;
import cn.springmvc.model.MemberInfo;
import cn.springmvc.model.MemberInvestmentInfo;
import cn.springmvc.model.MemberThirdInfo;
import cn.springmvc.model.VIPMemberInfos;




/***
 * 会员管理
 * @author LiJie
 *
 */
public interface IMemberManangerService {

	
	
	
	/**
	 * 获取会员列表信息
	 * @return
	 */
	public List<MemberInfo> getMembersByParam(PageEntity pageEntity);
	
	
	
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
	* @param  sessionId						
	* @return -1会员不存在、-2会员已被拉黑				
	* @date 2016-3-21 上午11:51:35
	*/
	public int pullBlack(Long id, Long memberId, String mac, String ipaddress,String referer,String sessionId);



	
	
	
	/***
	* 获取所有VIP会员列表
	* @author 李杰 
	* @Description: TODO 
	* @param userName					用户姓名
	* @param memberName					会员登录名
	* @param phone						会员电话
	* @return List<MemberInfo> 返回类型 
	* @date 2016-3-21 下午5:17:03
	 */
	public List<VIPMemberInfos> getVIPMemberByParam(String userName,String memberName, String phone);



	
	
	
	/***
	* 注册会员列表
	* registers :获取所有注册了过后没有进行任何认证项认证的会员
	* 我也不晓得这个功能是用来干嘛的,查看哪些会员注册后就不用了？看看活跃用户有多少？也不是这样弄的啊
	* @author 李杰
	* @param  memberName				会员登录名
	* @param  userName					用户姓名
	* @param  phone						会员电话
	* @param  idCard					会员身份证
	* @param  regDate					会员注册时间
	* @param  regType					会员注册客户端类型（PC or Android or IOS）
	* @return 会员集合
	* @date   2016-3-22 上午11:10:47
	*/
	public List<MemberInfo> registers(String memberName, String userName,String phone, String idCard, String regDate, Integer regType);



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
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午1:49:49
	*/
	public List<MemberInfo> authenticationMember(String memberName,String userName, String phone, String idCard, String regDate,String endDate);



	/***
	* 获取借款至少一次的会员
	* 
	* TODO(描述)
	* @author 李杰
	* @Title loanMember
	* @param memberName					会员登录名称
	* @param userName					用户姓名
	* @param phone						用户手机号
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午2:44:47
	 */
	public List<MemberInfo> loanMember(String memberName, String userName,String phone);


	
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
	public List<MemberInfo> investmentMember(String memberName,String userName, String phone, String escrowAccount);



	
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
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午5:43:58
	*/
	public List<MemberInfo> blackList(String userName, String memberName,String phone, String startTime, String endTime);



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
	* 
	* 
	* 
	* @author 李杰
	* @Title: borrowers
	* @param memberId					会员编号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-4-7 下午8:29:39
	 */
	public BorrowingStatistics borrowers(long memberId, int memberType);
	
	
	
	
	
	
	
	
	
	
	
	
}
