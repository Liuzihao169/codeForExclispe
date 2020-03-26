package day27.demo.Lock;

public class RunnaleThread implements Runnable{
    private int tackts=100;
     private Object obj=new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(obj){
			if(tackts>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"出售第"+tackts--+"张票");
			}
			else break;
		}
	}

}}
