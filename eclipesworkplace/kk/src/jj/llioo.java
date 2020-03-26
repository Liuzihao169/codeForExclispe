package jj;

import java.util.*;

public class llioo {
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		while(true){
		System.out.println("请输入密码");
		System.out.println("*******************");
		System.out.println("密码至少八个字符");
		System.out.println("密码仅仅能包含字母和数字");
		System.out.println("密码包含至少两个数字");
		String str = in.nextLine();
		if (eight(str)) {
			if (onr(str)) {
				if (ol(str)) {
					System.out.println("密码正确");
					break;
				}
				else System.out.println("密码错误");
			} else
				System.out.println("密码错误");
		} else
			System.out.println("密码错误");
	}
	}
	static boolean eight(String n) {
		boolean b = false;// 判断八个字符
		if (n.length() >= 8) {
			b = true;
		}
		return b;

	}

	static boolean onr(String n) {// 至少含有两个数字
		int number = 0;
		boolean a = false;
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (c >= 48 && c <= 57) {
				number++;
			}
			if (number >= 1) {
				a = true;
			}
		}
		return a;
	}

	static boolean ol(String n) {// 判断仅能字母和数字
		boolean f = false;
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (('a' <= c && c <= 'z') || (48 <= c && c <= 57)) {
				f = true;
			}

		}

		return f;
	}
}