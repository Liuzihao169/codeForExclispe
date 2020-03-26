package day23.demo.Inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    FileInputStream fis=new FileInputStream("D:\\abc\\b.text");
    int len=0;
    byte[]b=new byte[2];
    while((len=fis.read(b))!=-1){
    System.out.print(new String(b,0,len));//能直接把字节变成字符串
	}
    fis.close();

}}
