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
		System.out.println("请输入学生的个数");
		int Student2=in.nextInt();
		String []arr=new String[Student2];
		while(true){
		System.out.println("*****学生管理系统*****");
		System.out.println("1.添加学生");
		System.out.println("2.删除学生");
		System.out.println("3.清除学生信息");
		String number=in.next();
		if(number.equals("1")){
			System.out.println("输入学生姓名");
	arr[arrnumber]=in.next();
	arrnumber++;
			myCourse.addStudent(arr,arrnumber);
		}
		if(number.equals("2")){
			System.out.println("输入要删除学生的编号");
			int arrnumber1=in.nextInt();
			myCourse.dopstudent(arr,arrnumber1);
		}
	}

}}
