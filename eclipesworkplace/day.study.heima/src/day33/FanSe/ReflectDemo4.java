package day33.FanSe;

import java.lang.reflect.Field;

public class ReflectDemo4 {
    /*
     * 反射获取成员变量，并且修改其变量的值*/
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class c=Class.forName("day33.FanSe.People");
		Field fie=c.getField("name");
		Object obj=c.newInstance();
		fie.set(obj, "刘大大");
	}

}
