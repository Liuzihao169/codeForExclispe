package day22.demo.recurison;

public class AddrecurisonDemo {
	   public static void main(String[]args){
		   long start=System.currentTimeMillis();
		   System.out.println(start);
		   int b=10000;
		   founction(b);
		   int c=5;
		   founction_1(c);
		   System.out.println(founction(b));
		   System.out.println(founction_1(c));
		   long end=System.currentTimeMillis();
		   System.out.println(end);
		   
	   }

	private static int  founction_1(int c) {
		// TODO Auto-generated method stub
		if(c==1){
			return 1;
		}
		else return c*founction_1(c-1);
	}

	private static int  founction(int b) {
		// TODO Auto-generated method stub
		if(b==1)
		{
			return 1;
		}
		
		else return b+founction(b-1);
	}

}
