package demotexe.demo1.a1;

public class Cat extends Pet{
 String name;
 String gender;
 int age;
 int health;
public Cat(String name, String gender,  int age,int health) {
	this.name = name;
	this.gender = gender;
	this.age=age;
	this.health = health;
}
@Override
public void eat(){
	System.out.println("我在吃鱼-------喵喵喵");
	health+=15;
}
public void show(){
	System.out.println("毛的基本信息");
	System.out.println("name"+name);
	System.out.println("性别"+gender);
	System.out.println("年龄"+age);
	System.out.println("health"+health);
	
}
 
 
}
