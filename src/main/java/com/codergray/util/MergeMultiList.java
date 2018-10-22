package com.codergray.util;

import java.util.HashMap;
import java.util.Map;

public class MergeMultiList {

	public static void main(String[] args) {
		Map<String, Integer> testMap = new HashMap();
		
		testMap.put("one" , 1);
		testMap.put("two" , 2);
		testMap.put("three" ,testMap.get("three")+1);
		System.out.println(testMap.get("one" ));
		System.out.println(testMap.get("two"));
		System.out.println(testMap.get("three"));

	}

}
