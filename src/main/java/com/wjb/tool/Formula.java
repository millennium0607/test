package com.wjb.tool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 通用公式
 * @author millennium
 *
 */
public class Formula {
	
	public static <T> boolean isEmptyList(List<T> list) {
		if (list==null||list.isEmpty()) 
			return true;
		return false;
	}
	
	public static <T> boolean isEmptySet(Set<T> set) {
		if (set==null||set.isEmpty()) 
			return true;
		return false;
	}
	
	public static <K,V> boolean isEmptyMap(Map<K, V> map) {
		if (map==null||map.isEmpty()) 
			return true;
		return false;
		
	}
	
}
