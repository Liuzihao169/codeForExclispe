package day33.FanSe;

import java.lang.reflect.Method;

public class ReflectDemo5 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
       /*���÷�����ô��в����ķ���*/
		Class c=Class.forName("day33.FanSe.People");
		Object obj=c.newInstance();
	Method me=	c.getMethod("run", String.class);
	me.invoke(obj,"�ܲ�����");
	}

}
