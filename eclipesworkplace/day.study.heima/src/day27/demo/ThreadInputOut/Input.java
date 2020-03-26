package day27.demo.ThreadInputOut;

public class Input implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true){
			if(i%2==0){
				Resrous.r.name="´óÃ«";
				Resrous.r.Gender="ÄÐ";
			}
			else{
				Resrous.r.Gender="nv";
				Resrous.r.name="ermao";
			}
			i++;
		}
	}

}
