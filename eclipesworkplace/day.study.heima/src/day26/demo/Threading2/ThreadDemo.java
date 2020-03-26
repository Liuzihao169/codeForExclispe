package day26.demo.Threading2;

public class ThreadDemo {
  public static void main(String[]args){
	  SubRunnable sub=new SubRunnable();
	  Thread t=new Thread(sub);
	  t.start();
	  for(int i=1; i<5; i++){
		  System.out.println(i+"mian");
	  }
  }
}
