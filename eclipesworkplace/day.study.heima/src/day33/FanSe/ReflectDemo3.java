package day33.FanSe;

import java.lang.reflect.Method;

public class ReflectDemo3 {
//���÷��� ��ȡ��Ա������ʹ�ã�û�в���
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		Class c=Class.forName("day33.FanSe.People");
		Object obj=c.newInstance();
		Method met=c.getMethod("eat");
		met.invoke(obj);
	}

}
