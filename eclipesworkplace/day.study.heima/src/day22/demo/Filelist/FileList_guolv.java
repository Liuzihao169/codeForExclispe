package day22.demo.Filelist;

import java.io.File;

public class FileList_guolv {
	public static void main(String[]args){
		founction();
		
	}

	private static void founction() {
		// TODO Auto-generated method stub
		File file=new File("D:\\abc");
		File[]arr=file.listFiles(new Myfilter());
		for(File str:arr){
			System.out.println(str);
		}
	}
	

}
