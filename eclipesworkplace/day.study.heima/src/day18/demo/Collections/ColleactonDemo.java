package day18.demo.Collections;

import java.util.ArrayList;
import java.util.Collection;

public class ColleactonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function();
	}
	public static void function(){
		Collection <String>c=new ArrayList<String>();//a�ӿڵĶ�̬
		c.add("���Ӻ�");
		c.add("��С��ͯ");
		System.out.println(c);
		c.clear();
		System.out.println(c);
		c.contains("���Ӻ�");
		System.out.println(c.contains("���Ӻ�"));
		
	}

}
