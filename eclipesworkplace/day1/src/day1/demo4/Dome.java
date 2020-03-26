package day1.demo4;

public class Dome {
	public static void main(String[]Args){
		Cat cat1=new Cat("damao", "母", 15, "白色");
		PetHospital PetHospital1=new PetHospital();
		System.out.println("cat1毛的颜色是:"+cat1.color);
		System.out.println("进入宠物医院染色");
		PetHospital1.Hairdiy(cat1);
		System.out.println("cat1毛的颜色是:"+cat1.color);
		System.out.println(cat1);
		Pet pet=PetHospital1.produce("cat");
		if(pet instanceof Cat){
			Cat myCat=(Cat)pet;
			System.out.println(myCat);
			
		}
		
	}

}
