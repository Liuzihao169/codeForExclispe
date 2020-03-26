package day1.demo3;

public class HourlyEmployee extends Employee{
	int workHours;
	int hourSelary;
 public  double getsalary(int month){
	 if(workHours>=600){
		 return super.getsalary(month)+workHours*hourSelary+(workHours-600)*1.5;
	 }
	 else {
		 return super.getsalary(month)+workHours*hourSelary;
	 }	 
 }
public HourlyEmployee(String name, int birthMonth, int workHours, int hourSelary) {
	super(name, birthMonth);
	this.workHours = workHours;
	this.hourSelary = hourSelary;
}

}
