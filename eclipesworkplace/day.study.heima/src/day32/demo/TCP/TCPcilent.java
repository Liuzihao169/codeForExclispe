package day32.demo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPcilent {
//ʵ�ֿͻ��˵�socket��
	//���췽�����ݷ�������IP�Ͷ˿ں�
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket sk=new Socket("127.0.0.1",8888); 
		OutputStream out=sk.getOutputStream();
		out.write("������OK��".getBytes());
		InputStream inp=sk.getInputStream();
		byte [] by=new byte[1024];
		int len=inp.read(by);
		System.out.println(new String(by,0,len));
		out.close();
		sk.close();

	}

}
