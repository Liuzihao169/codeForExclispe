package day22.demo.File;

import java.io.File;

public class ListFileDmoo {
	public static void main(String[]args){
		 founction();
	}

	private static void founction() {
		// TODO Auto-generated method stub
		File file=new File("D:\\");
		File[]arr1=file.listFiles();
		System.out.println(arr1.length);
		for(File arr:arr1){
			System.out.println(arr);
		}
		
	}

}
