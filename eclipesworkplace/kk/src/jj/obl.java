package jj;

import java.util.*;

public class obl {
	public static void main(String args[]) {
		while (true) {
		Scanner in = new Scanner(System.in);
		System.out.println("����������");
		System.out.println("*******************");
		System.out.println("�������ٰ˸��ַ�");
		System.out.println("��������ܰ�����ĸ������");
		System.out.println("�������������������");
		String str = in.nextLine();
		nu(str);
		int l = nu(str);
		if (l == 1) {
			System.out.println("�����ʽ��ȷ ");
			break;
		}
		System.out.println(" �����ʽ����");
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
