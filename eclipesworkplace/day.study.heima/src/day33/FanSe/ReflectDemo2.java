package day33.FanSe;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class c=Class.forName("day33.FanSe.People");
		   Constructor con= c.getConstructor(String.class,int.class);
		  Object obj=  con.newInstance("���",18);
		  System.out.println(obj);//���в����ķ��似��
	}

}
