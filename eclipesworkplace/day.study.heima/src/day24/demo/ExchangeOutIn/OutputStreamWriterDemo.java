package day24.demo.ExchangeOutIn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	/*
	 *   
	 *   转换流
	 *   基础writerl类
*/
	public static void main(String[]args) throws IOException{

		//writeGBK();
		writeUTF();
		
	}

	private static void writeUTF() throws IOException{
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("d:\\abc\\1.txt");
		OutputStreamWriter opsw=new OutputStreamWriter(fos,"UTF-8");
		opsw.write("我好你好大家好");
		opsw.close();
		
		
	}

	/*private static void writeGBK()throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("d\\abc\\b.txt");
		OutputStreamWriter opsw=new OutputStreamWriter(fos);
		opsw.write("悲惨的世界");
		opsw.close();
	}*/
	

}
