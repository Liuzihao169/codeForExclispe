package day24.demo.BuferedStrean;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
  public static void main(String[]args) throws IOException{
	  FileInputStream fis=new FileInputStream("D:\\abc\\12.txt");
	  BufferedInputStream bfis=new BufferedInputStream(fis);
//	  byte[]bs=new byte[6];
//	 bfis.read(bs);
//	 System.out.println(new String(bs));//知道长度的前前提下能够一次打印出来
	  byte []bs=new byte[5];
	  int len=0;
	  while((len=bfis.read(bs))!=-1){
		  System.out.println(new String(bs,0,len));
	  }
	  bfis.close();
  }
}
