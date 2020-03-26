package day32.demo.TCPThread;

import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServerDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 ServerSocket ssk=new ServerSocket(8000);
		 while(true){
			 Socket sk=ssk.accept();//获得客户端接口，一获得就开线程
			 new Thread(new ThreadRunable(sk)).start();
		 }
		 

}
}