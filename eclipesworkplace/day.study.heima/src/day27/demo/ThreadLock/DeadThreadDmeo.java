package day27.demo.ThreadLock;

public class DeadThreadDmeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadLock dl=new DeadLock();
		Thread th=new Thread(dl);
		Thread th1= new Thread(dl);
		th.start();
		th1.start();

	}

}
