package day24.demo.ExchangeOutIn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	/*
	 *   
	 *   ת����
	 *   ����writerl��
*/
	public static void main(String[]args) throws IOException{

		//writeGBK();
		writeUTF();
		
	}

	private static void writeUTF() throws IOException{
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("d:\\abc\\1.txt");
		OutputStreamWriter opsw=new OutputStreamWriter(fos,"UTF-8");
		opsw.write("�Һ���ô�Һ�");
		opsw.close();
		
		
	}

	/*private static void writeGBK()throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("d\\abc\\b.txt");
		OutputStreamWriter opsw=new OutputStreamWriter(fos);
		opsw.write("���ҵ�����");
		opsw.close();
	}*/
	

}
