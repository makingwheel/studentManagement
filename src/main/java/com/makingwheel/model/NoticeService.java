package com.makingwheel.model;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;

public interface NoticeService {

	public PageResult queryByStatus(Integer status, QueryParameters queryParameters);
}
