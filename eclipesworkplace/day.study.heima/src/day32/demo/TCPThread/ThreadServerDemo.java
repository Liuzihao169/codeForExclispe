package day32.demo.TCPThread;

import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServerDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 ServerSocket ssk=new ServerSocket(8000);
		 while(true){
			 Socket sk=ssk.accept();//��ÿͻ��˽ӿڣ�һ��þͿ��߳�
			 new Thread(new ThreadRunable(sk)).start();
		 }
		 

}
}