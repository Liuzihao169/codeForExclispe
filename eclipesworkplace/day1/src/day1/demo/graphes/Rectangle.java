package day1.demo.graphes;

public class Rectangle extends Graphes {
	double length;
	double wide;
	public double getArea(){
		 System.out.println(" �����ε������--------");
		return length*wide;
	}
	public double getPerimeter(){
		 System.out.println(" �����ε��ܳ���--------");
		return 2*(wide+length);
	}
	

}
