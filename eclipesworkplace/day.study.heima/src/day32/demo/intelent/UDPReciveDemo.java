package day32.demo.intelent;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReciveDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket ds=new DatagramSocket(8000);//��ͷ�ϰ󶨶˿ں�
		byte []bytes=new byte[1024];
		DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
		ds.receive(dp);
		int length=dp.getLength();
		System.out.println(new String(bytes,0,length)+dp.getAddress().getHostAddress()+dp.getPort());
		ds.close();

	}

}
