package demotexe.demo1.a1;

public class peopletext1_1 {
	public static void main(String []Args){
		Cat cat1=new Cat("С��","ĸ",5,10);
		Dog dog1=new Dog("С��","��",6,10);
		People p1=new People();
		/*p1.name="����";
		dog1.show();
		p1.faeddog(dog1);
		dog1.show();
		cat1.show();
		p1.faedcat(cat1);
		cat1.show();*/
		p1.faedPet(cat1);//����ת��
		p1.faedPet(dog1);
		
		
				
		
	}

}
