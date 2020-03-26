package day22.demo.ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
   //  founction_1();
     founction_2();
	}

	private static void founction_2() throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("d:\\abc\\6.txt");
		ObjectInputStream onps=new ObjectInputStream(fis);
		Object obj=onps.readObject();
		System.out.println(obj);
		onps.close();
	}

	private static void founction_1() throws IOException{
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("d:\\abc\\6.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		People p=new People("lll",18);
		oos.writeObject(p);
		oos.close();
		
	}

}
