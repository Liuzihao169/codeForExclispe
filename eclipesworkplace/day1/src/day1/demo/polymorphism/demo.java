package day1.demo.polymorphism;

public class demo {
	public static void main(String []Args){
		Pet pet=new Pet("ss","cc",2,"jj");
		pet.beark();
		 pet=new Dog("damai","��",15,"");
		pet.beark();
		System.out.println(pet);
		 pet=new Cat("mamomao","ĸ",12,"��ɫ");
		pet.beark();
		System.out.println(pet);//��̬�� ��̬������
	}

}
