package day21.demo.Excpetion;

public class RunTimeExceptionDmeo {
	public static void main(String [] args){
		int a=0;
		founction(0);
		
	}
	public static Double founction(int a){
		if(a==0){
			throw new RuntimeException("Բ�β�����");
		}
		return a*4.14;
		
	}

}
