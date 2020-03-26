package day22.demo.File;

import java.io.File;

public class FileifDmeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      founction();
	}

	private static void founction() {
		// TODO Auto-generated method stub
		File file=new File("F:\\java黑马视频");
		boolean b=file.exists();//是否存在
		boolean c=file.isDirectory();//是否是文件夹
		boolean d=file.isFile();//是否是文件
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);
	}

}
