package day1.demo.graphes;

public class Deom {
	public static void main(String[]Args){
		Rectangle r1=new Rectangle();
		Cicle c1=new Cicle();
		c1.radius=5.0;
		r1.length=5.0;
		r1.wide=3.0;
		 System.out.println(c1.getArea());
		 System.out.println(c1.getPerimeter());
		 System.out.println(r1.getArea());
		 System.out.println(r1.getPerimeter());
		 System.out.println("-------------------");
		Graphes graphes=r1;
		System.out.println(graphes.getArea());
		 graphes=c1;
		System.out.println(graphes.getArea());
		 //多态
		/*
		 * 继承
		 * 方法的重新
		 * 父类 的引用指向子类的对象
		 * 父类调用重写的方法
		 * */
	}
}
