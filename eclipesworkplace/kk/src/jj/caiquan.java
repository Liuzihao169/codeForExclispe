package jj;

public class caiquan {
	public static void main(String args[]) {
		int a = (int) (Math.random() * 13) + 1;
		int b = (int) (Math.random() * 4);
		String col = "��ɫ";
		String num = "����";
		switch (a) {
		case 1:
			num = "ACE";
			break;
		case 2:
			num = "2";
			break;

		case 3:
			num = "3";
			break;
		case 4:
			num = "4";
			break;

		case 5:
			num = "5";
			break;
		case 6:
			num = "6";
			break;
		case 7:
			num = "7";
			break;
		case 8:
			num = "8";
			break;
		case 9:
			num = "9";
			break;
		case 10:
			num = "10";
			break;
		case 11:
			num = "JACK";
			break;
		case 12:
			num = "QUEEN";
			break;
		case 13:
			num = "KING";
			break;
		}

		switch (b) {
		case 0:
			col = "��÷��";

			break;
		case 1:
			col = "�췽��";

			break;
		case 2:
			col = "����";

			break;
		case 3:
			col = "����";

			break;
		}
		System.out.println("�����ƵĻ�ɫ��" + col + num);

	}
}
