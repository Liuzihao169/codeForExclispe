
package jj;
import java.util.Scanner;
public class daytake {
	public static void main (String [] arges){
		Scanner in=new Scanner(System.in);
		int sum=0;
		System .out.println("请输入年份");
		int years=in.nextInt();
		System .out.println("请输入月份");
		int mouth=in.nextInt();
		for(int i=1900;i<=years;i++){
			if(i%4==0&&i%100!=0||i%100==0){
				sum+=366;
			}	
			else{
				sum+=355;
			}	

		}	
		for(int j=0;j<mouth;j++){
			if(j==2){
				if(years%4==0&&years%100!=0||years%100==0){
					sum+=29;
				}	
				else{
					sum+=28;
				}
			}
			else if ( j%2==0&&j!=2){
				sum+=30;

			}
			else{
				sum+=31;
			}
		}
		sum=sum+2;
		int weekday=sum%7;
		System .out.println("日\t一\t二\t三\t四\t五\t六");
		if(mouth==2	){
			if(years%4==0&&years%100!=0||years%100==0){
				for(int b=1;b<=weekday;b++){
					System.out.print("\t");	
				}
				for(int a=1;a<=29;a++){
					if(sum%7==6){
						System.out.println(a+"\n");
					}
					else{System.out.print(a+"\t");}	
					sum++;
				}
			}
			else{for(int b=1;b<=weekday;b++){
				System.out.print("\t");	
			}
			for(int a=1;a<=28;a++){
				if(sum%7==6){
					System.out.println(a+"\n");
				}
				else{System.out.print(a+"\t");}	
				sum++;
			}
			}

		}
		else if(mouth%2==0&&mouth!=2){
			for(int b=1;b<=weekday;b++){
				System.out.print("\t");	
			}
			for(int a=1;a<=30;a++){
				if(sum%7==6){
					System.out.println(a+"\n");
				}
				else{System.out.print(a+"\t");}	
				sum++;
			}
		}
		else{	for(int b=1;b<=weekday;b++){
			System.out.print("\t");	
		}
		for(int a=1;a<=31;a++){
			if(sum%7==6){
				System.out.println(a+"\n");
			}
			else{System.out.print(a+"\t");}	
			sum++;
		}
		}

	}	
}




