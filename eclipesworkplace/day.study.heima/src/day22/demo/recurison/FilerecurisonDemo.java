package day22.demo.recurison;

import java.io.File;

public class FilerecurisonDemo {
    public static void main(String[]args){
    	File dir=new File("d:\\abc");
    founction(dir);	
    
    }

	private static void founction(File dir) {
		File []arr=dir.listFiles(new Myfilter());
		for(File f:arr){
			if(f.isDirectory())
			{
				founction(f);
			}
			else {System.out.println(f);}
			
		}
	}
}
