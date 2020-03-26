package jj;
import java.util.*;
public class yuan {
public static void mian(String[]args){
	double a,b;
	Scanner in=new Scanner(System.in);
	double p=3.14;
	System.out.println("请输入半径");
	double R=in.nextDouble();
	a=2*p*R;
	b=R*R*p;
	System.out.println("圆的面积是"+b+"\n"+"圆的周长是"+a);
}
}
