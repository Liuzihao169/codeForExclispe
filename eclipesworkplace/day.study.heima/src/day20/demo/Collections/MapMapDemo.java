package day20.demo.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapMapDemo {

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
		Keyset(hj);

	}

	private static void Keyset(HashMap<String,HashMap<String,String>>hj) {
		Set<String> ClassName=hj.keySet();
		 Iterator <String>it=ClassName.iterator();
		 while(it.hasNext()){
			 String StudentNameKey=it.next();//�õ�һ��HashMapjih
			 HashMap<String,String>StrdentNameID=hj.get(StudentNameKey);
			 Set<String>Strdent=StrdentNameID.keySet();
			 Iterator<String>it1=Strdent.iterator();
			 while(it1.hasNext()){
				 String Key=it1.next();
				 System.out.println(Key+"----"+StrdentNameID.get(Key));
			 }
		 }
		
		
	}

}
