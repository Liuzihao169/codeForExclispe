package day24.demo.BufferedRead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderCopyDemo {
	/*
	 *  һ��һ�е�����
	 *   һ��һ�е�����
	 *   �и���
	 *   BufferWriter FileWriter
	 *   BufferReader FileReader*/
	public static void main(String[]args) throws IOException{
		copy(new File("d:\\abc\\1.txt"),new File("f:\\1.txt"));
	}

	private static void copy(File src, File dsec) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(src));
	  BufferedWriter bw=new BufferedWriter(new FileWriter(dsec));
	  String len=null;
	  while((len=br.readLine())!=null){
		  bw.write(len);
		  bw.flush();
		  bw.newLine();
	  }
	  
		
	}

}
