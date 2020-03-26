package day23.demo.WriteFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDmeo {
      public static void main(String[]args)throws IOException{
    	FileWriter fw=new FileWriter("D:\\abc\\3.txt");  
    	fw.write(100);
    	fw.flush();
    	char c[]={'z','c','f','g'};
    	fw.write(c);
    	fw.flush();
    	fw.close();
      
      }
}
