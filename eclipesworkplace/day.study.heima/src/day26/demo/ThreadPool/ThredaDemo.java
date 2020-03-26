package day26.demo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredaDemo {
	public static void main(String []args){
			ExecutorService ex=Executors.newFixedThreadPool(3);
			ThreadPoolRunnable tpr=new ThreadPoolRunnable();
			ex.submit(new ThreadPoolRunnable());
			ex.submit(new ThreadPoolRunnable());
			ex.submit(new ThreadPoolRunnable());
		
	}

}
