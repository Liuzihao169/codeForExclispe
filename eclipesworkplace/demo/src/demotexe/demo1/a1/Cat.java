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
	System.out.println("���ڳ���-------������");
	health+=15;
}
public void show(){
	System.out.println("ë�Ļ�����Ϣ");
	System.out.println("name"+name);
	System.out.println("�Ա�"+gender);
	System.out.println("����"+age);
	System.out.println("health"+health);
	
}
 
 
}
