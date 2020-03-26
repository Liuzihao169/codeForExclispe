package day22.demo.Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriterDemo {
	public static void main(String[]args) throws IOException{
		founction_2();
	

	}
	private static void founction_2()  throws IOException  {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				FileWriter fw=new FileWriter("d:\\abc\\5.properties");
				Properties pro=new Properties();
				pro.setProperty("mmm", "111");
				pro.setProperty("jjj","222");
				pro.setProperty("hhh", "333");
				pro.store(fw, "change main");
				
	}

}
