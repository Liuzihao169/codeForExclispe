 package day23.demo.ReadFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDemoWriter {
	public static void main(String[]args){
		FileReader fr=null;
		FileWriter fw=null;
		try{
			int len=0;
			char [] c=new char[1024];
		
		fr=new FileReader("d:\\abc\\3.txt");
		fw=new FileWriter("f:\\3.txt");
		while((len=fr.read(c))!=-1){
			fw.write(c,0,len);//
			fw.flush();
		}
		
		
		}
		catch(IOException e){
			System.out.println(e);
			throw new RuntimeException("³ö´í");
		}finally{try{
			if(fr!=null)
			fr.close();
			}
		catch(IOException e){
			System.out.println(e);
		
			}finally{
				try{
				if(fr!=null);
				fw.close();	
			}catch(IOException ce){
				System.out.println(ce);
				throw new RuntimeException("³ö´í");
				
			}
		}}
		
		

}
}