package day13.demo.Year;
import java.util.*;

public class JudgeYear {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("����һ����ݣ��ж������껹��ƽ��");
		int year=sc.nextInt();
		boolean b=Year(year);
		System.out.println(b);
		
	}

	private static boolean Year(int year) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		c.set(year,2,1);
		c.add(Calendar.DAY_OF_MONTH,-1);
		
		return c.get(Calendar.DAY_OF_MONTH)==29;
	}

	}


