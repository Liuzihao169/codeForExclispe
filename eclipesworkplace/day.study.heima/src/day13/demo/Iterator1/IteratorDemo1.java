package day13.demo.Iterator1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo1 {
     public static void main(String[]args){
    	 ArrayList<Integer>coll=new ArrayList<Integer>();
    	 ArrayList<String>coll1=new ArrayList<String>();
    	 coll.add(12);
    	 coll.add(13);
    	 coll.add(14);
    	 coll1.add("23");
    	 coll1.add("24");
    	 coll1.add("25");
    	 iterator(coll);
    	 iterator(coll1);
     }

	private static void iterator(Collection<?>c) {//泛型？代表所有的都可以 
		Iterator<?>i=c.iterator();
		// TODO Auto-generated method stub
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
}
