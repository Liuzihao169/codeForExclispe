package day32.demo.intelent;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsendDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
    byte [] buf="���abc".getBytes();
    InetAddress inet=InetAddress.getByName("127.0.0.1");
    DatagramPacket dp=new DatagramPacket(buf,buf.length,inet,8000);
    DatagramSocket ds=new DatagramSocket();
    ds.send(dp);//�����Ҫ�ǲ𳤶Ⱥ�����IP��ַ
    ds.close();
    
	}

}
