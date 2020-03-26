package day1.demo4;

public class Dog extends Pet{

	public Dog(String name, String grnder, int age, String color) {
		super(name, grnder, age, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", grnder=" + grnder + ", age=" + age + ", color=" + color + ", toString()="
				+ super.toString() + "]";
	}
	

}
