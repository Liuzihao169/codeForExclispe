package day23.demo.Outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputstreamDemo1 {
   public static void main(String [] args){
	   FileOutputStream ofs=null;
	   try { ofs=new FileOutputStream("d:\\abc");
	   ofs.write(100);
	   ofs.close();
	   }catch(IOException ex){
		   System.out.println(ex);
		   throw new RuntimeException("���������");
	   }finally{
		   try {
			   if(ofs!=null)
			ofs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ϵͳ����ʧ��");
		}
		   
	   }
   }
}
