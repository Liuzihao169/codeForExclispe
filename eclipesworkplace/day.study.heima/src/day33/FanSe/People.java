package day33.FanSe;

public class People {
    private String name;
    private int age;
    static{
    	System.out.println("��̬�����");
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
		System.out.println("���ڳԷ�");
	}
	public void run(String name){
		System.out.println(name+"���ܲ�");
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
