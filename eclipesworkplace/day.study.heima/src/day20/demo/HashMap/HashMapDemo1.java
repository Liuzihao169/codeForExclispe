package day20.demo.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//founction();//KeySet()遍历
		//System.out.println("----------------------");
	//	founction_1();//entrySet()遍历
	//	System.out.println("----------------------");
		//founction_3();
		//System.out.println("-----------------------");
		founction_4();

	}

	private static void founction_4() {
		// TODO Auto-generated method stub
		Map<People,String> map=new HashMap <People,String>();
		map.put(new People("liu",15),"beijing");
		map.put(new People("zi",16),"shanghai");
		map.put(new People("liu",18),"guangzhou");
		map.put(new People("liu",18),"guangzhou");
		System.out.println("---------KeySet 增强For---------");
		for( People p1:map.keySet()){//使用keyset来储存键值对。
			People key= p1;
			String valeu=map.get(p1);
			System.out.println(p1+"---"+valeu);
			
		}
		System.out.println("-------------entry for--------");
		for(Entry<People,String>entry:map.entrySet()){
			People Key=entry.getKey();
			String Value=entry.getValue();
			System.out.println(Key+"---"+Value);
			
		}
	}

	private static void founction_1() {
		// TODO Auto-generated method stub
		Map<String,People> map=new HashMap <String,People>();
		map.put("a", new People("liu",18));
		map.put("b", new People("zi",12));
		map.put("c", new People("hao",23));
		Set<Entry<String,People>>set=map.entrySet();
	  Iterator <Entry<String,People>>it=	set.iterator();
	  while(it.hasNext()){
		  Entry<String,People> entry=it.next();
		  //String Key=entry.getKey();
		  People p1=entry.getValue();
		  System.out.println(p1);
	  }
	  System.out.println("-----------增强forla----------");
	  for(Entry<String,People> entry:map.entrySet()){
		  System.out.println(entry.getValue());
		  
	  }
	
	}

	private static void founction() {
		// TODO Auto-generated method stub
		Map<String,People> map=new HashMap <String,People>();
		map.put("a", new People("liu",18));
		map.put("b", new People("zi",19));
		map.put("c", new People("hao",20));
       Set<String> set=map.keySet();
       Iterator<String>it=set.iterator();
       while(it.hasNext()){
    	   People p1=map.get(it.next());//
    	   System.out.println(p1);
    	   }
       System.out.println("-----------------增强for-------");
       for(String Key:map.keySet()){
    	   System.out.println(map.get(Key));
       }
       }
	
       
	private static void founction_3() {
		int []arr={3,5,4,8,9};
		for(int i:arr){
			System.out.println(i);
		}

}}
