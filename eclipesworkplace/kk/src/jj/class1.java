package jj;
import java.util.*;
class Student{
	private int on;
	private String name;
	private int age;
	private int java;
	private int c_shar;
	private int html;
	private int sql;
	private int sum;
	private int avg;
	public void setOn(int on){ 
		this.on=on;

	} // 存编号
	public int getOn(){
		return this.on;

	} //取编号 
	public String getName() {
		return  this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getC_shar() {
		return c_shar;
	}
	public void setC_shar(int c_shar) {
		this.c_shar = c_shar;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getAql() {
		return sql;
	}
	public void setAql(int sql) {
		this.sql = sql;
	}
	public int getSum() {
		return sum;
	}
	public void setSum() {
		this.sum = this.java+this.sql+this.html+this.c_shar;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = this.sum/4;
	}
	public String toString(){
		String maa="\t"+this.on+"\t"+this.name+"\t"+this.age+"\t"+this.java+"\t"+
				+this.c_shar+"\t" +this.html+"\t"+this.sql+"\t"+this.sum+"\t"+this.avg;
		return maa;
	}




}


class Admin{//用来管理学生的一个类,添加学生的法的方法
	String mag="\t编号\t姓名\t年龄\tJava\tc_shar\tHTML\tsql\t总分\t平均分";
	public void print(Student[] arr){
		System.out.println(mag);//更新学生的成绩
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null)
				arr[i].setSum();
			//arr[i].setAvg();
			System.out.println(arr[i]);	
		}
	}
	public void create(String name,int age,Student[] arr){//添加学生
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==2){
			System.out.println("学生人数已经到达最大，不能够再添加了");
		}else{
			arr[i]=stu;
		}
	}
	public boolean exist(int on,Student stu){//判断编号是否对应
		if(stu!=null){
			if(stu.getOn()==on){
				return true;
			}else{
				return false;
			}

		}
		return false;
	}
	public void zong(Student []arr){
		for(int i=0;i<arr.length-1;i++){
			{if(arr[i]!=null){
				if(arr[i].getSum()<arr[i+1].getSum()){
					Student t=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=t;
				}
			}

			}
		}
		this.print(arr);
	}


	public int setIndex(Student[]arr){//返回数组里面为空的下标
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 2;
	}
	public void select(int on,Student []arr){
		System.out.println(mag);
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])==true){
				System.out.println(mag);

				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println("学生人数已经到达最大，不能够再添加了");
	}
	public void update(int on,String name,int age,Student [] arr){//更新学员的信息
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				arr[i].setName(name);
				arr[i].setAge(age);
				System.out.println("----更新信息成功----");
			}
		}

		System.out.println("没找到该学生，更新学生信息失败");
	}
	public void delete(int on,Student [] arr){
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				arr [i]=null;
				return;
			}
		}
		System.out.println("你所指定的学生不存在");	
	}
	public void coureSort(int num,Student[] arr){//排序
		if(num==1){
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){
						if(arr[i].getJava()<arr[j].getJava()){
							Student t=arr[i];
							arr[i]=arr[j];
							arr[j]=t;
						}
					}
				}
			}
		}
		else if(num==2){
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){
						if(arr[i].getC_shar()<arr[j].getC_shar()){
							Student t=arr[i];
							arr[i]=arr[j];
							arr[j]=t;
						}
					}
				}
			}
		}
		else if(num==3){
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){
						if(arr[i].getHtml()<arr[j].getHtml()){
							Student t=arr[i];
							arr[i]=arr[j];
							arr[j]=t;
						}
					}
				}
			}
		}
		else if(num==4){
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){
						if(arr[i].getAql()<arr[j].getAql()){
							Student t=arr[i];
							arr[i]=arr[j];
							arr[j]=t;
						}
					}
				}
			}
		}
		this.print(arr);
	}
	public void input(int on,Student[]arr  ){
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				Scanner in=new Scanner(System.in);
				System.out.println("请输入"+arr[i].getName()+"java成绩");		
				arr[i].setJava(in.nextInt());
				System.out.println("请输入"+arr[i].getName()+"c#成绩");
				arr[i].setC_shar(in.nextInt());
				System.out.println("请输入"+arr[i].getName()+"html成绩");	
				arr[i].setHtml(in.nextInt());
				System.out.println("请输入"+arr[i].getName()+"sql成绩");
				arr[i].setAql(in.nextInt());
				this.print(arr);
				break;
			}
		}
	}
}
public class class1 {
	public static void main(String[]args){	
		Scanner in=new Scanner(System.in);
		//System.out.println("--请输入你要执行的功能--");
		Student[] stuArr=new Student[2];//符合student类的可以存放
		Admin adminStu=new Admin();
		while(true){
			System.out.println("1：添加一个学生");
			System.out.println("2：查找一个学生");
			System.out.println("3：根据学生编号更新学生基本信息");
			System.out.println("4：根据学生编号删除学生信息");
			System.out.println("5：根据编号输入学生各门成绩");
			System.out.println("6：根据某门成绩排序");
			System.out.println("7：根据总分排序");
			System.out.println("8：退出系统");
			String number=in.next();
			if(number.equals("1")){
				System.out.println("请输入学生的姓名");
				String name=in.next();
				System.out.println("请输入学生的年龄");
				int age=in.nextInt();
				adminStu.create(name, age,stuArr);
				adminStu.print(stuArr);
				//添加学生
			}else if(number.equals("2")){
				System.out.println("执行学生的基本信息操作");
				System.out.println("请输入学生发编号");
				int on=in.nextInt();
				adminStu.select(on,stuArr);
			}else if(number.equals("3")) {
				System.out.println("执行更新学生的基本信息操作");
				System.out.println("请输入学生的编号：");
				int on=in.nextInt();
				System.out.println("请输入学生姓名：");
				String name=in.next();
				System.out.println("请输入学生的年龄：");
				int age=in.nextInt();
				adminStu.update(on, name, age, stuArr);
				adminStu.print(stuArr);}
			else if(number.equals("4")){
				System.out.println("---执行删除学生的操作---");
				System.out.println("请输入学生的编号：");
				int on=in.nextInt();
				adminStu.delete(on, stuArr);
				adminStu.print(stuArr);
			}
			else if(number.equals("5")){
				System.out.println("---执行输入学生成绩的操作---");
				System.out.println("请输入你要输入成绩学生的编号");
				int on=in.nextInt();
				adminStu.input(on, stuArr);
			}
			else if(number.equals("6")){
				System.out.println("---执行根据某门成绩排序操作---");
				System.out.println("请输入你要排序的科目(1.java 2.c# 3.html 4.sql)");
				int num=in.nextInt();
				adminStu.coureSort(num,stuArr);
			}
			else if(number.equals("7")){
				System.out.println("---执行总分成绩排序操作---");
				adminStu.zong(stuArr);
			}
			else if(number.equals("8")){
				System.exit(0);

			}
		}


	}
}


