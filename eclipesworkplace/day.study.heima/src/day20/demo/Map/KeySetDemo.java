package day20.demo.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KeySetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer>map=new HashMap <String,Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d",4);
	Set<String>set=	map.keySet();
	 Iterator<String>it=set.iterator();
	 while(it.hasNext()){
		 String key=it.next();
		 Integer value=map.get(key);
		 System.out.println(key+"------"+value);
	 }
	

	}

}
