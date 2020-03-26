package day1.demo3;

public class SalaiedEmployee extends Employee{
	int monthSalary;
	public double getsalary(int month){
		return super.getsalary(month)+monthSalary;
		
	}
	public SalaiedEmployee(String name, int birthMonth, int monthSalary) {
		super(name, birthMonth);
		this.monthSalary = monthSalary;
	}

}
