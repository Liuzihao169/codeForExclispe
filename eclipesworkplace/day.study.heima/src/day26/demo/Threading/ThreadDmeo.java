package day26.demo.Threading;

public class ThreadDmeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subThread st=new subThread();
		st.setName("大狗");
		st.start();
		//for(int i=0;i<=100;i++){
		//	System.out.println(i+"main");
	//	}
	   
	    System.out.println(Thread.currentThread().getName());// 取出当前线程的的名字，currentThread()

	}

}
