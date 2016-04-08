package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import product_p2p.kit.Lock.SyncLock;
import product_p2p.kit.id.IdEntity;

@Repository("idWriteDaoImpl")
public class IdWriteDaoImpl extends SqlSessionDaoSupport{
	public static SyncLock idLock = new SyncLock();				//id 生成锁
	/**
	 * 设置id状态为无效
	 * @param lId
	 * @return	0:失败	1：成功
	 */
	public int SetIdUsed(long lId){
		int iResult = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", lId);
		
		iResult = getSqlSession().update("IdWriteDao.updateIdUsed", param);
		
		return iResult;
	}
	
	
	/**
	 * 设置id状态为无效
	 * @param lId
	 * @return	0:失败	1：成功
	 */
	public List<Long> GetIdList(int iSize){
		List<Long> list = new ArrayList<Long>();
		if(iSize<=0){
			return list;
		}
		long lStart = 0;
		long lEnd = 0;
		idLock.EnterLock();
		try {
			SqlSession session = getSqlSession();
			lStart = GetMaxId(session);
			if(lStart == 0){
				lStart = lStart + 3;
			}
			lEnd = lStart + 2*(long)iSize;
			
			SetMaxId(session, lEnd);
			
			list.add(lStart);
			list.add(lEnd);
		} catch (Exception e) {
//			System.out.println("GetIdList"+e.getLocalizedMessage());
			logger.error("GetIdList:" + e.getLocalizedMessage());
		}finally{
			idLock.LeaveLock();
		}	
		return list;
	}
	
	/**
	 * 设置最大ID
	 * @param lId
	 * @return 0:失败 	1：成功
	 */
	private int SetMaxId(SqlSession session,long lId){
		int iResult = 0;
		
		if(session!=null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", lId);
			iResult = session.update("IdWriteDao.setMaxId", param);
			param.clear();
			param = null;
		}
		
		return iResult;
	}
	
	/**
	 * 获取数据库最大id
	 * @param session
	 * @return	最大ID值
	 */
	private long GetMaxId(SqlSession session){
		long lResult = 0;
		
		if(session!=null){
//			Map<String, Object> param = new HashMap<>();
			lResult = session.selectOne("IdWriteDao.getMaxId");
		}
		
		return lResult;
	}
	
	/**
	 * 添加id列表
	 * @param idList
	 */
	public void InsertIdInfo(List<Long> idList){
		if(idList == null){
			return;
		}
		int iSize = idList.size();
		try {
			SqlSession session = getSqlSession();
			long l = 0;
			for(int i=0;i<iSize;i++){
				l = idList.get(i);
				InsertId(l, session);
			}
		} catch (Exception e) {
			logger.error("InsertIdInfo:" + e.getLocalizedMessage());
		} finally {
//			DbUtility.close_ps(rs, ps, cn, session);
		}
	}
	
	/**
	 * 添加id记录
	 * @param lId
	 * @return		0：失败	1：成功
	 */
	public int InsertId(long lId,SqlSession session){
		int iResult = 0;
		
		if(session != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", lId);
			iResult = session.update("IdWriteDao.insertIdInfo", param);
			param.clear();
			param = null;
		}
		
		return iResult;
	}
	
	/**
	 * 获取未使用id
	 * @param iCount			获取个数
	 * @return
	 */
	public List<IdEntity> GetUnusedId(int iCount){
		List<IdEntity> idList = null;
		
		long lMaxId = 0;
		long lMinId = 0;
		try {
			SqlSession session = getSqlSession();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("count", iCount);
			
			idList = session.selectList("IdWriteDao.getUnUseId",param);
			param.clear();
			param = null;
			
			if(idList!=null){
				int iSize = idList.size();
				if(iSize>0){
					lMinId = idList.get(0).getlId();
					lMaxId = idList.get(iSize-1).getlId();
				}
				param = new HashMap<String, Object>();
				param.put("min", lMinId);
				param.put("max", lMaxId);
				session.update("IdWriteDao.updateIdsStatu",param);
			}
		} catch (Exception e) {
			System.out.println(" 获取全部操作列表getOperationList:"+e.getLocalizedMessage());
			logger.error(" 获取全部操作列表getOperationList:" + e.getLocalizedMessage());
		}finally{
			
		}
		
		return idList;
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
