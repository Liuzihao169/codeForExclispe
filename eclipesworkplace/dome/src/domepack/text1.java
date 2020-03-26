package domepack;

import java.util.*;

public class text1 {
	public static void main(String[] args) {	
		int b=0;
		int a=0;
	while(true){
		Scanner input = new Scanner(System.in);
		System.out.println("请出拳1.剪刀 2.石头 3.布");
		int p = input.nextInt();
		int c = (int) (Math.random() * 3 + 1);
		String m1 = "出拳";
		String m2 = "出拳";
		switch (p) {
		case 1:
			m1 = "剪刀";
			break;
		case 2:
			m1 = "石头";
			break;
		case 3:
			m1 = "布";
			break;

		}
		switch (c) {
		case 1:
			m2 = "剪刀";
			break;
		case 2:
			m2 = "石头";
			break;
		case 3:
			m2 = "布";
			break;

		}
		if (c == p) {
			System.out.println("平局  你出的是" + m1 + "\n" + "电脑出的也是" + m2);
		} else if (c == 1 && p == 2 || c == 2 && p == 3 || c == 3 && p == 1) {
			a++;
			System.out.println("你赢了  你出的是" + m1 + "\n" + "电脑出是" + m2);
			
			
		
		}

		else {
			b++;
			System.out.println("你赢了  你出的是" + m1 + "\n" + "电脑出是" + m2);
		
		}

	if(a>=2||b>=2){break;
		
	}
}
		
	System.out.println("游戏结束");
		}
}