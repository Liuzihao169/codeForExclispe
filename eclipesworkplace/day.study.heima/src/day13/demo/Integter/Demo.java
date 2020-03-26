package day13.demo.Integter;

import org.junit.Test;

public class Demo {
	public static void main(String[]args){
		int xx=100;
		String c="ºÃºÃÑ§Ï°";
		String S1=""+xx;
		System.out.println(S1);
		String S2=String.valueOf(xx);
		System.out.println(S2);
		int i1=Integer.parseInt(c);
		Integer i2=new Integer(c);
	    int i3=i2.intValue();
	    System.out.println(i1);
	    System.out.println(i3);
		
	}
	@Test
	public void test1(){
		int a []=new int [10];
		System.out.println(a[1]);
		int d[]=null;
		
	}

}
