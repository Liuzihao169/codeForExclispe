package day1.demo.lfiy;

public class Demo {
	public static void main(String[]Args){
		Ifiy ifiy=new bird();
		ifiy.fly();
		ifiy=new Plane();
		ifiy.fly();//接口也可以实现多态
		
	}

}
