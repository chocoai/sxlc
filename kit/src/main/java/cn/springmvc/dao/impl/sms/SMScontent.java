package cn.springmvc.dao.impl.sms;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;




/** 
 * 短信内容配置
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-7 上午9:52:58  */
@Service("sMScontent")
public class SMScontent {
	private static final String SMSsign = "四象联创";//短信签名
	private static final String SMSphone = "";//联系电话
	private static final String SMSurl = "";//短信内容网址
	
	@Resource(name="smsReadDaoImpl")
	private SmsReadDaoImpl smsReadDaoImpl;
	@Resource(name="smsWriteDaoImpl")
	private SmsWriteDaoImpl smsWriteDaoImpl;
	private static SMScontent sMScontent = null;
	
	public SmsReadDaoImpl getSmsReadDaoImpl() {
		return smsReadDaoImpl;
	}

	public void setSmsReadDaoImpl(SmsReadDaoImpl smsReadDaoImpl) {
		this.smsReadDaoImpl = smsReadDaoImpl;
	}

	public SmsWriteDaoImpl getSmsWriteDaoImpl() {
		return smsWriteDaoImpl;
	}

	public void setSmsWriteDaoImpl(SmsWriteDaoImpl smsWriteDaoImpl) {
		this.smsWriteDaoImpl = smsWriteDaoImpl;
	}

	public static SMScontent getsMScontent() {
		return sMScontent;
	}
	public SMScontent(){
		if(sMScontent == null){
			sMScontent = this;
		}
	}
	public static void setsMScontent(SMScontent sMScontent) {
		SMScontent.sMScontent = sMScontent;
	}
	
	
	
	
	

	/** 
	* ContentSMS1 注册成功消息内容 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS1 
	* @Description: TODO 
	* @param @param logname 登录名
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午9:54:16
	* @throws 
	*/
	public String ContentSMS1(String logname){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(-1,1);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{zhanghao\\}", logname);
		}
		return set;
	}
	
	/** 
	* ContentSMS2 开户成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS2 
	* @Description: TODO 
	* @param @param memberId
	* @param @param logname
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:07:32
	* @throws 
	*/
	public String ContentSMS2(long memberId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,2);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	/** 
	* ContentSMS3 充值成功 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS3 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:14:13
	* @throws 
	*/
	public String ContentSMS3(long memberId,String money){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,3);
		String logName=smsReadDaoImpl.findLogName(memberId);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{chognzhi\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS4 提现成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS4 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:14:36
	* @throws 
	*/
	public String ContentSMS4(long memberId,String money){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,4);
		String logName=smsReadDaoImpl.findLogName(memberId);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{tixian\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS5 会员 投资放款成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS5 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:26:13
	* @throws 
	*/
	public String ContentSMS5(long memberId,String money,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,5);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			String projectTypeName=smsReadDaoImpl.findProjectTypeNameById(applyId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{xiangmuleixing\\}", projectTypeName);
			set=set.replaceAll("\\$\\{touzi\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS6 会员投资项目流标
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS6 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:27:32
	* @throws 
	*/
	public String ContentSMS6(long memberId,String money,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,6);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			String projectTypeName=smsReadDaoImpl.findProjectTypeNameById(applyId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{xiangmuleixing\\}", projectTypeName);
			set=set.replaceAll("\\$\\{touzi\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	/** 
	* ContentSMS7 会员借款申请审核 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS7 
	* @Description: TODO 
	* @param @param memberId
	* @param @param statu 审核状态名称
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:53:38
	* @throws 
	*/
	public String ContentSMS7(long memberId,String statu,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,7);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{zhaungtai\\}", statu);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS8 借款会员借款项目流标
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS8 
	* @Description: TODO 
	* @param @param memberId
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:00:46
	* @throws 
	*/
	public String ContentSMS8(long memberId,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,8);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS9  借款会员借款项目放款
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS9 
	* @Description: TODO 
	* @param @param memberId
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:03:23
	* @throws 
	*/
	public String ContentSMS9(long memberId,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,9);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	
	/** 
	* ContentSMS10  即将还款提醒 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS10 
	* @Description: TODO 
	* @param @param memberId
	* @param @param applyId
	* @param @param repalyMoney
	* @param @param repalyTime
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:11:20
	* @throws 
	*/
	public String ContentSMS10(long memberId,long applyId,String repalyMoney,String repalyTime){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,10);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			set=set.replaceAll("\\$\\{huankuanjine\\}", repalyMoney);
			set=set.replaceAll("\\$\\{huankuanri\\}", repalyTime);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS11 成功还款 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS11 
	* @Description: TODO 
	* @param @param memberId
	* @param @param applyId
	* @param @param repalyMoney
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:13:21
	* @throws 
	*/
	public String ContentSMS11(long memberId,long applyId,String repalyMoney){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,11);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			set=set.replaceAll("\\$\\{huankuanjine\\}", repalyMoney);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS12 投资会员成功收到还款 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS12 
	* @Description: TODO 
	* @param @param memberId
	* @param @param applyId
	* @param @param shouyijine
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:15:54
	* @throws 
	*/
	public String ContentSMS12(long memberId,long applyId,String shouyijine){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,12);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			set=set.replaceAll("\\$\\{shouyijine\\}", shouyijine);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS13 密码修改成功 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS13 
	* @Description: TODO 
	* @param @param memberId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:19:04
	* @throws 
	*/
	public String ContentSMS13(long memberId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,13);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS14 登录验证码
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS14 
	* @Description: TODO 
	* @param @param memberId
	* @param @param youxiaoshijian
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午11:22:15
	* @throws 
	*/
	public String ContentSMS14(long memberId,String youxiaoshijian){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,14);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{youxiaoshijian\\}", youxiaoshijian);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS15 找回密码手机验证码 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS15 
	* @Description: TODO 
	* @param @param memberId 可传 -1
	* @param @param yzm
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:34:31
	* @throws 
	*/
	public String ContentSMS15(long memberId,String yzm){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,15);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{yanzhengma\\}", yzm);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS16 注册手机验证码
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS16 
	* @Description: TODO 
	* @param @param yzm
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:35:44
	* @throws 
	*/
	public String ContentSMS16(String yzm){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(-1,16);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{yanzhengma\\}", yzm);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS17 提现验证码 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS17 
	* @Description: TODO 
	* @param @param yzm
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:44:02
	* @throws 
	*/
	public String ContentSMS17(String yzm){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(-1,17);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{yanzhengma\\}", yzm);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	/** 
	* ContentSMS19 投资债权转让放款成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS19 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:49:10
	* @throws 
	*/
	public String ContentSMS19(long memberId,String money,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,19);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	/** 
	* ContentSMS19 投资债权转让流标
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS19 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:49:10
	* @throws 
	*/
	public String ContentSMS20(long memberId,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,20);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS21 会员投资项目投资成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS21 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:51:35
	* @throws 
	*/
	public String ContentSMS21(long memberId,String money,long applyId){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,21);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String projectTitle=smsReadDaoImpl.findProjectNameById(applyId);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{touzixiangmu\\}", projectTitle);
			set=set.replaceAll("\\$\\{touzijine\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS22 转账成功
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS22 
	* @Description: TODO 
	* @param @param memberId
	* @param @param memberIdtow
	* @param @param money
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:54:25
	* @throws 
	*/
	public String ContentSMS22(long memberId,long memberIdtow,String money){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,22);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String logName2=smsReadDaoImpl.findLogName(memberIdtow);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{haoyou\\}", logName2);
			set=set.replaceAll("\\$\\{zhuanzhangjine\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS23 成功收到转账 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS23 
	* @Description: TODO 
	* @param @param memberId
	* @param @param memberIdtow
	* @param @param money
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:58:53
	* @throws 
	*/
	public String ContentSMS23(long memberId,long memberIdtow,String money){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,23);
		if (set!=null && !set.equals("")) {
			String logName=smsReadDaoImpl.findLogName(memberId);
			String logName2=smsReadDaoImpl.findLogName(memberIdtow);
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{haoyou\\}", logName2);
			set=set.replaceAll("\\$\\{zhuanzhangjine\\}", money);
//			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
//			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
	
	/** 
	* ContentSMS24 提现失败 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ContentSMS24 
	* @Description: TODO 
	* @param @param memberId
	* @param @param money
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 下午1:59:59
	* @throws 
	*/
	public String ContentSMS24(long memberId,String money){
		String set = smsReadDaoImpl.WhetherThereTextMessaging(memberId,24);
		String logName=smsReadDaoImpl.findLogName(memberId);
		if (set!=null && !set.equals("")) {
			set=set.replaceAll("\\$\\{zhanghao\\}", logName);
			set=set.replaceAll("\\$\\{tixian\\}", money);
			set=set.replaceAll("\\$\\{rexian\\}", SMSphone);
			set=set.replaceAll("\\$\\{wangzhi\\}", SMSurl);
		}
		return set;
	}
	
}
