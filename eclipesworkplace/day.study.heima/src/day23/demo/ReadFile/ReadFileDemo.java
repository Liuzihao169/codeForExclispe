package day23.demo.ReadFile;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileDemo {
  public static void main(String []args) throws IOException{
	  FileReader fr=new FileReader("d:\\abc\\12.txt");
	  int len =0;
	  char []b=new char[1024];
	  while((len=fr.read(b))!=-1){
		  System.out.println(new String(b,0,len));//运用数组缓冲来读取字符流
	  }
	  
	  
  }
}
