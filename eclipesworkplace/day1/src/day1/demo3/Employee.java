package day1.demo3;

public class Employee {
	  private String name;
	private int birthMonth;
	public double getsalary(int month){
		if(month==birthMonth){
			return 200;
		}
		else{
			return 0;
		}
		
	}
	public Employee(String name, int birthMonth) {
		super();
		this.name = name;
		this.birthMonth = birthMonth;
	}

}
