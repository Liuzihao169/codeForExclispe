package day20.demo.Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         foution();

	}
	private static void foution() {
		// TODO Auto-generated method stub
		Map<String,Integer>map=new HashMap <String,Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d",4);
		System.out.println(map);
		System.out.println(map.get("a"));
	}

}
