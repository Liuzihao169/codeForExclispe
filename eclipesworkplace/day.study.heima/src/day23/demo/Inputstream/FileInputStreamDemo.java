package day23.demo.Inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
     public static void main(String[]args) throws IOException{
    	 int len=0;
    	 FileInputStream ofs=new FileInputStream("D:\\abc\\b.txt");
    	 while((len=ofs.read())!=-1){
    	 System.out.print((char)len);
    	
    	 }
    	 ofs.close();
     }
   
}
