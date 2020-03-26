package day27.demo.ThreadInputOut1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
	//解决那个使用同一个对象的
	//用lock锁解决一个问题同步问题
	public static void main(String[]args){
		Lock l=new ReentrantLock();
		Resrous r = new Resrous();
		Input in=new Input(r,l);
        Output out=new Output(r,l);
        Thread t1=new Thread(in);
        Thread t2=new Thread(out);
        	t1.start();
        	t2.start();
		
	}
}
