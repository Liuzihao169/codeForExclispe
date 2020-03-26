package day1.demo1;

public class Singleton {
	private Singleton(){
	}
	private static Singleton obj=new Singleton();
	public static Singleton SingleronGet(){
		return obj;//静态方法不能访问实例变量，要把实例变量也定义为静态
		
	}
}
