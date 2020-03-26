package day1.demo.polymorphism;

public class Dog extends Pet{

	public Dog(String name, String grnder, int age, String color) {
		super(name, grnder, age, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", grnder=" + grnder + ", age=" + age + ", color=" + color + ", toString()="
				 + "]";
	}
	public void beark(){
		System.out.println("ÍôÍôÍô----");
		
	}
	

}
