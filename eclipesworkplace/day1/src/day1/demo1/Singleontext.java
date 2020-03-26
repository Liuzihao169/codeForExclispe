package day1.demo1;

public class Singleontext {
  public static void main(String[]Args){
	  Singleton obj=Singleton.SingleronGet();
	  Singleton obj1=Singleton.SingleronGet();
	  Singleton obj2=Singleton.SingleronGet();
	  System.out.println(obj);
	  System.out.println(obj1);
	  System.out.println(obj2);
	  
  }
}
