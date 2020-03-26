package day32.demo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer{
   public static void main(String[]args)throws IOException{
	   ServerSocket ssk=new ServerSocket(8888);//服务器的端口号
	   Socket soc=ssk.accept();//获得客户端的对象
	   InputStream inp=soc.getInputStream();//已经默认了套接字对象
	   byte []bys=new byte[1024];
           int len=inp.read(bys);
           System.out.println(new String(bys,0,len));
           OutputStream oup=soc.getOutputStream();
           oup.write("收到，谢谢".getBytes());
   }
}
