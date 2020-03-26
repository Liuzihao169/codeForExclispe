package day32.demo.UDPinput;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPsendDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
    InetAddress inet=InetAddress.getByName("127.0.0.1");
    DatagramSocket ds=new DatagramSocket();
    while(true){
    	String str=sc.nextLine();
    byte [] buf=str.getBytes();
    DatagramPacket dp=new DatagramPacket(buf,buf.length,inet,8000);
    ds.send(dp);//拆包主要是拆长度和主机IP地址
    }

    
	}

}
