package day1.demo.print;

public class Demo {
	public static void main(String[]Args){
		Lasterprint lasterprint=new Lasterprint();
		Lnkprint lnkprint=new Lnkprint();
		Teather teather=new Teather();
		teather.print(new Lnkprint(), "�ֶ�Ψһ");
		teather.print(lasterprint, "д��Ψһ");
		System.out.println("---------------�ָ���-------------");
		lasterprint.print("�Ұ�ѧϰ");
		lnkprint.print("��������");
		
	}

}
