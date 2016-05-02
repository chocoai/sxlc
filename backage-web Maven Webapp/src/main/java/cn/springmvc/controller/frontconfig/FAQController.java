
package cn.springmvc.controller.frontconfig; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
import cn.springmvc.service.FrequentlyAskedQuestionsService;

@Controller
@RequestMapping("/question")
public class FAQController {

	@Autowired
	private FrequentlyAskedQuestionsService frequentlyAskedQuestionsService;
	
	/**
	 * 
	* query查询常见问题 
	* TODO查询常见问题
	* @author 杨翰林  
	* * @Title: query 
	* @Description: 查询常见问题 
	* @param @return 设定文件 
	* @return FrequentlyAskedQuestionsEntity 返回类型 
	* @date 2016-4-26 下午4:42:35
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public FrequentlyAskedQuestionsEntity query() {
		
		FrequentlyAskedQuestionsEntity entity = frequentlyAskedQuestionsService.selectFrequentlyAskedQuestionsList();
		return entity;
	}
	
	/**
	 * 
	* save添加修改常见问题 
	* TODO添加修改常见问题
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加修改常见问题 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 下午4:43:00
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		FrequentlyAskedQuestionsEntity frequentlyAskedQuestionsEntity = new FrequentlyAskedQuestionsEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String content = request.getParameter("content");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51201);
		entity.setlModuleId(512);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		if (!"".equals(content)) {
			int num = frequentlyAskedQuestionsService.insertFrequentlyAskedQuestions(frequentlyAskedQuestionsEntity, entity, sIpInfo);
			return num;
		}else {
			return 0;
		}
		
	}
}

