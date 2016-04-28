

/** 
* @Title: ExtensionModuleService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:10:45 
* @version V5.0 */
 
package cn.springmvc.service; 
  
import java.util.List;
import java.util.Map;

import cn.invitemastermng.model.FirstInvestRedpacketsSetEntity;
import cn.invitemastermng.model.MemberRedpacketsSetEntity;
import cn.invitemastermng.model.RedpacketsAffairEntity;
import cn.invitemastermng.model.RedpacketsDetailRecordEntity;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:10:45  */

public interface ExtensionModuleGiftService { 
	
	//*************红包赠送配置***************//
	/**
	 * 分页查询会员首次投资红包赠送配置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page {statu :-1全部 ， 0：无效 ，1：有效}
	 * @return void 返回类型 
	 * @date 2016-4-18 下午4:07:57
	 */
	public void selectFIInvestRedSetList(PageEntity page);
	/**
	 * 根据ID查询会员首次投资红包赠送配置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param firpID
	 * @param @return 设定文件 
	 * @return FirstInvestRedpacketsSetEntity 返回类型 
	 * @date 2016-4-18 下午3:36:38
	 */
	public FirstInvestRedpacketsSetEntity selectFIInvestRedSetByID(long firpID);
	/**
	 * 会员首次投资红包赠送配置表设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * invest_Amount:投资金额
	 * rp_Rate:赠送比例
	 * lId:新增传0或者需要修改的ID
	 * @param @return 设定文件 
	 * @return int 返回类型 (0：失败，1：成功)
	 * @date 2016-4-18 上午9:19:33
	 */
	public int FirstInvestRedpacketsSet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 会员首次投资红包赠送配置表删除 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param FIRPID
	 * @param @return 设定文件 
	 * @return int 返回类型  (0：失败，1：成功)
	 * @date 2016-4-18 上午9:36:14
	 */
	public int deleteFirstInvestRedpacketsSet(int FIRPID,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	
	/**
	 * 查询会员红包赠送配置表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return MemberRedpacketsSetEntity 返回类型 
	 * @date 2016-4-18 下午2:58:58
	 */
	public MemberRedpacketsSetEntity selectMemberRedpacketsSet(); 
	
	/**
	 * 会员红包赠送配置表设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * open_Account:新注册会员开户赠送金额
	 * first_Recharge:首次充值赠送红包金额 
	 * @param @return 设定文件 
	 * @return int 返回类型   (0：失败，1：成功)
	 * @date 2016-4-18 上午9:44:02
	 */
	public int MemberRedpacketsSet(String openAccount,String firstRecharge,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	//*************赠送活动配置***************//
	/**
	 * 红包活动新增记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 *  startDate:活动开始时间
	 *	endDate:活动结束时间
	 *	userendDate:红包使用有效期
	 *	affairName:活动名称
	 *	giftAmount:红包金额，按照顺序组合成字符串
	 *	quantity:红包对应个数，顺序与红包金额一一对应 
	 * @param @return 设定文件 
	 * @return int 返回类型   (0：失败，1：成功)
	 * @date 2016-4-18 上午10:07:59
	 */
	public int RedpacketsAffairinsert(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 红包活动修改记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map 
	 * startDate:活动开始时间
	 * endDate:活动结束时间
	 * userendDate:红包使用有效期
	 * affairName:活动名称
	 * giftAmount:红包金额，按照顺序组合成字符串，只传入需要修改的数据或者对应个数有修改的数据
	 * quantity:红包对应个数，顺序与红包金额对应，只传入需要修改的数据或者对应金额有修改的数据
	 * detailID:活动红包明细记录ID，根据红包金额的顺序传入相应明细记录ID
	 * affairID:需要修改的红包活动记录ID
	 * @param @return 设定文件 
	 * @return int 返回类型  (0：失败，1：成功)
	 * @date 2016-4-18 上午10:19:55
	 */
	public int RedpacketsAffairupdate(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 红包活动发布 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param affairID:需要修改的红包活动记录ID
	 * @param @return 设定文件 
	 * @return int 返回类型  (0：失败，1：成功)
	 * @date 2016-4-18 上午11:46:09
	 */
	public int RedpacketsAffairrelease(long affairID,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 红包活动记录查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page
	 * #{CreateTime_Min} #{CreateTime_Max} #{Start_Date_Min}
	 * #{Start_Date_Max} #{End_Date_Min}   #{End_Date_Max}  
	 * #{Statu} #{orderDsec 1升序，0降序}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-16 下午3:27:46
	 */
	public void getRedpacketsAffair(PageEntity page);
	/**
	 * 红包领取明细查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page
	 * #{Affair_ID}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-16 下午3:31:33
	 */
	public void getRedpacketsreceive(PageEntity page);
	/**
	 * 根据ID查询红包活动记录详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param affairID 红包活动ID
	 * @param @return 设定文件 
	 * @return RedpacketsAffairEntity 返回类型 
	 * @date 2016-4-16 下午3:27:46
	 */
	public  RedpacketsAffairEntity  selectRedpacketsAffairbyID(long affairID);
	/**
	 * 根据红包活动ID查询活动红包明细纪录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param affairID 红包活动ID
	 * @param @return 设定文件 
	 * @return List<RedpacketsDetailRecordEntity> 返回类型 
	 * @date 2016-4-20 下午5:06:15
	 */
	public  List<RedpacketsDetailRecordEntity> selectRedpacketsDetailbyaffairID(long affairID);
	
}	

