package day33.FanSe;

import java.lang.reflect.Method;

public class ReflectDemo3 {
//利用反射 获取成员方法的使用，没有参数
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		Class c=Class.forName("day33.FanSe.People");
		Object obj=c.newInstance();
		Method met=c.getMethod("eat");
		met.invoke(obj);
	}

}
