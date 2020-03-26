package day24.demo.BuferedStrean;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdedOutputStreamDemo {
    public static void main(String[]args) throws IOException{
     FileOutputStream fos= new FileOutputStream("d:\\abc\\12.txt");
     BufferedOutputStream bfs=new BufferedOutputStream(fos);
     bfs.write("hellow".getBytes());
     bfs.close();
     
    }
}
