package day1.demo.polymorphism1;

public class Son extends Father {
	int xx=101;
	public void mothed(){
		System.out.println("这是子类的方法");
		System.out.println("xx="+xx);
	}
	public static void staticmothed(){
		System.out.println("这是子类静态方法");
	}

}
