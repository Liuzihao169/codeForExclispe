package day33.FanSe;

import java.lang.reflect.Constructor;

public class ReflectDmeo1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class c=Class.forName("day33.FanSe.People");
		Constructor con= c.getConstructor();
		Object obj=con.newInstance();
		System.out.println(obj);

	}

}
