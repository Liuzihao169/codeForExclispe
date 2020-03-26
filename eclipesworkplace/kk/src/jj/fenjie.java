package jj;

import java.util.*;

public class fenjie {
	public static void main(String[]args){
      int f;
		int g;
		Scanner in=new Scanner(System.in);
		while (true) { System.out.print("开始游戏1 结束2"); f=in.nextInt() ;
			if(f==1){			
		System.out.println("执行数字求和的功能");
		System.out.print("请输入一个0-1000的数字");
		int a=in.nextInt();
		int b;
		int c;
		int e;
		int sum;
		if (a<=100){sum=a%10+(int)(a/10);
		System.out.println("这个和为"+sum);
		}
			
		else if(a>=100&&a<1000){c=a%10;
	    b= (int) (a/10);
	    e=b;
	    sum=c+e%10+(int)(e/10);
		
	    System.out.println("这个和为"+sum);
	  
			
		}
		}
	
			
			if(f==2){System.out.println("游戏结束");

		}  
		

	
}}}