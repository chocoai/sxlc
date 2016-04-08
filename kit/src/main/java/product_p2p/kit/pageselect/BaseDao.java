package product_p2p.kit.pageselect;

import java.util.List;
import java.util.Map;

/**
 * 所以接口的父接口
 * @author sxlc-08
 *
 * @param <T>
 */
public interface BaseDao {
	
	public List selectPageE(String name,PageEntity pageEntity);
	/**
	 * 根据条查询，返回存在于数据库中
	 * 2016-1-20
	 * @author lsf
	 * @description
	 * @param name
	 * @return int
	 */
	public boolean selectCount(String name,Map map);
	
}
