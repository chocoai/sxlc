package cn.springmvc.controller.common; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.AccountEscrowInterfaceEntity;
import cn.springmvc.service.ChannelSetService;

/**
 * @author pengran
 *  公共控制层  用于 添加之前或者查询用的选择列表
 * @date:2016-5-13 上午10:23:54
 **/

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private ChannelSetService channelSetService;
	
	/**
	 * 查询托管平台接口类型
	 * TODO
	 * 创建日期：2016-5-13上午10:13:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/AccountEscrow", method = RequestMethod.POST)
	@ResponseBody
	public List<AccountEscrowInterfaceEntity> AccountEscrow(HttpServletRequest request){
		List<AccountEscrowInterfaceEntity> list =  channelSetService.TypeAccountInterface();
		return list;
	}
}

