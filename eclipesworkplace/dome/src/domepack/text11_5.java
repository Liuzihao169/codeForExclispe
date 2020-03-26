package domepack;
import java.util.*;
public class text11_5 {
	public static void main(String []args){
		while(true){
	int[] arr=new int  [100];
	System.out.println("请输入数组的脚标");
	System.out.println("结束请输入0");
	Scanner input=new Scanner(System.in);
		int num1=input.nextInt();
		for(int i=0;i<100;i++){
			int num=(int)(1+Math.random()*100);
			arr[i]=num;
		}
		if(num1<100){
			System.out.println(arr[num1]);	
		}
		else{
			System.out.println("out of  Bounds");	
		}
		int num2=input.nextInt();
		if(num2==0){
			break;
		}
	}
		System.out.println("结束");	
}}
