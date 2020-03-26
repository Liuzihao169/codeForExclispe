package day20.demo.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EntrySetDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map= new HashMap <String,Integer>();
		map.put("a", 10);
		map.put("b", 11);
		map.put("c", 12);
		map.put("d", 13);
		Set<Map.Entry<String, Integer>>set=map.entrySet();
		Iterator<Entry<String,Integer>> it= set.iterator();
		while(it.hasNext()){
			Entry <String,Integer>entry=it.next();
			  String key=entry.getKey();
			  Integer value=entry.getValue();
			  System.out.println(key+value);
		}

	}

}
