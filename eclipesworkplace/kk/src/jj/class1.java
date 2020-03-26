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

	} // ����
	public int getOn(){
		return this.on;

	} //ȡ��� 
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


class Admin{//��������ѧ����һ����,���ѧ���ķ��ķ���
	String mag="\t���\t����\t����\tJava\tc_shar\tHTML\tsql\t�ܷ�\tƽ����";
	public void print(Student[] arr){
		System.out.println(mag);//����ѧ���ĳɼ�
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null)
				arr[i].setSum();
			//arr[i].setAvg();
			System.out.println(arr[i]);	
		}
	}
	public void create(String name,int age,Student[] arr){//���ѧ��
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==2){
			System.out.println("ѧ�������Ѿ�������󣬲��ܹ��������");
		}else{
			arr[i]=stu;
		}
	}
	public boolean exist(int on,Student stu){//�жϱ���Ƿ��Ӧ
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


	public int setIndex(Student[]arr){//������������Ϊ�յ��±�
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
		System.out.println("ѧ�������Ѿ�������󣬲��ܹ��������");
	}
	public void update(int on,String name,int age,Student [] arr){//����ѧԱ����Ϣ
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				arr[i].setName(name);
				arr[i].setAge(age);
				System.out.println("----������Ϣ�ɹ�----");
			}
		}

		System.out.println("û�ҵ���ѧ��������ѧ����Ϣʧ��");
	}
	public void delete(int on,Student [] arr){
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				arr [i]=null;
				return;
			}
		}
		System.out.println("����ָ����ѧ��������");	
	}
	public void coureSort(int num,Student[] arr){//����
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
				System.out.println("������"+arr[i].getName()+"java�ɼ�");		
				arr[i].setJava(in.nextInt());
				System.out.println("������"+arr[i].getName()+"c#�ɼ�");
				arr[i].setC_shar(in.nextInt());
				System.out.println("������"+arr[i].getName()+"html�ɼ�");	
				arr[i].setHtml(in.nextInt());
				System.out.println("������"+arr[i].getName()+"sql�ɼ�");
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
		//System.out.println("--��������Ҫִ�еĹ���--");
		Student[] stuArr=new Student[2];//����student��Ŀ��Դ��
		Admin adminStu=new Admin();
		while(true){
			System.out.println("1�����һ��ѧ��");
			System.out.println("2������һ��ѧ��");
			System.out.println("3������ѧ����Ÿ���ѧ��������Ϣ");
			System.out.println("4������ѧ�����ɾ��ѧ����Ϣ");
			System.out.println("5�����ݱ������ѧ�����ųɼ�");
			System.out.println("6������ĳ�ųɼ�����");
			System.out.println("7�������ܷ�����");
			System.out.println("8���˳�ϵͳ");
			String number=in.next();
			if(number.equals("1")){
				System.out.println("������ѧ��������");
				String name=in.next();
				System.out.println("������ѧ��������");
				int age=in.nextInt();
				adminStu.create(name, age,stuArr);
				adminStu.print(stuArr);
				//���ѧ��
			}else if(number.equals("2")){
				System.out.println("ִ��ѧ���Ļ�����Ϣ����");
				System.out.println("������ѧ�������");
				int on=in.nextInt();
				adminStu.select(on,stuArr);
			}else if(number.equals("3")) {
				System.out.println("ִ�и���ѧ���Ļ�����Ϣ����");
				System.out.println("������ѧ���ı�ţ�");
				int on=in.nextInt();
				System.out.println("������ѧ��������");
				String name=in.next();
				System.out.println("������ѧ�������䣺");
				int age=in.nextInt();
				adminStu.update(on, name, age, stuArr);
				adminStu.print(stuArr);}
			else if(number.equals("4")){
				System.out.println("---ִ��ɾ��ѧ���Ĳ���---");
				System.out.println("������ѧ���ı�ţ�");
				int on=in.nextInt();
				adminStu.delete(on, stuArr);
				adminStu.print(stuArr);
			}
			else if(number.equals("5")){
				System.out.println("---ִ������ѧ���ɼ��Ĳ���---");
				System.out.println("��������Ҫ����ɼ�ѧ���ı��");
				int on=in.nextInt();
				adminStu.input(on, stuArr);
			}
			else if(number.equals("6")){
				System.out.println("---ִ�и���ĳ�ųɼ��������---");
				System.out.println("��������Ҫ����Ŀ�Ŀ(1.java 2.c# 3.html 4.sql)");
				int num=in.nextInt();
				adminStu.coureSort(num,stuArr);
			}
			else if(number.equals("7")){
				System.out.println("---ִ���ֳܷɼ��������---");
				adminStu.zong(stuArr);
			}
			else if(number.equals("8")){
				System.exit(0);

			}
		}


	}
}


