package day32.demo.TCPpicture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerPricture {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
       ServerSocket ssk=new ServerSocket(8000);
       Socket sk=ssk.accept();//获得客户端的套接字对象
       InputStream is=sk.getInputStream();
       FileOutputStream fos=new FileOutputStream("d:\\abc\\po0.jpg");
       int len=0;
       byte [] byts=new byte[1024];
      while((len=is.read(byts))!=-1){
    	  fos.write(byts, 0, len);
      }
    
     sk.getOutputStream().write("上传成功".getBytes());
     ssk.close();
     fos.close();
     
	}

}
