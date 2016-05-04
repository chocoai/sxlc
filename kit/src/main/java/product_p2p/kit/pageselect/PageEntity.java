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
	
	
	private static final long serialVersionUID = 1L;
	private int pageNum=1;		//当前页
	private int pageSize=10;	//当前页大小
	private Map map;			// 条件查询
	private List results;		//返回结果集
	private String orderKey;	// 排序关键字
	private int draw;				//datatable传参所需
	private long recordsFiltered ;	//过滤总数据
	private long recordsTotal; 		//对应datatable返回参数总数据
	private long totalPage;			//总页数
	
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
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	//	@Override
	public String toString() {
		return "PageEntity [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", map=" + map + ", results=" + results + ", orderKey="
				+ orderKey + ", enumOrder=" + enumOrder + "]";
	}
}
