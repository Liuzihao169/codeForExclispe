package day32.demo.TCPThread;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

public class ThreadRunable implements Runnable {
         private Socket sk;
	public ThreadRunable( Socket sk){
		this.sk=sk;
	};
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
	      //��ÿͻ��˵��׽��ֶ���
	       InputStream is=sk.getInputStream();
	       String filename="mm"+System.currentTimeMillis()+new Random().nextInt(9999999)+".jpg";
	       FileOutputStream fos=new FileOutputStream("d:\\abc\\"+filename);
	       int len=0;
	       byte [] byts=new byte[1024];
	      while((len=is.read(byts))!=-1){
	    	  fos.write(byts, 0, len);
	      }
	    
	     sk.getOutputStream().write("�ϴ��ɹ�".getBytes());

	     fos.close();
	     
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

}
