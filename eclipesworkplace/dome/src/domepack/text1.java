package domepack;

import java.util.*;

public class text1 {
	public static void main(String[] args) {	
		int b=0;
		int a=0;
	while(true){
		Scanner input = new Scanner(System.in);
		System.out.println("���ȭ1.���� 2.ʯͷ 3.��");
		int p = input.nextInt();
		int c = (int) (Math.random() * 3 + 1);
		String m1 = "��ȭ";
		String m2 = "��ȭ";
		switch (p) {
		case 1:
			m1 = "����";
			break;
		case 2:
			m1 = "ʯͷ";
			break;
		case 3:
			m1 = "��";
			break;

		}
		switch (c) {
		case 1:
			m2 = "����";
			break;
		case 2:
			m2 = "ʯͷ";
			break;
		case 3:
			m2 = "��";
			break;

		}
		if (c == p) {
			System.out.println("ƽ��  �������" + m1 + "\n" + "���Գ���Ҳ��" + m2);
		} else if (c == 1 && p == 2 || c == 2 && p == 3 || c == 3 && p == 1) {
			a++;
			System.out.println("��Ӯ��  �������" + m1 + "\n" + "���Գ���" + m2);
			
			
		
		}

		else {
			b++;
			System.out.println("��Ӯ��  �������" + m1 + "\n" + "���Գ���" + m2);
		
		}

	if(a>=2||b>=2){break;
		
	}
}
		
	System.out.println("��Ϸ����");
		}
}