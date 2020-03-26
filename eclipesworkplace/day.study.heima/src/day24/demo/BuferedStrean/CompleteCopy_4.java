package day24.demo.BuferedStrean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CompleteCopy_4 {
	/*
	 *   字节输入输出
	 *   字节数组输入输出
	 *   缓冲字节输入输出
	 *   缓冲字节数组输入输出
	 *   */
  public static void main(String [] args) throws IOException{
	  long s=System.currentTimeMillis();
	  //copy_1(new File("D:\\操作软件\\123.zip"),new File("f:\\123.zip"));
	  //copy_2(new File("D:\\操作软件\\123.zip"),new File("f:\\123.zip"));
	  copy_3(new File("D:\\操作软件\\123.zip"),new File("f:\\123.zip"));
	  long e=System.currentTimeMillis();
	  System.out.println(e-s);
	  

  }

private static void copy_3(File src, File desc) throws IOException {
		// TODO Auto-generated method stub
	    BufferedOutputStream bfos=new BufferedOutputStream(new FileOutputStream(desc));
		BufferedInputStream bfis=new  BufferedInputStream(new FileInputStream(src));
	    int len=0;
	    while((len=bfis.read())!=-1){
	    	bfos.write(len);
	    }
	    bfos.close();
	    bfis.close();

}

private static void copy_1(File src,File desc ) throws IOException{
	// TODO Auto-generated method stub
	 FileInputStream fio=new FileInputStream(src);
	 FileOutputStream fis=new FileOutputStream(desc);
	 int len=0;
	 while((len=fio.read())!=-1){
		 fis.write(len);
	 }
	 fio.close();
	 fis.close();
	
}
private static void copy_2(File src,File desc ) throws IOException{
	// TODO Auto-generated method stub
	 FileInputStream fio=new FileInputStream(src);
	 FileOutputStream fis=new FileOutputStream(desc);
	 int len=0;
	 byte[]bytes=new byte[1024];
	 while((len=fio.read(bytes))!=-1){
		 fis.write(bytes,0,len);
	 }
	 fio.close();
	 fis.close();
	
}

}
