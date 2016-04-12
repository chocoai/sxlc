 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.CompanyInfoEntity;
import cn.membermng.model.MemberInfoEntity;
import cn.membermng.model.PersonalBaseInfoEntity;

/** 
 * @author 刘利 
 * @Description: 会员信息查询实体
 * @since 
 * @date 2016-3-21 上午9:18:25  */

public interface MemberInfoList {
	/**
	 * 分页查询会员信息
	 * @param pageEntity 分页实体类
	 * @return 会员信息
	 */
	public List<MemberInfoEntity> selectMemberInfoAllpage(
			PageEntity pageEntity);
	/** 
	 * 查询借款个人会员基本信息 
	 * @author 刘利   
	 * @Description: 查询借款个人会员基本信息 
	 * @param personID 会员基本信息ID
	 * @return PersonalBaseInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public PersonalBaseInfoEntity selectMemberInfoPersonByID(long personID);
    /** 
	 * 查询借款企业会员基本信息 
	 * @author 刘利   
	 * @Description: 查询借款企业会员基本信息 
	 * @param personID 会员基本信息ID
	 * @return PersonalBaseInfoEntity 会员信息实体 
	 * @date 2016-3-21 下午3:26:08 
	 */
    public CompanyInfoEntity selectMemberInfoCompanByID(long personID);
}

