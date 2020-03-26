package day22.demo.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderDmeo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        founction_1();
	}

	private static void founction_1()throws IOException{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("D:\\abc\\4.properties");
		Properties pro= new Properties();
		pro.load(fr);
		//System.out.println(pro);
		System.out.println(pro.getProperty("name"));
		
	}

}
