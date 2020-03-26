package day32.demo.TCPThread;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
     /*
      * 
      * 1.通过socket套接字连接服务器
      * 2.通过socket获得字节输出流，目的是为了写图片
      * 3.使用自己的流对象读取数据源图片
      * 4.使用字节流输出流将图片写到服务器上
      * 采用字节数组作为缓冲
      * 5.通过输入流来读取服务器发回来的上传成功信息 
      * 关闭资源*/
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
      Socket sk=new Socket("127.0.0.1",8000);
      OutputStream out=sk.getOutputStream();
      FileInputStream fis=new FileInputStream("c:\\1.jpg");
      int len=0;
      byte [] byts=new byte[1024];
      while((len=fis.read(byts))!=-1){
    	  out.write(byts);
      }
      sk.shutdownOutput();
      InputStream ips=sk.getInputStream();
       len=ips.read(byts);
       System.out.println(new String(byts,0,len));
       sk.close();
       fis.close();
	}
}
