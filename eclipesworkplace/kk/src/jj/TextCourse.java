package jj;
import java.util.*;
 class Course{
		private String name;
		private int on;
		private String java;
public void addStudent(String[] arr1, int number1){
	System.out.println("****java*****");
	for(int i=0;i<arr1.length;i++){
		System.out.println((1+i)+"."+arr1[i]);
	}
}
static void dopstudent(String[]arr2,int number2){
    System.out.println("*****java****");
    for(int i=0;i<arr2.length;i++){
    	if(i==(number2-1)){
    	System.out.println(arr2[i]=null);
    	}
    	else {System.out.println((1+i)+"."+arr2[i]);}
    	
    }
}
}
public class TextCourse {
	public static void main(String []args){
		 Course myCourse=new Course();
		 int arrnumber=0;
		Scanner in=new Scanner(System.in);
		System.out.println("������ѧ���ĸ���");
		int Student2=in.nextInt();
		String []arr=new String[Student2];
		while(true){
		System.out.println("*****ѧ������ϵͳ*****");
		System.out.println("1.���ѧ��");
		System.out.println("2.ɾ��ѧ��");
		System.out.println("3.���ѧ����Ϣ");
		String number=in.next();
		if(number.equals("1")){
			System.out.println("����ѧ������");
	arr[arrnumber]=in.next();
	arrnumber++;
			myCourse.addStudent(arr,arrnumber);
		}
		if(number.equals("2")){
			System.out.println("����Ҫɾ��ѧ���ı��");
			int arrnumber1=in.nextInt();
			myCourse.dopstudent(arr,arrnumber1);
		}
	}

}}
