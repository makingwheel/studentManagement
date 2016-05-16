package com.makingwheel.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.ConvertUtils;

public class BeanUtils {

	public static <T> T counstruct(Object[] objects, Class<T> c) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T t = c.getConstructor().newInstance();
		List<FieldEntry> fieldEntries = new ArrayList<>();
		for (Method m : c.getMethods()) {
			SortField sortField = m.getAnnotation(SortField.class);
			if (sortField != null) {
				fieldEntries.add(new FieldEntry(sortField.value(), m));
			}
		}
		fieldEntries = fieldEntries.stream().sorted((y, x) -> x.sort - y.sort).collect(Collectors.toList());
		for (int i = 0, length = fieldEntries.size(); i < length; i++){
			fieldEntries.get(i).method.invoke(t, coverToType(objects[i], (fieldEntries.get(i).method.getParameterTypes())[0]));			
		}
			return t;
	}

	@SuppressWarnings("unchecked")
	private static <T> T coverToType(Object source , Class<T> type){
		return null == source ? null : (T)ConvertUtils.convert(source, type);
	}
	
	private static class FieldEntry {
		private int sort;

		private Method method;

		FieldEntry(int sort, Method method) {
			this.sort = sort;
			this.method = method;
		}
	}
}
