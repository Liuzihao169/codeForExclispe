package jj;

import java.util.*;

public class llioo {
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		while(true){
		System.out.println("����������");
		System.out.println("*******************");
		System.out.println("�������ٰ˸��ַ�");
		System.out.println("��������ܰ�����ĸ������");
		System.out.println("�������������������");
		String str = in.nextLine();
		if (eight(str)) {
			if (onr(str)) {
				if (ol(str)) {
					System.out.println("������ȷ");
					break;
				}
				else System.out.println("�������");
			} else
				System.out.println("�������");
		} else
			System.out.println("�������");
	}
	}
	static boolean eight(String n) {
		boolean b = false;// �жϰ˸��ַ�
		if (n.length() >= 8) {
			b = true;
		}
		return b;

	}

	static boolean onr(String n) {// ���ٺ�����������
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

	static boolean ol(String n) {// �жϽ�����ĸ������
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