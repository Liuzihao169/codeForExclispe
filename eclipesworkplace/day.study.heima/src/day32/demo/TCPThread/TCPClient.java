package day32.demo.TCPThread;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
     /*
      * 
      * 1.ͨ��socket�׽������ӷ�����
      * 2.ͨ��socket����ֽ��������Ŀ����Ϊ��дͼƬ
      * 3.ʹ���Լ����������ȡ����ԴͼƬ
      * 4.ʹ���ֽ����������ͼƬд����������
      * �����ֽ�������Ϊ����
      * 5.ͨ������������ȡ���������������ϴ��ɹ���Ϣ 
      * �ر���Դ*/
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
