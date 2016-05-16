package com.makingwheel.controller.queryParams;

import com.makingwheel.common.QueryParameters;

public class CourseQueryParameters extends QueryParameters {
	private Long term;

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
	}
}
