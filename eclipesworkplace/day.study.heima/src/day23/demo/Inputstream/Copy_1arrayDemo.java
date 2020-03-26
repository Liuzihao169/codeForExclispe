package day23.demo.Inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_1arrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FileInputStream fis=null;
		   FileOutputStream fio=null;
		   try{
		   fis=new FileInputStream("D:\\操作软件\\123.zip");
		   fio=new FileOutputStream("F:\\123.zip");
		   byte [] b=new byte[1024];
		   int len=0;
		   while((len=fis.read(b))!=-1){
			   fio.write(b);
		   }
	}catch(IOException e){
		System.out.println(e);
		throw new RuntimeException("出错");
		
	}finally{
		try{if(fis!=null)fis.close();
	}catch(IOException ex){
		System.out.println(ex);
		throw new RuntimeException("出错");
	}finally{
		try{
			if(fio!=null)fio.close();
		}catch(IOException ec){
			System.out.println(ec);
			throw new RuntimeException("出错");
			
		}
	}
		}

}
}