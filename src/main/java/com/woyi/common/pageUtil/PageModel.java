package com.woyi.common.pageUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页的实体类（入参）
 * @ClassName  PageModel 
 * @Description  TODO
 * @author  jfli@woyitech.com
 * @date  2016年5月27日 下午1:41:30
 */
public class PageModel implements Serializable {

	private static final long serialVersionUID = 4703719675957589144L;
	// -- 分页参数 --//
	/**
	 * 页码 从1开始 如果传值小于1，则被置为1
	 */
	private int pageNo = 1;
	/**
	 * 每页大小 pageSize 小于等于0代表不分页
	 */
	private int pageSize = 10;
	/**
	 * 排序字段对象列表 为null代表不排序
	 */
	private List<SortOrder> sortOrders;
	
	/**
	 * 构造器
	 * @Title PageModel
	 * @Description TODO
	 */
	public PageModel() {
		super();
	}
	/**
	 * 
	 * @Title PageModel
	 * @Description TODO 
	 * @param pageNo
	 * @param pageSize
	 */
	public PageModel(int pageNo, int pageSize) {
		if(pageNo <= 0){
			pageNo = 1;
		}
		if(pageSize <= 0){
			pageSize = 10;
		}
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	/**
	 * PageModel带参数的构造方法
	 * @param pageNo 页码 从1开始
	 * @param pageSize 每页大小 pageSize 小于等于0代表不分页
	 * @param sortNames 排序字段对象列表 组织形式为排序字段与排序方式按循序放入 如 id,desc,customerId,asc
	 */
	public PageModel(int pageNo, int pageSize,
			String... sortNames) {
		setPageNo(pageNo);
		this.pageSize = pageSize;
		String[] sortStr = sortNames.clone();
		sortOrders = new ArrayList<SortOrder>();
		for (int i = 0; i < sortStr.length; i = i + 2) {
			SortOrder sortOrder = new SortOrder(sortStr[i], sortStr[i + 1]);
			sortOrders.add(sortOrder);
		}
	}
	/**
	 * 此方法描述的是：排序字段的设置 输入方法（sortStr，sortRule）为一组 com.woyi.common.pageUtil.OrderByEnum
	 * @author: jfli@woyitech.com
	 * @version: 2016年2月26日 下午5:28:09
	 */
	public void setSortOrders(String... sortNames) {
		String[] sortStr = sortNames.clone();
		sortOrders = new ArrayList<SortOrder>();
		for (int i = 0; i < sortStr.length; i = i + 2) {
			SortOrder sortOrder = new SortOrder(sortStr[i], sortStr[i + 1]);
			sortOrders.add(sortOrder);
		}
	}
	/**
	 * 获取排序字段
	 * @Title  getSortOrders 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  List<SortOrder>
	 */
	public List<SortOrder> getSortOrders() {
		return sortOrders;
	}
	/**
	 * set排序
	 * @Title  setSortOrders 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param sortOrders
	 */
	public void setSortOrders(List<SortOrder> sortOrders) {
		this.sortOrders = sortOrders;
	}
	/**
	 * 获得当前页的页号,序号从1开始,默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}
	/**
	 * get分页大小
	 * @Title  getPageSize 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  int
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * set 分页大小
	 * @Title  setPageSize 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param pageSize
	 * @return
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
