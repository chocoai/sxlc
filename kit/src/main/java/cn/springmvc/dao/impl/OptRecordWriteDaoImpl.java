package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.optrecord.InsertMemberLogEntity;

@Repository("optRecordWriteDaoImpl")
public class OptRecordWriteDaoImpl extends SqlSessionDaoSupport{
	
	/**
	 * 添加后台操作日志
	 * @param entity			日志内容
	 * @param sIpInfo			ip详情
	 */
	public void InsertAdminOptRecord(InsertAdminLogEntity entity,String[] sIpInfo){
		if(entity == null){
			return;
		}
		if(sIpInfo == null || sIpInfo.length<6){
			return;
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("adminId", entity.getiAdminId());
		param.put("modId", entity.getlModuleId());
		param.put("optId", entity.getlOptId());
		param.put("detail", entity.getsDetail());
		param.put("ipv", entity.getsIp());
		param.put("macv", entity.getsMac());
		param.put("urlv", entity.getsUrl());
		param.put("icountry", sIpInfo[0]);
		param.put("iregion", sIpInfo[1]);
		param.put("iprovince", sIpInfo[2]);
		param.put("icity", sIpInfo[3]);
		param.put("iarea", sIpInfo[4]);
		param.put("iISP", sIpInfo[5]);
		param.put("result", 0);
		
		getSqlSession().selectOne("optRecord.insertAdminOptRecord",param);
	}
	
	/**
	 * 添加前台访问日志
	 * @param entity			日志内容
	 * @param sIpInfo			ip详情
	 * @return
	 */
	public void InsertForgroundLog(String sSessionId,long lMemberId,InsertMemberLogEntity entity,String[] sIpInfo){
		if(entity == null){
			return ;
		}
		if(sIpInfo == null || sIpInfo.length<6){
			return ;
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sessionId", sSessionId);
		param.put("memberId", lMemberId);
		param.put("ipv", entity.getsIp());
		param.put("macv", entity.getsMac());
		param.put("urlv", entity.getsUrl());
		param.put("reurlv", entity.getsReferrUrl());
		param.put("sKeyWord", entity.getsKeyWord());
		param.put("icountry", sIpInfo[0]);
		param.put("iregion", sIpInfo[1]);
		param.put("iprovince", sIpInfo[2]);
		param.put("icity", sIpInfo[3]);
		param.put("iarea", sIpInfo[4]);
		param.put("iISP", sIpInfo[5]);
		param.put("result", 0);
		
		getSqlSession().selectOne("optRecord.insertMemberOptRecord",param);
	}
	
	/**
	 * 
	* MemberSessionCheck(前台session验证) 
	* TODO(描述)
	* @author 张友  
	* * @Title: MemberSessionCheck 
	* @Description: TODO 
	* @param @param sSessionId			sessionId
	* @param @param lMemberId			会员id
	* @param @param sIsNeedLogin		操作是否需要登录
	* @param @param iValidityPeriod		session有效时间
	* @param @param sIp					访问ip地址
	* @param @param sIpInfo				ip详细信息
	* @param @return 设定文件 			
	* @return int 返回类型 					-1：非法操作 -2：未登录 -3:登录已过期 1：验证成功 0:验证失败
	* @date 2016-3-22 下午5:16:51
	* @throws null
	 */
	public int MemberSessionCheck(String sSessionId,long lMemberId,short sIsNeedLogin,int iValidityPeriod,
			String sIp,String[] sIpInfo){
		int iResult = 0;
		
		if(sSessionId == null || sSessionId.equals("") || sIpInfo==null || sIpInfo.length<6){
			return iResult;
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sessionid", sSessionId);
		param.put("memberId", lMemberId);
		param.put("isneedlogin", sIsNeedLogin);
		param.put("iValidityPeriod", iValidityPeriod);
		param.put("ipv", sIp);
		param.put("icountry", sIpInfo[0]);
		param.put("iregion", sIpInfo[1]);
		param.put("iprovince", sIpInfo[2]);
		param.put("icity", sIpInfo[3]);
		param.put("iarea", sIpInfo[4]);
		param.put("iISP", sIpInfo[5]);
		param.put("result", 0);
		
		getSqlSession().selectOne("optRecord.MemberSessionCheck",param);
		iResult = IntegerAndString.StringToInt(param.get("result").toString(),-1);
		return iResult;
	}
	
	/**
	 * 
	* AdminSessionCheck(后台session验证) 
	* TODO(描述)
	* @author 张友  
	* * @Title: AdminSessionCheck 
	* @Description: TODO 
	* @param @param sSessionId			sessionId
	* @param @param lMemberId			会员id
	* @param @param sIsNeedLogin		操作是否需要登录
	* @param @param iValidityPeriod		session有效时间
	* @param @param sIp					访问ip地址
	* @param @param sIpInfo				ip详细信息
	* @param @return 设定文件 
	* @return int 返回类型 					-1：非法操作 -2：未登录 -3:登录已过期 1：验证成功 0:验证失败
	* @date 2016-3-22 下午8:59:07
	* @throws
	 */
	public int AdminSessionCheck(String sSessionId,long lAdminId,short sIsNeedLogin,int iValidityPeriod,
			String sIp,String[] sIpInfo){
		int iResult = 0;
		
		if(sSessionId == null || sSessionId.equals("") || sIpInfo==null || sIpInfo.length<6){
			return iResult;
		}
		
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("sessionid", sSessionId);
		param.put("memberId", lAdminId);
		param.put("isneedlogin", sIsNeedLogin);
		param.put("iValidityPeriod", iValidityPeriod);
		param.put("ipv", sIp);
		param.put("icountry", sIpInfo[0]);
		param.put("iregion", sIpInfo[1]);
		param.put("iprovince", sIpInfo[2]);
		param.put("icity", sIpInfo[3]);
		param.put("iarea", sIpInfo[4]);
		param.put("iISP", sIpInfo[5]);
		param.put("result", 0);
		
		getSqlSession().selectOne("optRecord.AdminSessionCheck",param);
		iResult = IntegerAndString.StringToInt(param.get("result").toString(),-1);
		return iResult; 
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
