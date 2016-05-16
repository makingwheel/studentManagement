package com.makingwheel.common;

import java.util.Collection;

public class CollectionUtils {

	public static boolean validate(Collection<?> collection){
		return null != collection && collection.size() > 0;
	}
}
