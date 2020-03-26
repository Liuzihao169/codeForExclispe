package day32.demo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPcilent {
//实现客户端的socket类
	//构造方法传递服务器的IP和端口号
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket sk=new Socket("127.0.0.1",8888); 
		OutputStream out=sk.getOutputStream();
		out.write("服务器OK？".getBytes());
		InputStream inp=sk.getInputStream();
		byte [] by=new byte[1024];
		int len=inp.read(by);
		System.out.println(new String(by,0,len));
		out.close();
		sk.close();

	}

}
