package cn.springmvc.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.SystemSetService;
/**
 * 
* @author 杨翰林
* @Description: 自动投标控制层 
* @since 
* @date 2016-4-13 下午2:54:56
 */
@Controller
@RequestMapping("/auto")
public class AutomaticbidController {
	
	@Autowired
	private SystemSetService systemSetService;
	
	/**
	 * 
	* msg查询系统设置 
	* TODO查询系统设置
	* @author 杨翰林  
	* * @Title: msg 
	* @Description: 查询系统设置 
	* @param @return 设定文件 
	* @return SystemSetEntity 返回类型 
	* @date 2016-4-13 下午2:57:31
	* @throws
	 */
	@RequestMapping("/msg")
	@ResponseBody
	public SystemSetEntity msg() {
		
		SystemSetEntity systemEntity = systemSetService.
				findSystemSet();
		
		return systemEntity;
	}
	
	/**
	 * 
	* update修改自动投标成功后返还百分比 
	* TODO修改自动投标成功后返还百分比
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改自动投标成功后返还百分比 
	* @param @param autoBackRate
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-13 下午2:58:08
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(String autoBackRate) {
		
		SystemSetEntity systemSetEntity = new SystemSetEntity();
		
		if (autoBackRate != null && autoBackRate != "") {
			systemSetEntity.setSautoBackRate(autoBackRate);
		}
		systemSetEntity.setEndDateRemind(-1);
		systemSetEntity.setExpirationReminderSet(-1);
		systemSetEntity.setOverdueInsteadDay(-1);
		systemSetEntity.setRedpacketsRateMax(-1);
		systemSetEntity.getRiskMarginType();
		
		int num = systemSetService.updateSystemSet(systemSetEntity, null, null);
		
		return num;
	}

}

