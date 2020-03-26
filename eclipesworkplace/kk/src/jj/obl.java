package jj;

import java.util.*;

public class obl {
	public static void main(String args[]) {
		while (true) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入密码");
		System.out.println("*******************");
		System.out.println("密码至少八个字符");
		System.out.println("密码仅仅能包含字母和数字");
		System.out.println("密码包含至少两个数字");
		String str = in.nextLine();
		nu(str);
		int l = nu(str);
		if (l == 1) {
			System.out.println("密码格式正确 ");
			break;
		}
		System.out.println(" 密码格式错误");
	}
	}
	static int nu (String n) {
		int k = 0;
		int w=0;
		int bb;
		int number = 0;
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if ('a' <= c && c <= 'z' || '1'<= c && c <= '9') {
				k=1;
			} else
				k = 2;
		}
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if ('1' <= c && c <= '9') {
				number++;
			}
		
		if (n.length() >= 8 && k == 1 && number >= 2) {
			bb = 1;

		} else
			bb = 0;

		return bb;
	}
		return number;

	}}
