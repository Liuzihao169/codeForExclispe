package day32.demo.intelent;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsendDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
    byte [] buf="你好abc".getBytes();
    InetAddress inet=InetAddress.getByName("127.0.0.1");
    DatagramPacket dp=new DatagramPacket(buf,buf.length,inet,8000);
    DatagramSocket ds=new DatagramSocket();
    ds.send(dp);//拆包主要是拆长度和主机IP地址
    ds.close();
    
	}

}
