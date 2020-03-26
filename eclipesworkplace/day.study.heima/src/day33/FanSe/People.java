package day33.FanSe;

public class People {
    private String name;
    private int age;
    static{
    	System.out.println("静态代码块");
    }
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public People() {
		// TODO Auto-generated constructor stub
	}
	public void eat(){
		System.out.println("我在吃饭");
	}
	public void run(String name){
		System.out.println(name+"在跑步");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
    
}
