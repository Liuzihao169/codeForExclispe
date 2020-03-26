package day26.demo.Threading3;

import java.util.concurrent.Callable;

public class CallablePool implements Callable<Integer> {
	private int a ;
public CallablePool(int a){
	this.a =a ;
}
@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<=a;i++){
			sum=sum+i;
		}
		return sum;
	}

}
