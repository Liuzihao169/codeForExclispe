package day32.demo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer{
   public static void main(String[]args)throws IOException{
	   ServerSocket ssk=new ServerSocket(8888);//�������Ķ˿ں�
	   Socket soc=ssk.accept();//��ÿͻ��˵Ķ���
	   InputStream inp=soc.getInputStream();//�Ѿ�Ĭ�����׽��ֶ���
	   byte []bys=new byte[1024];
           int len=inp.read(bys);
           System.out.println(new String(bys,0,len));
           OutputStream oup=soc.getOutputStream();
           oup.write("�յ���лл".getBytes());
   }
}
