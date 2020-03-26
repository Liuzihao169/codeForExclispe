package day23.demo.Inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CompDemo1 {
   public static void main(String []args){
	   FileInputStream fis=null;
	   FileOutputStream fio=null;
	   try{
		   fis=new FileInputStream("d:\\abc\\b.txt");
		   fio=new FileOutputStream("c:\\b.txt");
		   int len =0;
		   while((len =fis.read())!=-1){
			   fio.write(len);
		   }
	   }catch(IOException ex){
		   System.out.println(ex);
		   throw new RuntimeException("文件复制失败");
		   
	   }finally{
		   try {
			   if(fio!=null)
			fio.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		       System.out.println(e);
		       throw new RuntimeException("资源关闭失败");
		}
		   finally{
			   try{
				   if(fis!=null)
			   fis.close();
		   }catch(IOException e){
			   System.out.println(e);
			   throw new RuntimeException("资源关闭失败");
		   }
			   }
	   }
   }
}
