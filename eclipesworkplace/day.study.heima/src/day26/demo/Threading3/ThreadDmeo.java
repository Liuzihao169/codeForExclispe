package day26.demo.Threading3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDmeo {
//多线程异步计算
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
       ExecutorService ex=   Executors.newFixedThreadPool(2);
       Future <Integer>f=ex.submit(new CallablePool(100));
      Future<Integer>f1= ex.submit(new CallablePool(200));
       System.out.println(f.get());
      System.out.println(f1.get());
	}
}
