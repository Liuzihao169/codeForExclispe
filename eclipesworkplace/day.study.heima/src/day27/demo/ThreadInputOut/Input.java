package day27.demo.ThreadInputOut;

public class Input implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true){
			if(i%2==0){
				Resrous.r.name="��ë";
				Resrous.r.Gender="��";
			}
			else{
				Resrous.r.Gender="nv";
				Resrous.r.name="ermao";
			}
			i++;
		}
	}

}
