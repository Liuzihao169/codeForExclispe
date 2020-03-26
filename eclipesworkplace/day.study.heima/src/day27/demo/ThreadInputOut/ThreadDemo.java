package day27.demo.ThreadInputOut;

public class ThreadDemo {
	public static void main(String[]args){
		Input in=new Input();
        Output out=new Output();
        Thread t1=new Thread(in);
        Thread t2=new Thread(out);
        	t1.start();
        	t2.start();
		
	}

}
