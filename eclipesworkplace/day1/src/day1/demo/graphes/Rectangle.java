package day1.demo.graphes;

public class Rectangle extends Graphes {
	double length;
	double wide;
	public double getArea(){
		 System.out.println(" 长方形的面积是--------");
		return length*wide;
	}
	public double getPerimeter(){
		 System.out.println(" 长方形的周长是--------");
		return 2*(wide+length);
	}
	

}
