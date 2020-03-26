package day1.demo.graphes;

public class Cicle extends Graphes {
     double radius;
     final static double pi=3.14;
     @Override
     public double  getPerimeter(){
    	 System.out.println(" 圆形的面积是--------");
    	 return  radius*2*pi;
    	 
     }
     @Override
     public double getArea(){
    	 System.out.println("圆形的周长是---------");
    	 return radius*radius*pi;
    	 
     }
	
}
