package product_p2p.kit.pageselect;

import java.util.Map;

import java.util.List;
/**
 * 分页实体对象
 * @author sxlc-08
 *
 * @param <T>
 */
public class PageEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页
	 */
	private int pageNum=1;
	/**
	 * 当前页大小
	 */
	private int pageSize=15;
	/**
	 * 总条数
	 */
	private long tatalNum;
	/**
	 * 总页数
	 */
	private long tatalPage;
	/**
	 * 条件查询
	 */
	private Map map;
	/**
	 * 返回结果集
	 */
	private List results;
	/**
	 * 排序关键字
	 */
	private String orderKey;
	
	/**
	 * 当前页行数
	 */
	private int length;
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	/**
	 * @author sxlc-08
	 * 排序值
	 * asc 升序
	 * desc 降序
	 */
//	public enum EnumOrder{ase,desc}
//	public enum EnumOrder{asc,desc}
	/**
	 * 排序，默认为asc
	 */
	private  String enumOrder="asc";
	public String getEnumOrder() {
		return enumOrder;
	}
	/**
	 * 通过枚举赋值
	 * 2016-1-7
	 * @author lsf
	 * @description
	 * @param enumorder void
	 */
	public void setEnumOrder(int iOrderType) {
		switch (iOrderType) {
		case 0:
			enumOrder="desc";
			break;
		default:
			enumOrder="asc";
			break;
		}
	}
	/**
	 * 通过String 赋值
	 * 2016-1-7
	 * @author lsf
	 * @description
	 * @param enumorder void
	 */
	public void setEnumOrder(String enumorder) {
		this.enumOrder=enumorder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
		this.tatalNum = results.size();
		this.tatalPage = this.tatalNum%pageSize==0?this.tatalNum/pageSize:this.tatalNum/pageSize+1;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTatalNum() {
		return tatalNum;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * 赋值总条数 并计算总页数
	 * 2016-1-7
	 * @author lsf
	 * @description
	 * @param l void
	 */
	public void setTatalNum(long l) {
		this.tatalNum = l;
		setTatalPage(l%pageSize==0?l/pageSize:l/pageSize+1);
	}
	
	public long getTatalPage() {
		return tatalPage;
	}
	public void setTatalPage(long tatalPage) {
		this.tatalPage = tatalPage;
	}
	//	@Override
	public String toString() {
		return "PageEntity [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", tatalNum=" + tatalNum + ", tatalPage=" + tatalPage
				+ ", map=" + map + ", results=" + results + ", orderKey="
				+ orderKey + ", enumOrder=" + enumOrder + "]";
	}
}
