package day22.demo.File;

import java.io.File;
import java.io.IOException;

public class FileDmeo1 {

	public static void main(String[] args) throws  IOException{
		// TODO Auto-generated method stub
   // founction();
    //founction_1();
   // founction_3();
	//	founction_4();
    founction_5();
    
	}

	private static void founction_5() {
		// TODO Auto-generated method stub
		File file=new File("f:\\¹È¸èÏÂÔØÄ¿Â¼");
		File objk=file.getParentFile();
		System.out.println(objk);
		
	}

	private static void founction_4() {
		// TODO Auto-generated method stub
		File file=new File("D:\\abc");
		String s=file.getName();
		System.out.println(s);
		
	}

	private static void founction_3() {
		// TODO Auto-generated method stub
		File file= new File("D:\\abc.text");
		boolean b=file.delete();
		System.out.println(b);
		
	}

	private static void founction_1() {
		// TODO Auto-generated method stub
		File file=new File("D:\\abc");
		boolean b=file.mkdir();
		System.out.println(b);
		
	}

	private static void founction() throws IOException {
		// TODO Auto-generated method stub
		 File file=new File("C:\\");
		    System.out.println(file);
		    File file1=new File("D:\\abc.text");
		    boolean b=file1.createNewFile();
		    System.out.println(b);
	}
	

}
