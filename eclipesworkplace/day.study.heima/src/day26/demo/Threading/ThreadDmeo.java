package day26.demo.Threading;

public class ThreadDmeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subThread st=new subThread();
		st.setName("��");
		st.start();
		//for(int i=0;i<=100;i++){
		//	System.out.println(i+"main");
	//	}
	   
	    System.out.println(Thread.currentThread().getName());// ȡ����ǰ�̵߳ĵ����֣�currentThread()

	}

}
