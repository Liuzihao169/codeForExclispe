package jj;
class W{
	String name;
	int age;
	 public String toString(){//重写
return "我的姓名:"+name+"\t我的年龄:"+age;		 
		
		
	}
}
public class thiss {
	public static void main (String[]args){
		W my=new W();
	my.name="刘子豪";
	my.age=18;
System.out.println(my);

}
}