package day1.demo.polymorphism1;

public class demo {
	public static void main(String [] Args){
		Father f1=new Father();
		System.out.println(f1.xx);
		f1.mothed();
		f1.staticmothed();//对象调用静态方法
		System.out.println("---------");
		f1=new Son();
	    f1.mothed();
	    f1.staticmothed();
		System.out.println(f1.xx);
		/*实例变量不存在多态
		 * 
		 * 
		 * */
		
	}

}
