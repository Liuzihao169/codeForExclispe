package jj;
import java.util.*;
public class arr {
           public static void main(String[]args){
     Scanner in=new Scanner(System.in);
     System.out.println("请输入学生人数");
     int b=in.nextInt();
    int sum=0;
     int []a=new int[b];
     for(int i=0;i<b;i++){
    	 System.out.println("请输入第"+(i+1)+"名学生的成绩");
    	 a[i]=in.nextInt();
    	sum=sum+a[i]; 
    	 
     }
     System.out.println("这"+b+"个学生的平均成绩是"+sum/5);
        	   
        	   
        	   
       
           }
}
