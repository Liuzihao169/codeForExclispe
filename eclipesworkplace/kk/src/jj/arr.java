package jj;
import java.util.*;
public class arr {
           public static void main(String[]args){
     Scanner in=new Scanner(System.in);
     System.out.println("������ѧ������");
     int b=in.nextInt();
    int sum=0;
     int []a=new int[b];
     for(int i=0;i<b;i++){
    	 System.out.println("�������"+(i+1)+"��ѧ���ĳɼ�");
    	 a[i]=in.nextInt();
    	sum=sum+a[i]; 
    	 
     }
     System.out.println("��"+b+"��ѧ����ƽ���ɼ���"+sum/5);
        	   
        	   
        	   
       
           }
}
