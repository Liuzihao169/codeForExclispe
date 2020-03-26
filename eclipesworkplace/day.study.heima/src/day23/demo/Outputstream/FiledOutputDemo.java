package day23.demo.Outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FiledOutputDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("d:\\abc\\b.text");
		FileOutputStream fors=new FileOutputStream(file,true);
    fors.write("HELLO".getBytes());
    fors.close();
	}

}
