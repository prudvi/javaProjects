package com.demo.inbuiltClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapValueSortingJava8 {

	HashMap<Integer,Integer> followLikeCount=new HashMap<Integer,Integer>();

	//Map followLikeCount = new HashMap();
	
	followLikeCount.put(1,2);
	followLikeCount.put(1,2);
	List<Map.Entry<Integer, Integer>> list = (List<Entry<Integer, Integer>>) followLikeCount.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
}
