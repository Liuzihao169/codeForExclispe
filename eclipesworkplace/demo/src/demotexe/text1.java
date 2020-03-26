package demotexe;

public class text1 {
	public static void main(String []args){
		long result=getFactorial(5);
		System.out.println(result);
	}
public static long getFactorial(int n){
	if(n==1){return 1;
	
	}
    return getFactorial(n-1)*n; 
}
}