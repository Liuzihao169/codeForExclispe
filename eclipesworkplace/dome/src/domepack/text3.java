package domepack;
import java.util.*;
public class text3 {
	public static void main(String []args){
	Scanner input=new Scanner(System.in);
	int temp1=0;
	 String temp="l";
	 System.out.println("������ѧ�������ĸ���");
	 int number=input.nextInt();
	String []arr=new String[number];//���˵�����
	int [] num=new int[number];//���ܳɼ�������
	 for(int i=0;i<arr.length;i++){
		 System.out.println("�������"+(i+1)+"������");
			arr[i]=input.next(); 
	 }
	 for(int i=0;i<arr.length;i++){
		 System.out.println("�������"+(i+1)+"�ɼ�");
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
