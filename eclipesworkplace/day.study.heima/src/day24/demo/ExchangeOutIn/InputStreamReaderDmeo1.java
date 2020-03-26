package day24.demo.ExchangeOutIn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDmeo1 {
  public static void main(String [] args) throws IOException{
	  
	  FileInputStream fis=new FileInputStream("d:\\abc\\b.txt");
	  InputStreamReader isr=new InputStreamReader(fis);
	  int len=0;
	  char[]c=new char[1024];
	  while((len=isr.read(c))!=-1){
		  System.out.println(new String(c,0,len));//len «≥§∂»
	  }
	  isr.close();
  }
}
