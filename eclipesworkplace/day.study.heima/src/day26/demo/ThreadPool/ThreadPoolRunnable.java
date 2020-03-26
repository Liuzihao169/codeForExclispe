package day26.demo.ThreadPool;

public class ThreadPoolRunnable implements Runnable{
	public void run(){
		System.out.println("这是一个线程池"+Thread.currentThread().getName());
		
	}

}
