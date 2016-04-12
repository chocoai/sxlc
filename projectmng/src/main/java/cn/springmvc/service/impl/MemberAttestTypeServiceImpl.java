package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.MemberAttestTypeDao;
import cn.springmvc.dao.MemberAttestTypeListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MemberAttestTypeDaoImpl;
import cn.springmvc.dao.impl.MemberAttestTypeListDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.service.MemberAttestTypeService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
/**
 * 
* @author 刘利 
* @Description: 会员借款认证项
* @since 
* @date 2016-3-18 下午8:07:23
 */
@Service("memberAttestTypeServiceImpl")
public class MemberAttestTypeServiceImpl implements MemberAttestTypeService {
	@Resource(name="memberAttestTypeDaoImpl")
	private MemberAttestTypeDao memberAttestTypeDaoImpl;  
	@Resource(name="memberAttestTypeListDaoImpl")
	private MemberAttestTypeListDao memberAttestTypeListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteMemberAttestTypeByID(int id,InsertAdminLogEntity entity, String[] sIpInfo) {
		
		int result=memberAttestTypeDaoImpl.deleteMemberAttestTypeByID(id);
		if(result == 1) {
			entity.setsDetail("删除借款认证类型");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMemberAttestTypeByID(MemberAttestTypeEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的会员认证类型是否存在,如果已存在则不插入  
		MemberAttestTypeEntity memberAttestTypeEntity= memberAttestTypeListDaoImpl.selectMemberAttestTypeIsExistByNAme(entity);
		if(memberAttestTypeEntity != null){
			return -1;
		} 
		int result=memberAttestTypeDaoImpl.updateMemberAttestTypeByID(entity); 
		if(result == 1) {
			entityLog.setsDetail("修改借款认证类型"+entity.getAttestTypeName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMemberAttestTypeStatuByID(MemberAttestTypeEntity entity) {
		if(entity == null){
			return 0;
		}  
		int result=memberAttestTypeDaoImpl.updateMemberAttestTypeStatuByID(entity); 
		return result;
	}

	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestTypeListpage(
			PageEntity pageEntity) {
		
		List<MemberAttestTypeEntity> memberAttestTypeList=new ArrayList<MemberAttestTypeEntity>();    
	 	memberAttestTypeList = memberAttestTypeListDaoImpl.selectMemberAttestTypeAllpage(pageEntity);  
		return memberAttestTypeList; 
	}

	@Override
	public int insertMemberAttestType(MemberAttestTypeEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的会员认证类型是否存在,如果已存在则不插入  
		MemberAttestTypeEntity memberAttestTypeEntity= memberAttestTypeListDaoImpl.selectMemberAttestTypeIsExistByNAme(entity);
		if(memberAttestTypeEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setAttestTypeID((int)id);
		int result =  memberAttestTypeDaoImpl.insertMemberAttestType(entity); 
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		} 
		if(result == 1) {
			entityLog.setsDetail("添加借款认证类型"+entity.getAttestTypeName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public MemberAttestTypeEntity selectMemberAttestTypeById(int id) {
		 if(id == 0){
			return null;
		 } 
		 MemberAttestTypeEntity memberAttestTypeEntity= memberAttestTypeListDaoImpl.selectMemberAttestTypeIsExistById(id);
		 return memberAttestTypeEntity;
	}

	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestTypeByMemberType(
			MemberAttestTypeEntity entity) {
		
		List<MemberAttestTypeEntity> memberAttestTypeList=new ArrayList<MemberAttestTypeEntity>();    
	 	memberAttestTypeList = memberAttestTypeListDaoImpl.selectMemberAttestTypeByMemberType(entity);  
		return memberAttestTypeList; 
		
	} 
}
