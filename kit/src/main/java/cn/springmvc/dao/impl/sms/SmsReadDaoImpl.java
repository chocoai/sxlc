package cn.springmvc.dao.impl.sms;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("smsReadDaoImpl")
public class SmsReadDaoImpl extends SqlSessionDaoSupport{
	
	public SmsSetInfoEntity GetSmsInfo(){
		return getSqlSession().selectOne("SmsDao.getSmsSetInfo");
	}
	
	/** 
	* WhetherThereTextMessaging 根据会员id，短信类型查询是否存在发送该短信内容
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: WhetherThereTextMessaging 
	* @Description: TODO 
	* @param @param memberID 会员id
	* @param @param typeID 短信类型
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-4 下午8:27:58
	* @throws 
	*/
	public String WhetherThereTextMessaging(long memberID,int typeID){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberID", memberID);
		map.put("typeId", typeID);
		
		return getSqlSession().selectOne("SmsDao.WhetherThereTextMessaging",map);
	};
	
	public EMessageEntity getEmail(){
		Map<String, Object> map = new HashMap<String, Object>();
		return getSqlSession().selectOne("SmsDao.getEmail",map);
	};
	
	
	/** 
	* findLogName 根据会员id查询会员名称 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findLogName 
	* @Description: TODO 
	* @param @param memberID
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:12:16
	* @throws 
	*/
	public String findLogName(long memberID){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberID", memberID);
		return getSqlSession().selectOne("SmsDao.findLogName",map);
	};
	
	
	/** 
	* findProjectTypeNameById 根据借款申请id查询项目类型名称 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findProjectTypeNameById 
	* @Description: TODO 
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:22:58
	* @throws 
	*/
	public String findProjectTypeNameById(long applyId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
		return getSqlSession().selectOne("SmsDao.findProjectTypeNameById",map);
	};
	
	
	/** 
	* findProjectNameById 根据借款申请id查询项目名称 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findProjectNameById 
	* @Description: TODO 
	* @param @param applyId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-7 上午10:23:42
	* @throws 
	*/
	public String findProjectNameById(long applyId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
		return getSqlSession().selectOne("SmsDao.findProjectNameById",map);
	}; 
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
