package jj;

import java.util.Scanner;
public class wenti{
	public static void main (String[] args){
		Scanner in =new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int number=in.nextInt();
		int number1=number%10;
		int number2=number/10;
		int number3=number2%10;
		int number4=number2/10;
		int number5=number4%10;
		System.out.println("The sum of the digits"+number1+number3+number5+"is");
	}
}
