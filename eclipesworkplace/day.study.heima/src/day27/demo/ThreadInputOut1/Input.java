package day27.demo.ThreadInputOut1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Input implements Runnable{
   private Resrous r;
   private Lock l;
	public Input(Resrous r,Lock l){
		this.l=l;
		this.r=r;
	}
	Lock lock=new ReentrantLock();
	
	public  void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true){
			l.lock();
			if(r.flag){
				try {
					l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(i%2==0){
				r.name="´óÃ«";
				r.Gender="ÄÐ";
			}
			else{
				r.Gender="nv";
			    r.name="ermao";
			}
			r.flag=true;
			l.notify();
			l.unlock();
			i++;
		}
	}}


