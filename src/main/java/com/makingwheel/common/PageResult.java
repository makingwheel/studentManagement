package com.makingwheel.common;

public class PageResult {

	private Object rows;

	private Integer total = 10;

	public Object getRows() {
		return rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
}
