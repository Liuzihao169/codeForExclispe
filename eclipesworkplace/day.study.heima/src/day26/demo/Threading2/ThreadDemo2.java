package day26.demo.Threading2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo2 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ExecutorService ex=Executors.newFixedThreadPool(3);// 建立养鱼塘，调用newfixedthread方法
		ThreadsCallable tc=new ThreadsCallable();
	Future<String>f=ex.submit(new ThreadsCallable());
		System.out.println(f.get());
	} 
}
