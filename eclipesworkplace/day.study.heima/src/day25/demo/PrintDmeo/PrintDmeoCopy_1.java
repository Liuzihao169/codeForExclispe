package day25.demo.PrintDmeo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintDmeoCopy_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
       BufferedReader bfr=new BufferedReader(new FileReader("D:\\abc\\12.txt"));
       PrintWriter pw=new PrintWriter("f:\\12.txt");
       String len=null;
       while((len=bfr.readLine())!=null){
    	   pw.println(len);
    	   pw.flush();
    	   //���Ҫ�Զ�ˢ��  �Ǹ�printwriter�Ĳ���������������
    	   //�Զ�ˢ�¡�
    	   
    	   
       }
       bfr.close();
       pw.close();
       
	}

}
