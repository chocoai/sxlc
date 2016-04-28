

/** 
* @Title: NewbieExperienceService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:16:47 
* @version V5.0 */
 
package cn.springmvc.service; 
 
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.invitemastermng.model.NewbieExperienceSetEntity;

/** 
 * @author 刘利 
 * @Description: 新手体验标 
 * @since 
 * @date 2016-4-15 下午2:16:47  */

public interface NewbieExperienceService {
	/**
	 * 会员体验收益获取记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * #{skey}					#{Member_No}	#{Logname}
	 * #{Personal_Name}			#{Reg_Date_Min}	#{Reg_Date_Max}
	 * #{Experience_Date_Max}	#{Statu}		#{ordercolumn}
	 * #{Experience_Date_Min}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-15 下午2:14:04
	 */
	public void getExperienceIncome(PageEntity page);
	/**
	 * 新手体验标设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 *  {project_ID:体验标类型(项目类型)
	 *	Experience_Name:体验标标题
	 *	Experience_Describe:体验标描述
	 *	Experience_Url:体验标图片路径
	 *	Repay_Way:体验产品还款方式
	 *	Year_Rate:体验产品年化收益率
	 *	Deadline:借款期限
	 *	Deadline_Type:期限类型
	 *	Vouchers_Amount:投资即得代金券面值
	 *	Statu:1启用0停用}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 下午2:31:15
	 */
	public int NewbieExperienceSet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 查询新手体验标设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return NewbieExperienceSetEntity 返回类型 
	 * @date 2016-4-19 下午3:34:30
	 */
	public NewbieExperienceSetEntity  getNewbieExperienceSet();
}

