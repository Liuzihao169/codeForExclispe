 package day20.demo.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapMapEntrySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String>javaee=new HashMap<String,String>();
		HashMap<String,String>javase=new HashMap<String,String>();
		javaee.put("��", "01");
		javaee.put("��", "02");
		javase.put("��", "001");
		javase.put("��", "002");
		HashMap<String,HashMap<String,String>>hj=new HashMap<String,HashMap<String,String>>();
		hj.put("������", javaee);
		hj.put("��ҵ��", javase);
		System.out.println(hj); 
		System.out.println("-------------�ָ���-------------");
		Set<Entry<String,HashMap<String,String>>> ClassName=hj.entrySet();
	          Iterator<Entry<String, HashMap<String, String>>>it=ClassName.iterator();
		      while(it.hasNext()){
		    	  //�Ǹ�Entry����ֵ�Թ�ϵ�Ķ���
		    	Entry<String, HashMap<String, String>>StudentName=it.next();
		    	String ClsssnameKey=StudentName.getKey();
		    	HashMap<String,String>StudentId=StudentName.getValue();
		    	Set<Entry<String, String>>SetEntry=StudentId.entrySet();
		    	Iterator<Entry<String, String>> it1=SetEntry.iterator();
		    	while(it1.hasNext()){
		    	    Entry<String,String>Entry=it1.next();
		    	    String Key=Entry.getKey();
		    	    String Value=Entry.getValue();
		    	    System.out.println(ClsssnameKey+"---"+Key+"---"+Value);
		    		
		    		
		    	}
		    		
		    	}
		    	
		    	  
		      }
		
	}


