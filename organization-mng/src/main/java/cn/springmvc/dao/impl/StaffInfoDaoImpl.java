package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.Util.StringUtils;
import cn.springmvc.dao.IStaffInfoDao;
import cn.springmvc.model.PostInfo;
import cn.springmvc.model.StaffInfo;

@Repository
public class StaffInfoDaoImpl extends SqlSessionDaoSupport implements IStaffInfoDao{

	


	@Override
	public int saveStaff(StaffInfo info,String deptId,String postId,String joinDate,String sKey) {
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey", 				sKey);
		param.put("id", 				id);
		param.put("sexId", 				info.getBaseInfo().getSexId());
		param.put("personalName", 		info.getBaseInfo().getPersonalName());
		param.put("personalIdCard", 	info.getBaseInfo().getPersonalIDCard());
		param.put("nationId", 			info.getBaseInfo().getNationId());
		param.put("personalPhone",		info.getBaseInfo().getPersonalPhone());
		param.put("qq", 				info.getBaseInfo().getQq());
		param.put("personalEmail", 		info.getBaseInfo().getPersonalEmail());
		param.put("homeTown", 			info.getBaseInfo().getHomeTown());
		param.put("houseAddress",		info.getBaseInfo().getHouseAddress());
		param.put("education", 			info.getBaseInfo().getEducation());
		param.put("graduatedDATE", 		info.getBaseInfo().getGraduatedDATE());
		param.put("emerName", 			info.getEmerName());
		param.put("emerPhone", 			info.getEmerPhone());
		param.put("staffNo", 			"123456");
		param.put("startDate", 			StringUtils.fromtDate(null, info.getStartDate()));
		param.put("endDate", 			null);
		param.put("result", 			1);
		
		//职务信息
		param.put("deptId", 			deptId);
		param.put("postId", 			postId);
		param.put("joinDate", 			joinDate);
		
		getSqlSession().selectOne("StaffInfoDaoImpl.saveStaff",param);
		
		int result =IntegerAndString.StringToInt(param.get("result").toString(), -1);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
		}else {
			generatorUtil.SetIdUsedFail(id);
		}
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	
	
	
	@Override
	public int editStaff(StaffInfo info,String deptId,String postId,String joinDate,String sKey) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey", sKey);
		param.put("id", info.getId());
		param.put("personalName", info.getBaseInfo().getPersonalName());
		param.put("personalIdCard", info.getBaseInfo().getPersonalIDCard());
		param.put("nationId", info.getBaseInfo().getNationId());
		param.put("personalPhone",info.getBaseInfo().getPersonalPhone());
		param.put("qq", info.getBaseInfo().getQq());
		param.put("personalEmail", info.getBaseInfo().getPersonalEmail());
		param.put("homeTown", info.getBaseInfo().getHomeTown());
		param.put("houseAddress", info.getBaseInfo().getHouseAddress());
		param.put("education", info.getBaseInfo().getEducation());
		param.put("graduatedDATE", info.getBaseInfo().getGraduatedDATE());
		param.put("emerName", info.getEmerName());
		param.put("emerPhone", info.getEmerPhone());
		param.put("staffNo", info.getStaffNo());
		param.put("startDate", StringUtils.fromtDate(null, info.getStartDate()));
		param.put("endDate", null);
		
		param.put("deptId", 			deptId);
		param.put("postId", 			postId);
		param.put("joinDate", 			joinDate);
		param.put("result", 1);
		
		getSqlSession().selectOne("StaffInfoDaoImpl.editStaff",param);
		IntegerAndString.StringToInt(param.get("result").toString(), -1);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	
	
	@Override
	public int quit(StaffInfo info) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sid",	info.getId());
		getSqlSession().selectOne("StaffInfoDaoImpl.staffQuit",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
	
	
	
}
