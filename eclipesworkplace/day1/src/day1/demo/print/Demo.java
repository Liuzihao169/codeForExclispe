package day1.demo.print;

public class Demo {
	public static void main(String[]Args){
		Lasterprint lasterprint=new Lasterprint();
		Lnkprint lnkprint=new Lnkprint();
		Teather teather=new Teather();
		teather.print(new Lnkprint(), "字段唯一");
		teather.print(lasterprint, "写字唯一");
		System.out.println("---------------分割线-------------");
		lasterprint.print("我爱学习");
		lnkprint.print("天天向上");
		
	}

}
