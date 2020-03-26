package day26.demo.Threading1;

public class sleepThread extends Thread {
	public void run(){
		for(int i=0;i<5;i++){
			try{
			Thread.sleep(1000);}
			catch(Exception ex){
			}
			System.out.println(i);
		}
	}
}
