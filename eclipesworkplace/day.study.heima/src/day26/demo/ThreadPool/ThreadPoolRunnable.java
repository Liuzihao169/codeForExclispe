package day26.demo.ThreadPool;

public class ThreadPoolRunnable implements Runnable{
	public void run(){
		System.out.println("����һ���̳߳�"+Thread.currentThread().getName());
		
	}

}
