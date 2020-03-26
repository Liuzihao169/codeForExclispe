package jj;
class Cat{
	String color;
	int age;
	public	void set(String color,int age){
		this.color=color;
		this.age=age;
	}
	public String toString(){
		return "狗的毛色："+color+"\t狗的年龄："+age;
	}
	public Cat bb(){
		return this;
	}
}


public class this2 {
	public static void main(String[]args){
		Cat one=new Cat();
		Cat two=new Cat();
		Cat three=new Cat();
		one.set("黄色",4);
		two.set("绿色", 6);
		three=two.bb();

		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
	}

}
