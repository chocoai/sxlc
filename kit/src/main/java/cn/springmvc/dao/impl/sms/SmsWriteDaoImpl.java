package cn.springmvc.dao.impl.sms;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

@Repository("smsWriteDaoImpl")
public class SmsWriteDaoImpl extends SqlSessionDaoSupport{
	
	/**
	 * (添加短信发送日志) 
	* InsertSmsRecord(添加短信发送日志) 
	* TODO(描述)
	* @author 张友  
	* * @Title: InsertSmsRecord 
	* @Description: TODO 
	* @param  sType				发送类型 0：首次发送 1：再次发送
	* @param  sDetail				短信内容
	* @param  sPhone				手机号， 对象类型1,对象ID1,手机号1;对象类型2,对象ID2,手机号2 多个时用','隔开
	* @param  sSendType			发送类型 0：系统自动发送 1：管理员手动发送
	* @param  lAdminId			手动发送管理员ID
	* @param  sStatu				发送状态	 0：成功、1：失败 
	* @param  ttLastDate			上次发送时间 再次发送时用
	* @param @return 					1：成功	0：失败
	* @return int 返回类型 
	* @date 2016-3-24 下午4:58:22
	* @throws
	 */
	public int InsertSmsRecord(short sType,String sDetail,String sPhone,short sSendType,long lAdminId,short sStatu,Timestamp ttLastDate){
		int iResult = 0;
		SqlSession session = getSqlSession();
		if(session != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("iType", sType);
//			param.put("iMemberType", sMemberType);
//			param.put("lMemberId", lMemberId);	short sMemberType,long lMemberId,
			param.put("sDetail", sDetail);
			param.put("sPhone", sPhone);
			param.put("iSendType", sSendType);
			param.put("adminId", lAdminId);
			param.put("istatu", sStatu);
			param.put("recordDate", ttLastDate);
			param.put("result", 0);
			iResult = session.update("SmsDao.insertSmsRecord", param);
			param.clear();
			param = null;
		}
		
		return iResult;
	}
	
	
	
	
	
	
	
	/** 
	* InsertEmailSmsRecord  邮件发送历史
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: InsertEmailSmsRecord 
	* @Description: TODO 
	* @param @param memberID 发送会员id 
	* @param @param memberType 发送会员类型  邮件发送对象类型 0：会员 1：担保机构
	* @param @param sDetail	发送内容
	* @param @param email 邮箱地址
	* @param @param sSendType  发送类型 0：系统自动发送 1：管理员手动发送
	* @param @param lAdminId 手动发送管理员id
	* @param @param sStatu 发送状态 1:成功 0：失败
	* @param @return 设定文件 
	* @return int 返回类型  1:成功
	* @date 2016-5-6 下午2:09:25
	* @throws 
	*/
	public int InsertEmailSmsRecord(long memberID,int memberType,String sDetail,String email,short sSendType,long lAdminId,short sStatu){
		int iResult = 0;
		SqlSession session = getSqlSession();
		if(session != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("memberID", memberID);
			param.put("memberType", memberType);
			param.put("sDetail", sDetail);
			param.put("email", email);
			param.put("sSendType", sSendType);
			param.put("lAdminId", lAdminId);
			param.put("sStatu", sStatu);
			iResult = session.insert("SmsDao.insertEmailSmsRecord", param);
			param.clear();
			param = null;
		}
		
		return iResult;
	}
	
	
	/** 
	* LetterSendRecord(这里用一句话描述这个方法的作用) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: LetterSendRecord 
	* @Description: TODO 
	* @param @param vTmp 发送会员拼接（会员类型，会员id;会员类型，会员id） 如:0,111;1,121
	* @param @param adminId 操作管理员id
	* @param @param sendType 发送类型 0：系统自动发送 1：管理员手动发送
	* @param @param details 发送内容
	* @param @return 设定文件 1 成功
	* @return int 返回类型 
	* @date 2016-5-6 下午3:15:14
	* @throws 
	*/
	public int LetterSendRecord(String vTmp,long adminId,int sendType,String details){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vTmp", vTmp);
		param.put("adminId", adminId);
		param.put("sendType", sendType);
		param.put("details", details);
		getSqlSession().selectOne("SmsDao.insertEmailSmsRecord", param);
		int result=IntegerAndString.StringToInt(param.get("result").toString(), 0);
		return result;
	};
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
