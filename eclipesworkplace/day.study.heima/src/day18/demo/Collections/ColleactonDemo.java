package day18.demo.Collections;

import java.util.ArrayList;
import java.util.Collection;

public class ColleactonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function();
	}
	public static void function(){
		Collection <String>c=new ArrayList<String>();//a接口的多态
		c.add("刘子豪");
		c.add("六小儿童");
		System.out.println(c);
		c.clear();
		System.out.println(c);
		c.contains("刘子豪");
		System.out.println(c.contains("刘子豪"));
		
	}

}
