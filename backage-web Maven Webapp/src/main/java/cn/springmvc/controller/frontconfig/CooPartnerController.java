
package cn.springmvc.controller.frontconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.PartnersEntity;
import cn.springmvc.service.PartnersService;

import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林
* @Description: 合作伙伴控制层 
* @since 
* @date 2016-4-11 下午1:36:09
 */
@Controller
@RequestMapping("/coop")
public class CooPartnerController {
	
	@Autowired
	private PartnersService partnersService;
	
	/**
	 * 
	* list查询合作伙伴列表 
	* TODO查询合作伙伴列表 
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询合作伙伴列表  
	* @param @param req
	* @param @param start
	* @param @param length
	* @param @param name
	* @param @param statu
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-11 下午3:15:53
	* @throws
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, int start, int length,
			String name, String statu) {
		
		PageEntity pager = new PageEntity();
		
		if (name != null && name != "") {
			req.put("name", name);
		}
		if (statu != null && statu != "") {
			req.put("statu", statu);
		}else {
			req.put("statu", -1);
		}
		pager.setPageNum(start / length + 1);
		pager.setPageSize(length);
		pager.setMap(req);
		
		List<PartnersEntity> results = partnersService.selectPartnersList(pager);
		pager.setResults(results);
		
		return pager;
	}
	
	/**
	 * 
	* save添加合作伙伴 
	* TODO添加合作伙伴
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加合作伙伴 
	* @param @param logo
	* @param @param url
	* @param @param introduction
	* @param @param name
	* @param @param indexs
	* @param @param optId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:18:02
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(String logo, String url, String introduction, String name,
			String indexs, String optId) {
		
		PartnersEntity partNer = new PartnersEntity();
		
		if (name != null && name != "") {
			partNer.setName(name);
		}
		if (logo != null && logo != "") {
			partNer.setLogo(logo);
		}
		if (url != null && url != "") {
			partNer.setUrl(url);
		}
		if (introduction != null && introduction != "") {
			partNer.setIntroduction(introduction);
		}
		if (indexs != null && indexs != "") {
			partNer.setIndexs(Integer.valueOf(indexs));
		}
		if (optId != null && optId != "") {
			partNer.setOptId(Long.valueOf(optId));
		}
		
		int num = partnersService.insertPartners(partNer);
		return num;
	}
	
	/**
	 * 
	* update修改合作伙伴 
	* TODO修改合作伙伴 
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改合作伙伴  
	* @param @param logo
	* @param @param url
	* @param @param introduction
	* @param @param name
	* @param @param indexs
	* @param @param optId
	* @param @param partnerId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:17:34
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(String logo, String url, String introduction, String name,
			String indexs, String optId, String partnerId) {
		
		PartnersEntity partNer = new PartnersEntity();
		
		if (partnerId != null && partnerId != "") {
			partNer.setId(Long.valueOf(partnerId));
		}
		if (name != null && name != "") {
			partNer.setName(name);
		}
		if (logo != null && logo != "") {
			partNer.setLogo(logo);
		}
		if (url != null && url != "") {
			partNer.setUrl(url);
		}
		if (introduction != null && introduction != "") {
			partNer.setIntroduction(introduction);
		}
		if (indexs != null && indexs != "") {
			partNer.setIndexs(Integer.valueOf(indexs));
		}
		if (optId != null && optId != "") {
			partNer.setOptId(Long.valueOf(optId));
		}
		int num = partnersService.updatePartners(partNer);
		return num;
	}
	
	/**
	 * 
	* ofOrOpen启用停用合作伙伴 
	* TODO启用停用合作伙伴
	* @author 杨翰林  
	* * @Title: ofOrOpen 
	* @Description: 启用停用合作伙伴 
	* @param @param statu
	* @param @param partNerId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:22:57
	* @throws
	 */
	@RequestMapping("/ofOrOpen")
	@ResponseBody
	public int ofOrOpen(boolean statu, String partNerId) {
		
		PartnersEntity partNer = new PartnersEntity();
		
		partNer.setStatu(statu);
		if (partNerId != null && partNerId != "") {
			partNer.setId(Long.valueOf(partNerId));
		}
		
		int num = partnersService.updatePartnerStatuByID(partNer);
		return num;
	}
	
	/**
	 * 
	* query4update为修改查询单个实体  
	* TODO为修改查询单个实体 
	* @author 杨翰林  
	* * @Title: query4update 
	* @Description: 为修改查询单个实体  
	* @param @param partNerId
	* @param @return 设定文件 
	* @return PartnersEntity 返回类型 
	* @date 2016-4-11 下午4:26:12
	* @throws
	 */
	@RequestMapping("/query4update")
	@ResponseBody
	public PartnersEntity query4update (String partNerId){
		
		PartnersEntity partNer= partnersService.
				selectPartnerByID(Integer.valueOf(partNerId));
		return partNer;
	}
}

