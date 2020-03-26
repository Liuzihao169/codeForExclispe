package day27.demo.ThreadLock;

public class DeadLock implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		
		while(true){
			if(i%2==0){
		synchronized(lockA.locka){
			System.out.println("if---------a");
			synchronized(lockB.lockb){
				System.out.println("if-------------b");
			}}
		}
			else{
				synchronized(lockB.lockb){
					System.out.println("if--------b");
					synchronized(lockA.locka){
						System.out.println("if---------a");
					}
				}
				
			}i++;
	}

}
}