package day1.demo1;

public class Singleton {
	private Singleton(){
	}
	private static Singleton obj=new Singleton();
	public static Singleton SingleronGet(){
		return obj;//��̬�������ܷ���ʵ��������Ҫ��ʵ������Ҳ����Ϊ��̬
		
	}
}
