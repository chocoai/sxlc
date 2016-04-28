
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.integralmall.model.CommodityInfo;
import cn.integralmall.model.CommodityType;
import cn.integralmall.model.ShippingAddress;
import cn.springmvc.dao.IIntegrallServiceReadDao;
import cn.springmvc.dao.IIntegrallServiceWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.IIntegrallService;

@Repository
public class IntegrallServiceImpl implements IIntegrallService {
	
	@Resource(name="integrallServiceReadDaoImpl")
	private IIntegrallServiceReadDao integrallServiceReadDao;
	
	@Resource(name="integrallServiceWriteDaoImpl")
	private IIntegrallServiceWriteDao integrallServiceWriteDao;
	
	
	
	
	
	
	public List<CommodityType> indexList() {
		List<CommodityType> list = integrallServiceReadDao.indexList();
		for (int i = 0; i < list.size(); i++) {
			List<CommodityInfo> goods = integrallServiceReadDao.goodsTop4(list.get(i).getCommodityTypeId());
			list.get(i).setGoods(goods);
		}
		return list;
	}
	
	
	public List<CommodityInfo> goods(PageEntity entity) {
		
		return integrallServiceReadDao.goods(entity);
	}
	
	
	public CommodityInfo commodityInfo(long commodityId) {
		
		return integrallServiceReadDao.commodityInfo(commodityId);
	}
	
	
	public int saveShippingAddress(ShippingAddress address) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id	= generatorUtil.GetId();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sid", 				id);
		param.put("mid", 				address.getMemberId());
		param.put("contactName", 		address.getContactName());
		param.put("provinceId",	 		address.getProvince());
		param.put("cityId", 			address.getCity());
		param.put("countyId", 			address.getCounty());
		param.put("detailedAddress", 	address.getDetailedAddress());
		param.put("contactPhone", 		address.getContactPhone());
		param.put("deliveryChoice", 	address.getDeliveryChoice());
		param.put("isDefaultAddress", 	address.getiSDefaultAddress());
		int result = integrallServiceWriteDao.saveShippingAddress(param);
		
		if(result == 1){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}

	
	public int pointxchange(long memberId, long commodityId, int quantity,long addressId) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		param.put("orderId", id);
		param.put("mid", memberId);
		param.put("commodityId", commodityId);
		param.put("myquantity", quantity);
		param.put("addressId", addressId);
		int result = integrallServiceWriteDao.pointxchange(param);
		if(result == 1){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}
	
	
	public List<ShippingAddress> ShippingAddressList(long memberId) {
		
		return integrallServiceReadDao.ShippingAddressList(memberId);
	}
	
		
	public ShippingAddress ShippingAddressInfoById(long l) {
		
		return null;
	}
	
	
	public int editShippingAddress(ShippingAddress address) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sid", 				address.getAddressId());
		param.put("mid", 				address.getMemberId());
		param.put("contactName", 		address.getContactName());
		param.put("provinceId",	 		address.getProvince());
		param.put("cityId", 			address.getCity());
		param.put("countyId", 			address.getCounty());
		param.put("detailedAddress", 	address.getDetailedAddress());
		param.put("contactPhone", 		address.getContactPhone());
		param.put("deliveryChoice", 	address.getDeliveryChoice());
		param.put("isDefaultAddress", 	address.getiSDefaultAddress());
		return integrallServiceWriteDao.editShippingAddress(param);
	}
	
	
}

