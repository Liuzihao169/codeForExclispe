package day27.demo.ThreadInputOut;

public class Output implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println(Resrous.r.Gender+Resrous.r.name);
		}
		
	}

}
