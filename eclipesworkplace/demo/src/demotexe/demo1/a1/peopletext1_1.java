package demotexe.demo1.a1;

public class peopletext1_1 {
	public static void main(String []Args){
		Cat cat1=new Cat("小白","母",5,10);
		Dog dog1=new Dog("小黄","公",6,10);
		People p1=new People();
		/*p1.name="大哥哥";
		dog1.show();
		p1.faeddog(dog1);
		dog1.show();
		cat1.show();
		p1.faedcat(cat1);
		cat1.show();*/
		p1.faedPet(cat1);//向下转承
		p1.faedPet(dog1);
		
		
				
		
	}

}
