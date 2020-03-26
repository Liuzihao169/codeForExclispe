package day27.demo.ThreadInputOut1;

import java.util.concurrent.locks.Lock;

public class Output implements Runnable {
	 private Resrous r;
	 private Lock l;
	Output(Resrous r,Lock l){
		this.r=r;
		this.l=l;
	}
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		while(true){
			l.lock();
			if(!r.flag){
				try {
					l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(r.Gender+r.name);
			r.flag=false;
			notify();
			l.unlock();
			}
			
		}
		
}

