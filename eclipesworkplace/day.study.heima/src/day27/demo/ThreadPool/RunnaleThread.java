package day27.demo.ThreadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnaleThread implements Runnable{
    Lock lock=new ReentrantLock();
    private int tackts=100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			lock.lock();
			if(tackts>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"出售第"+tackts--+"张票");
			}
			else break;
			lock.unlock();
	}

}
	}
