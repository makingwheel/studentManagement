package com.makingwheel.common;

public class QueryParameters {

	private Integer limit;
	
	private Integer offset;

	public Integer getFirstResult(){
		return (offset - 1) / limit;
	}
	
	public Integer getLimit() {
		return limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
