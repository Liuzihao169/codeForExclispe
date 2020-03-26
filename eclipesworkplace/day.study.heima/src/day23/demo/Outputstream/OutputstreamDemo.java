package day23.demo.Outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputstreamDemo {
	public static void main(String [] args) throws IOException{
      FileOutputStream fors =new  FileOutputStream("d:\\abc\\b.text");
      //fors.write(100);
      //fors.close();
     //byte [] b1={96,97,98,99};
     //fors.write(b1);
     //fors.close();
      byte [] b2={97,98,99,100,101,102};
      fors.write(b2, 2, 2);
	}

}
