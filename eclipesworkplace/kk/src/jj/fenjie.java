package jj;

import java.util.*;

public class fenjie {
	public static void main(String[]args){
      int f;
		int g;
		Scanner in=new Scanner(System.in);
		while (true) { System.out.print("��ʼ��Ϸ1 ����2"); f=in.nextInt() ;
			if(f==1){			
		System.out.println("ִ��������͵Ĺ���");
		System.out.print("������һ��0-1000������");
		int a=in.nextInt();
		int b;
		int c;
		int e;
		int sum;
		if (a<=100){sum=a%10+(int)(a/10);
		System.out.println("�����Ϊ"+sum);
		}
			
		else if(a>=100&&a<1000){c=a%10;
	    b= (int) (a/10);
	    e=b;
	    sum=c+e%10+(int)(e/10);
		
	    System.out.println("�����Ϊ"+sum);
	  
			
		}
		}
	
			
			if(f==2){System.out.println("��Ϸ����");

		}  
		

	
}}}