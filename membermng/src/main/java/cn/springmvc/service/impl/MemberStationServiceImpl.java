

/** 
* @Title: MemberStationServiceImpl.java 
* @Package cn.memberstation.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午4:52:15 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List; 
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.membermng.model.MemberStationLetterEntity;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MemberStationDaoImpl;
import cn.springmvc.dao.impl.MemberStationListDaoImpl;
import cn.springmvc.service.MemberStationService;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description: 会员站内信
 * @since 
 * @date 2016-3-29 下午4:52:15  */
@Service("memberStationServiceImpl")
public class MemberStationServiceImpl implements MemberStationService {
	@Resource(name="memberStationDaoImpl")
	private MemberStationDaoImpl memberStationDaoImpl;
	@Resource(name="memberStationListDaoImpl")
	private MemberStationListDaoImpl memberStationListDaoImpl;
	
	@Override
	public int deleteSendStationLetter(List<Integer> list) {

		if(list == null) {
			return -1;
		}
        return memberStationDaoImpl.deleteSendStationLetter(list);
	}

	@Override
	public int deleteRecStationLetter(List<Integer> list) {

		if(list == null) {
			return -1;
		}
        return memberStationDaoImpl.deleteRecStationLetter(list);
	}

	@Override
	public int updateRecStationReadlist(List<Integer> list) {

		if(list == null) {
			return -1;
		}
        return memberStationDaoImpl.updateRecStationReadlist(list);
	}

	@Override
	public int updateRecStationNotReadlist(List<Integer> list) {

		if(list == null) {
			return -1;
		}
        return memberStationDaoImpl.updateRecStationNotReadlist(list);
	}

	@Override
	public int addStationLetter(
			MemberStationLetterEntity memberStationLetterEntity) {

		if(memberStationLetterEntity == null) {
			return -1;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		memberStationLetterEntity.setLetterID(id);
		
		int result =  memberStationDaoImpl.addStationLetter(memberStationLetterEntity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
        return memberStationDaoImpl.addStationLetter(memberStationLetterEntity);
	}

	@Override
	public List<MemberStationLetterEntity> selectSendLetter(PageEntity pageEntity) {

		return memberStationListDaoImpl.selectSendLetter(pageEntity);

	}

	@Override
	public List<MemberStationLetterEntity> selectRecLetter(
			PageEntity pageEntity) {

		return memberStationListDaoImpl.selectRecLetter(pageEntity);

	}

	@Override
	public MemberStationLetterEntity selectSendLetterDetail(Map<String,Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return memberStationListDaoImpl.selectSendLetterDetail(map);

	}

	@Override
	public MemberStationLetterEntity selectRecLetterDetail(Map<String,Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return memberStationListDaoImpl.selectRecLetterDetail(map);

	}

	@Override
	public long selectMemberID(String logname) {

		return memberStationListDaoImpl.selectMemberID(logname);

	}

	@Override
	public int updateRecStationRead(int letterID) {
		
		return memberStationDaoImpl.updateRecStationRead(letterID);
		
	}

}

