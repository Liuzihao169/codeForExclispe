package demotexe.demo1.a1;

public class Dog extends Pet{
   String name;
   String gender;
   int age;
   int health; 
   public Dog(String name, String gender,int age , int health) {
	this.name = name;
	this.gender = gender;
	this.age=age;
	this.health = health;
}
public void eat(){
	   System.out.println("���ڹ�ͷ--������");
	   health=health+5;
   }
   public void show(){
	   System.out.println("���Ļ�����Ϣ--------");
	   System.out.println("name"+name);
	   System.out.println("gender"+gender);
	   System.out.println("����ֵΪ��"+health);
   }
}

