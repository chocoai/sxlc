package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.BlackLimitEntity;
import cn.membermng.model.BlackRecordEntity;
import cn.membermng.model.BorrowingStatistics;
import cn.membermng.model.ComplanyInfoEntity;
import cn.membermng.model.InvitationMembers;
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberAttestInfo;
import cn.membermng.model.MemberBankICardInfos;
import cn.membermng.model.MemberDetaileInfo;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberInfoEntity;
import cn.membermng.model.MemberInvestmentInfo;
import cn.membermng.model.MemberResetPwdEntity;
import cn.membermng.model.MemberThirdInfo;
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MyRecommand;
import cn.membermng.model.TradingTypeEntity;
import cn.membermng.model.VIPMemberInfos;




/***
 * 会员管理数据访问层
 * @author LiJie
 *
 */
public interface IMemberManagerReadDao {

	
	
	/***
	 * 根据条件查询
	 * @param entity
	 * @return
	 */
	public List<MemberAll> getMembersByParam(PageEntity entity);

	
	
	/***
	 * 更具会员编号获取会员详细信息
	 * @param memberId
	 * @return
	 */
	public MemberDetaileInfo memberInfoById(Map<String,Object> param);
	
	
	
	/****
	 * 获取会员第三方账户开通情况
	 * @param param
	 * @return
	 */
	public MemberThirdInfo memberThirdInfo(Map<String,Object> param);
	
	
	/***
	 * 会员资料认证信息
	 * @param param
	 * @return
	 */
	public List<MemberAttestInfo> memberAttestInfo(Map<String,Object> param);
	
	
	
	/***
	 * 会员借款信用统计
	 * @param param
	 * @return
	 */
	public BorrowingStatistics borrowers(Map<String,Object> param);
	
	
	/***
	 * 会员投资信息统计
	 * @param param
	 * @return
	 */
	public MemberInvestmentInfo investment(Map<String,Object> param);
	
	
	/**
	 *  查看会员的交易类型
	 * TODO
	 * 创建日期：2016-5-2下午2:08:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<T>
	 */
	public List<TradingTypeEntity> memberTradingTypes();

	
	/**
	 *  查看会员的交易记录 
	 * TODO
	 * 创建日期：2016-5-2下午2:08:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<T>
	 */
	public List<MemberTradingRecordsEntity> memberTradingList(PageEntity pageEntity);
	
	
	
	/***
	 * 查看会员的银行卡列表
	* @author 李杰 
	* @Title: bankCards 
	* @Description: 管理员查看该会员的银行卡列表
	* @param @param param			查询条件
	* @param @return 设定文件 
	* @return List<T> 返回类型 
	* @date 2016-3-18 下午7:10:48
	* @throws
	 */
	public List<MemberBankICardInfos> bankCards(PageEntity entity);
	
	
	
	
	
	
	/***
	* 重置一个会员的登陆密码
	* @author 李杰 
	* @Title: resetPassword 
	* @Description: 如果某个会员的密码忘记了，那么管理员即可通过此功能重新设置用户密码、
	* @param param	参数
	* @return int 返回类型 
	* @date 2016-3-18 下午7:12:29
	* @throws
	 */
	public int resetPassword(Map<String,Object> param);
	
	
	
	/**
	* 查看会员邀请的会员
	* @author 李杰 
	* @Title: invitationsByParam 
	* @Description:更具条件查看该会员邀请的注册的会员
	* @param @param param
	* @param @return 设定文件 
	* @return List<MemberInfo> 返回类型 
	* @date 2016-3-18 下午7:17:02
	* @throws
	 */
	public List<InvitationMembers> invitationsByParam(PageEntity entity);




	
	/***
	* 根据条件查询VIP会员
	* @author 李杰 
	* @Title: vipMembersByParam 
	* @Description: TODO 
	* @param @param param
	* @param @return 设定文件 
	* @return List<VIPMemberInfos> 返回类型 
	* @date 2016-3-21 下午5:28:09
	*/
	public List<VIPMemberInfos> vipMembersByParam(PageEntity entity);



	/***
	* 更具条件查询注册会员列表
	* @author 李杰
	* @param param					查询条件
	* @return
	* @date 2016-3-22 上午11:22:11
	 */
	public List<MemberInfo> registers(PageEntity entity);



	
	/***
	* 更具条件查询认证会员 
	* authenticationMember(管理员查询会员注册后认证至少一项后，没有借过款、没有投过资的)
	* @author 李杰
	* @Title: authenticationMember
	* @param param					查询条件
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午2:09:52
	 */
	public List<MemberInfo> authenticationMember(PageEntity entity);



	/***
	* 更具条件查询至少借款过一次的会员
	* 
	* @author 李杰
	* @Title loanMember
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午2:52:53
	 */
	public List<MemberInfo> loanMember(PageEntity entity);



	/***
	* 查询至少投过一次资的会员
	* 
	* @author 李杰
	* @Title investmentMember
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午4:30:02
	*/
	public List<MemberInfo> investmentMember(PageEntity entity);
	
	
	/**
	 * 查询至少投过一次资且借过一次款的会员
	 * TODO
	 * 创建日期：2016-5-2上午11:53:06
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<MemberInfo>
	 */
	public List<MemberInfo> componentMembers(PageEntity entity);

	

	
	/***
	* 会员黑名单
	* 
	* @author 李杰
	* @Title blackList
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午5:49:18
	*/
	public List<MemberInfo> blackList(PageEntity entity);

	
	/**
	 * 会员黑名单移除记录列表
	 * TODO
	 * 创建日期：2016-5-5下午8:48:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<BlackRecordEntity>
	 */
	public List<BlackRecordEntity>  blackRecord(PageEntity entity);
	
	/**
	 * 会员重置密码记录
	 * TODO
	 * 创建日期：2016-5-5下午3:47:18
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	public List<MemberResetPwdEntity> memberResetPwdList(PageEntity entity);

	
	/**
	 * 我的邀请人
	 * TODO
	 * 创建日期：2016-5-5下午8:34:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MyRecommand
	 */
	public MyRecommand  MyRecommandMan(Map<String,Object> map);
	
	
	/**
	 * 邀请人列表
	 * TODO
	 * 创建日期：2016-5-5下午8:35:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	public  List<MyRecommand> ExceptMyRecommandMan(PageEntity entity);
	
	
	/**
	 * 黑名单受限
	 * TODO
	 * 创建日期：2016-5-10上午10:40:12
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<BlackLimitEntity>
	 */
	public List<BlackLimitEntity> blackLimtList();
	
	/**
	 * 黑名单限制数量
	 * TODO
	 * 创建日期：2016-5-10上午11:29:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int countLimit();



	/***
	* 查询企业会员信息
	* 
	* @author 李杰
	* @param param
	* memberId			会员编号
	* skey				钥
	* @return
	* @date 2016-5-11 上午11:01:49
	 */
	public ComplanyInfoEntity companyInfo(Map<String, Object> param);
	
	
}
