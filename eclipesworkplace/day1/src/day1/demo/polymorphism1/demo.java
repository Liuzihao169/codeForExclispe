package day1.demo.polymorphism1;

public class demo {
	public static void main(String [] Args){
		Father f1=new Father();
		System.out.println(f1.xx);
		f1.mothed();
		f1.staticmothed();//������þ�̬����
		System.out.println("---------");
		f1=new Son();
	    f1.mothed();
	    f1.staticmothed();
		System.out.println(f1.xx);
		/*ʵ�����������ڶ�̬
		 * 
		 * 
		 * */
		
	}

}
