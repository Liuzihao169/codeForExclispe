package day1.demo3;

public class Dome {
	public static void main(String[]Args){
		 SalaiedEmployee p1=new  SalaiedEmployee("daming",5,5000);
		 HourlyEmployee p2=new     HourlyEmployee("mm",5,700,2);
		 System.out.println("daming 6�·ݵĹ�����");
		 System.out.println(p1.getsalary(6));
		 System.out.println("daming 5�·ݵĹ�����");
		 System.out.println(p1.getsalary(5));
		 System.out.println("mm 6�·ݵĹ�����");
		 System.out.println(p2.getsalary(6));
		 System.out.println("mm 5�·ݵĹ�����");
		 System.out.println(p2.getsalary(5));
		
	}
}
