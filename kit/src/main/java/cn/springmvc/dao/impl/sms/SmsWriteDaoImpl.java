package cn.springmvc.dao.impl.sms;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

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
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
