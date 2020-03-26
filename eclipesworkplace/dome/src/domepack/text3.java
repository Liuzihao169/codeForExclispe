package domepack;
import java.util.*;
public class text3 {
	public static void main(String []args){
	Scanner input=new Scanner(System.in);
	int temp1=0;
	 String temp="l";
	 System.out.println("请输入学生人数的个数");
	 int number=input.nextInt();
	String []arr=new String[number];//接人的数组
	int [] num=new int[number];//接受成绩的数组
	 for(int i=0;i<arr.length;i++){
		 System.out.println("请输入第"+(i+1)+"的名字");
			arr[i]=input.next(); 
	 }
	 for(int i=0;i<arr.length;i++){
		 System.out.println("请输入第"+(i+1)+"成绩");
		 num[i]=input.nextInt();
	 }
	 
	 for(int i=0;i<arr.length;i++){
		 for(int j=i;j<arr.length-1;j++){
			 if(num[j]<num[j+1]){
				 num[j]=num[j+1];
				 temp1=num[j];
				num[j+1]=temp1;
				 arr[j]=arr[j+1];
				 temp=arr[j];
				 arr[j+1]=temp;
			 }
			 
			 
		 }
	 }
	 for(int i=0;i<arr.length;i++){
		 System.out.println(arr[i]+"\n");
	}
	}
}
