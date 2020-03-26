package day24.demo.BufferedRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReadDemo {
	public static void main(String[]args) throws IOException{
		FileReader fw=new FileReader("d:\\abc\\1.txt");
		BufferedReader bw=new BufferedReader(fw);
		String len="j";
		while((len=bw.readLine())!=null){
			System.out.println(len);
			
		}
		bw.close();
				
	}

}
