 package domepack;
import java.util.*;
class Location{
	int row;
	int column;
	double maxValue;
	public static  void mm(double [][]a,int rows, int column ){
		int c=0;
		int b=0;
		double maxValue=a[0][0];
		for(int i=0;i<rows;i++){
			for(int j=0;j<column;j++){
				if(a[i][j]>maxValue){
					maxValue=a[i][j];
					 c=j;
					 b=i;
				}
			}
			}
		System.out.println("The location of the largest element is"+maxValue+"at"+"("+(b+1)+","+(c+1)+")");
	}
}
public class text5 {
	public static void main(String []args){
		System.out.println("Enter the number of rows and coluns in the array");
		Location my=new Location();
		Scanner in=new Scanner(System.in);
		int rows=in.nextInt();
		int column=in.nextInt();
		double [][] arr=new double[rows][column];
		System.out.println("Enter the  array");
		for(int i=0;i<rows;i++){
			for(int j=0;j<column;j++){  
				arr[i][j]=in.nextDouble();
			}
		}
		my.mm(arr, rows, column);
	}
}
