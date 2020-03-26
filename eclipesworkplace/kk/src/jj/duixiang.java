package jj;

class person{
	String name;
	String work;
	int age;

  void run(int a){
	System.out.println("我在跑步"+a);
}}
public class duixiang {
	public static void main(String[]args){
		person my=new person();
		my.work="打酱油";
	System.out.println (my.work);	
	my.run(18);
	}
	
}


