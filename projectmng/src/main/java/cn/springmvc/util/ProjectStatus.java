package cn.springmvc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import cn.springmvc.model.ProjectAppRecordEntity;

/**
 * 判断项目状态
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-5-9 下午7:45:57
 */
public class ProjectStatus {
	private static Logger log = Logger.getLogger(ProjectStatus.class);
	
	/**
	 * 	判断项目状态
	* GetProjectStatus			判断项目状态
	* TODO(描述)
	* @author 张友  
	* * @Title: GetProjectStatus 
	* @Description: TODO 
	* @param entity				项目对象
	* @param @return 			项目状态 
	* @return int				1：预热中 	2：投标中(融资中) 	3：还款中		4：已结清		5：投标完成		6：流标	7：申请失败
	* @date 2016-5-9 下午7:46:13
	* @throws
	 */
	public static int GetProjectStatus(ProjectAppRecordEntity entity){
		int iResult = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(entity == null){
			return iResult;
		}
		try {
			Date startTime 	= sdf.parse(entity.getStartDate());		//项目开标时间
			Date cTime 		= new Date();										//系统当前时间
			Date endTime 	= sdf.parse(entity.getEndDate());			//投资最晚时间
			//重新定义项目状态
			if(entity.getInvestStatu() == 0 && startTime.after(cTime)){
				//预热中
				iResult = 1;
			}else if(entity.getInvestStatu() == 0 && startTime.after(cTime) && entity.getInvestRate() < 1000000){
				//投标中(融资中)
				iResult = 2;
			}else if(entity.getInvestStatu() == 2 || (entity.getInvestStatu() == 0 && entity.getInvestRate() >= 1000000)
					|| (entity.getCheckStatu() == 1 && entity.getPublishStatu() == 2 && entity.getInvestStatu() == 0 && (endTime.after(cTime) || endTime.equals(cTime)))){
				//投标完成
				iResult = 5;
			}else if(entity.getInvestStatu() == 1 || entity.getInvestStatu() == -3){
				//流标
				iResult = 6;
			}else if(entity.getCheckStatu() == -1){
				//申请失败
				iResult = 7;
			}else if(entity.getInvestStatu() == 3 || entity.getInvestStatu() == 4){
				//还款中 3 Or 已结清 4
				iResult = entity.getInvestStatu();
			}else{
				iResult = entity.getInvestStatu();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("GetProjectStatus:"+e.getStackTrace());
		}
		
		return iResult;
	}
}
