package day22.demo.File;

import java.io.File;

public class FileifDmeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      founction();
	}

	private static void founction() {
		// TODO Auto-generated method stub
		File file=new File("F:\\java������Ƶ");
		boolean b=file.exists();//�Ƿ����
		boolean c=file.isDirectory();//�Ƿ����ļ���
		boolean d=file.isFile();//�Ƿ����ļ�
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);
	}

}
