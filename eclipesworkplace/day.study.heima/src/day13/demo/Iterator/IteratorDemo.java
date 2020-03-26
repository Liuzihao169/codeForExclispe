package day13.demo.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
   public static void main(String []args){
	   Collection <String> coll=new ArrayList<String>();
	   coll.add("jjj");
	   coll.add("mmm");
	   coll.add("kkk");
	   Iterator <String> mm=coll.iterator();
	  boolean bb= mm.hasNext();//判断是否有迭代的元素
	  System.out.println(bb);
	  String str=mm.next();
	  System.out.println(str);
	  while(mm.hasNext()){
		  System.out.println(mm.next());
	  }
   }
}
