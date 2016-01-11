package com.sven.util;

/**
 * @author Sven 分页处理
 * 2016.1.5
 */
public class Paging {

	/** 当前页 */
	private int currentPage;

	/** 每页显示记录数 */
	private int pageSize = 20;

	/** 总记录数 */
	private long recordCount = 1L;

	/** 总页数 */
	private int pageCount;

	/** 偏移数 */
	private int offset;

	/** 上一页 */
	private int prePage;

	/** 下一页 */
	private int nextPage;

	/** 是否有上一页 */
	private boolean hasPrePage;

	/** 是否有下一页 */
	private boolean hasNextPage;

	/** 返回码 */
	private int returnCode = 200;

	/** 返回码描述 */
	private String returnMessage = "";

	/** 返回对象 */
	private Object returnValue;

	/** 返回url地址 */
	private String returnUrl = "";

	/**
	 * 构造函数,计算总页数、是否有上一页、下一页等.
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页显示记录数
	 * @param recordCount
	 *            总记录数
	 * @param recordList
	 *            记录集合
	 */
	public Paging(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		if (currentPage < 1) {
			this.currentPage = 1;
		}

		this.pageSize = pageSize;

		// 偏移量
		this.offset = (this.currentPage - 1) * pageSize;
	}

	/**
	 * 根据总记录数初始化总页数，下一页， 上一页等参数
	 * 
	 * @param recordCount
	 */
	public void initiatePage(int recordCount) {
		// 上一页等于当前页减一
		this.prePage = this.currentPage - 1;
		if (this.prePage < 1) {
			this.hasPrePage = false;// 没有上一页
			this.prePage = 1;
		} else {
			this.hasPrePage = true;// 有上一页
		}

		// 计算总页数
		this.pageCount = (int) Math.ceil(recordCount / (double) pageSize);
		if (this.currentPage > this.pageCount) {
			this.currentPage = this.pageCount;
		}

		// 下一页等于当前页加一
		this.nextPage = this.currentPage + 1;
		if (this.nextPage > this.pageCount) {
			this.hasNextPage = false;// 没有下一页
			this.nextPage = this.pageCount;
		} else {
			this.hasNextPage = true;// 有下一页
		}
	}

	public Paging() {
	}

	public Paging(Object returnValue) {
		this.returnValue = returnValue;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public Object getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
