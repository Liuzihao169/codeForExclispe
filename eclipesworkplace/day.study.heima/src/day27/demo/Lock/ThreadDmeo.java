package day27.demo.Lock;

public class ThreadDmeo {
   public static void main(String[]args){
	   RunnaleThread Rt=new RunnaleThread();
	   Thread t0=new Thread(Rt);
	   Thread t1=new Thread(Rt);
	   Thread t2=new Thread(Rt);
	   t1.start();
	   t2.start();
	   t0.start();
	   
   }
}
