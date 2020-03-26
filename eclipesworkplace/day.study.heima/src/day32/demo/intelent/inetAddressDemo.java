package day32.demo.intelent;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class inetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		founction();
        founction_1();
	}
	public static void founction() throws UnknownHostException{
		 InetAddress inet=InetAddress.getLocalHost();
		 System.out.println(inet);
		System.out.println( inet.getHostName());
		System.out.println(inet.getHostAddress());
	}
	public static void founction_1() throws UnknownHostException{
		InetAddress inet=InetAddress.getByName("pc");//…Ë∂®IPµÿ÷∑
		System.out.println(inet);
		
	}

}
