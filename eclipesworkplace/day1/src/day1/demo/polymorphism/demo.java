package day1.demo.polymorphism;

public class demo {
	public static void main(String []Args){
		Pet pet=new Pet("ss","cc",2,"jj");
		pet.beark();
		 pet=new Dog("damai","公",15,"");
		pet.beark();
		System.out.println(pet);
		 pet=new Cat("mamomao","母",12,"白色");
		pet.beark();
		System.out.println(pet);//动态绑定 多态的运用
	}

}
