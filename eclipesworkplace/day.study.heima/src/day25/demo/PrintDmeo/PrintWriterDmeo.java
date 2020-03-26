package day25.demo.PrintDmeo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDmeo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
      founction_1();
	}

	private static void founction_1() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter("d:\\abc\\7.txt");
		pw.print(100);
		pw.write(100);
		pw.write("lll");
		pw.flush();
		pw.close();
		
		
	}

}
